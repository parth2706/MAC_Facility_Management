package mac.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import mac.data.FacilityDAO;
import mac.model.FacilityErrorMsgs;

public class Facility implements Serializable{
	private String facilityName;
	private String facilityType;
	private String interval;
	private String duration;
	private String venue;
	
	public void setAddFacility(String facilityName, String facilityType, String interval, String duration, String venue ) {
		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setInterval(interval);
		setDuration(duration);
		setVenue(venue);
	}
	
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public void validateFacility(Facility facility, FacilityErrorMsgs errorMsgs) {
		System.out.println("inside facility validate function");
		errorMsgs.setFacilitytypeError(validateFacilityeypeError(facility.getFacilityType()));
		
		if(errorMsgs.getFacilitytypeError().equals(""))
		   errorMsgs.setFacilitynameError(validateFacilitynameError(facility.getFacilityName(), facility.getFacilityType()));
		
		errorMsgs.setErrorMsg();
	}
	
	private String validateFacilitynameError(String facilityname, String facilitytype) {
		System.out.println("inside validate facility name");
		String result = "";
		HashMap<String, String> FacilityTypeID = new HashMap<>();
		FacilityTypeID.put("multipurpose rooms", "mr");
		FacilityTypeID.put("basketball court", "ibcc");
		FacilityTypeID.put("volleyball court", "ivbc");
		FacilityTypeID.put("soccer gymnasium", "scg");
		FacilityTypeID.put("racquetball court", "rbc");
		FacilityTypeID.put("badminton court", "bmc");
		FacilityTypeID.put("table tennis", "tti");
		FacilityTypeID.put("conference room", "cr");
		
		if(!(facilityname.toLowerCase().contains(FacilityTypeID.get(facilitytype.toLowerCase())))) {
			System.out.println("inside contains name check");
			result = "facility name should be either of MR/IBCC/IVBC/SCG/RBC/BMC/TTI/CR type";
		}
		else {
			if(FacilityDAO.uniqueFacilityName(facilityname)) {
				System.out.println("inside unique name check");
				result = "facility name already present";
			}
			
		}
		return result;
		
	}
	
	private String validateFacilityeypeError(String facilitytype) {
		System.out.println("inside validate facility type");
		String result = "";
		ArrayList<String> listFacilityType = new ArrayList<String>();
		listFacilityType.add("multipurpose rooms");
		listFacilityType.add("basketball court");
		listFacilityType.add("volleyball court");
		listFacilityType.add("soccer gymnasium");
		listFacilityType.add("racquetball court");
		listFacilityType.add("badminton court");
		listFacilityType.add("table tennis");
		listFacilityType.add("conference room");
		
		for(int i = 0; i < listFacilityType.size(); i++) {
			System.out.println(listFacilityType.get(i));
		}
		
		if(facilitytype.equals("")) {
			return "Facility Type cannot be empty";
		}
		else if(!(listFacilityType.contains(facilitytype.toLowerCase()))) {
			System.out.println("Inside some check");
			return "Facility should of type: Multipurpose Rooms / Basketball Court / Volleyball Court /Soccer Gymnasium / Racquetball Court /"
					+ " Badminton Court / Table Tennis / Conference Room";
		}
		return result;
	}
	
}
