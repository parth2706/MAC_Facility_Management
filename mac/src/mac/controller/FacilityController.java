package mac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mac.data.FacilityDAO;
import mac.data.MarDAO;
import mac.data.SystemUserDAO;
import mac.model.Facility;
import mac.model.FacilityErrorMsgs;
import mac.model.Mar;

/**
 * Servlet implementation class FacilityController
 */
@WebServlet("/FacilityController")
public class FacilityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FacilityController() {
        super();
    }
    
    private void getFacilityParams(HttpServletRequest request, Facility facility) {
        facility.setAddFacility(request.getParameter("facilityName").trim(),request.getParameter("facilitytype").trim(),request.getParameter("interval"),request.getParameter("duration"),request.getParameter("venue"));
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
                HttpSession session = request.getSession();
                String action = request.getParameter("action");
                System.out.println(action);
                session.removeAttribute("errorMsgs");
                if(action.equalsIgnoreCase("listUnassignedMARs")) {
                    ArrayList<Mar> listofMARs = new ArrayList<Mar>();
                    listofMARs = MarDAO.showUnassignedMARs();
                    session.setAttribute("MARS", listofMARs);                   
                    getServletContext().getRequestDispatcher("/listMAR.jsp").forward(request, response);
                    
                }
 
               if(action.equalsIgnoreCase("addNewFacility")) {
                    getServletContext().getRequestDispatcher("/addNewFacility.jsp").forward(request, response);
                    
                }
               if (action.equalsIgnoreCase("viewAllFacilities")) {
                    System.out.println("Inside view facilities");
                    ArrayList<Facility> facilitiesInDB = new ArrayList<Facility>();
                    facilitiesInDB=FacilityDAO.listFacility();
                    System.out.println("Contents of list");
                    for(Facility S: facilitiesInDB) {
                        System.out.println(S);
                    }
                    session.setAttribute("Facilities", facilitiesInDB);             
                    getServletContext().getRequestDispatcher("/viewFacility.jsp").forward(request, response);
                    return;
                }
                else // redirect all other gets to post
                    doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("I  am here");
        Facility facility = new Facility();request.getParameterNames();
        FacilityErrorMsgs FerrorMsg = new FacilityErrorMsgs();
        session.removeAttribute("errorMsgs");
        String action = request.getParameter("action");
       if(request.getParameter("action").equalsIgnoreCase("listSpecificMar")) {
            
            String marnumber = request.getParameter("radioMar");
            Mar mar = MarDAO.showSpecificMAR(marnumber);
            session.setAttribute("MARS", mar);
            List<String> listofAssignedTo = SystemUserDAO.getListOfRepairers();                     
            session.setAttribute("ASSIGNEDTO", listofAssignedTo);
            getServletContext().getRequestDispatcher("/editMar.jsp").forward(request, response);
        }
       if(request.getParameter("action").equalsIgnoreCase("updateMar")){
            String estimateOfRepair = request.getParameter("estimateOfRepair"); 
            String assignedTo= request.getParameter("assignedTo");
            String marNumber= request.getParameter("marNumber");
            
            boolean lessThan5RepairsPerDay = MarDAO.checkIfRepairerHasMoreThan5PerDay(assignedTo);
            
            boolean lessThan10RepairsPerWeek = MarDAO.checkIfRepairerHasMoreThan10PerWeek(assignedTo);
            
            if(lessThan5RepairsPerDay == true && lessThan10RepairsPerWeek == true) {
               MarDAO.updateMar(marNumber,assignedTo,estimateOfRepair);
            }
 
            Mar mar1 = MarDAO.showSpecificMAR(marNumber);
            session.setAttribute("MARS", mar1);
        
            if(lessThan5RepairsPerDay && lessThan10RepairsPerWeek)
               getServletContext().getRequestDispatcher("/viewMar.jsp").forward(request, response);
            else {
                Mar.addErrorMessagesInSession(lessThan5RepairsPerDay,lessThan10RepairsPerWeek,request);
                getServletContext().getRequestDispatcher("/editMar.jsp").forward(request, response);
            }
        }
 
      if (action.equalsIgnoreCase("saveFacility")) {
            System.out.println("Nothing");
            getFacilityParams(request,facility);
            System.out.println("SOmething");
            facility.validateFacility(facility, FerrorMsg);
            System.out.println("Back from the validate function");
            System.out.println("Error msg is: ");
            System.out.println(FerrorMsg.getErrorMsg());
            if(!FerrorMsg.getErrorMsg().equals("")) {// if error messages
                System.out.println("Error in validation");
                session.setAttribute("facility", facility);
                session.setAttribute("FerrorMsgs", FerrorMsg);
                getServletContext().getRequestDispatcher("/addNewFacility.jsp").forward(request, response);
                return;
            }
            else {
            
                System.out.println("Insert facility");
                FacilityDAO.insertFacility(facility);
                String success = "User registered successfully";
                session.setAttribute("sucMsg2", success);
                getServletContext().getRequestDispatcher("/fmHomepage.jsp").forward(request, response);
                return;
            }          
        }
        
        if (action.equalsIgnoreCase("ViewSpecificFacility") ) {
            ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
            facilityInDB=FacilityDAO.searchFacility(request.getParameter("id"));
            System.out.println(facilityInDB);
            session.setAttribute("Facilities", facilityInDB);
            getServletContext().getRequestDispatcher("/listspecificfacility.jsp").forward(request, response);
            return;
            }
    }
}