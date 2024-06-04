package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPreferencesPage {
	WebDriver driver;

	public MyPreferencesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id=\"dtlview_Email\"]/a")
	private WebElement emailLnk;

	public WebElement getEmailLnk() {
		return emailLnk;
	}
}
