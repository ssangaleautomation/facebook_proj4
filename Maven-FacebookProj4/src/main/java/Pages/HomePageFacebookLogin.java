package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFacebookLogin {
	
	
	
	
	@FindBy (xpath="//div[@class='_8esk']//h2")
	private WebElement HomePageText;
	
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement EmailOrPhone;
	
	@FindBy (xpath="//input[@id='pass']")
	private WebElement Password;
	
	@FindBy (xpath="//button[text()='Log in']")
	private WebElement LogInButton;
	
//	@FindBy (xpath="//div[@class='_9ay7']")
//	private WebElement ErrorsmgUnderPassword;
	
	@FindBy (xpath="//div[@class='_9ay7']")
	private WebElement ErrorsmgUnderEmail;
	
	WebDriver driver4;
	
	public HomePageFacebookLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver4=driver;  
}
	
	public String VerifyHomText () {
		String text=HomePageText.getText();
		return text;
	}
	public void SendOnEmailOrPhone () {
		EmailOrPhone.sendKeys("78546");
	}
	public void SendOnPassword () {
		Password.sendKeys("pass@12ss");
	}
	
	public void ClickOnLoginButton() {
		LogInButton.click();
	}
	
//	public String VerifyPasswordErrorSmgByPassingWrongData () {
//		String text=HomePageText.getText();
//		return text;
//	}
	
	
	public String VerifyEmailErrorSmgByPassingWrongData () {
		String text=ErrorsmgUnderEmail.getText();
		return text;
	}

}
