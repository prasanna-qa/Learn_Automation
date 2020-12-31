package com.cosfa.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cosfa.qa.base.TestBase;

public class LoginPageObjectory extends TestBase {
	
@FindBy(xpath="//*[@name='email']")
WebElement username;
@FindBy(name="password")
WebElement password;
@FindBy(xpath="//*[@type='submit']")
WebElement loginButton;

@FindBy(xpath="//*[contains(@class,'text-login')]")
WebElement logoName;



//initializing page objects to driver
public LoginPageObjectory()
{
	PageFactory.initElements(driver, this);
}

//actions
public String validateLoginpagetitle()
{ return driver.getTitle();
	}

public boolean verifyLogo()
{
	boolean b=logoName.isDisplayed();
	return b;
	}

public HomePage login(String un,String pass)
{
	username.sendKeys(un);
	password.sendKeys(pass);
	loginButton.click();
	return new HomePage();
	}
}
