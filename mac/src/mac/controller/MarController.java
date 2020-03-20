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
import mac.model.*;

/**
 * Servlet implementation class MarController
 */
@WebServlet("/MarController")
public class MarController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MarController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    private void getMarParam (HttpServletRequest request, Mar mar) {
        mar.setMAR(request.getParameter("marnumber"),request.getParameter("facilityname"),request.getParameter("description"),request.getParameter("reportedby"));  
    }
    private void getSystemUserParam(HttpServletRequest request, SystemUser systemuser) {
        systemuser.userRegister(request.getParameter("username"),request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("utaId"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("address"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zipcode"),request.getParameter("role"));  
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        HttpSession session = request.getSession();
        SystemUser systemuser = new SystemUser();
        getSystemUserParam(request,systemuser);
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");
        if (action.equalsIgnoreCase("createproblemreport")) {
   
            String MarNumberinDB=new String();
            String SystemUserNameSession="vaibhav";
            String[] FacilityNames= {"MR1","MR2","MR3","MR4","IBBC1","IBBC2","IBBC3","IBBC4","IBBC5","IVBC1","IVBC2","IVBC3","IVBC4","IVBC5",
                    "IVBC6","IVBC7","IVBC8","IVBC9","SCG","RBC1","RBC2","RBC3","RBC4","RBC5","BMC1","BMC2","BMC3","BMC4","BMC5","BMC6","BMC7"
                    ,"BMC8","BMC9","BMC10","TT1","CR1","CR2","CR3","CR4","CR5","OVBC1","OVBC2","OBBC1","OBBC2"};
            MarNumberinDB=MarDAO.getMAR();
            session.setAttribute("CreateReportDetailsMARNumber",MarNumberinDB);
            session.setAttribute("CreateReportDetailsFacilityNames",FacilityNames);
            session.setAttribute("SystemUserSession",SystemUserNameSession);
            getServletContext().getRequestDispatcher("/createproblemreport.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("listReservations")) {
            ArrayList<Mar> reservation = new ArrayList<Mar>();
            
            SystemUser sysreporteduser = new SystemUser();
            sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
            String reportedusername=sysreporteduser.getUsername();
            
            reservation=MarDAO.listReservations(reportedusername);
            session.setAttribute("RESERVATION", reservation);               
            getServletContext().getRequestDispatcher("/reservedrepair.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("cancelReservations")) {
			ArrayList<Mar> reservation = new ArrayList<Mar>();
			
			SystemUser sysreporteduser = new SystemUser();
			sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
			String reportedusername=sysreporteduser.getUsername();
			
			reservation=MarDAO.listReservations(reportedusername);
			session.setAttribute("RESERVATION", reservation);				
			getServletContext().getRequestDispatcher("/cancelrepair.jsp").forward(request, response);
		}
        else if (action.equalsIgnoreCase("viewmars")) {
            SystemUser sysreporteduser=new SystemUser();
            sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
            String reportedusername=sysreporteduser.getUsername();
            ArrayList<Mar> marsInDB = new ArrayList<Mar>();
            marsInDB=MarDAO.listMars(reportedusername);
            session.setAttribute("MARS", marsInDB);             
            getServletContext().getRequestDispatcher("/listallmars.jsp").forward(request, response);
        }
                else if(action.equalsIgnoreCase("searchMAR")) {
                    
                    Mar.generateSearchPageForMar(request);
                    getServletContext().getRequestDispatcher("/searchMAR.jsp").forward(request, response);
                }
                if(action.equalsIgnoreCase("searchReservation")) {
                    
                    generateSearchPageForReservation(request);
                    getServletContext().getRequestDispatcher("/searchReservation.jsp").forward(request, response);
                }    
                if(action.equalsIgnoreCase("modifyReservation")) {
					generateSearchPageForReservation(request);
					getServletContext().getRequestDispatcher("/modifyReservation.jsp").forward(request, response);
				}
    }

    public static void generateSearchPageForReservation(HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        List<String> listOfFacilityTypes = FacilityDAO.getDistinctFacilityTypes();
        List<String> listOfFacilityNames = FacilityDAO.getDistinctFacilityNames();
        session.setAttribute("FACILITYTYPES",listOfFacilityTypes);
        session.setAttribute("FACILITYNAMES",listOfFacilityNames);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Mar mar = new Mar();
        MarErrorMsgs MarerrorMsgs = new MarErrorMsgs();
        int selectedReservationIndex;
        session.removeAttribute("errorMsgs");
        ArrayList<Mar> reservation = new ArrayList<Mar>();
        Mar selectedReservation = new Mar();
        if (action.equalsIgnoreCase("createMAR") ) {  
            getMarParam(request,mar);
            mar.validateMAR(action, mar, MarerrorMsgs);
            session.setAttribute("MAR", mar);
            if (!MarerrorMsgs.getErrorMsg().equals("")) {// if error messages
            getMarParam(request,mar);
            session.setAttribute("Message", MarerrorMsgs);
            getServletContext().getRequestDispatcher("/createproblemreport.jsp").forward(request, response);
            }
            else {// if no error messages
                MarDAO.insertMar(mar);
                String success = "MAR created successfully";
                session.setAttribute("sucMsg", success);
                getServletContext().getRequestDispatcher("/userhomepage.jsp").forward(request, response);
            }
        }

        if (request.getParameter("marnumber")!=null && request.getParameter("action")!=null && !request.getParameter("action").equalsIgnoreCase("reserveMar")) {  //showSpecificMAR(marnumber) 
				String marNumber = request.getParameter("marnumber");
				Mar specificMar = MarDAO.showSpecificMAR(marNumber);
				session.setAttribute("RESERVATION", specificMar);
				getServletContext().getRequestDispatcher("/listspecificreservation.jsp").forward(request, response);
			}
			if(request.getParameter("marNumberToCancel") != null) {
				String marNumber = request.getParameter("marNumberToCancel");
				
				MarDAO.deleteSpecificMAR(marNumber);
				
				SystemUser sysreporteduser = new SystemUser();
				sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
				String reportedusername=sysreporteduser.getUsername();
				
				reservation=MarDAO.listReservations(reportedusername);
				
				session.setAttribute("RESERVATION", reservation);	
				session.setAttribute("errorMsgs", "Reservation cancelled successfully.");
				getServletContext().getRequestDispatcher("/cancelrepair.jsp").forward(request, response);
			
			}
			
            else if(action.equalsIgnoreCase("searchAndShowListOfMar")) {
   
                System.out.println(request.getParameter("dateToSearchMAR"));
                System.out.println(request.getParameter("timeToSearchMAR"));
                System.out.println(request.getParameter("facilitytype"));
                System.out.println(request.getParameter("facilityname"));
                System.out.println(request.getParameter("assignedto"));
                System.out.println(request.getParameter("marno"));
                
                String assignedDate=request.getParameter("dateToSearchMAR");
                String assignedTime=request.getParameter("timeToSearchMAR");
                String facilityType=request.getParameter("facilitytype");
                String facilityName=request.getParameter("facilityname");
                String assignedTo=request.getParameter("assignedto");
                String marno=request.getParameter("marno");
                
               List<MarFacility> listOfMarFacilty = Mar.getListOfMars(assignedDate, assignedTime, facilityType, facilityName, assignedTo, marno);
               Mar.generateSearchPageForMar(request);
               request.getSession().setAttribute("MARFACILITY", listOfMarFacilty);
               getServletContext().getRequestDispatcher("/searchMAR.jsp").forward(request, response);
               return;
            }
            else if(request.getParameter("action").equalsIgnoreCase("searchAndShowListOfReservation")) {
				 System.out.println(request.getParameter("startdate")); // 0
				 System.out.println(request.getParameter("facilitytype")); //Multipurpose rooms
				 System.out.println(request.getParameter("facilityname"));  // MR1
				  
				 SystemUser sysreporteduser=new SystemUser();
				 sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
				 String reportedusername=sysreporteduser.getUsername();
				 
				 String startdate = request.getParameter("startdate");
				 String facilitytype= request.getParameter("facilitytype");
				 String facilityname = request.getParameter("facilityname");
				 
				 boolean isModify = false;
                List<MarFacility> listOfMars = Mar.getMarOfRepairer(reportedusername, startdate, facilitytype,  facilityname, isModify);
				 
				 session.setAttribute("MARFACILITY", listOfMars);
				 generateSearchPageForReservation(request);
				 getServletContext().getRequestDispatcher("/searchReservation.jsp").forward(request, response);
				 
				 
				    // Logic for last 7 days is not yet handled
				
				    // Below logic to retrieve assigned mar of repairer for same date (today) -- select * from mar where assignedto=				   
			}
			
            else if(request.getParameter("action").equalsIgnoreCase("searchAndShowListOfReservationForModify")) {
				 System.out.println(request.getParameter("startdate")); // 0
				 System.out.println(request.getParameter("facilitytype")); //Multipurpose rooms
				 System.out.println(request.getParameter("facilityname"));  // MR1
				  
				 SystemUser sysreporteduser=new SystemUser();
				 sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
				 String reportedusername=sysreporteduser.getUsername();
				 
				 String startdate = request.getParameter("startdate");
				 String facilitytype= request.getParameter("facilitytype");
				 String facilityname = request.getParameter("facilityname");
				 
				 boolean isModify = true;
               List<MarFacility> listOfMars = Mar.getMarOfRepairer(reportedusername, startdate, facilitytype,  facilityname, isModify);
				 
				 session.setAttribute("MARFACILITY", listOfMars);
				 generateSearchPageForReservation(request);
				 getServletContext().getRequestDispatcher("/modifyReservation.jsp").forward(request, response);
				 
				    // Logic for last 7 days is not yet handled
			}
            else if(request.getParameter("action").equalsIgnoreCase("viewMarToEdit")) {
                
                String marnumber = request.getParameter("radioMar");
                Mar mar1 = MarDAO.showSpecificMAR(marnumber);
                session.setAttribute("MARS", mar1);
                getServletContext().getRequestDispatcher("/viewMar.jsp").forward(request, response);
            }
            else if(request.getParameter("action").equalsIgnoreCase("editMarToReserve")) {
                
                String marnumber = request.getParameter("radioMar");
                Mar mar1 = MarDAO.showSpecificMAR(marnumber);
                session.setAttribute("MARS", mar1);
                getServletContext().getRequestDispatcher("/editReservation.jsp").forward(request, response);
            }
            else if(request.getParameter("action").equalsIgnoreCase("reserveMar")) {
                
                 String marnumber = request.getParameter("marnumber");
                 String starttime = request.getParameter("starttime");
                 String endtime = request.getParameter("endtime");
                 String facilityname = request.getParameter("facilityname");
                 
                 SystemUser sysreporteduser=new SystemUser();
                 sysreporteduser=(SystemUser) session.getAttribute ("systemuser");
                 String repairer = sysreporteduser.getUsername();
                 
                 starttime = starttime + ":00";
                 endtime = endtime + ":00";
                 
                 boolean lessThan5RepairsPerDay = MarDAO.checkIfRepairerHasMoreThan5PerDay(repairer);
                 boolean lessThan10RepairsPerWeek = MarDAO.checkIfRepairerHasMoreThan10PerWeek(repairer);
                 boolean c = MarDAO.isCorrectInterval(facilityname, starttime, endtime, marnumber);
                 boolean d = MarDAO.isSlotAvailableForRepairer(starttime, endtime, repairer);
                 
                 if(lessThan5RepairsPerDay && lessThan10RepairsPerWeek && c && d) {
                     MarDAO.reserveMar(marnumber, starttime, endtime);
                     Mar mar1 = MarDAO.showSpecificMAR(marnumber);
                    session.setAttribute("MARS", mar1);
                    getServletContext().getRequestDispatcher("/viewReservation.jsp").forward(request, response);
                 }
                 else { 
                     boolean errorPresent = false;
                     StringBuffer sb = new StringBuffer();
                     MarErrorMsgs errmsg = new MarErrorMsgs();
                     if(!lessThan5RepairsPerDay) {
                        
                        sb.append("Repairer has 5 repairs/day.");
                        errorPresent = true;
                     }
                    if(!lessThan10RepairsPerWeek) {
                        
                        sb.append("Repairer has 10 repairs/week.");
                        errorPresent = true;
                      }
                    if(!c) {
                        
                        sb.append("Time Interval mismatch.");
                        errorPresent = true;
                      }
                    if(!d) {
                        
                        sb.append("Already booked for this time slot."); 
                        errorPresent = true;
                      }
                         errmsg.setdescriptionError(sb.toString());
                         session.setAttribute("ERRORMSGS", errmsg );     
                  getServletContext().getRequestDispatcher("/editReservation.jsp").forward(request, response);
               }
            }
    }

}