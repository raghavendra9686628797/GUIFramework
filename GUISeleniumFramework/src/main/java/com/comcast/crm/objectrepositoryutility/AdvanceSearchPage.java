package com.comcast.crm.objectrepositoryutility;
/*
 * @author Raghavendra
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSearchPage {
	WebDriver driver;
@FindBy(xpath = "//b[text()='Advanced Search']")
private WebElement advanceSearchtitle;
@FindBy(id = "fcol0")
private WebElement CampaignNameDropdown;

@FindBy(id = "fop0")
private WebElement conditionDropDown;
@FindBy(id = "fval0")
private WebElement textfield;
@FindBy(xpath = "//input[@onclick=\"callSearch('Advanced');\"]")
private WebElement searchButton;
@FindBy(xpath = "//tbody//a[text()='bin2bilCmapign verna']")
private WebElement verifyname;
public AdvanceSearchPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getAdvanceSearchtitle() {
	return advanceSearchtitle;
}
public WebElement getCampaignNameDropdown() {
	return CampaignNameDropdown;
}
public WebElement getConditionDropDown() {
	return conditionDropDown;
}
public WebElement getTextfield() {
	return textfield;
}
public WebElement getSearchButton() {
	return searchButton;
}

}
