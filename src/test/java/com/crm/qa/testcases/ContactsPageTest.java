package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();       //try to delete this and try again
	}
	 
	@BeforeMethod
	public void setUp(){
		initialize();
		testUtil = new TestUtil();
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();	
		
	}
	
	@Test( priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact label is missing on the page");
	}
	
	@Test( priority=2, enabled = false)
	public void selectContactsTest()
	{
			contactsPage.selectContactByName("David Hakobyan");
	}
	
	@Test(priority=3, dataProvider = "dataCRMData")
	public void validateCreateNewContact(String title, String fname, String lname, String company){
		homePage.ClickOnNewContact();
		contactsPage.createNewContract(title, fname, lname, company);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] dataCRMData()
	{
		String fileName = "FreeCRMTestData.xlsx";
		String sheetName = "contacts";
		Object [][] data = TestUtil.getData(fileName, sheetName);
		return data;		
	}
	
	
}
