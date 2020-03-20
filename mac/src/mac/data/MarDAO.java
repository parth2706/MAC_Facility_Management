package mac.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import mac.util.SQLConnection;
import mac.model.Mar;
import mac.model.MarFacility;

public class MarDAO {
    
    static SQLConnection DBMgr = SQLConnection.getInstance();
    private static void StoreListinDB (Mar mar,String queryString) {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            String insertCompany = queryString + " VALUES ('"  
                    + mar.getMarnumber()  + "','"
                    + mar.getFacilityname() + "','"     
                    + mar.getDescription() + "','"
                    + mar.getReportedby() + "',"
                    + " current_date"+ ","
                    + " current_time"+ ","
                    +"NULL"+ ","
                    + " current_date"+ ","
                    +"NULL"+ ","
                    +"NULL"+ ","
                    +"NULL);";
            stmt.executeUpdate(insertCompany);  
            conn.commit(); 
        } catch (SQLException e) {}
    }
    
    private static String ReturnMarNumber (String queryString) {
        String MarNumber = new String();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            Integer count=1;
            ResultSet marNumberList = stmt.executeQuery(queryString);
            while (marNumberList.next()) {
                count++;
            }
            MarNumber="MAR"+count;
        } catch (SQLException e) {}
        return MarNumber;
    }


    public static void insertMar(Mar mar) {  
        StoreListinDB(mar,"insert into mar (marnumber,facilityname,description,reportedby,date,time,assignedto,assigneddate,estimateofrepair,starttime,endtime)");
    } 
    
    public static String  getMAR() {  
        return ReturnMarNumber(" select * from mar; ");
}
    
    private static ArrayList<Mar> ReturnMatchingReservationList (String queryString) {
        ArrayList<Mar> res1 = new ArrayList<Mar>();
            
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            ResultSet reservationList = stmt.executeQuery(queryString);
            while (reservationList.next()) {
                Mar mar = new Mar(); 
                mar.setMarnumber(reservationList.getString("marnumber"));
                mar.setFacilityname(reservationList.getString("facilityname"));
                mar.setTime(reservationList.getTime("time"));  
                mar.setDescription(reservationList.getString("description"));
                mar.setReportedby(reservationList.getString("reportedby"));
                mar.setDate(reservationList.getDate("date"));
                mar.setAssignedto(reservationList.getString("assignedto"));
                mar.setAssigneddate(reservationList.getDate("assigneddate"));
                mar.setEstimateofrepair(reservationList.getString("estimateofrepair")); 
                res1.add(mar);  
            }
        } catch (SQLException e) {}
        return res1;
    }
    
    public static ArrayList<Mar>  listReservations(String repairer) {  
        return ReturnMatchingReservationList(" SELECT * from Mar where assignedto='"+repairer +"' ORDER BY facilityname");
     }
    public static ArrayList<Mar>  listReservations() {  
        return ReturnMatchingReservationList(" SELECT * from Mar  ORDER BY facilityname");
     }

    public static ArrayList<Mar>  showUnassignedMARs() {  
        return showUnassignedMarsList(" SELECT * from mar where assignedto is null");
     }

    public static Mar  showSpecificMAR(String marnumber) {  
        return showSpecificMARQuery(" SELECT * from mar where marnumber=\""+ marnumber+"\"");
     }

    public static ArrayList<Mar>  listMars(String reportedby) {  
        return showUnassignedMarsList(" SELECT * from mar where reportedby="+"'"+ reportedby+"';");
     }
    
    public static void  deleteSpecificMAR(String marnumber) {  
   	 deleteSpecificMARQuery(" DELETE from mar where marnumber=\""+ marnumber+"\"");
   }
    

private static ArrayList<Mar> showUnassignedMarsList (String queryString) {
    ArrayList<Mar> marListInDB = new ArrayList<Mar>();
    
    Statement stmt = null;
    Connection conn = SQLConnection.getDBConnection();  
    try {
        stmt = conn.createStatement();
        ResultSet marList = stmt.executeQuery(queryString);
        while (marList.next()) {
            Mar mar = new Mar(); 
            mar.setMarnumber(marList.getString("marnumber"));
            mar.setFacilityname(marList.getString("facilityname"));
            mar.setDescription(marList.getString("description"));
            mar.setReportedby(marList.getString("reportedby"));
            mar.setDate(marList.getDate("date"));
            mar.setTime(marList.getTime("time"));
            mar.setAssignedto(marList.getString("assignedto"));
            mar.setAssigneddate(marList.getDate("assigneddate"));
            mar.setEstimateofrepair(marList.getString("estimateofrepair"));
                      
            marListInDB.add(mar);   
        }
    } catch (SQLException e) {}
    return marListInDB;
}

private static Mar showSpecificMARQuery(String queryString) {
    
    Statement stmt = null;
    Mar mar = new Mar(); 
    Connection conn = SQLConnection.getDBConnection();  
    try {
        stmt = conn.createStatement();
        ResultSet marList = stmt.executeQuery(queryString);
        while (marList.next()) {
            mar = new Mar(); 
            
                mar.setMarnumber(marList.getString("marnumber"));
                mar.setFacilityname(marList.getString("facilityname"));
                mar.setDescription(marList.getString("description"));
                mar.setReportedby(marList.getString("reportedby"));
                mar.setDate(marList.getDate("date"));
                mar.setTime(marList.getTime("time"));
                mar.setAssignedto(marList.getString("assignedto"));
                mar.setAssigneddate(marList.getDate("assigneddate"));
                mar.setEstimateofrepair(marList.getString("estimateofrepair"));
                mar.setStartTime(marList.getTime("starttime"));
                mar.setEndTime(marList.getTime("endtime"));
                break;
        }
   } 
    catch (SQLException e) {}
        return mar;
}

public static void  updateMar(String marNumber, String assignedTo, String estimateOfRepair) {  
    updateMarFromDb(marNumber,assignedTo,estimateOfRepair);
}

private static void updateMarFromDb(String marNumber, String assignedTo, String estimateOfRepair){
    
    
    Statement stmt = null;
    Connection conn = SQLConnection.getDBConnection();  
    try {
        
        PreparedStatement updateemp = conn.prepareStatement
                  ("update mar set assignedto=?, estimateofrepair=?, assigneddate=current_date() where marnumber=?");
                  updateemp.setString(1,assignedTo);
                  updateemp.setString(2,estimateOfRepair);
                  updateemp.setString(3, marNumber);
                  updateemp.executeUpdate();
                  conn.commit();
    } catch (SQLException e) {}
}

private static void deleteSpecificMARQuery(String queryString) {
	
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();  
	try {
		stmt = conn.createStatement();
		//ResultSet marList = stmt.execute(queryString);
		 stmt.executeUpdate(queryString);
		 conn.commit();
		 System.out.println("Record deleted successfully");
		 
   } 
	catch (SQLException e) {
	e.printStackTrace();
}
}


public static void  reserveMar(String marNumber, String starttime, String endtime) {  
    reserveMarFromDb(marNumber,starttime,endtime);
}

private static void reserveMarFromDb(String marNumber, String starttime, String endtime){
      
    Connection conn = SQLConnection.getDBConnection();  
    try {
        PreparedStatement updateemp = conn.prepareStatement
                  ("update mar set starttime=?, endtime=?, assigneddate=current_date() where marnumber=?");
                  updateemp.setString(1,starttime);
                  updateemp.setString(2,endtime);
                  updateemp.setString(3, marNumber);
                  updateemp.executeUpdate();
                  conn.commit();
                  
    } catch (SQLException e) {}
}

public static List<String> getListOfMARs() {
      return SystemUserDAO.getUserDistinctValues("SELECT DISTINCT marnumber FROM mar","mar");
}

public static List<MarFacility> getListOfMars(String assignedDate,String assignedTime,String facilityType,String facilityName,String assignedTo,String marno) {
       String queryString = "select assigneddate, time, time as endtime, facilitytype, mar.facilityname, marnumber  from mar inner join facility on mar.facilityname=facility.facilityname";
            StringBuffer whereClause = new StringBuffer();
            boolean isFilter = false;
            
            //if(!assignedDate.trim().equals("")) {
            whereClause.append(" assigneddate='"+assignedDate+"'");
            isFilter = true;
           // }
            
           // if(!assignedTo.trim().equals(""))
           // {
               // if(isFilter)
                    whereClause.append(" and ");

                whereClause.append(" assignedto='"+assignedTo+"'");
                isFilter = true;
           // }
            
          //  if(!marno.trim().equals(""))
          //  {
           //     if(isFilter)
                    whereClause.append(" and ");

                whereClause.append(" marnumber='"+marno+"'");
                isFilter = true;
           // }
            
           // if(!facilityName.trim().equals(""))
           // {
           //     if(isFilter)
                    whereClause.append(" and ");

                whereClause.append(" mar.facilityname='"+facilityName+"'");
                isFilter = true;
           // }
            
           // if(!facilityType.trim().equals(""))
          //  {
            //    if(isFilter)
                    whereClause.append(" and ");

                whereClause.append(" facilitytype='"+facilityType+"'");
                isFilter = true;
          //  }
            
           // if(isFilter) {
                queryString = queryString +" where "+ whereClause.toString();
           // }
            
       return MarDAO.getListOfMars(queryString);
}

public static List<MarFacility> getListOfMars(String queryString){
       List<MarFacility> marFacility = new ArrayList<MarFacility>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try {
            stmt = conn.createStatement();
            ResultSet outputList = stmt.executeQuery(queryString);
            while (outputList.next()) {
                MarFacility marfac = new MarFacility();
                marfac.setAssignedDate(outputList.getString("assigneddate"));
                marfac.setAssignedTime(outputList.getString("time"));
                marfac.setFacilityType(outputList.getString("facilitytype"));
             marfac.setFacilityName(outputList.getString("mar.facilityname"));
             marfac.setMarno(outputList.getString("marnumber"));

             marFacility.add(marfac);   
            }
        } catch (SQLException e) {}
        return marFacility;
}

public static boolean checkIfRepairerHasMoreThan5PerDay(String repairer)
{
       Connection conn = SQLConnection.getDBConnection();
       Statement stmt = null;
       boolean res = true;
       String query = "SELECT count(*) as count FROM mac.mar where assigneddate=current_date() and assignedto='"+repairer+"'";
       int count = 0;
       try {
       conn = SQLConnection.getDBConnection();
       conn.setAutoCommit(false);
       stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(query);
       while (rs.next()) {
       count = rs.getInt("count");
       System.out.println(count + "\n");
       }
       }catch(Exception e) {}

       if(count >= 5) {
       System.out.println("Count greater than 5");
       return false;
       }
       else {
       System.out.println("Count less than 5");
       }
       return res;      
}

public static boolean checkIfRepairerHasMoreThan10PerWeek(String repairer) {
       Connection conn = SQLConnection.getDBConnection();
       Statement stmt = null;
       boolean res = true;
       String query = "select count(*) as count FROM mac.mar where assignedto ='"+repairer+"' and YEARWEEK(assigneddate) = YEARWEEK(NOW())";
       int count = 0;
       try {
           conn = SQLConnection.getDBConnection();
           conn.setAutoCommit(false);
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           while (rs.next()) {
           count = rs.getInt("count");
           System.out.println(count + "\n");
       }
       }catch(Exception e) {}

       if(count >= 10) {
       System.out.println("Count greater than 10");
       return false;
       }
       else {
       System.out.println("Count less than 10");
       }
       return res;
}

public static List<MarFacility> getMarOfRepairer(String repairerName, String startdate, String facilitytype, String facilityname, boolean isModify){
	   List<MarFacility> listOfMars = new ArrayList<MarFacility>();
	   
	   // ASSUMING THAT STARTDATE IS ALWAYS 0 - For Same Day
	   // Last 7 days not yet implemented...
	   String queryString="";
	   if(isModify) {
		   queryString = "select * from mac.mar inner join facility on mar.facilityname=facility.facilityname where assignedto ='"+repairerName+"' and assigneddate=current_date() and facility.facilitytype='"+facilitytype+"' and facility.facilityname= '"+facilityname+"' and starttime is not null and endtime is not null";    
	   }else {
	       queryString = "select * from mac.mar inner join facility on mar.facilityname=facility.facilityname where assignedto ='"+repairerName+"' and assigneddate=current_date() and facility.facilitytype='"+facilitytype+"' and facility.facilityname= '"+facilityname+"' and starttime is null and endtime is null";
	   }
	   Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet outputList = stmt.executeQuery(queryString);
			while (outputList.next()) {
				MarFacility marfac = new MarFacility();
				marfac.setAssignedDate(outputList.getString("assigneddate"));
				marfac.setAssignedTime(outputList.getString("time"));
				marfac.setFacilityType(outputList.getString("facilitytype"));
          marfac.setFacilityName(outputList.getString("mar.facilityname"));
          marfac.setMarno(outputList.getString("marnumber"));
          
          
          if(outputList.getTime("starttime")!=null)
         	 marfac.setStartTime(outputList.getTime("starttime"));
          
          if(outputList.getTime("endtime")!=null)
         	 marfac.setEndTime(outputList.getTime("endtime"));
          
				//marfac.equals(outputList.getString(""));
         
				//System.out.println(outputList.getString("assignedto"));
         listOfMars.add(marfac);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   return listOfMars;
}

 public static boolean isSlotAvailableForRepairer(String startTime,String endTime,String repairer )
//Checking Validation if there no time slots already booked in the user selected time slot
{
try {
boolean result=false;
ArrayList<Time> dbStartTime=ReturnStartTimeSlot ("Select startTime from Mar where assignedto='"+repairer+"' and startTime>='"+startTime+"' and assigneddate=current_date();");
ArrayList<Time> dbEndTime=ReturnEndTimeSlot ("Select endTime from Mar where assignedto='"+repairer+"' and endTime<='"+endTime+"' and assigneddate=current_date();");
ArrayList<String> stringdbStartTime=new ArrayList<String>();
ArrayList<String> stringdbEndTime=new ArrayList<String>();
     for(int i=0;i<dbStartTime.size();i++)
     {
     String stringStartTime=dbStartTime.get(i).toString();
     stringdbStartTime.add(stringStartTime);
     }
     for(int i=0;i<dbEndTime.size();i++)
     {
     String stringEndTime=dbEndTime.get(i).toString();
     stringdbEndTime.add(stringEndTime);
     }
     
     ArrayList<java.util.Date> dbdate1=new ArrayList<java.util.Date>();
     ArrayList<java.util.Date> dbdate2=new ArrayList<java.util.Date>();
     SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
     for(int i=0;i<stringdbStartTime.size();i++)
     {
     java.util.Date dateStartTime=format.parse(stringdbStartTime.get(i));
     dbdate1.add(dateStartTime);
     }
     for(int i=0;i<stringdbEndTime.size();i++)
     {
         java.util.Date dateEndTime=format.parse(stringdbEndTime.get(i));
     dbdate2.add(dateEndTime);
     }
     java.util.Date uidate1 = format.parse(startTime);
     java.util.Date uidate2 = format.parse(endTime);
     int toggle=1;
     for(int i=0;i<stringdbStartTime.size();i++)
     {
     long difference1 = dbdate1.get(i).getTime() - uidate1.getTime();
     long difference2 = dbdate2.get(i).getTime() - uidate2.getTime();
 //    if(difference1>=0)
 //    {
 //    if(difference2<=0)
  //   {
     toggle=0;
  //   }
  //   }
     }
     if(toggle==0)
     {
     result=false;
     }else {result=true;}
     return result;
     }
     catch (ParseException e) {} return false;
}

    public static  ArrayList<Time> ReturnStartTimeSlot (String queryString) {
    
    Statement stmt = null;
    Time result;
    ArrayList<Time> resultTimeArray=new ArrayList<Time>();
    Connection conn = SQLConnection.getDBConnection();  
    try {
    stmt = conn.createStatement();
    ResultSet startTimeSlot = stmt.executeQuery(queryString);
    while (startTimeSlot.next()) {
    result=startTimeSlot.getTime("startTime");
    resultTimeArray.add(result);
    }
    } catch (SQLException e) {}
    return resultTimeArray;
    }

    private static ArrayList<Time> ReturnEndTimeSlot (String queryString) {
    
    Statement stmt = null;
    Time result;
    Connection conn = SQLConnection.getDBConnection();  
    ArrayList<Time> resultTimeArray=new ArrayList<Time>();
    try {
    stmt = conn.createStatement();
    ResultSet endTimeSlot = stmt.executeQuery(queryString);
    while (endTimeSlot.next()) {
    result=endTimeSlot.getTime("endTime");
    resultTimeArray.add(result);
    }
    } catch (SQLException e) {}
    return resultTimeArray;
    }

    public static boolean isCorrectInterval(String facilityName,String startTime,String endTime,String marnumber )
    //Validate that time slot entered is equal to the facility time slot
    {
    try {
    boolean result=false;
    long difference;
    String facilityTimeSlot="";
    long facilityTimeFloat=0;
 
    facilityTimeSlot=ReturnFacilityTimeSlot(" SELECT myinterval from facility WHERE facilityname LIKE '%"+facilityName+"%'");

    if(facilityTimeSlot.equalsIgnoreCase("1 hour"))
    {
    facilityTimeFloat=60;
    }
 
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    java.util.Date date1;
    java.util.Date date2;
     
    date1 = format.parse(startTime);
    date2 = format.parse(endTime);
    difference = date2.getTime() - date1.getTime();
    long minDifference=difference/60000;
    if(facilityTimeFloat==minDifference)
    {
    result=true;
    }
    return result;
    } catch (ParseException e) {} return false;
    }

    private static String ReturnFacilityTimeSlot (String queryString) {

        Statement stmt = null;
        String result="";
        Connection conn = SQLConnection.getDBConnection();  
        try {
        stmt = conn.createStatement();
        ResultSet facilityTimeSlot = stmt.executeQuery(queryString);
        while (facilityTimeSlot.next()) {
        result=facilityTimeSlot.getString("myinterval");
        }
        } catch (SQLException e) {}
        return result;
        }
}