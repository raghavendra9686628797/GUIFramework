package com.comcast.crm.objectrepositoryutility;
/**
 * 
 * @author Raghavendra
 *        
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	WebDriver driver;
@FindBy(name = "campaignname")
private WebElement editCampaignName;

@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
private WebElement addProductIcon;

@FindBy(xpath = "//a[@href=\"index.php?action=CallRelatedList&module=Campaigns&record=38&parenttab=Marketing\"]")
private WebElement moreinformationLink;

@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
private WebElement headertext;

public WebElement getHeadertext() {
	return headertext;
}

public WebElement getMoreinformationLink() {
	return moreinformationLink;
}

@FindBy(xpath = "//input[@class=\"crmButton small save\"]")
private WebElement savebutton;

@FindBy(id = "mouseArea_Campaign Name")
private WebElement enterdCampaignName;

@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
private WebElement campaignsHeaderText;
public WebElement getCampaignsHeaderText() {
	return campaignsHeaderText;
}

public WebElement getEnterdCampaignName() {
	return enterdCampaignName;
}

public CampaignInformationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getEditCampaignName() {
	return editCampaignName;
}

public WebElement getAddProductIcon() {
	return addProductIcon;
}

public WebElement getSavebutton() {
	return savebutton;
}

}
