package com.cosfa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cosfa.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//h3[contains(@class,'themecolour')]")
	WebElement homepagelogo;
	
	@FindBy(xpath="//*[text()='Welcome Office']")
	WebElement welcomeofficelink;
	
	@FindBy(xpath="//ul[@id='sidebarnav']/li[4]/a/span")
	WebElement message;
	
	public HomePage(){	
	PageFactory.initElements(driver, this);
}
	
	
	public Boolean verifyHomePagelogo()
	{
		return homepagelogo.isDisplayed();
	}
	public void clickOnWelcomeOffice()
	{
		welcomeofficelink.click();
	}
	public void clickOnmessage()
	{
		message.click();
	}
	
	
	
	
	
	
}
