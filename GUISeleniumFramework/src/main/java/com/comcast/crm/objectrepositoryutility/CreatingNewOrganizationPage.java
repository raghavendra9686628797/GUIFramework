package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Creating New Organization']")
	private WebElement CreatingNewOrganizationText;
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindAll({@FindBy(id="phone"),@FindBy(name="phone")})
	private WebElement phoneEdt;

	public WebElement getCreatingNewOrganizationText() {
		return CreatingNewOrganizationText;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName, String industry) {
		OrgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByValue(industry);
		saveBtn.click();
	}
	
	
	
}
