package mac.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mac.data.FacilityDAO;
import mac.data.MarDAO;
import mac.data.SystemUserDAO;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;


public class Mar implements Serializable{
	
	private static final long serialVersionUID = 3L;
	private String marnumber;
	private String facilityname;
	private String description;
	private String reportedby;
	private Date date;
	private Time time;
	private String assignedto;
	private Date assigneddate;
	private String estimateofrepair;
	private Time startTime;
	private Time endTime;
	
	public void setMAR (String marnumber, String facilityname,String description, String reportedby) {
		//,Date date,LocalTime time,String assignedto,Date assigneddate,String estimateofrepair
		setMarnumber(marnumber);
		setFacilityname(facilityname);
		setDescription(description);
		setReportedby(reportedby);
		//setDate(date);
		//setTime(time);
		//setAssignedto(assignedto);
		//setAssigneddate(assigneddate);
		//setEstimateofrepair(estimateofrepair);
	}
	
	
	public void setMARS (String marnumber, String facilityname,String description, String reportedby
		,Date date,Time time,String assignedto,Date assigneddate,String estimateofrepair) {
		setMarnumber(marnumber);
		setFacilityname(facilityname);
		setDescription(description);
		setReportedby(reportedby);
		setDate(date);
		setTime(time);
		setAssignedto(assignedto);
		setAssigneddate(assigneddate);
		setEstimateofrepair(estimateofrepair);
	}
	
	/*public void setMARDate (Date date) {
			setDate(date);
		}
	*/
	public void setReservation (String marnumber, String facilityname,Time time,String description,String reportedby,
            Date date,String assignedto,Date assigneddate,String estimateofrepair) {
       setMarnumber(marnumber);
       setFacilityname(facilityname);
       setTime(time);
       setDescription(description);
       setReportedby(reportedby);
       setDate(date);
       setAssignedto(assignedto);
       setAssigneddate(assigneddate);
       setEstimateofrepair(estimateofrepair);
}

	
	public String getMarnumber() {
		return marnumber;
	}
	public void setMarnumber(String marnumber) {
		this.marnumber = marnumber;
	}
	
	public String getFacilityname() {
		return facilityname;
	}
	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReportedby() {
		return reportedby;
	}
	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public String getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	
	public Date getAssigneddate() {
		return assigneddate;
	}
	public void setAssigneddate(Date assigneddate) {
		this.assigneddate = assigneddate;
	}
	
	public String getEstimateofrepair() {
		return estimateofrepair;
	}
	public void setEstimateofrepair(String estimateofrepair) {
		this.estimateofrepair = estimateofrepair;
	}
	
	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public void validateDescription (String action, Mar mar, MarErrorMsgs errorMsgs) {
		//if (action.equals("createMAR")) {
			if (description.equals("") || description.length()<120) 
				errorMsgs.setdescriptionError("Please enter the description");
			    errorMsgs.setErrorMsg();
	//	}
	}
	
	public void validateMAR (String action, Mar mar, MarErrorMsgs errorMsgs) {
	//	if (action.equals("createMAR")) {
			errorMsgs.setdescriptionError(validateDescription(action,mar.getDescription()));
		//	if(!errorMsgs.getDescriptionerror().equals(""))
			errorMsgs.setErrorMsg();
		}
//}
	
	public String validateDescription(String action, String description) {
		String result="";
		if (description.equals("") || description.length()>120) { 
			result="Please enter description";
	}
		return result;
	}
	
	public static void addErrorMessagesInSession(boolean lessThan5RepairsPerDay,boolean lessThan10RepairsPerWeek,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> listofAssignedTo = SystemUserDAO.getListOfRepairers();
		session.setAttribute("ASSIGNEDTO", listofAssignedTo);
		if(!lessThan5RepairsPerDay) {
		    MarErrorMsgs errmsg = new MarErrorMsgs();
		    errmsg.setdescriptionError("Repairer has 5 repairs for today already. Select another repairer.");
			session.setAttribute("ERRORMSGS", errmsg );
			
		}//	if(lessThan10RepairsPerWeek)
		if(!lessThan10RepairsPerWeek) {
		    MarErrorMsgs errmsg = new MarErrorMsgs();
		    errmsg.setdescriptionError("Repairer has 10 repairs for last 7 days already. Select another repairer.");
			session.setAttribute("ERRORMSGS", errmsg );
		}
	}
	
	public static void generateSearchPageForMar(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todaysDate = sdf.format(d);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String nowtime = sdf2.format(d);
		
		List<String> listOfFacilityTypes = FacilityDAO.getDistinctFacilityTypes();
		List<String> listOfFacilityNames = FacilityDAO.getDistinctFacilityNames();
		List<String> listofAssignedTo = SystemUserDAO.getListOfRepairers();
		List<String> listOfMARs = MarDAO.getListOfMARs();
		
		listOfFacilityNames.add(0, " "); // To set null initially as per my Function Table.xlsx
		listofAssignedTo.add(0, " "); // To set null initially as per my Function Table.xlsx
		listOfMARs.add(0, " "); // To set null initially as per my Function Table.xlsx
		
		
		session.setAttribute("DATE", todaysDate);
		session.setAttribute("TIME", nowtime);
		session.setAttribute("FACILITYTYPES",listOfFacilityTypes);
		session.setAttribute("FACILITYNAMES",listOfFacilityNames);
		session.setAttribute("ASSIGNEDTO",listofAssignedTo);
		session.setAttribute("MARNO",listOfMARs);
		
	}
	
	public static List<MarFacility> getListOfMars(String assignedDate,String assignedTime,String facilityType,String facilityName,String assignedTo,String marno) {
		return MarDAO.getListOfMars(assignedDate, assignedTime, facilityType, facilityName, assignedTo, marno);
	}
	
	public static List<MarFacility> getMarOfRepairer(String repairerName, String startdate, String facilitytype, String facilityname,boolean isModify){
		return MarDAO.getMarOfRepairer(repairerName, startdate, facilitytype,  facilityname,isModify);
	}

}