package com.cosfa.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cosfa.qa.base.TestBase;
import com.cosfa.qa.pages.HomePage;
import com.cosfa.qa.pages.LoginPageObjectory;


public class LoginPageTest extends TestBase {
	HomePage homepage;
	LoginPageObjectory login;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() 
	{
	initialization();
	login=new LoginPageObjectory();
		}
	
	
	@Test
	public void LoginPageTitleTest()
	{
		String a=login.validateLoginpagetitle();
		Assert.assertEquals(a, "School of WDC | Sign in");
	}
	
	@Test
	public void LogoTest()
	{
		boolean b=login.verifyLogo();
		Assert.assertTrue(b);
	}
	
	@Test
	public void LoginTest()
	{
		 homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	
	
	
	
	
@AfterMethod
public void teardown()
{
	driver.quit();
	}
}
