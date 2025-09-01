package Functional_Automation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_ECOM_Login_009 {
	
	WebDriver driver;
	LoginPage loginPage;
	String projectpath=System.getProperty("user.dir");
	private ExtentReports extent;
	
  @Test
  public void f() {
	  ExtentReports extent=new ExtentReports();
	  
	  ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"\\TC_ECOM_Login_009.html");
      extent = new ExtentReports();
      extent.attachReporter(spark); 
	
	  
	  loginPage.clickLoginLink();
	  loginPage.enterEmail(" subhashm9579@gmail.com");
	  loginPage.enterPassword("Hello@123");
	  loginPage.clickLoginButton();
	  
      Assert.assertTrue(loginPage.isLogoutDisplayed()," Login success");
      loginPage.clickLogout();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		loginPage = new LoginPage(driver);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {

  }

  @AfterSuite
  public void afterSuite() {
	  extent.flush(); 

  }

}
