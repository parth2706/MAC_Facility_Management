package mac.model;

public class FacilityErrorMsgs {
	private String errorMsg;
	private String facilitynameError;
	private String facilitytypeError;
	
	public FacilityErrorMsgs() {
		this.facilitynameError = "";
		this.facilitytypeError = "";
		this.errorMsg = "";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if(!facilitynameError.equals("") || !facilitytypeError.equals("")) {
			this.errorMsg = "Please correct the following errors";
		}
	}
	public String getFacilitynameError() {
		return facilitynameError;
	}
	public void setFacilitynameError(String facilitynameError) {
		this.facilitynameError = facilitynameError;
	}
	public String getFacilitytypeError() {
		return facilitytypeError;
	}
	public void setFacilitytypeError(String facilitytypeError) {
		this.facilitytypeError = facilitytypeError;
	}
	
}
