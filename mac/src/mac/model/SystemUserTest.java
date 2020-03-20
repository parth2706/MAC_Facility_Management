package mac.model;

import static org.junit.Assert.*;

 

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

 

import junitparams.FileParameters;

import junitparams.JUnitParamsRunner;

 

import static org.junit.Assert.assertEquals;

 

@RunWith(JUnitParamsRunner.class)

public class SystemUserTest {

 

           SystemUser systemuser;

           SystemUserErrorMsgs systemusererrormsgs;

           @Before

           public void setUp() throws Exception {

                      systemuser=new SystemUser();

                      systemusererrormsgs=new SystemUserErrorMsgs();

                     

           }

 

           @FileParameters("src/Excel/sysuser12.csv")

           @Test

           public void validateUserNameTest(int testcasenumber,String username, String password,String utaid, String firstname,String lastname,

                                 String phone,String email,String address,String city,String state,String zipcode,String Eusername,String Epassword,String Eutaid,String Efirstname,String Elastname,String Ephone,

                                 String Eemail,String Eaddress,String Ecity,String Estate,String Ezipcode) {

                      String role="";

                      systemuser.setUser(username,password,utaid,firstname,lastname,phone,email,address,city,state,zipcode, role);

                      assertEquals(Eusername,systemuser.validateUser(systemuser,systemusererrormsgs).getUsernameError());

                      assertEquals(Epassword,systemuser.validateUser(systemuser,systemusererrormsgs).getPasswordError());

                      assertEquals(Eutaid,systemuser.validateUser(systemuser,systemusererrormsgs).getUtaIdError());

                      assertEquals(Efirstname,systemuser.validateUser(systemuser,systemusererrormsgs).getFirstNameError());

                      assertEquals(Elastname,systemuser.validateUser(systemuser,systemusererrormsgs).getLastNameError());

                      assertEquals(Ephone,systemuser.validateUser(systemuser,systemusererrormsgs).getPhoneError());

                      assertEquals(Eemail,systemuser.validateUser(systemuser,systemusererrormsgs).getEmailError());

                      assertEquals(Eaddress,systemuser.validateUser(systemuser,systemusererrormsgs).getAddressError());

                      assertEquals(Ecity,systemuser.validateUser(systemuser,systemusererrormsgs).getCityError());

                      assertEquals(Estate,systemuser.validateUser(systemuser,systemusererrormsgs).getStateError());

                      assertEquals(Ezipcode,systemuser.validateUser(systemuser,systemusererrormsgs).getZipcodeError());

                     

                      assertEquals(Epassword,systemuser.validateUser1(systemuser,systemusererrormsgs).getPasswordError());

                      assertEquals(Eutaid,systemuser.validateUser1(systemuser,systemusererrormsgs).getUtaIdError());

                      assertEquals(Efirstname,systemuser.validateUser1(systemuser,systemusererrormsgs).getFirstNameError());

                      assertEquals(Elastname,systemuser.validateUser1(systemuser,systemusererrormsgs).getLastNameError());

                      assertEquals(Ephone,systemuser.validateUser1(systemuser,systemusererrormsgs).getPhoneError());

                      assertEquals(Eemail,systemuser.validateUser1(systemuser,systemusererrormsgs).getEmailError());

                      assertEquals(Eaddress,systemuser.validateUser1(systemuser,systemusererrormsgs).getAddressError());

                      assertEquals(Ecity,systemuser.validateUser1(systemuser,systemusererrormsgs).getCityError());

                      assertEquals(Estate,systemuser.validateUser1(systemuser,systemusererrormsgs).getStateError());

                      assertEquals(Ezipcode,systemuser.validateUser1(systemuser,systemusererrormsgs).getZipcodeError());

                      systemusererrormsgs.getErrorMsg();

                     

                    systemuser.userRegister(username,password,utaid,firstname,lastname,phone,email,address,city,state,zipcode,role);

                      systemuser.userLogin(username,password);

                      systemuser.setUpdateUser(username, firstname, Elastname, Ephone, Eemail, Eaddress, Ecity, Estate, Ezipcode, role);

                      systemuser.setUpdateRole(username,role);

                      systemuser.getRole();
                      
                      systemuser.getUser();
                     /* String user1="";
                      systemuser.setUser(user1);
                      String action="";
                      String userError1="";
                      systemuser.validateSelectedUser(action,userError1,systemusererrormsgs);
                      systemuser.validateSelectedUserFromDB(action,userError1);
                      systemusererrormsgs.getErrorMsg();
                      
                      systemusererrormsgs.getUserError();
                      String userError="";
                     // systemusererrormsgs.setUserError(userError);  */          

           }                   

}