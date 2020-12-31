package com.cosfa.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cosfa.qa.utility.TestUtil;

public class TestBase {
public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\src\\main\\java\\com\\cosfa\\qa\\proprties\\Config.properties");
		prop=new Properties();
		prop.load(fis);}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
           public static void initialization() 
	{
		String browsername=prop.getProperty("browser");	
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\aaa\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtim, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	}

}