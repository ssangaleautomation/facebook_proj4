package TestingNGDEMO;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.Base;
import Pages.ForgotPassword;
import Pages.HomePageFacebookLogin;
import Utils.Utility;

public class HomePageTestNGClass extends Base {
	
	HomePageFacebookLogin homepage;
	
	WebDriver driver;
	
	SoftAssert soft;
	String TESTID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
		System.out.println("Before Test-1");
		if(BrowserName.equals("Chrome"))
		{
			driver=OpenChromeBrowser();
		}
		if(BrowserName.equals("Firefox"))
	    {
			driver=OpenFirefoxBrowser();
		}
		if(BrowserName.equals("Edge"))
	    {
			driver=OpenEgdeBrowser();
		}
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@BeforeClass
	public void createPOMObject() {
		
		homepage=new HomePageFacebookLogin(driver);	
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method-1");
		driver.get("https://www.facebook.com/");
	
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyTextMessagePresentInHomePage() {
		System.out.println("Test1");
 
		 String Actualmsg=homepage.VerifyHomText();
		 String Expectsmg="Facebook helps you connect and share with the people in your life.";
		soft.assertEquals(Actualmsg, Expectsmg,"HomePage Message is wrong");
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifyLoginPageisOpen()  {
		System.out.println("Test2");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
	
		homepage.SendOnEmailOrPhone();
		WebDriverWait wait1=new WebDriverWait(driver,20);	
		homepage.SendOnPassword();
		WebDriverWait wait2=new WebDriverWait(driver,20);	
		homepage.ClickOnLoginButton();
		
		
	
		String actualTitle=driver.getTitle();
		String expectedTitle="Facebook – log in or sign up";
		
	

		soft.assertEquals(actualTitle, expectedTitle,"Title is wrong");
		soft.assertAll();
	}	
	@Test(priority=3)
	public void VerifyErrorSMGOccursByPassingInvalidData() {
		TESTID="TEST-3001";
		System.out.println("Test3");
		
		homepage.SendOnEmailOrPhone();
		homepage.SendOnPassword();
		homepage.ClickOnLoginButton();
		
		String actualText=homepage.VerifyEmailErrorSmgByPassingWrongData();
		String expectedTitle="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		
	
		soft.assertEquals(actualText, expectedTitle,"Error smg Is Wrong");
	
		soft.assertAll();
	}	
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-1");
	}
	
	@AfterClass
	public void clearObject() {
		homepage=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-1");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
		
}



