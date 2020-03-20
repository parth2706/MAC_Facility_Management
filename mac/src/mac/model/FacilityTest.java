package mac.model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacilityTest {

	Facility facility;
	FacilityErrorMsgs facilityerrormsgs;
	@Before
	public void setUp() throws Exception {
		facility=new Facility();
		facilityerrormsgs=new FacilityErrorMsgs(); 
	}
    
	@FileParameters("src/Excel/validateFacilityTest.csv")
	@Test
	public void validateFacilityTest(int testcasenumber,String facilityType,String facilityName ,String interval,String duration,String venue,String facilitytypeError,String facilitynameError,String errorMsg) {
		Facility selectedFacility = new Facility();
		FacilityErrorMsgs selectedfacilityerrormsgs = new FacilityErrorMsgs();
		selectedFacility.setAddFacility(facilityName,facilityType,interval, duration, venue );
		assertEquals(facilityName,selectedFacility.getFacilityName());
		assertEquals(facilityType,selectedFacility.getFacilityType());
		assertEquals(interval,selectedFacility.getInterval());
		assertEquals(duration,selectedFacility.getDuration());
		assertEquals(venue,selectedFacility.getVenue());
		selectedFacility.setDuration(duration);
		selectedFacility.setFacilityName(facilityName);
		selectedFacility.setFacilityType(facilityType);
		selectedFacility.setInterval(interval);
		selectedFacility.setVenue(venue);
	    facility.validateFacility(selectedFacility, selectedfacilityerrormsgs);
		assertEquals(facilitynameError,selectedfacilityerrormsgs.getFacilitynameError());
		assertEquals(facilitytypeError,selectedfacilityerrormsgs.getFacilitytypeError());
		assertEquals(errorMsg,selectedfacilityerrormsgs.getErrorMsg());
		
	}

}
