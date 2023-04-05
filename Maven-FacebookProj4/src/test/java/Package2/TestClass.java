package Package2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CreateNewAccount;
import Pages.ForgotPassword;
import Pages.HomePageFacebookLogin;
import Pages.Instagram;

public class TestClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		
		
		HomePageFacebookLogin homepage=new HomePageFacebookLogin(driver);
		homepage.VerifyHomText();
		homepage.SendOnEmailOrPhone();
		homepage.SendOnPassword();
		homepage.ClickOnLoginButton();
		homepage.VerifyEmailErrorSmgByPassingWrongData();
		
		
	
		ForgotPassword forgotpass=new ForgotPassword(driver);
		forgotpass.ClickonForgotPassword();
		forgotpass.getTextMessage();
		forgotpass.SendonEmailOrMobno();
		forgotpass.ClickonCancel();
		forgotpass.ClickonSearch();
		

		CreateNewAccount createnewacc=new CreateNewAccount(driver);
		createnewacc.ClickoncreateNewAccount();
		createnewacc.VerifyTextSignUp();
		createnewacc.VerifyTextItsQuickAndEasy();
		createnewacc.SendonFirstName();
		createnewacc.SendonSurName();
		createnewacc.SendonEmailOrMob();
		createnewacc.SendonNewPassword();
		createnewacc.SelectDayofBirth();
		createnewacc.SelectMonthofBirth();
		createnewacc.SelectYearofBirth();
	
		createnewacc.ClickonMaleGender();
		createnewacc.ClickonSignUp();
		createnewacc.VerifyTextOnConfirmationCode();
		
		
		Instagram instaa=new Instagram(driver);
		instaa.ClickonInstagram();
		instaa.ClickonForgotPassword();
		instaa.HomePageTextCreatePage();
		
		
	
	
	
	}	

}
