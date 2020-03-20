package tests1;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;
import java.io.FileInputStream;
import functions.Macfunctions;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC01 extends Macfunctions {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer(); 
  public static String sAppURL, sSharedUIMapPath,username,password;
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    prop=new Properties();	  
	    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
		username = prop.getProperty("Login_UserNameInput");
		password = prop.getProperty("Login_PasswordInput");
	    prop.load(new FileInputStream("./Configuration/Mac_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
 
  //@Test
  @FileParameters("src/tests1/TC01a.csv")  //check for all validation errors for user(A05)
	 public void TC01a(String Username,String Password,String FirstName,String LastName,String UtaId,String Email,
			 String Phone,String Address,String City,String State,String ZipCode,String role, String GeneralError, String UsernameError,
			 String PasswordError, String FirstNameError, String LastNameError, String UtaIdError, String EmailError, String PhoneError, 
			 String CityError, String StateError, String ZipCodeError) throws Exception {
	 
	driver.get(sAppURL);
	MacRegister(driver, Username, Password, FirstName, LastName, UtaId, Email,
			  Phone, Address, City, State, ZipCode);
    takeScreenshot(driver,"TC01a_userregister_error_testcase1");
	try {
	      assertEquals(UsernameError, driver.findElement(By.xpath(prop.getProperty("Register_UserNameError"))).getAttribute("value"));     
	      assertEquals(PasswordError, driver.findElement(By.xpath(prop.getProperty("Register_PasswordError"))).getAttribute("value"));
	      assertEquals(FirstNameError, driver.findElement(By.xpath(prop.getProperty("Register_FirstNameError"))).getAttribute("value"));
	      assertEquals(LastNameError, driver.findElement(By.xpath(prop.getProperty("Register_LastNameError"))).getAttribute("value"));
	      assertEquals(UtaIdError, driver.findElement(By.xpath(prop.getProperty("Register_UtaIdError"))).getAttribute("value"));
	      assertEquals(EmailError, driver.findElement(By.xpath(prop.getProperty("Register_EmailError"))).getAttribute("value"));
	      assertEquals(PhoneError, driver.findElement(By.xpath(prop.getProperty("Register_PhoneError"))).getAttribute("value"));
	      assertEquals(CityError, driver.findElement(By.xpath(prop.getProperty("Register_CityError"))).getAttribute("value"));
	      assertEquals(StateError, driver.findElement(By.xpath(prop.getProperty("Register_StateError"))).getAttribute("value"));
	      assertEquals(ZipCodeError, driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeError"))).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	
  }
  
  @Test
  @FileParameters("src/tests1/TC01b.csv") //register user
	 public void TC01b(String Username,String Password,String FirstName,String LastName,String UtaId,String Email,
			 String Phone,String Address,String City,String State,String ZipCode,String role, String GeneralError, String UsernameError,
			 String PasswordError, String FirstNameError, String LastNameError, String UtaIdError, String EmailError, String PhoneError, 
			 String CityError, String StateError, String ZipCodeError) throws Exception {
	 
	driver.get(sAppURL);
	MacRegister(driver, Username, Password, FirstName, LastName, UtaId, Email,
			  Phone, Address, City, State, ZipCode);
    takeScreenshot(driver,"TC01b_userregister_testcase2");
  }

  @Test
  @FileParameters("src/tests1/TC01c.csv") //show login page validations,check all links working,check for create mar validations and successfully create MAR
  public void TC01c(String WrongUsername,String WrongPassword,String UserNameError,String CorrectUsername,String CorrectPassword,String GeneralError,String DescriptionError) throws Exception {
	driver.get(sAppURL);
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
    MacLogin(driver,WrongUsername,WrongPassword);
    takeScreenshot(driver,"TC01c_userlogin_error_testcase3");
    try {   //verifying login error
      assertEquals(UserNameError, driver.findElement(By.xpath(prop.getProperty("LoginPage_UserName_Error"))).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    MacLogin(driver,CorrectUsername,CorrectPassword);
    takeScreenshot(driver,"TC01c_userlogin_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_ViewProfile_Link"))).click();
    try { //check user home page
    	assertEquals("Mavericks Application Center", driver.findElement(By.xpath(prop.getProperty("User_ViewProfile_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC01c_ViewProfileTitle_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_ReturntoHomePage"))).click();
    driver.findElement(By.xpath(prop.getProperty("User_UpdateProfile_Link"))).click();
    try { //check user update profile home page
    	assertEquals("Update Profile", driver.findElement(By.xpath(prop.getProperty("User_UpdateProfile_Title"))).getText());
    	
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC01c_UpdateProfileTitle_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_ReturntoHomePage"))).click();
    driver.findElement(By.xpath(prop.getProperty("User_CreateProblemReport_Link"))).click();
    try {  //check create problem report
    	assertEquals("Create Problem Report", driver.findElement(By.xpath(prop.getProperty("User_CreateProblemReport_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC01c_CreateProblemReportTitle_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_ReturntoHomePage"))).click();
    driver.findElement(By.xpath(prop.getProperty("User_SearchProblemReport_Link"))).click();
    try { //check search problem report
    	assertEquals("Mavericks Activity Center Application", driver.findElement(By.xpath(prop.getProperty("User_SearchProblemReport_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC01c_SearchProblemReportTitle_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_ReturntoHomePage"))).click();
    driver.findElement(By.xpath(prop.getProperty("User_CreateProblemReportLink"))).click();
    driver.findElement(By.xpath(prop.getProperty("CreateMar_CreateMarButton"))).click();
    takeScreenshot(driver,"TC01c_user_createmar_error_testcase3");
    try { //check for error message
    	assertEquals(GeneralError, driver.findElement(By.xpath(prop.getProperty("CreateMar_ErrorMsg"))).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try { //check for description error message
    	assertEquals(DescriptionError, driver.findElement(By.xpath(prop.getProperty("CreateMar_DescriptionError"))).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }//create mar successfully
    driver.findElement(By.xpath(prop.getProperty("CreateMar_DescriptionInput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("CreateMar_DescriptionInput"))).sendKeys("Needs Cleaning");
    driver.findElement(By.xpath(prop.getProperty("CreateMar_CreateMarButton"))).click();
    takeScreenshot(driver,"TC01c_user_createmar_testcase3");
    driver.findElement(By.xpath(prop.getProperty("User_LogoutLink"))).click();
  }

  @Test
  @FileParameters("src/tests1/TC01d.csv") //check for errors in update profile
	 public void TC01d(String FirstName,String LastName,String UtaId,String Email,
			 String Phone,String Address,String City,String State,String ZipCode,String role, String GeneralError,
			  String FirstNameError, String LastNameError, String UtaIdError, String EmailError, String PhoneError, 
			 String CityError, String StateError, String ZipCodeError) throws Exception {
	  driver.get(sAppURL);
	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
    MacLogin(driver,"jane123","jane123");
    driver.findElement(By.xpath(prop.getProperty("User_UpdateProfile_Link"))).click();
    MacUpdateProfile(driver, FirstName, LastName, UtaId, Email,
			  Phone, Address, City, State, ZipCode);  
    try {
	      assertEquals(FirstNameError, driver.findElement(By.xpath(prop.getProperty("Register_FirstNameError"))).getAttribute("value"));
	      assertEquals(LastNameError, driver.findElement(By.xpath(prop.getProperty("Register_LastNameError"))).getAttribute("value"));
	      assertEquals(UtaIdError, driver.findElement(By.xpath(prop.getProperty("Register_UtaIdError"))).getAttribute("value"));
	      assertEquals(EmailError, driver.findElement(By.xpath(prop.getProperty("Register_EmailError"))).getAttribute("value"));
	      assertEquals(PhoneError, driver.findElement(By.xpath(prop.getProperty("Register_PhoneError"))).getAttribute("value"));
	      assertEquals(CityError, driver.findElement(By.xpath(prop.getProperty("Register_CityError"))).getAttribute("value"));
	      assertEquals(StateError, driver.findElement(By.xpath(prop.getProperty("Register_StateError"))).getAttribute("value"));
	      assertEquals(ZipCodeError, driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeError"))).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
    Thread.sleep(2_000);
    takeScreenshot(driver,"TC01d_user_checkupdatevalidations_testcase4");
  }

  @Test
  @FileParameters("src/tests1/TC01e.csv") //update profile successfully and logout
	 public void TC01e(String UserName,String Password,String Email) throws Exception {
	  driver.get(sAppURL);
	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
    MacLogin(driver,UserName,Password);
    driver.findElement(By.xpath(prop.getProperty("User_UpdateProfile_Link"))).click();
    driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).clear();
	   driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).sendKeys(Email);
	   driver.findElement(By.xpath(prop.getProperty("UpdateProfile_UpdateButton"))).click();
	   Thread.sleep(2_000);
	   takeScreenshot(driver,"TC01e_user_sucessfulupdate_testcase5");
	   driver.findElement(By.xpath(prop.getProperty("User_LogoutLink"))).click();
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
