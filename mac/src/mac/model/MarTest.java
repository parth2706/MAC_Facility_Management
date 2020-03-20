package mac.model;


import static org.junit.Assert.assertEquals;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class MarTest {

	Mar m;
	MarErrorMsgs msg;
	
	@Before
	public void setUp() throws Exception {
		m=new Mar();
		msg = new MarErrorMsgs();
	}	

	@FileParameters("src/Excel/MARTestCases.csv")
	@Test
	public void testSetMAR(int testcase, String marnumber, String facilityname,String time,String description,String reportedby,
            String date,String assignedto,String assigneddate,String estimateofrepair, String descriptionError,String error) {
		//Mar mar = new Mar();
		m.setMAR(marnumber, facilityname, description, reportedby);
		assertEquals(marnumber, m.getMarnumber());
		assertEquals(facilityname, m.getFacilityname());
		assertEquals(description, m.getDescription());
		assertEquals(reportedby, m.getReportedby());
	}

	@FileParameters("src/Excel/MARTestCases.csv")
	@Test
	public void testSetMARS(int testcase,String marnumber, String facilityname,String time,String description,String reportedby,
            String date,String assignedto,String assigneddate,String estimateofrepair, String descriptionError,String error) throws ParseException{
		Mar mar = new Mar();
		//mar.setMarnumber(marnumber);
		//mar.setFacilityname(facilityname);
		//mar.setDescription(description);
		
		//String time = "15:30:18";
		
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		long ms = sdf.parse(time).getTime();
		Time time1 = new Time(ms);
		//mar.setTime(time1);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(date);
        java.sql.Date date1 = new java.sql.Date(parsed.getTime());
		
		//mar.setDate(date1);
		
		//mar.setAssignedto(assignedto);
		
		Date parsed1;
		
			parsed1 = format.parse(assigneddate);
		 
        java.sql.Date assigneddate1 = new java.sql.Date(parsed1.getTime());
		
		//mar.setAssigneddate(assigneddate1);
		
		
		
		//mar.setEstimateofrepair(estimateofrepair);
		mar.setMARS(marnumber, facilityname, description, reportedby, date1, time1, assignedto, assigneddate1, estimateofrepair);
		assertEquals(marnumber, mar.getMarnumber());
		assertEquals(facilityname, mar.getFacilityname());
		assertEquals(description, mar.getDescription());
		assertEquals(time1, mar.getTime());
		assertEquals(date1, mar.getDate());
		assertEquals(assignedto,mar.getAssignedto());
		assertEquals(assigneddate1, mar.getAssigneddate());
		assertEquals(estimateofrepair, mar.getEstimateofrepair());
		//fail("Not yet implemented"); 
	}

	@FileParameters("src/Excel/MARTestCases.csv")
	@Test
	public void testSetReservation(int testcase,String marnumber, String facilityname,String time,String description,String reportedby,
            String date,String assignedto,String assigneddate,String estimateofrepair, String descriptionError,String error) throws ParseException {
		

		Mar mar = new Mar();
		
		//mar.setMarnumber(marnumber);
		//mar.setFacilityname(facilityname);
		//mar.setDescription(description);
		
		//String time = "15:30:18";
		
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		long ms = sdf.parse(time).getTime();
		Time time1 = new Time(ms);
		//mar.setTime(time1);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(date);
        java.sql.Date date1 = new java.sql.Date(parsed.getTime());
		
		//mar.setDate(date1);
		
		//mar.setAssignedto(assignedto);
		
		Date parsed1;
		
			parsed1 = format.parse(assigneddate);
		 
        java.sql.Date assigneddate1 = new java.sql.Date(parsed1.getTime());
		
		//mar.setAssigneddate(assigneddate1);
		
		
		
		//mar.setEstimateofrepair(estimateofrepair);
		mar.setReservation(marnumber, facilityname, time1, description, reportedby, date1, assignedto, assigneddate1, estimateofrepair);
		assertEquals(marnumber, mar.getMarnumber());
		assertEquals(facilityname, mar.getFacilityname());
		assertEquals(description, mar.getDescription());
		assertEquals(time1, mar.getTime());
		assertEquals(date1, mar.getDate());
		assertEquals(assignedto,mar.getAssignedto());
		assertEquals(assigneddate1, mar.getAssigneddate());
		assertEquals(estimateofrepair, mar.getEstimateofrepair());
		//fail("Not yet implemented"); 
	
		//fail("Not yet implemented");
	}

	@FileParameters("src/Excel/MARTestCases.csv")
	@Test
	public void testValidateMAR(int testcase,String marnumber, String facilityname,String time,String description,String reportedby,
            String date,String assignedto,String assigneddate,String estimateofrepair, String descriptionError,String error) {
		Mar mar = new Mar();
		MarErrorMsgs msg = new MarErrorMsgs();
		mar.setDescription(description);
		
		mar.validateMAR("createMAR",mar,msg);
		assertEquals(msg.getDescriptionerror(), descriptionError);
	    mar.validateDescription("createMAR",mar,msg);
		//fail("Not yet implemented");
	}
	
	
}
