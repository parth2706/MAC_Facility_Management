package mac.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mac.model.Facility;
import mac.util.SQLConnection;

public class FacilityDAO {
    
    static SQLConnection DBMgr = SQLConnection.getInstance();
    static SQLConnection con=SQLConnection.getInstance();
    
    private static ArrayList<Facility> ReturnMatchingFacilityList (String queryString) {
        ArrayList<Facility> facilityListInDB = new ArrayList<Facility>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try { 
            stmt = conn.createStatement();
            ResultSet facilityList = stmt.executeQuery(queryString);
            while (facilityList.next()) {
                Facility facility = new Facility(); 
                facility.setFacilityName(facilityList.getString("facilityname"));
                facility.setFacilityType(facilityList.getString("facilitytype"));
                facility.setInterval(facilityList.getString("myinterval"));
                facility.setDuration(facilityList.getString("duration"));
                facility.setVenue(facilityList.getString("venue"));
                facilityListInDB.add(facility); 
            }
        } catch (SQLException e) {}
        return facilityListInDB;
    }
    
    public static void insertFacility(Facility facility) {
  
        System.out.println("Connected inside facility dao file");
        System.out.println("inside DAO");
        Statement stmt = null;   
        Connection conn = SQLConnection.getDBConnection(); 
        String insertFacility = "INSERT INTO facility ";                    
        insertFacility += " VALUES ('"  
                + facility.getFacilityName()  + "','"
                + facility.getFacilityType() + "','"
                + facility.getInterval() + "','" 
                + facility.getDuration() + "','"
                + facility.getVenue() + "');"; 
                
        System.out.println(insertFacility);
        
        conn = SQLConnection.getDBConnection();  
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt = conn.createStatement();
            stmt.executeUpdate(insertFacility);
            conn.commit();                   
        } catch (SQLException e) {}   
    }
    
          public static ArrayList<Facility>  listFacility() {  
              return ReturnMatchingFacilityList(" SELECT * from facility");
          }
          
          public static ArrayList<Facility>  searchFacility(String username)  {  
              return ReturnMatchingFacilityList(" SELECT * from facility WHERE facilityname LIKE '%"+username+"%'");
          }
    
          public static List<String> getDistinctFacilityTypes() {
              return SystemUserDAO.getUserDistinctValues("SELECT DISTINCT facilitytype FROM facility","facility");
          }
          
          public static List<String> getDistinctFacilityNames() {
              return SystemUserDAO.getUserDistinctValues("SELECT DISTINCT facilityname FROM facility","facility1");
          } 
          
          public static boolean uniqueFacilityName(String facilityname) {
                Statement stmt = null;  
                boolean result = false;
                Connection conn = SQLConnection.getDBConnection(); 
                String getfacility = "Select facilityname from facility where facilityname like \"%";
                getfacility += facilityname + "%\"";
                System.out.println(getfacility);
                conn = SQLConnection.getDBConnection();
                try {
                    conn.setAutoCommit(false);
                    stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(getfacility);
                    String facility = "";
                    while (rs.next()) {
                        facility = rs.getString("facilityname");
                          System.out.println(facility + "\n");
                        }
                    
                    if(facility.equals(facilityname)) {
                        result = true;
                        return result;
                    }
                }
                catch(Exception e) {}
                return result;
            }
}

