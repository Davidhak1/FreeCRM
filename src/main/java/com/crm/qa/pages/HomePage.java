package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'David Hakobyan')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsTab;
	                                                        /// Page Library
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")       /// Test cases should be separated -- independent from each other
	WebElement dealsTab;									/// Before each test case -- launch the browser and login 
															/// Execute test case										
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")       /// After each test case -- close the browser
	WebElement tasksTab;

	@FindBy(xpath = "//a[@title = 'New Contact']")
	WebElement newContact;
	
public HomePage(){
	PageFactory.initElements(driver, this);
}

public String verifyTitle() {
	return driver.getTitle();
}

public boolean verifyUsername() {
	return userNameLabel.isDisplayed();
}

public ContactsPage clickOnContactsLink() {
	 contactsTab.click();
	 return new ContactsPage();
}

public DealsPage ClickOnDealsTab() {
	 dealsTab.click();
	 return new DealsPage();
}

public TaskPage ClickOnTasksTab() {
	 tasksTab.click();
	 return new TaskPage();
}

public void ClickOnNewContact() {
	Actions a = new Actions(driver);
	a.moveToElement(contactsTab).build().perform();
	try {
		Thread.sleep(1000l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	newContact.click();
	
}

}


