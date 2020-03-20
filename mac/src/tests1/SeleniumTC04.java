package tests1;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import java.util.Properties;
import java.io.FileInputStream;
import functions.Macfunctions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


@RunWith(JUnitParamsRunner.class)
public class SeleniumTC04 extends Macfunctions {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer(); 
  public static String sAppURL, sSharedUIMapPath,username,password;
  
  @Before
  public void setUp() throws Exception {
	  //System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
	//  driver = new FirefoxDriver(); 
	  System.setProperty("webdriver.chrome.driver","C:/ChromeDriver/chromedriver.exe");  
		driver = new ChromeDriver();
	    prop=new Properties();	  
	    prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
		username = prop.getProperty("Login_UserNameInput");
		password = prop.getProperty("Login_PasswordInput");
	    prop.load(new FileInputStream("./Configuration/Mac_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 @Test
  @FileParameters("src/tests1/TC04a.csv")//registers and view my assigned repairs
	 public void TC04a(String Username,String Password,String FirstName,String LastName,String UtaId,String Email,
			 String Phone,String Address,String City,String State,String ZipCode) throws Exception {
	 
	driver.get(sAppURL);
	
	new Macfunctions().CommonMacRegister(driver, Username, Password, FirstName, LastName, UtaId, Email, Phone, Address, City, State, ZipCode);
	
    driver.findElement(By.xpath(prop.getProperty("Register_Repairer"))).click();
    takeScreenshot(driver,"TC04 Register Repairer test case 1");
    driver.findElement(By.xpath(prop.getProperty("Register_InsertUserButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
  
    MacLogin(driver,"vaibhav5","lahoti1");
    try {
    	assertEquals("Welcome Repairer", driver.findElement(By.xpath(prop.getProperty("Repairer_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC04a Verify Repairer Home Page test case 1");
    driver.findElement(By.xpath(prop.getProperty("Repairer_ViewReservedRepairLink"))).click();
    try {
    	assertEquals("My reserved Repairs", driver.findElement(By.xpath(prop.getProperty("CancelReservation_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC04a View list of reserved Repair Page test case 1");
    driver.findElement(By.xpath(prop.getProperty("ListReservation_SelectCompanyValue"))).click();
    driver.findElement(By.xpath(prop.getProperty("ListReservation_SubmitButton"))).click();
    try {
    	assertEquals("Reservation", driver.findElement(By.xpath(prop.getProperty("Reservation_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC04a View Specific Repair Page test case 1");
    driver.findElement(By.xpath(prop.getProperty("Reservation_LogoutLink"))).click();
	 }
  
  @Test
  @FileParameters("src/tests1/TC04b.csv")//10 repair validation while requesting reservation
  public void TC04b(String starttime,String endtime) throws Exception {
	
	driver.get(sAppURL);
	  
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	
	MacLogin(driver,"vaibhav4","lahoti1");
   
    driver.findElement(By.xpath(prop.getProperty("Repairer_RequestReservationLink"))).click();
    try {
    	assertEquals("Search MARs to Reserve", driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_StartDateInput")))).selectByVisibleText("Last 7 Days");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityTypeInput")))).selectByVisibleText("Multipurpose Rooms");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityNameInput")))).selectByVisibleText("MR1");
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_SearchMarButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_RadioButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_EditButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).sendKeys(starttime);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).sendKeys(endtime);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_Button"))).click();
    takeScreenshot(driver,"TC04b 10 repairs validation while requesting reservation");
    Thread.sleep(3000);
    
  }

  @Test
  @FileParameters("src/tests1/TC04b.csv")//5 repair validation while requesting reservation
  public void TC04c(String starttime,String endtime) throws Exception {
	
	driver.get(sAppURL);
	  
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	
	MacLogin(driver,"eapen","eap");
   
    driver.findElement(By.xpath(prop.getProperty("Repairer_RequestReservationLink"))).click();
    try {
    	assertEquals("Search MARs to Reserve", driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_StartDateInput")))).selectByVisibleText("Last 7 Days");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityTypeInput")))).selectByVisibleText("Multipurpose Rooms");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityNameInput")))).selectByVisibleText("MR1");
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_SearchMarButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_RadioButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_EditButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).sendKeys(starttime);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).sendKeys(endtime);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_Button"))).click();
    takeScreenshot(driver,"TC04c 5 repairs validation while requesting reservation");
    Thread.sleep(3000);
  }
  
  @Test
  @FileParameters("src/tests1/TC04c.csv")//time interval mismatch,repairer already booked validations while requesting reservation and then successfully assign reservation to repairer
  public void TC04d(String starttime,String endtime ) throws Exception {
	
	driver.get(sAppURL);
	  
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	
	MacLogin(driver,"vaibhav1","lahoti1");
   
    driver.findElement(By.xpath(prop.getProperty("Repairer_RequestReservationLink"))).click();
    try {
    	assertEquals("Search MARs to Reserve", driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_StartDateInput")))).selectByVisibleText("Last 7 Days");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityTypeInput")))).selectByVisibleText("Multipurpose Rooms");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityNameInput")))).selectByVisibleText("MR1");
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_SearchMarButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_RadioButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_EditButton"))).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).sendKeys(starttime);
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).sendKeys(endtime);
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_Button"))).click();
    takeScreenshot(driver,"TC04d succesfully assigned requested reservation to repairer");
    Thread.sleep(3000);
  }

  @Test
  @FileParameters("src/tests1/TC04e.csv")//modify reservation start time and end time
  public void TC04e(String starttime,String endtime ) throws Exception {
	
	driver.get(sAppURL);
	  
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	
	MacLogin(driver,"vaibhav2","lahoti1");
   
    driver.findElement(By.xpath(prop.getProperty("Repairer_ModifyReservationLink"))).click();
    //assert
    try {
    	assertEquals("Modify Reserved MARs", driver.findElement(By.xpath(prop.getProperty("ModifyReservarion_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_StartDateInput")))).selectByVisibleText("Last 7 Days");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityTypeInput")))).selectByVisibleText("Multipurpose Rooms");
    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_FacilityNameInput")))).selectByVisibleText("MR1");
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_SearchMarButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("ModifyReservarion_RadioButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("SearchMarToReserve_EditButton"))).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_StartTimeinput"))).sendKeys(starttime);
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).clear();
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_EndTimeinput"))).sendKeys(endtime);
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("EditMarToReserve_Button"))).click();
    takeScreenshot(driver,"TC04e succesfully modified reservation by repairer");
    driver.findElement(By.xpath(prop.getProperty("ModifyReservation_BackToHomePage"))).click();
    
    Thread.sleep(3000);
  }
  
  @Test//cancel reservation
  public void TC04f() throws Exception {
	
	driver.get(sAppURL);
	  
	driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	
	MacLogin(driver,"vaibhav2","lahoti1");
   
    driver.findElement(By.xpath(prop.getProperty("Repairer_CancelReservationLink"))).click();
    Thread.sleep(3000);
    //assert
    try {
    	assertEquals("My reserved Repairs", driver.findElement(By.xpath(prop.getProperty("CancelReservation_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    //
    driver.findElement(By.xpath(prop.getProperty("CancelReservation_RadioButton"))).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath(prop.getProperty("CancelReservation_cancelReservationButton"))).click();
    Thread.sleep(3000);
    
    Thread.sleep(3000);
    try {//check for successfully deleted MAR
    	assertEquals("My reserved Repairs", driver.findElement(By.xpath(prop.getProperty("CancelReservation_Heading"))).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    takeScreenshot(driver,"TC04f succesfully cancelled reservation by repairer");
        driver.findElement(By.xpath(prop.getProperty("CancelReservation_BackToHomePage"))).click();
    
    driver.findElement(By.xpath(prop.getProperty("Repairer_LogoutLink"))).click();
    
    Thread.sleep(3000);
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