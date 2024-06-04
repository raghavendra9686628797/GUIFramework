package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Elements related to more info page
 * created by - jhanvi
 */

public class moreInformationPage {

	WebDriver driver;

	public moreInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//span[@class='lvtHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(xpath = "//a[text()='More Information']")
	private WebElement moreInformationLink;
	
	@FindBy(xpath="//img[@id=\"show_Accounts_Contacts\"]")
	private WebElement contactsTab;
	
	@FindBy(xpath = "//input[@value=\"Add Contact\"]")
	private WebElement addcontactButton;
	
	public WebElement getmoreInformationLink() {
		return moreInformationLink;
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public WebElement getcontactsTab() {
		return contactsTab;
	}
	
	public WebElement getaddcontactButton() {
		return addcontactButton;
	}
}
