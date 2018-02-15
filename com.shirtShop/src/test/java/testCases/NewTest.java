package testCases;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import config.Configclass;
import config.Takescreenshot;
import inputData.data;
import pages.basics;
import pages.selectShortSleevePage;
import pages.selectSummerPage;

public class NewTest
{
	WebDriver driver;
	
	//accessing Properties
	Configclass configObj=new Configclass();
	Properties prop=configObj.readProperty("C:\\Users\\nandhinid\\workspace\\com.shirtShop\\src\\test\\java\\config\\Utilities.property");
	
	//reference to ShortSleevePage
	selectShortSleevePage shortSleeveObj;
	
	//reference to BasicPage
	basics basicsObj;
	
	//reference to SummerPage
	selectSummerPage summerObj;
	
	//launching Browser...
	 @BeforeTest
	  public void setUp()
	  {
		  driver=new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(prop.getProperty("url"));
	  }
	 
	 //login to site
	 @BeforeClass
	 public void login() throws FilloException
	 {
		 ArrayList<String> credentials=data.readData(prop.getProperty("dataSheet"));
		 String userName=credentials.get(0);
		 String password=credentials.get(1);
		 basicsObj=new basics(driver);
		 basicsObj.clickLogin(userName,password);
	 }
	 
	//shopping
	 @Test
	 public void selectFadedTshirt() throws InterruptedException 
	 {
		//purchasing fadedShortSleeve T-shirt
		shortSleeveObj=new selectShortSleevePage(driver); 
		shortSleeveObj.selectTshirt(5);
		
		//purchasing summerDress
		summerObj=new selectSummerPage(driver);
		summerObj.selectSummerDress("Summer Dresses");
	 }
	
	 //logout
	 @AfterClass
	 public void logout()
	 {
		 basicsObj.logout();
	 }
	  
     //terminate browser
	  @AfterTest
	  public void setDown()
	  {
		  driver.close();
	  }

}
