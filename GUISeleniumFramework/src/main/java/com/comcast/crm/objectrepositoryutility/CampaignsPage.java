package com.comcast.crm.objectrepositoryutility;
/**
 * 
 * @author Raghavendra
 *        
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	WebDriver driver;
@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
private WebElement createCampaignIcon;

@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Calendar.gif\"]")
private WebElement CampaignCalanderIcon;

@FindBy(xpath = "//img[@src=\"themes/softed/images/settingsBox.png\"]")
private WebElement CampaignsettingsIcon;

public CampaignsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getCreateCampaignIcon() {
	return createCampaignIcon;
}

public WebElement getCampaignCalanderIcon() {
	return CampaignCalanderIcon;
}

public WebElement getCampaignsettingsIcon() {
	return CampaignsettingsIcon;
}

}
