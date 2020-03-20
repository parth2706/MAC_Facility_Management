package tests1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import functions.Macfunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC03 extends Macfunctions{
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

  @Test
  @FileParameters("src/tests1/TC03a.csv")//admin creates profile and checks for all links on admin home page and changes user role
  public void TC03a(String Username,String Password,String FirstName,String LastName,String UtaId,String Email,
			 String Phone,String Address,String City,String State,String ZipCode, String wronguser,String CorrectUser) throws Exception {
	  driver.get(sAppURL);
    CommonMacRegister(driver, Username, Password, FirstName, LastName, UtaId, Email,
			  Phone, Address, City, State, ZipCode); 
    driver.findElement(By.xpath(prop.getProperty("Register_Admin"))).click();
 
    takeScreenshot(driver,"TC03_adminregister_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Register_InsertUserButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
    MacLogin(driver,"SameerMM","sam123");
    takeScreenshot(driver,"TC03_adminlogin_testcase1");

    driver.findElement(By.xpath(prop.getProperty("Admin_ViewProfileLink"))).click();
    try {
    	assertEquals("Mavericks Application Center", driver.findElement(By.xpath(prop.getProperty("Admin_ViewProfile_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

    takeScreenshot(driver,"TC03_adminviewprofiletitle_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_ReturnToHomepage"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_UpdateProfileLink"))).click();
    try {
    	assertEquals("Update Profile", driver.findElement(By.xpath(prop.getProperty("Admin_UpdateProfile_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC03_adminupdateprofiletitle_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_ReturnToHomepage"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_ChangeUserRoleLink"))).click();
    try {
    	assertEquals("Mavericks Activity Center Application", driver.findElement(By.xpath(prop.getProperty("Admin_ChangeUserRole_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC03_adminchangeuser_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_ReturnToHomepage"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUserProfileLink"))).click();
    try {
      assertEquals("Mavericks Activity Center Application", driver.findElement(By.xpath(prop.getProperty("Admin_EditUserProfile_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

    takeScreenshot(driver,"TC03_admineditprofiletitle_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_ReturnToHomepage"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Box"))).click();
    try {
    	assertEquals("Enter User Name :", driver.findElement(By.xpath(prop.getProperty("Admin_View_Title"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC03_adminviewuserstitle_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_ReturnToHomepage"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Box"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Name"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Name"))).sendKeys(wronguser);
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Submit"))).click();
    try {
    	 assertEquals("User does not exist, Please enter another User", driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Error"))).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }

    takeScreenshot(driver,"TC03_admin_userinvalid_search_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Name"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Name"))).sendKeys(CorrectUser);
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSearch_Submit"))).click();
    takeScreenshot(driver,"TC03_userinvalid_search_testcase1");
    driver.findElement(By.xpath(prop.getProperty("Admin_UserSelect"))).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_SelectedUser_View"))).click();
    new Select(driver.findElement(By.name("role"))).selectByVisibleText("facility manager");
    driver.findElement(By.xpath(prop.getProperty("Admin_ChangeUserRole_Submit"))).click();
    takeScreenshot(driver,"TC03_changeuserrole_testcase1");
    driver.findElement(By.xpath(prop.getProperty("User_LogoutLink"))).click();
  }
  

  @Test
  @FileParameters("src/tests1/TC03b.csv")//changes profile of another user
  public void TC03b(String Username, String Password,String lastname, String Role) throws Exception {
	  driver.get(sAppURL);
	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  MacLogin(driver,Username,Password);
	  driver.findElement(By.xpath(prop.getProperty("Admin_EditUserProfileLink"))).click();
	  driver.findElement(By.xpath(prop.getProperty("Select_SecondRadioButton"))).click(); 
	  driver.findElement(By.xpath(prop.getProperty("Select_Edit_Button"))).click();
	  driver.findElement(By.xpath(prop.getProperty("ChangeSpecificUserRole_LastNameInput"))).clear();
	  driver.findElement(By.xpath(prop.getProperty("ChangeSpecificUserRole_LastNameInput"))).sendKeys(lastname);
	    new Select(driver.findElement(By.name("role"))).selectByVisibleText(Role); 
	    driver.findElement(By.xpath(prop.getProperty("Admin_ChangeUserRole_Submit"))).click();
	    Thread.sleep(2_000);
	    takeScreenshot(driver,"TC03_updateuser_testcase2");
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