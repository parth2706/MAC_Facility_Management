package mac.model;

import java.io.Serializable;

import mac.data.SystemUserDAO;

import java.util.regex.*;

import mac.model.SystemUserErrorMsgs;

 

public class SystemUser implements Serializable{

          

           private static final long serialVersionUID = 3L;

           private String username;

           private String password;

           private String utaid;

           private String firstname;

           private String lastname;

           private String phone;

           private String email;

           private String address;

           private String city;

           private String state;

           private String zipcode;

           private String role;
           
           private String user;

           public void setUser (String username, String password,String utaid, String firstname,String lastname,

                                 String phone,String email,String address,String city,String state,String zipcode, String role) {

                      setUsername(username);

                      setPassword(password);

                      setUtaid(utaid);

                      setFirstname(firstname);

                      setLastname(lastname);

                      setPhone(phone);

                      setEmail(email);

                      setAddress(address);

                      setCity(city);

                      setState(state);

                      setZipcode(zipcode);

                      setRole(role);    

           }

          

          

          public void userRegister (String username, String password, String firstname, String lastname, String utaid, String email, String phone, String address, String city, String state, String zipcode, String role) {

                      setUsername(username);

                      setPassword(password);

                      setUtaid(utaid);

                      setFirstname(firstname);

                      setLastname(lastname);

                      setPhone(phone);

                      setEmail(email);

                      setAddress(address);

                      setCity(city);

                      setState(state);

                      setZipcode(zipcode);

                      setRole(role);

 

           }

          

           public void userLogin(String username, String password) {

                      setUsername(username);

                      setPassword(password);

           }

          

           public void setUpdateUser(String username,String firstname, String lastname, String phone, String email, String address, String city, String state, String zipcode,String role) {

                      setUsername(username);

                      setFirstname(firstname);

                      setLastname(lastname);

                      setEmail(email);

                      setPhone(phone);

                      setAddress(address);

                      setCity(city);

                      setState(state);

                      setZipcode(zipcode);

                      setRole(role);

           }

          

           public void setUpdateRole(String username,String role) {

                      setUsername(username);

                      setRole(role);

           }

          

           public  String getRole() {

                      return role;

           }

           public void setRole(String role) {

                      this.role = role;

                      return;

           }

          

           public String getUsername() {

                      return username;

           }

           public void setUsername(String username) {

                      this.username = username;

                      return;

           }

           public String getPassword() {

                      return password;

           }

           public void setPassword(String password) {

                      this.password = password;

           }

           public String getUtaid() {

                      return utaid;

           }

           public void setUtaid(String utaId) {

                      this.utaid = utaId;

                      return;

           }

           public String getFirstname() {

                      return firstname;

           }

           public void setFirstname(String firstname) {

                      this.firstname = firstname;

           }

           public String getLastname() {

                      return lastname;

           }

           public void setLastname(String lastname) {

                      this.lastname = lastname;

           }

           public String getPhone() {

                      return phone;

           }

           public void setPhone(String phone) {

                      this.phone = phone;

           }

           public String getEmail() {

                      return email;

           }

           public void setEmail(String email) {

                      this.email = email;

           }

 

           public String getAddress() {

                      return address;

           }

           public void setAddress(String address) {

                      this.address = address;

           }

          

           public String getCity() {

                      return city;

           }

           public void setCity(String city) {

                      this.city = city;

           }

           public String getState() {

                      return state;

           }

           public void setState(String state) {

                      this.state = state;

           }

           public String getZipcode() {

                      return zipcode;

           }

           public void setZipcode(String zipcode) {

                      this.zipcode = zipcode;

           }
           
           public  String getUser() {
               return user;
           }
           
         /* public void setUser(String user) {
           this.user = user;
           }*/

          

           public SystemUserErrorMsgs validateUser(SystemUser systemuser, SystemUserErrorMsgs errorMsgs) {

                      errorMsgs.setUsernameError(validateUsername(systemuser.getUsername()));

                      errorMsgs.setPasswordError(validatePassword(systemuser.getPassword()));

                      errorMsgs.setUtaIdError(validateUtaId(systemuser.getUtaid()));

                      errorMsgs.setPhoneError(validatePhone(systemuser.getPhone()));

                      errorMsgs.setFirstNameError(validateFirstName(systemuser.getFirstname()));

                      errorMsgs.setLastNameError(validateLastName(systemuser.getLastname()));

                      errorMsgs.setZipcodeError(validateZipcode(systemuser.getZipcode()));

                      errorMsgs.setAddressError(validateAddress(systemuser.getAddress()));

                      errorMsgs.setCityError(validateCity(systemuser.getCity()));

                      errorMsgs.setStateError(validateState(systemuser.getState()));

                      errorMsgs.setEmailError(validateEmail(systemuser.getEmail()));
                      
                      errorMsgs.setErrorMsg();

                      return errorMsgs;

           }

          

           public SystemUserErrorMsgs validateUser1(SystemUser systemuser, SystemUserErrorMsgs errorMsgs) {

                      errorMsgs.setPasswordError(validatePassword(systemuser.getPassword()));

                      errorMsgs.setUtaIdError(validateUtaId(systemuser.getUtaid()));

                      errorMsgs.setPhoneError(validatePhone(systemuser.getPhone()));

                      errorMsgs.setFirstNameError(validateFirstName(systemuser.getFirstname()));

                      errorMsgs.setLastNameError(validateLastName(systemuser.getLastname()));

                      errorMsgs.setZipcodeError(validateZipcode(systemuser.getZipcode()));

                      errorMsgs.setAddressError(validateAddress(systemuser.getAddress()));

                      errorMsgs.setCityError(validateCity(systemuser.getCity()));

                      errorMsgs.setStateError(validateState(systemuser.getState()));

                      errorMsgs.setEmailError(validateEmail(systemuser.getEmail()));
                      
                      errorMsgs.setErrorMsg_Update();

                      return errorMsgs;

           }

          

           public String validateUsername(String username) {

                      String result = "";

                      if (!stringSize(username,6,10))

                                 result= "Your username must between 6 and 10 digits";

                      else {

                                 if(SystemUserDAO.uniqueUsername(username)) {

                                            result = "Username already present";

                                 }

                      }

                      return result;

           }

          

           public String validatePassword(String password) {

                      String result = "";

                      if (!stringSize(password,6,30)) {

                                 result= "Password has to be minimum 6 characters";

                      }

                     

                      else{

                                 if(!specialChar(password)) {

                                            result = "No special characters allowed";

                                 }

                      }

                     

                      return result;

           }

          

           public String validateUtaId(String utaId) {

                      String result = "";

                      if (!stringSize(utaId,10,10)) {

                                 result= "UtaID has to be 10 digits";

                      }

                      else{

                                 if(!isTextAnInteger(utaId)) {

                                            result = "Has to be digits";

                                 }

                      }

                      return result;

           }

          

           public String validateFirstName(String Fname) {

                      String result = "";

                      if(Fname.equals("")) {

                                 result = "First name cannot be empty";

                      }

                      return result;

           }

          

           public String validateLastName(String Lname) {

                      String result = "";

                      if(Lname.equals("")) {

                                 result = "Last name cannot be empty";

                      }

                      return result;

           }

          

          

           public String validatePhone(String phone) {

                      String result = "";

                      if (!stringSize(phone,10,10)) {

                                 result= "Phone number has to be 10 digits";

                      }

                      else{

                                 if(!isTextAnInteger(phone)) {

                                            result = "Has to be digits";

                                 }

                      }

                      return result;

           }

          

           public String validateEmail(String email) {

                      String result = "";

                     

                                 if(!emailCheck(email)) {

                                            result = "Enter a valid email id";

                                 }         

                      return result;

           }

          

           public String validateAddress(String address) {

                      String result = "";

                      if(address.equals("")) {

                                 result = "address cannot be empty";

                      }

                      return result;

           }

          

           public String validateCity(String city) {

                      String result = "";

                      if(city.equals("")) {

                                 result = "city cannot be empty";

                      }

                      return result;

           }

          

           public String validateState(String state) {

                      String result = "";

                      if(state.equals("")) {

                                 result = "state cannot be empty";

                      }

                      return result;

           }

          

           public String validateZipcode(String zipcode) {

                      String result = "";

                     

                                 if(!isTextAnInteger(zipcode)) {

                                            result = "Has to be digits";

                                 }

                      return result;

           }

          

           public boolean stringSize(String string, int min, int max) {

                      return string.length()>=min && string.length()<=max;

           }

           public boolean isTextAnInteger (String string) {

        boolean result;

                      try

        {

            Long.parseLong(string);

            result=true;

        }

        catch (NumberFormatException e)

        {

            result=false;

        }

                      return result;

           }

          

           public boolean specialChar(String string) {

                      String regex = "^[a-zA-Z0-9]{6,30}$";

                      boolean result = Pattern.matches(regex, string);

                      return result;

}

           public boolean emailCheck(String string) {

                      String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

                      boolean result = Pattern.matches(regex, string);

                      return result;

}
           
           public void validateSelectedUser (String action, String systemuser, SystemUserErrorMsgs errorMsgs) {
        	   errorMsgs.setUserError(validateSelectedUserFromDB(action,systemuser));
           }

           public String validateSelectedUserFromDB(String action, String user) {
        	      String result="";
        	      Integer count=null;
        	      count=SystemUserDAO.listSpecificUsersCount(user);
        	      if(count==0)
        	      {
        	       result="User does not exist, Please enter another User";
        	      }
        	      else
        	      {
        	       result="";
        	      }
        	   return result;
        	}

}