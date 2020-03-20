package functions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class Macfunctions{
	 public static WebDriver driver;
	  public static Properties prop;

	   public void takeScreenshot(WebDriver driver, String screenshotname) {
			  try
			  {
				  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
				  FileUtils.copyFile(source, new File("./ScreenShots/" + screenshotname +".png"));
			  }
			  catch(IOException e) {}
			  try {
				  Thread.sleep(0);
			} catch (InterruptedException e) {} 
	   }
	   
	   public void MacLogin (WebDriver driver, String sUserName, String sPassword ) {
		   driver.findElement(By.xpath(prop.getProperty("Login_UserNameInput"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Login_UserNameInput"))).sendKeys(sUserName);
		    driver.findElement(By.xpath(prop.getProperty("Login_PasswordInput"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Login_PasswordInput"))).sendKeys(sPassword);
		    driver.findElement(By.xpath(prop.getProperty("Login_LoginUserButton"))).click();
		  }
	   
	   public void MacRegister(WebDriver driver, String Username, String Password, String FirstName, String LastName, String UtaId, String Email, String Phone, String Address, String City, String State, String ZipCode ) {

		  driver.findElement(By.xpath(prop.getProperty("MainApp_RegisterLink"))).click();
		   driver.findElement(By.xpath(prop.getProperty("Register_UserNameInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_UserNameInput"))).sendKeys(Username);
		   driver.findElement(By.xpath(prop.getProperty("Register_PasswordInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_PasswordInput"))).sendKeys(Password);
		   driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).sendKeys(FirstName);
		   driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).sendKeys(LastName);
		   driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).sendKeys(UtaId);
		   driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).sendKeys(Email);
		   driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).sendKeys(Phone);
		   driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).sendKeys(Address);
		   driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).sendKeys(City);
		   driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).sendKeys(State);
		   driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).sendKeys(ZipCode);
		   driver.findElement(By.xpath(prop.getProperty("Register_User"))).click();
		   driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		 } 

	   public void CommonMacRegister(WebDriver driver, String Username, String Password, String FirstName, String LastName, String UtaId, String Email, String Phone, String Address, String City, String State, String ZipCode ) {


			  driver.findElement(By.xpath(prop.getProperty("MainApp_RegisterLink"))).click();
			   driver.findElement(By.xpath(prop.getProperty("Register_UserNameInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_UserNameInput"))).sendKeys(Username);
			   driver.findElement(By.xpath(prop.getProperty("Register_PasswordInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_PasswordInput"))).sendKeys(Password);
			   driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).sendKeys(FirstName);
			   driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).sendKeys(LastName);
			   driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).sendKeys(UtaId);
			   driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).sendKeys(Email);
			   driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).sendKeys(Phone);
			   driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).sendKeys(Address);
			   driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).sendKeys(City);
			   driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).sendKeys(State);
			   driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).clear();
			   driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).sendKeys(ZipCode);
	
			 }
	   
	   public void MacUpdateProfile(WebDriver driver, String FirstName, String LastName, String UtaId, String Email, String Phone, String Address, String City, String State, String ZipCode ) {

		// Provide user name.
		  driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_FirstNameInput"))).sendKeys(FirstName);
		  driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_LastNameInput"))).sendKeys(LastName);
		  driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_UtaIdInput"))).sendKeys(UtaId);
		  driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_EmailInput"))).sendKeys(Email);
		  driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_PhoneInput"))).sendKeys(Phone);
		  driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_AddressInput"))).sendKeys(Address);
		  driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_CityInput"))).sendKeys(City);
		  driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_StateInput"))).sendKeys(State);
		  driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).clear();
		  driver.findElement(By.xpath(prop.getProperty("Register_ZipCodeInput"))).sendKeys(ZipCode);
		  driver.findElement(By.xpath(prop.getProperty("UpdateProfile_UpdateButton"))).click();

		}
	   
	   public void addFacility(WebDriver driver, String facilityType, String facilityName) 
	   {
	   
		   driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityTypeInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityTypeInput"))).sendKeys(facilityType);
		   driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityNameInput"))).clear();
		   driver.findElement(By.xpath(prop.getProperty("AddNewFacility_FacilityNameInput"))).sendKeys(facilityName);
		    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	   }



		

}
