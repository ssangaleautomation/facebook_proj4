package TestingNGDEMO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CreateNewAccount;
import Pages.ForgotPassword;

public class CreateNewAccountTestNG {

	WebDriver driver;
	CreateNewAccount createnewacc;
	SoftAssert soft;
	WebDriver wait;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		System.out.println("Before Test-3");
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(BrowserName.equals("Firefox"))
	    {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium New file\\geckodriver-v0.32.2-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(BrowserName.equals("Edge"))
	    {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium New file\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class-3");
		createnewacc=new CreateNewAccount(driver);
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method-3");
		driver.get("https://www.facebook.com/");
		createnewacc.ClickoncreateNewAccount();
		
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyTextOnSignUpPage() {
		System.out.println("Test D");

		 String Actualmsg=createnewacc.VerifyTextSignUp();
		 String Expectsmg="Sign Up";
		soft.assertEquals(Actualmsg, Expectsmg,"Message is wrong");
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifyTextItsQuickandEasyonPage() {
		System.out.println("Test E");

		 String Actualmsg=createnewacc.VerifyTextItsQuickAndEasy();
		 String Expectsmg="It's quick and easy.";
		soft.assertEquals(Actualmsg, Expectsmg,"Message is wrong");
		soft.assertAll();
	}
	@Test(priority=3)
	public void VerifytheSignUpButton() throws InterruptedException {
		System.out.println("Test E"); 
		
	
		createnewacc.SendonFirstName();
		createnewacc.SendonSurName();
		createnewacc.SendonEmailOrMob();
		createnewacc.SendonNewPassword();
		createnewacc.SelectDayofBirth();
		createnewacc.SelectMonthofBirth();
		createnewacc.SelectYearofBirth();	
		createnewacc.ClickonMaleGender();	
		createnewacc.ClickonSignUp();
		
		Thread.sleep(10000);
	
		
		String expectedURL="https://www.facebook.com/confirmemail.php?next=https%3A%2F%2Fwww.facebook.com%2F";
		String actualURL=driver.getCurrentUrl();
		
		 String actualmsg=createnewacc.VerifyTextOnConfirmationCode();
		 String expectsmg="Enter the confirmation code from the text message";
		
		

		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualmsg, expectsmg,"Text is wrong");
		soft.assertAll();
	}	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method-3");
	}
	
	@AfterClass
	public void clearObject() {
		createnewacc=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-3");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	
	
	
	
	
}

	
	

