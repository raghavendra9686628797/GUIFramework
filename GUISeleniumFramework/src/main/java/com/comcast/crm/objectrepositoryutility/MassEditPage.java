package com.comcast.crm.objectrepositoryutility;
/*
 * @author Raghavendra
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MassEditPage {
WebDriver driver;
@FindBy(id = "campaignstatus_mass_edit_check")
private WebElement campaignStatusCheckbox;

@FindBy(name = "campaignstatus")
private WebElement campaignStatusDropDown;

@FindBy(name = "button")
private WebElement savebutton;

public WebElement getMasseditHeader() {
	return masseditHeader;
}

@FindBy(xpath = "//td[@class=\"layerPopupHeading\"]")
private WebElement masseditHeader;
public MassEditPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getCampaignStatusCheckbox() {
	return campaignStatusCheckbox;
}

public WebElement getCampaignStatusDropDown() {
	return campaignStatusDropDown;
}

public WebElement getSavebutton() {
	return savebutton;
}

}
