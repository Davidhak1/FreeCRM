package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory Annotation 
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement submit;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Constructor, We initialize all this variables with our driver instance
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String username, String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", submit);
		return new HomePage();
		
	}
		
	
}
