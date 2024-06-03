package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Elements realted to After creating the organization
 * created by - jhanvi
 */

public class OrganizationInformationPage {

	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerMsg;
	
	@FindBy(xpath = "//a[text()='More Information']")
	private WebElement moreInformationLink;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameText;

	@FindBy(xpath = "//td[@id='mouseArea_Phone']/span")
	private WebElement phoneText;

	@FindBy(id = "dtlview_Industry")
	private WebElement industryText;

	@FindBy(id = "dtlview_Type")
	private WebElement typeText;
	
	@FindBy(xpath= "//a[text()=\"Add Note\"]")
	private WebElement addNoteLink;

	public WebElement getIndustryText() {
		return industryText;
	}

	public WebElement getTypeText() {
		return typeText;
	}

	public WebElement getOrgNameText() {
		return orgNameText;
	}

	public WebElement getPhoneText() {
		return phoneText;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public WebElement getmoreInformationLink() {
		return moreInformationLink;
	}
	
	public WebElement getaddNoteLink() {
		return addNoteLink;
	}
}
