import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomateDesktop {
	WiniumDriver driver;
	WebDriver driverr;
	
	
	
	@BeforeTest
	public void m1() throws MalformedURLException
	{
		DesktopOptions option=new DesktopOptions();
		option.setApplicationPath("C:\\Program Files\\Charles\\Charles.exe");
		driver=new WiniumDriver(new URL("http://localhost:9999"),option);
//	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\brw\\chromedriver.exe");
//		 driverr=new ChromeDriver();
//		driverr.get("https://www.usbank.com");
		
		
		
		
	}
	
	
	@Test
	public void n() {}
	
	@AfterTest
	
	public void f()
	{
		
		driver.switchTo().frame(1);
		
	}
	
	
	
	

}
