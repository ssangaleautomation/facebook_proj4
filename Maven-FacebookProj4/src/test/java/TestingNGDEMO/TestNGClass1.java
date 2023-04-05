package TestingNGDEMO;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import BrowserSetup.Base;
import Pages.ForgotPassword;
import Pages.HomePageFacebookLogin;
import Utils.Utility;

public class TestNGClass1 extends Base {
	
	
	WebDriver driver;
	ForgotPassword forgotpass;
	SoftAssert soft;
	String TESTID;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		System.out.println("Before Test-2");
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
		
		 forgotpass=new ForgotPassword(driver);
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method-2");
		driver.get("https://www.facebook.com/");
		
		forgotpass.ClickonForgotPassword();
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyMessageonforgotpasswordPage() {
		TESTID="TEST-3005";
		System.out.println("Test A");

		 String Actualmsg=forgotpass.getTextMessage();
		 String Expectsmg="Please enter your email address or mobile number to search for your account.";
		soft.assertEquals(Actualmsg, Expectsmg,"Message is wrong");
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifyCancelbuttononForgotpasswordpage() {
		TESTID="TEST-3006";
		System.out.println("Test B");

		forgotpass.ClickonCancel();
		String expectedURL="https://www.facebook.com/login.php";
		String expectedTitle="Log in to Facebook";
		String actualURL=driver.getCurrentUrl();
		String actualTitle=driver.getTitle();
	
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualTitle, expectedTitle,"Title is wrong");
		soft.assertAll();
	}	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
	
		System.out.println("After Method-2");
	}
	
	@AfterClass
	public void clearObject() {
		forgotpass=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-2");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	
	
	
	
	
}

	
	


