package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreLinkPage {
	WebDriver driver;
	
	public MoreLinkPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(name = "Campaigns")
private WebElement campaignlink;

public WebElement getCampaignlink() {
	return campaignlink;
}

}
