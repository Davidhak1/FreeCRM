package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();       //try to delete this and try again
	} 
	
	@BeforeMethod
	public void setUp(){
		initialize();
		testUtil = new TestUtil();
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void verifyHomePageTitle()
	{
		Assert.assertEquals(homePage.verifyTitle(),"CRMPRO", "HomePage title not matched");
	}
	
	@Test
	public void verifyUserName()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUsername(), "Mismatch in username part");
	}
	
	@Test
	public void verifyContactsTab()
	{
		testUtil.switchToFrame();

		contactsPage = homePage.clickOnContactsLink();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
