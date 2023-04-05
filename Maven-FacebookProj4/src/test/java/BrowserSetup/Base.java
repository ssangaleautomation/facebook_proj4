package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	
	
	public static WebDriver OpenChromeBrowser() {
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanja\\git\\facebook_proj4\\Maven-FacebookProj4\\src\\test\\resources\\BrowserFiles\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver OpenFirefoxBrowser() {
//		System.setProperty("webdriver.gecko.driver", "D:\\Selenium New file\\geckodriver-v0.32.2-win32\\geckodriver.exe");
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanja\\git\\facebook_proj4\\Maven-FacebookProj4\\src\\test\\resources\\BrowserFiles\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver OpenEgdeBrowser() {
//		System.setProperty("webdriver.edge.driver", "D:\\Selenium New file\\edgedriver_win64\\msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sanja\\git\\facebook_proj4\\Maven-FacebookProj4\\src\\test\\resources\\BrowserFiles\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

}



