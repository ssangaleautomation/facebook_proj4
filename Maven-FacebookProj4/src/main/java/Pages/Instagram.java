package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Instagram {
	
	
	@FindBy (xpath="//div[@id='pageFooterChildren']//li[12]")
	private WebElement Instagramlink;
	
	
	@FindBy (xpath="//a[contains(text(),'Forgot password?')]")
	private WebElement ForgotPass;
	
	
	@FindBy (xpath="//div[@id='reg_pages_msg']//a")
	private WebElement CreatePageText;
	
	public Instagram(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	
	public void ClickonInstagram() {
		Instagramlink.click();
	}
	
	public void ClickonForgotPassword() {
		ForgotPass.click();
	}
	
	public String HomePageTextCreatePage() {
		String text=CreatePageText.getText();
		return text;
	}
	

}
