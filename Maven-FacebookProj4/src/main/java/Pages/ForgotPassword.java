package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	@FindBy (xpath="//a[text()='Forgotten password?']")
	private WebElement ForgotPassword;
	
	@FindBy (xpath="//table//div")
	private WebElement textMessage;
	
	@FindBy (xpath="(//input[@name='email'])[2]")
	private WebElement EmailOrMobNo;
	
	@FindBy (xpath="//a[text()='Cancel']")
	private WebElement CancelButton;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement SearchButton;
	
	
	public ForgotPassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
		
		public void ClickonForgotPassword() {
			ForgotPassword.click();
		}
		public String getTextMessage() {
			String text=textMessage.getText();
			return text ;
		}
		public void SendonEmailOrMobno() {
			EmailOrMobNo.sendKeys("akash.yeole@rediffmail.com");
		}
		public void ClickonCancel() {
			CancelButton.click();
		}
		public void ClickonSearch() {
			SearchButton.click();
		}
	
	
	

}
