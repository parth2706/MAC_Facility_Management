package tests1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import functions.Macfunctions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(JUnitParamsRunner.class)

public class SeleniumTC02 extends Macfunctions{
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath,username,password, baseUrl;
  
  @Before
  public void setUp() throws Exception 
  {
	  System.setProperty("webdriver.chrome.driver", "C://ChromeDriver/chromedriver.exe");
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
  @FileParameters("src/tests1/TC02a.csv")  //register
  public void TC02a(String Username,String Password,String FirstName,String LastName,String UtaId,String Email,String Phone,String Address,String City,String State,String ZipCode) throws Exception {
    
	driver.get(sAppURL);
	
	new Macfunctions().CommonMacRegister(driver, Username, Password, FirstName, LastName, UtaId, Email, Phone, Address, City, State, ZipCode);
	
    driver.findElement(By.xpath(prop.getProperty("Register_FacilityManager"))).click();
    
    takeScreenshot(driver,"TC02a Facility Manager Register Page test case 1");

    
    driver.findElement(By.xpath(prop.getProperty("Register_InsertUserButton"))).click();
    driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
    
  }
  
  @Test
  @FileParameters("src/tests1/TC02b.csv")   //10 repair per week validation while assigning mar to repairer
  public void TC02b(String repairer) throws Exception {
	  driver.get(sAppURL);
	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  MacLogin(driver,"fm12345","fm12345");
	    
	  takeScreenshot(driver,"TC02b Facility Manager Home Page test case 1");
	  
	    driver.findElement(By.xpath(prop.getProperty("FacilityManager_ShowUnassignedMarLink"))).click(); 
	    
	    try { //check for unassigned mar list page
	    	assertEquals("Select MAR", driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarHeading"))).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarValue"))).click(); 
	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_EditButton"))).click();
	    
	    try { //check for list specific unassigned mar list page
	    	assertEquals("MAR Number:", driver.findElement(By.xpath(prop.getProperty("AssignMar_MarNumber"))).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    new Select(driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignedToInput")))).selectByVisibleText(repairer);

	    driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignButton"))).click();
	   
	    takeScreenshot(driver,"TC02b 10 Repair per week test case 1"); //screenshot of 10 repair validation
	      //cannot do assert because validation message is a html value but you can see the screenshot
  }
  
  @Test
  @FileParameters("src/tests1/TC02c.csv")  //5 repair/day validation while assigning mar to repairer
  public void TC02c(String repairer) throws Exception {
	  driver.get(sAppURL);
	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  MacLogin(driver,"fm12345","fm12345");
	    
	  
	    driver.findElement(By.xpath(prop.getProperty("FacilityManager_ShowUnassignedMarLink"))).click(); 
	    
	    try { //check for unassigned mar list page
	    	assertEquals("Select MAR", driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarHeading"))).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarValue"))).click(); 
	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_EditButton"))).click();
	    
	    try { //check for list specific unassigned mar list page
	    	assertEquals("MAR Number:", driver.findElement(By.xpath(prop.getProperty("AssignMar_MarNumber"))).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    new Select(driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignedToInput")))).selectByVisibleText(repairer);

	    driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignButton"))).click();
	  	    
	    takeScreenshot(driver,"TC02c 5 Repair per day test case 1"); //screenshot of 5 repair validation	    
	    //cannot do assert because validation message is a html value but you can see the screenshot
  }
  
	    @Test
	    @FileParameters("src/tests1/TC02d.csv") //searches mar,reviews mar, successfully assign mar(Happy State)
	    public void TC02d(String repairer) throws Exception {
	  	  driver.get(sAppURL);
	  	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  	  MacLogin(driver,"fm12345","fm12345");
	  	    
	  	    
	  	    driver.findElement(By.xpath(prop.getProperty("FacilityManager_ShowUnassignedMarLink"))).click();  
	  	    takeScreenshot(driver,"TC02d Show unassigned page");
	  	    try { //check for unassigned mar list page
		    	assertEquals("Select MAR", driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarHeading"))).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  	  
	  	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_SelectMarValue"))).click(); 
	  	    driver.findElement(By.xpath(prop.getProperty("ShowUnassignedMar_EditButton"))).click(); 
	  	  
	  	    try { //check for list specific unassigned mar list page
		    	assertEquals("MAR Number:", driver.findElement(By.xpath(prop.getProperty("AssignMar_MarNumber"))).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  	    new Select(driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignedToInput")))).selectByVisibleText(repairer);

	  	    driver.findElement(By.xpath(prop.getProperty("AssignMar_AssignButton"))).click();
	  	    takeScreenshot(driver,"TC02d MarAssigned test case 1");
	  	    
	  	    try { //check for successfully assigned mar to vaibhav
		    	assertEquals("vaibhav", driver.findElement(By.xpath(prop.getProperty("AssignMar_TimeValue"))).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	  	  
	  	    driver.findElement(By.xpath(prop.getProperty("AssignedMar_BackToHomePageButton"))).click();
	  	    driver.findElement(By.xpath(prop.getProperty("FacilityManager_LogoutLink"))).click();
	    }
	    
	    @Test
	    @FileParameters("src/tests1/TC02e.csv")//searches for MAR by date,facility type,name assignedTo and Marno
	    public void TC02e(String dateToSearch, String facilityType, String facilityName, String assignedTo, String marNo) throws Exception {
	  	  driver.get(sAppURL);
	  	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  	  MacLogin(driver,"fm12345","fm12345");
	  
		    driver.findElement(By.xpath(prop.getProperty("FacilityManager_SearchForassignedMarLink"))).click();
		    try { //check for search mar page
		    	assertEquals("Search MAR", driver.findElement(By.xpath(prop.getProperty("SearchMarFM_Heading"))).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    driver.findElement(By.xpath(prop.getProperty("SearchMarFM_StartDateInput"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("SearchMarFM_StartDateInput"))).sendKeys(dateToSearch);
		    driver.findElement(By.xpath(prop.getProperty("SearchMarFM_StartTimeInput"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("SearchMarFM_StartTimeInput"))).sendKeys("");
		    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarFM_FacilityTypeInput")))).selectByVisibleText(facilityType);
		    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarFM_FacilityNameInput")))).selectByVisibleText(facilityName);
		    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarFM_AssignedToValue")))).selectByVisibleText(assignedTo);
		    new Select(driver.findElement(By.xpath(prop.getProperty("SearchMarFM_MarNoInput")))).selectByVisibleText(marNo);
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		    Thread.sleep(5000);
		    takeScreenshot(driver,"TC02e search for mar based on date,repairer,facility name and type");
		    driver.findElement(By.id("MAR3")).click();
		    driver.findElement(By.name("ListSelectedCompanyButton")).click();
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		    takeScreenshot(driver,"TC02e view mar after inputs of date,repairer,facility name and type");
		    driver.findElement(By.xpath(prop.getProperty("FacilityManager_LogoutLink"))).click();
	    }
	    
	    @Test
	    @FileParameters("src/tests1/TC02f.csv")//check for validations while adding new facility
	    public void TC02f(String facilityName, String facilityType, String output1, String output2, String output3) throws Exception {
	  	  driver.get(sAppURL);
	  	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  	  MacLogin(driver,"fm12345","fm12345");
	  	    
		    driver.findElement(By.xpath(prop.getProperty("FacilityManager_AddNewFacilityLink"))).click();
		    
		    try { //check for search mar page
		    	assertEquals("Add New Facility", driver.findElement(By.xpath(prop.getProperty("AddNewFacility_Heading"))).getText());
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
		    
		    addFacility(driver, facilityName, facilityType);
		    takeScreenshot(driver,"TC02f validations while creating new facility");
		    try {//assert for all validation messages 
	
			      assertEquals(output1, driver.findElement(By.xpath(prop.getProperty("AddNewFacility_ErrorMsg"))).getAttribute("value")); 
			      assertEquals(output2, driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityTypeError"))).getAttribute("value")); 
			      assertEquals(output3, driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityNameError"))).getAttribute("value")); 
			      
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
	    }
	    
	   @Test
	    @FileParameters("src/tests1/TC02g.csv")//successfully adds new facility
	    public void TC02f1(String facilityName, String facilityType, String output1) throws Exception {
	  	  driver.get(sAppURL);
	  	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  	  MacLogin(driver,"fm12345","fm12345");
	  	    
		    driver.findElement(By.xpath(prop.getProperty("FacilityManager_AddNewFacilityLink"))).click();
		    
		    addFacility(driver, facilityName, facilityType);
		    takeScreenshot(driver,"TC02g creating new facility successfully");
		    try {//assert for successfully add a facility 
			    
			      assertEquals(output1, driver.findElement(By.xpath(prop.getProperty("FacilityManager_SucessMsg"))).getAttribute("value"));
			    
			    } catch (Error e) {
			      verificationErrors.append(e.toString());
			    }
		    
	    }
	    
	    @Test
	    public void TC02g() throws Exception {
	  	  driver.get(sAppURL);
	  	  driver.findElement(By.xpath(prop.getProperty("MainApp_LoginLink"))).click();
	  	  MacLogin(driver,"fm12345","fm12345");
	  	    
	  	driver.findElement(By.xpath(prop.getProperty("FacilityManager_ViewAllFacilityLink"))).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'View')])[2]")).click();
	    driver.findElement(By.linkText("Back to home page")).click();
		    
		driver.findElement(By.xpath(prop.getProperty("FacilityManager_LogoutLink"))).click();
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
