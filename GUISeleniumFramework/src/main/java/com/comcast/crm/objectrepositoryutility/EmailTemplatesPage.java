package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailTemplatesPage {
	WebDriver driver;

	public EmailTemplatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Follow Up")
	private WebElement followUpLnk;

	public WebElement getFollowUpLnk() {
		return followUpLnk;
	}
}
