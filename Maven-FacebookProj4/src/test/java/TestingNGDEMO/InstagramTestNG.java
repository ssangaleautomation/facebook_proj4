package TestingNGDEMO;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import Pages.Instagram;

public class InstagramTestNG {
	
	
	WebDriver driver;
	Instagram instaa;
	
	WebDriver wait;
	SoftAssert soft;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		System.out.println("Before Test-4");
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
		System.out.println("Before Class-4");
		instaa=new Instagram(driver);
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method-4");
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,600)");
	
		instaa.ClickonInstagram();
		
		Thread.sleep(5000);
		
		ArrayList<String> allAddr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allAddr.get(1));
		//Main Browser To Child Browser.......
		
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyInstagramLink() {
		System.out.println("Test X");
		
		 String ActualTitle=driver.getTitle();
		 String ExpectTitle="Instagram";

		soft.assertEquals(ActualTitle, ExpectTitle,"Tile is wrong");
		

		 String ActualURL=driver.getCurrentUrl();
		 String ExpectURL="https://www.instagram.com/";

		soft.assertEquals(ActualURL, ExpectURL,"URL is wrong");
		
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifyForgotPassworfLinkInstagram() throws InterruptedException {
		System.out.println("Test Y");
		

	//Child Browser to Another Child Browse.......	
		ArrayList<String> allAddr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allAddr.get(2));
		
		instaa.ClickonForgotPassword();
		
		Thread.sleep(8000);
		
		 String ActualTitle=driver.getTitle();
		 String ExpectTitle="Reset Password • Instagram";

		soft.assertEquals(ActualTitle, ExpectTitle,"Tile is wrong");
		

		 String ActualURL=driver.getCurrentUrl();
		 String ExpectURL="https://www.instagram.com/accounts/password/reset/";

		soft.assertEquals(ActualURL, ExpectURL,"URL is wrong");
		
		
		
		soft.assertAll();
	}
	@Test(priority=3)
	public void VerifyUserCanGoInstagramPageToFacebookMainPage() throws InterruptedException {
		System.out.println("Test Z");
		
       // Child Browser to Main Browser
		
		ArrayList<String> allAddr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allAddr.get(0));
		
		String ActualTitle=instaa.HomePageTextCreatePage();
		 String ExpectTitle="Create a Page";

		soft.assertEquals(ActualTitle, ExpectTitle,"Tile is wrong");
		
		soft.assertAll();
		
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method-4");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-4");
//		instaa=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-4");
		driver.quit();
	//	driver=null;
	//	System.gc();
	}
	
	
//	  <class name="TestingNGDEMO.HomePageTestNGClass"/>
  //    <class name="TestingNGDEMO.TestNGClass1"/>
  //     <class name="TestingNGDEMO.CreateNewAccountTestNG"/>	
	
	

}


