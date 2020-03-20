package mac.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mac.util.SQLConnection;
import mac.model.SystemUser;

public class SystemUserDAO {
    
    static SQLConnection DBMgr = SQLConnection.getInstance();
    static SQLConnection con=SQLConnection.getInstance();
    
    private static ArrayList<SystemUser> ReturnMatchingSystemUsersList (String queryString) {
        ArrayList<SystemUser> systemuserListInDB = new ArrayList<SystemUser>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            ResultSet systemuserList = stmt.executeQuery(queryString);
            while (systemuserList.next()) {
                SystemUser systemuser = new SystemUser(); 
                systemuser.setUsername(systemuserList.getString("username"));
                systemuser.setPassword(systemuserList.getString("password"));
                systemuser.setUtaid(systemuserList.getString("utaid"));
                systemuser.setFirstname(systemuserList.getString("firstname"));
                systemuser.setLastname(systemuserList.getString("lastname"));
                systemuser.setPhone(systemuserList.getString("phone"));
                systemuser.setEmail(systemuserList.getString("email"));
                systemuser.setAddress(systemuserList.getString("address"));
                systemuser.setCity(systemuserList.getString("city"));
                systemuser.setState(systemuserList.getString("state"));
                systemuser.setZipcode(systemuserList.getString("zipcode"));
                systemuser.setRole(systemuserList.getString("role"));
                systemuserListInDB.add(systemuser); 
            }
        } catch (SQLException e) {}
        return systemuserListInDB;
    }
    
    private static void UpdateRoleinDB (SystemUser systemuser,String queryString) {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            String updateRole = queryString+  "'"
                    + systemuser.getRole() +  "' " +
                    "where username='"  + 
                     systemuser.getUsername() +"';";
            stmt.executeUpdate(updateRole); 
            conn.commit(); 
        } catch (SQLException e) {}
    }
    
    private static void UpdateUserinDB (SystemUser systemuser,String queryString) {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(queryString);    
            conn.commit(); 
        } catch (SQLException e) {}
    }
    
    //update user role
    public static void updateRole(SystemUser systemuser) {  
        UpdateRoleinDB(systemuser,"UPDATE systemuser set role=");
    }   
    //update user info
    public static void updateUserInfo(SystemUser systemuser) {  
        UpdateUserinDB(systemuser,"UPDATE systemuser set firstname='"+systemuser.getFirstname()+"',lastname='"+systemuser.getLastname()+"',phone='"+systemuser.getPhone()+"',email='"
                +systemuser.getEmail()+"',city='"+systemuser.getCity()+"',state='"+systemuser.getState()+"' ,zipcode='"+systemuser.getZipcode()+"' ,role='"+systemuser.getRole()+"'"+" where username='"    + systemuser.getUsername() +"';");
    }
    
    //search user roles
    public static ArrayList<SystemUser>  searchUsers(String username)  {  
          return ReturnMatchingSystemUsersList(" SELECT * from systemuser WHERE username LIKE '%"+username+"%'");
    }
        
        public static ArrayList<SystemUser>  listUsers() {  
            return ReturnMatchingSystemUsersList(" SELECT * from systemuser");
    }
        
        public static void insertUser(SystemUser systemuser) {
                       
            if(con.getDBConnection()!=null) {
                System.out.println("Connected inside dao dile");
                System.out.println("role" + systemuser.getRole());
            }
            System.out.println("inside DAO");
            Statement stmt = null;   
            Connection conn = SQLConnection.getDBConnection(); 
            String insertUser = "INSERT INTO systemuser (username, password, utaid, firstname, lastname, phone, email, address, city, state, zipcode, role) ";                  
            insertUser += " VALUES ('"  
                    + systemuser.getUsername()  + "','"
                    + systemuser.getPassword() + "','"
                    + systemuser.getUtaid() + "','" 
                    + systemuser.getFirstname() + "','"     
                    + systemuser.getLastname() + "','"
                    + systemuser.getPhone() + "','" 
                    + systemuser.getEmail() + "','" 
                    + systemuser.getAddress() + "','" 
                    + systemuser.getCity() + "','" 
                    + systemuser.getState() + "','"
                    + systemuser.getZipcode() + "','"
                    + systemuser.getRole() + "')"; 
                    
            System.out.println(insertUser);
            
            try {
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt.executeUpdate(insertUser);
                conn.commit();                   
            } catch (SQLException e) {}   
        }
        
        public static String verifyUser(SystemUser systemuser) {
            System.out.println("Inside verifyuser");
            Statement stmt = null;  
            String result = "";
            String password = systemuser.getPassword();
            System.out.println(password);
            Connection conn = SQLConnection.getDBConnection(); 
            String getPass = "Select password from systemuser where username like \"";
            getPass += systemuser.getUsername() + "\"";
            System.out.println(getPass);
            try {
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getPass);
                String newPassword = "";
                while (rs.next()) {
                      newPassword = rs.getString("password");
                      System.out.println(newPassword + "\n");
                    }
                System.out.println("User entered");
                System.out.println(password);
                System.out.println("DB retrieved");
                System.out.println(newPassword);
                
                if(newPassword.equals(password)) {
                    System.out.println("inside verify password");
                    System.out.println(newPassword + "\n");
                    return result;
                }
                else {
                    result = "incorrect details";
                    return result;
                } 
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return result;
        }
        
        public static boolean uniqueUsername(String username) {
            Statement stmt = null;  
            boolean result = false;
            Connection conn = SQLConnection.getDBConnection(); 
            String getUser = "Select username from systemuser where username like \"%";
            getUser += username + "%\"";
            conn = SQLConnection.getDBConnection();
            try {
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(getUser);
                String user = "";
                while (rs.next()) {
                      user = rs.getString("username");
                    }
                
                if(user.equals(username)) {
                    result = true;
                    return result;
                }
                
            }
            catch(Exception e) {}
            return result;          
        }
        
    public static String getVerifiedRole(SystemUser systemuser) {
        Statement stmt = null;  
        String role = "";
        Connection conn = SQLConnection.getDBConnection(); 
        String getRole = "Select role from systemuser where username like \"";
        getRole += systemuser.getUsername() + "\"";
        System.out.println(getRole);
        conn = SQLConnection.getDBConnection();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getRole);
            
            while (rs.next()) {
                    role = rs.getString("role");
                  System.out.println(role + "\n");
                }
            return role;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
               
        return role;
    }
    
     public static List<String> getListOfRepairers() {
          return getUserDistinctValues("SELECT DISTINCT username FROM systemuser where role='repairer'","systemuser");
     }
      
      public static List<String> getUserDistinctValues(String queryString, String tableName) {
          
          List<String> list = new ArrayList<String>();
          Statement stmt = null;
          Connection conn = SQLConnection.getDBConnection(); 
          try {
                stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(queryString);
                while (result.next()) {
                    if(tableName.equalsIgnoreCase("systemuser")) {
                        list.add(result.getString("username"));
                    }
                    if(tableName.equalsIgnoreCase("facility")) {
                        list.add(result.getString("facilitytype"));
                    }
                    if(tableName.equalsIgnoreCase("facility1")) {
                        list.add(result.getString("facilityname"));
                    }
                    if(tableName.equalsIgnoreCase("mar")) {
                        list.add(result.getString("marnumber"));
                    }
                        
                }
            } catch (SQLException e) {}
          
          return list;
      }

     public static void updateprofile(SystemUser systemuser) {  
            
            System.out.println("Connected inside dao dile");
            System.out.println("role" + systemuser.getRole());
            System.out.println("inside DAO");
            Statement stmt = null;   
            Connection conn = SQLConnection.getDBConnection();
            System.out.println(systemuser.getUtaid());
            System.out.println(systemuser.getZipcode());
            System.out.println(systemuser.getUsername());
            String updateUser = "update systemuser set password='"+systemuser.getPassword()+"',"
                    + "utaid='"+systemuser.getUtaid()+"',firstname='"+systemuser.getFirstname()+"',lastname='"+systemuser.getLastname()+"'," 
                    + "phone='"+systemuser.getPhone()+"',email='"+systemuser.getEmail()+"',address='"+systemuser.getAddress()+"',"
                    + "city='"+systemuser.getCity()+"',"
                    + "state='"+systemuser.getFirstname()+"',zipcode='"+systemuser.getZipcode()+"' where username='"+systemuser.getUsername()+"';"; 
  
            System.out.println(updateUser);
            
            conn = SQLConnection.getDBConnection();  
            try {
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
                stmt = conn.createStatement();
                stmt.executeUpdate(updateUser);
                conn.commit();                   
            } catch (SQLException e) {}   
        }

    public static ArrayList<SystemUser>  viewProfile(String username) {  
        return ReturnMatchingSystemUsersList("SELECT * from systemuser WHERE username LIKE '%"+username+"%'");
        }
    
    public static ArrayList<SystemUser>  listSpecificUsers(String username) {  
        return ReturnMatchingSystemUsersList(" SELECT * from systemuser where username LIKE '%"+username+"%'");
        }

        public static Integer  listSpecificUsersCount(String username) {  
        ArrayList<SystemUser> systemuserListInDB = new ArrayList<SystemUser>();
        systemuserListInDB=ReturnMatchingSystemUsersList(" SELECT * from systemuser where username LIKE '%"+username+"%'");
        return systemuserListInDB.size();
        }
}