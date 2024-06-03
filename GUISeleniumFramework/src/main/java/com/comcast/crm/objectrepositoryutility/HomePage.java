package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;

	@FindBy(xpath = "//img[contains(@src,\"themes/softed/images/user\")]")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutlnk;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement morelink;
	/**
	 * 
	 * @author Raghavendra
	 *        
	 *
	 */
	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void logout() {
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.mousemoveOnElement(driver, adminImg);
		signOutlnk.click();
	}

}
