package com.cosfa.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cosfa.qa.base.TestBase;
import com.cosfa.qa.pages.HomePage;
import com.cosfa.qa.pages.LoginPageObjectory;

public class HomePageTest extends TestBase {
    LoginPageObjectory login;
	HomePage homepage;
	public static util u;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		
	
		 u=new util("C:\\Users\\Admin PC\\eclipse-workspace\\cosfa\\src\\test\\java\\com\\cosfa\\qa\\testcases\\demodata.xlsx");
		login=new LoginPageObjectory();
		homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void homePageLogoTest() {
		boolean b = homepage.verifyHomePagelogo();
Assert.assertTrue(b);
String a="aaa";
u.addColumn("sheet1", "status");
u.setCellData("sheet1", "Status", 1, "pass");
	}

	@Test
	public void welcomeOfficeLinkTest() {
		homepage.clickOnWelcomeOffice();
	}

	@Test
	public void messageLinkTest() {
		homepage.clickOnmessage();
		
	}

}
