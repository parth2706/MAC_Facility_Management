package mac.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac.data.SystemUserDAO;
import mac.model.*;

/**
 * Servlet implementation class SystemUserController
 */
@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public SystemUserController() {
        super();
    }
    
    private void getSystemUserParam(HttpServletRequest request, SystemUser systemuser) {
        systemuser.userRegister(request.getParameter("username"),request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("utaId"),request.getParameter("email"),request.getParameter("phone"),request.getParameter("address"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zipcode"),request.getParameter("role"));  
    }
    
    private void getLoginParam(HttpServletRequest request, SystemUser systemuser) {
        systemuser.userLogin(request.getParameter("username"),request.getParameter("password"));
        System.out.println(request.getParameter("password"));
        HttpSession session=request.getSession();
        session.setAttribute("newname",request.getParameter("username"));
    }

    private void getUserRoleParam (HttpServletRequest request, SystemUser systemuser) {
        systemuser.setUpdateRole(request.getParameter("username"),request.getParameter("role"));  
    }
    private void getUserInfoParam (HttpServletRequest request, SystemUser systemuser) {
        systemuser.setUpdateUser(request.getParameter("username"),request.getParameter("firstname"),request.getParameter("lastname"),
                request.getParameter("phone"),request.getParameter("email"),request.getParameter("address"),request.getParameter("city"),
                request.getParameter("state"),request.getParameter("zipcode"),request.getParameter("role"));  
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");

        if (action.equalsIgnoreCase("viewusers")) {
            ArrayList<SystemUser> usersInDB = new ArrayList<SystemUser>();
            usersInDB=SystemUserDAO.listUsers();
            session.setAttribute("USERS", usersInDB);               
            getServletContext().getRequestDispatcher("/viewusers.jsp").forward(request, response);
        } 
        if (action.equalsIgnoreCase("viewupdateusers")) {
            ArrayList<SystemUser> usersInDB = new ArrayList<SystemUser>();
            usersInDB=SystemUserDAO.listUsers();
            session.setAttribute("USERS", usersInDB);               
            getServletContext().getRequestDispatcher("/viewupdateusers.jsp").forward(request, response);
        }
        else if(action.equalsIgnoreCase("registerUser")) {
            getServletContext().getRequestDispatcher("/registerUser.jsp").forward(request, response);
            
        }
        else if(action.equalsIgnoreCase("login")) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            
        }
        else if(action.equalsIgnoreCase("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            
        }
        else if(action.equalsIgnoreCase("updateprofile")) {
            ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
            SystemUser selectedsystemuser = new SystemUser();
            System.out.println((String)session.getAttribute("newname"));
            systemuserInDB=SystemUserDAO.viewProfile((String)session.getAttribute("newname"));
            selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                    systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole());
            session.setAttribute("USER1", selectedsystemuser);
            getServletContext().getRequestDispatcher("/updateprofile.jsp").forward(request, response);  
        }
        else if(action.equalsIgnoreCase("updateprofile_admin")) {
            ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
            SystemUser selectedsystemuser = new SystemUser();
            System.out.println((String)session.getAttribute("newname"));
            systemuserInDB=SystemUserDAO.viewProfile((String)session.getAttribute("newname"));
            selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                    systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole());
            session.setAttribute("USER1", selectedsystemuser);
            getServletContext().getRequestDispatcher("/updateprofile_admin.jsp").forward(request, response);    
        }
        else if(action.equalsIgnoreCase("searchusers")) {
            getServletContext().getRequestDispatcher("/searchusers.jsp").forward(request, response);
            }
        else // redirect all other gets to post
            doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        SystemUser systemuser = new SystemUser();
        getSystemUserParam(request,systemuser);
        SystemUserErrorMsgs UerrorMsgs = new SystemUserErrorMsgs();
        session.removeAttribute("errorMsgs");

        if (action.equalsIgnoreCase("ViewSpecificUser") ) {
        ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
        SystemUser selectedsystemuser = new SystemUser();
        String id=request.getParameter("id");
        systemuserInDB=SystemUserDAO.searchUsers(id);
        selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole()      );
        String[] SystemUserRoles= {"user","facility manager","repairer"};
        session.setAttribute("USERS", selectedsystemuser);
        session.setAttribute("USERROLES",SystemUserRoles);

        getServletContext().getRequestDispatcher("/listspecificusers.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("ViewSpecificUpdateUser") ) {
            ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
            SystemUser selectedsystemuser = new SystemUser();
            String id=request.getParameter("id");
            systemuserInDB=SystemUserDAO.searchUsers(id);
            selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                    systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole()      );
            String[] SystemUserRoles= {"user","facility manager","repairer"};
            session.setAttribute("USERS", selectedsystemuser);
            session.setAttribute("USERROLES",SystemUserRoles);

            getServletContext().getRequestDispatcher("/listspecificupdateusers.jsp").forward(request, response);
            }
        if (action.equalsIgnoreCase("updateUser") ) {
            SystemUser systemuser1 = new SystemUser();
            getUserInfoParam(request,systemuser1);
            session.setAttribute("UUSER",systemuser1);
                SystemUserDAO.updateUserInfo(systemuser1);
                String success = "User updated successfully";
                session.setAttribute("sucMsg", success);
                getServletContext().getRequestDispatcher("/adminhomepage.jsp").forward(request, response);
        }
             
        if (action.equalsIgnoreCase("updateRole") ) {  
            getUserRoleParam(request,systemuser);
            session.setAttribute("UUSER",systemuser);
                SystemUserDAO.updateRole(systemuser);
                String success = "Role updated successfully";
                session.setAttribute("sucMsg", success);
                getServletContext().getRequestDispatcher("/adminhomepage.jsp").forward(request, response);
        }
        
        if (action.equalsIgnoreCase("saveUser") ) {  
            getSystemUserParam(request,systemuser);
            systemuser.validateUser(systemuser,UerrorMsgs);
            session.setAttribute("systemuser", systemuser);
            if (!UerrorMsgs.getErrorMsg().equals("")) {// if error messages
                
                getSystemUserParam(request,systemuser);
                session.setAttribute("systemuser", systemuser);
                session.setAttribute("UerrorMsgs", UerrorMsgs);
                System.out.println(UerrorMsgs.getUsernameError());
                System.out.println(UerrorMsgs.getPasswordError());
                System.out.println(systemuser.getUsername());
                
                getServletContext().getRequestDispatcher("/registerUser.jsp").forward(request, response);  
            }
            else {// if no error messages
                SystemUserDAO.insertUser(systemuser);
                String success = "User registered successfully";
                session.setAttribute("sucMsg", success);
                  getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);  
            }
        }
        
        if (action.equalsIgnoreCase("userLogin") ) {  
            getLoginParam(request,systemuser);
            System.out.println(systemuser.getPassword());
                String result;
                result = SystemUserDAO.verifyUser(systemuser);
                if(result.equals("")) {
                    String role;
                    role = SystemUserDAO.getVerifiedRole(systemuser);
                    System.out.println("Role in systemusercontroller is:");
                    System.out.println(role);
                    session.setAttribute("systemuser", systemuser);
                    if(role.equals("user"))
                    {
                          getServletContext().getRequestDispatcher("/userhomepage.jsp").forward(request, response);
                    }
                    else if(role.equals("admin"))
                    {
                          getServletContext().getRequestDispatcher("/adminhomepage.jsp").forward(request, response);
                            }
                    else if(role.equals("facility manager"))
                    {
                          getServletContext().getRequestDispatcher("/fmHomepage.jsp").forward(request, response);
                            }
                    else if(role.equals("repairer"))
                    {
                          getServletContext().getRequestDispatcher("/repairerhomepage.jsp").forward(request, response);
                            }
                }
                
                else {
                    String fail = "Username or password is incorrect";
                    session.setAttribute("failMsg", fail);
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }
        }
                
        if (action.equalsIgnoreCase("viewprofile") ) {
            ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
            SystemUser selectedsystemuser = new SystemUser();
            System.out.println((String)session.getAttribute("newname"));
            systemuserInDB=SystemUserDAO.viewProfile((String)session.getAttribute("newname"));
            selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                    systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole());
            session.setAttribute("USER1", selectedsystemuser);
            getServletContext().getRequestDispatcher("/viewprofile.jsp").forward(request, response); 
        }
        
        if (action.equalsIgnoreCase("viewprofile_admin") ) {
            ArrayList<SystemUser> systemuserInDB = new ArrayList<SystemUser>();
            SystemUser selectedsystemuser = new SystemUser();
            System.out.println((String)session.getAttribute("newname"));
            systemuserInDB=SystemUserDAO.viewProfile((String)session.getAttribute("newname"));
            selectedsystemuser.setUser( systemuserInDB.get(0).getUsername(), systemuserInDB.get(0).getPassword(),systemuserInDB.get(0).getUtaid(),systemuserInDB.get(0).getFirstname(),systemuserInDB.get(0).getLastname(),systemuserInDB.get(0).getPhone(),systemuserInDB.get(0).getEmail(), 
                    systemuserInDB.get(0).getAddress(),systemuserInDB.get(0).getCity(),systemuserInDB.get(0).getState(),systemuserInDB.get(0).getZipcode(),systemuserInDB.get(0).getRole());
            session.setAttribute("USER1", selectedsystemuser);
            getServletContext().getRequestDispatcher("/viewprofile_admin.jsp").forward(request, response); 
        }
        
        
        if (action.equalsIgnoreCase("saveUser1") ) {  
 
            getSystemUserParam(request,systemuser);
            systemuser.validateUser1(systemuser,UerrorMsgs);
            session.setAttribute("systemuser", systemuser);
            if (!UerrorMsgs.getErrorMsg().equals("")) {// if error messages
                
                getSystemUserParam(request,systemuser);
                session.setAttribute("systemuser", systemuser);
                session.setAttribute("UerrorMsgs", UerrorMsgs);
                System.out.println(UerrorMsgs.getUsernameError());
                System.out.println(UerrorMsgs.getPasswordError());
                System.out.println(systemuser.getUsername());
                
                getServletContext().getRequestDispatcher("/updateprofile.jsp").forward(request, response);  
            }
            else {// if no error messages
                SystemUserDAO.updateprofile(systemuser);
                String success = "User profile updated successfully";
                session.setAttribute("sucMsg", success);
                  getServletContext().getRequestDispatcher("/userhomepage.jsp").forward(request, response);  
            }
        }
        if(action.equalsIgnoreCase("viewselecteduser")) {
            String selectedUserName=request.getParameter("user");
            SystemUser systemuser1 = new SystemUser();
            systemuser1.validateSelectedUser(action, selectedUserName, UerrorMsgs);
            session.setAttribute("MAR", systemuser1);
            if (!UerrorMsgs.getUserError().equals("")) {// if error messages
            session.setAttribute("Message", UerrorMsgs);
            getServletContext().getRequestDispatcher("/searchusers.jsp").forward(request, response);
            }
            else {
            ArrayList<SystemUser> usersInDB = new ArrayList<SystemUser>();
            usersInDB=SystemUserDAO.listSpecificUsers(selectedUserName);
            session.setAttribute("USERS", usersInDB);
            getServletContext().getRequestDispatcher("/viewusers.jsp").forward(request, response);
                 }
              }
    }

}