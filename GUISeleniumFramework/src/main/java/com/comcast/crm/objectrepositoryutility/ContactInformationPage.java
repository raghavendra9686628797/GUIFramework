package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "lvtHeaderText")
	private WebElement headerTxt;
	
	@FindBy(xpath = "//input[@name=\"lastname\"]") //created by - jhanvi
	private WebElement lastnameTextfield;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastnameTxt;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDateTxt;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDateTxt;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement orgNamelnk;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSupportStartDateTxt() {
		return supportStartDateTxt;
	}

	public WebElement getSupportEndDateTxt() {
		return supportEndDateTxt;
	}

	public WebElement getOrgNamelnk() {
		return orgNamelnk;
	}
	
	public void createContact(String orgName) {
		lastnameTextfield.sendKeys(orgName);
		saveButton.click();
	}

}
