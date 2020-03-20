package mac.model;

public class MarErrorMsgs {
	
	private String errorMsg;
	public String descriptionerror;
	
	public MarErrorMsgs() {
		//this.errorMsg = "";
		/*this.descriptionerror = "";*/
	}
	
	public String getDescriptionerror() {
		return descriptionerror;
	}
	
	/*public void setDescriptionerror(String descriptionerror) {
	//	this.descriptionerror = descriptionerror;
	}*/

	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!this.descriptionerror.equals("") )
			this.errorMsg = "Please correct the following errors";
		else
			this.errorMsg = "";
	}
	
	/*public String getdescriptionError() {
		return descriptionerror;
	}*/
	public void setdescriptionError(String descriptionerror) {
		this.descriptionerror = descriptionerror;
	}

}
