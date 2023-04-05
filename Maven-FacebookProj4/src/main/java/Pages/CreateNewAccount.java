package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount {
	
	
	@FindBy (xpath="//a[contains(text(),'Create new account')]")
	private WebElement CreateNewAccount;
	
	
	
	
	@FindBy (xpath="//div[@class='mbs _52lq fsl fwb fcb']")
	private WebElement SignUpText;
	
	@FindBy (xpath="//div[contains(@class,'pvl _52lp _59d-')]//div[2]")
	private WebElement ItsQuickandEasyText;
	
	@FindBy (xpath="//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement LastName;
	
	@FindBy (xpath="//input[@name='reg_email__']")
	private WebElement EmailOrMobNo;
	
	@FindBy (xpath="//input[@name='reg_passwd__']")
	private WebElement NewPassword;
	
	@FindBy (xpath="//select[@id='day']")
	private WebElement DayofBirth;
	
	@FindBy (xpath="//select[@id='month']")
	private WebElement MonthofBirth;
	
	@FindBy (xpath="//select[@id='year']")
	private WebElement YearofBirth;
	
	@FindBy (xpath="(//input[contains(@class,'_8esa')])[2]")
	private WebElement GenderMale;
	
	@FindBy (xpath="(//button[contains(text(),'Sign Up')])[1]")
	private WebElement SignUp;
	
	@FindBy (xpath="//div[contains(@class,'UIFullPage_Container')]//h2")
	private WebElement ConfirmationCodeText;
	
	
	WebDriver driver4;
	
	public CreateNewAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver4=driver;  
}
	
	public void ClickoncreateNewAccount () {
		CreateNewAccount.click();
	}
	public String VerifyTextSignUp () {
		String text=SignUpText.getText();
		return text;
	}
	public String VerifyTextItsQuickAndEasy () {
		String text=ItsQuickandEasyText.getText();
		return text;
	}

	public void SendonFirstName () {
		FirstName.sendKeys("SHARAD");
	}
	
	public void SendonSurName () {
		LastName.sendKeys("SANAP");
	}

	public void SendonEmailOrMob () {
		EmailOrMobNo.sendKeys("8765452599");
	}
	public void SendonNewPassword () {
		NewPassword.sendKeys("Pass@1234");
	}
	public void SelectDayofBirth () {
		Select select=new Select(DayofBirth);
		select.selectByVisibleText("20");
	}
	public void SelectMonthofBirth () {
		Select select=new Select(MonthofBirth);
		select.selectByVisibleText("Aug");
	}
	public void SelectYearofBirth () {
		Select select=new Select(YearofBirth);
		select.selectByVisibleText("2000");
	}
	public void ClickonMaleGender () {
		Actions act =new Actions(driver4);
		act.click(GenderMale).build().perform();
	}
	
	public void ClickonSignUp () {
		SignUp.click();
	}
	
	public String VerifyTextOnConfirmationCode () {
		String text=ConfirmationCodeText.getText();
		return text;
	}
	
	
	
	
	

	
	
}