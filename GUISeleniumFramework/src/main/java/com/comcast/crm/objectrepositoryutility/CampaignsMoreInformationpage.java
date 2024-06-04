package com.comcast.crm.objectrepositoryutility;
/*
 * @author Raghavendra
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsMoreInformationpage {
WebDriver driver;
@FindBy(id = "show_Campaigns_Contacts")
private WebElement contactTabExpandButton;

@FindBy(xpath = "//input[@title='Add Contact']")
private WebElement addContactButton;

@FindBy(name = "firstname")
private WebElement editFirstNameTextField;

@FindBy(name = "lastname")
private WebElement editLastNameTextField;

@FindBy(id = "mobile")
private WebElement mobileTextField;

@FindBy(xpath = "//input[@class=\"crmButton small save\"]")
private WebElement saveButton;

public WebElement getSaveButton() {
	return saveButton;
}
public WebElement getEditFirstNameTextField() {
	return editFirstNameTextField;
}

public WebElement getEditLastNameTextField() {
	return editLastNameTextField;
}

public WebElement getMobileTextField() {
	return mobileTextField;
}

public CampaignsMoreInformationpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getAddContactButton() {
	return addContactButton;
}

public WebElement getContactTabExpandButton() {
	return contactTabExpandButton;
}

}
