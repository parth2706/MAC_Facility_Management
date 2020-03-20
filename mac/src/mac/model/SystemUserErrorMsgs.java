package mac.model;

 

public class SystemUserErrorMsgs {

           private String errorMsg;

           private String usernameError;

           private String passwordError;

           private String utaIdError;

           private String phoneError;

           private String firstNameError;

           private String lastNameError;

           private String emailError;

           private String addressError;

           private String cityError;

           private String stateError;

           private String zipcodeError;
           
           private String userError;

          

           public SystemUserErrorMsgs() {

                      //this.errorMsg = "";

                      /*this.usernameError = "";

                      this.passwordError = "";

                      this.utaIdError = "";

                      this.phoneError = "";

                      this.firstNameError = "";

                      this.lastNameError = "";

                      this.emailError = "";

                      this.zipcodeError = "";

                      this.cityError = "";

                      this.stateError = "";

                      this.zipcodeError = "";*/

           }

          

           public String getAddressError() {

                      return addressError;

           }

 

           public void setAddressError(String addressError) {

                      this.addressError = addressError;

           }

 

           public String getCityError() {

                      return cityError;

           }

 

           public void setCityError(String cityError) {

                      this.cityError = cityError;

           }

 

           public String getStateError() {

                      return stateError;

           }

 

           public void setStateError(String stateError) {

                      this.stateError = stateError;

           }

 

           public String getZipcodeError() {

                      return zipcodeError;

           }

 

           public void setZipcodeError(String zipcodeError) {

                      this.zipcodeError = zipcodeError;

           }

 

           public String getEmailError() {

                      return emailError;

           }

           public void setEmailError(String emailError) {

                      this.emailError = emailError;

           }

           public String getErrorMsg() {

                      return errorMsg;

           }

           public void setErrorMsg() {

                      if(!usernameError.equals("") || !passwordError.equals("")|| !utaIdError.equals("") ||

                                            !phoneError.equals("") || !firstNameError.equals("") || !lastNameError.equals("") || !emailError.equals("") ||

                                            !zipcodeError.equals("") || !cityError.contentEquals("") || !stateError.contentEquals("") || !zipcodeError.equals("")) {

                                                                  this.errorMsg = "Please correct the following errors";

                                                       }
                      else
                    	  this.errorMsg = "";

                     

           }

           public String getUsernameError() {

                      return usernameError;

           }

           public void setUsernameError(String usernameError) {

                      this.usernameError = usernameError;

           }

           public String getPasswordError() {

                      return passwordError;

           }

           public void setPasswordError(String passwordError) {

                      this.passwordError = passwordError;

           }

           public String getUtaIdError() {

                      return utaIdError;

           }

           public void setUtaIdError(String utaIdError) {

                      this.utaIdError = utaIdError;

           }

           public String getPhoneError() {

                      return phoneError;

           }

           public void setPhoneError(String phoneError) {

                      this.phoneError = phoneError;

           }

           public String getFirstNameError() {

                      return firstNameError;

           }

           public void setFirstNameError(String firstNameError) {

                      this.firstNameError = firstNameError;

           }

           public String getLastNameError() {

                      return lastNameError;

           }

           public void setLastNameError(String lastNameError) {

                      this.lastNameError = lastNameError;

           }
           
           public String getUserError() {
        	   return userError;
           }

           public void setUserError(String userError) {
               this.userError = userError;
           }

           public void setErrorMsg_Update() {

               if(!passwordError.equals("")|| !utaIdError.equals("") ||

                                     !phoneError.equals("") || !firstNameError.equals("") || !lastNameError.equals("") || !emailError.equals("") ||

                                     !zipcodeError.equals("") || !cityError.contentEquals("") || !stateError.contentEquals("") || !zipcodeError.equals("")) {

                                                           this.errorMsg = "Please correct the following errors";

                                                }
               else
               this.errorMsg = "";

             

    }

      

}