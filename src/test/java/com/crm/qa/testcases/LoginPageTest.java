package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	public LoginPage loginPage;
	public HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		loginPage = new LoginPage();
	}
	 
	@Test
	public void loginPageTitleTest()
	{
		Assert.assertEquals(loginPage.validateLoginPageTitle(),"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void crmLogoImgTest()
	{
		Assert.assertEquals(loginPage.validateLogo(), true);
	}
	
	@Test
	public void loginTest()
	
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
