package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	WebDriver driver;

	public LeadInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameTxt;

	public WebElement getFirstNameTxt() {
		return firstNameTxt;
	}

	public WebElement getLeadNoTxt() {
		return leadNoTxt;
	}

	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

	public WebElement getFaxTxt() {
		return faxTxt;
	}

	public WebElement getWebsiteLnk() {
		return websiteLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getLeadsourceTxt() {
		return leadsourceTxt;
	}

	public WebElement getIndustryTxt() {
		return industryTxt;
	}

	public WebElement getAnnualRevenueTxt() {
		return annualRevenueTxt;
	}

	public WebElement getStreetTxt() {
		return streetTxt;
	}

	public WebElement getPostalCodeTxt() {
		return postalCodeTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getCountryTxt() {
		return countryTxt;
	}

	public WebElement getStateTxt() {
		return stateTxt;
	}

	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDuplicateBtn() {
		return duplicateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getSendMailLnk() {
		return sendMailLnk;
	}

	public WebElement getAddeventLnk() {
		return addeventLnk;
	}

	public WebElement getAddToDoLnk() {
		return addToDoLnk;
	}

	public WebElement getAddNoteLnk() {
		return addNoteLnk;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	@FindBy(id = "dtlview_Company")
	private WebElement companyTxt;

	@FindBy(id = "dtlview_First Name")
	private WebElement firstNameTxt;

	@FindBy(xpath = "//td[contains(text(),\"Lead No\")]/following-sibling::td")
	private WebElement leadNoTxt;

	@FindBy(id = "dtlview_Phone")
	private WebElement phoneTxt;

	@FindBy(id = "dtlview_Fax")
	private WebElement faxTxt;

	@FindBy(id = "dtlview_Website")
	private WebElement websiteLnk;

	@FindBy(id = "dtlview_Email")
	private WebElement emailLnk;

	@FindBy(id = "dtlview_Title")
	private WebElement titleTxt;

	@FindBy(id = "dtlview_Lead Source")
	private WebElement leadsourceTxt;

	@FindBy(id = "dtlview_Industry")
	private WebElement industryTxt;

	@FindBy(id = "dtlview_Annual Revenue")
	private WebElement annualRevenueTxt;

	@FindBy(id = "dtlview_Street")
	private WebElement streetTxt;

	@FindBy(id = "dtlview_Postal Code")
	private WebElement postalCodeTxt;

	@FindBy(id = "dtlview_City")
	private WebElement cityTxt;

	@FindBy(id = "dtlview_Country")
	private WebElement countryTxt;

	@FindBy(id = "dtlview_State")
	private WebElement stateTxt;

	@FindBy(id = "dtlview_Description")
	private WebElement descriptionTxt;

	@FindBy(className = "crmbutton small edit")
	private WebElement editBtn;

	@FindBy(className = "crmbutton small create")
	private WebElement duplicateBtn;

	@FindBy(className = "crmbutton small delete")
	private WebElement deleteBtn;

	@FindBy(linkText = "Send Mail")
	private WebElement sendMailLnk;

	@FindBy(linkText = "Add Event")
	private WebElement addeventLnk;

	@FindBy(linkText = "Add To Do")
	private WebElement addToDoLnk;

	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLnk;

	@FindBy(linkText = "Add Note")
	private WebElement addNoteLnk;

	@FindBy(xpath = "//input[@name=\"Select\"]")
	private WebElement selectBtn;

	@FindBy(xpath = "//td[contains(text(),\"Convert Lead\")]")
	private WebElement convertLeadPopupHdr;

	@FindBy(id = "select_potential")
	private WebElement opportunityCheckBox;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDateEdt;

	@FindBy(xpath = "//input[@name='Save']")
	private WebElement saveBtn;

	@FindBy(id = "potentialname")
	private WebElement opportunityNameEdt;

	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getConvertLeadPopupHdr() {
		return convertLeadPopupHdr;
	}

	public WebElement getOpportunityCheckBox() {
		return opportunityCheckBox;
	}

	public WebElement getExpectedCloseDateEdt() {
		return expectedCloseDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getCompanyTxt() {
		return companyTxt;
	}

	public WebElement getConvertLeadLnk() {
		return convertLeadLnk;
	}
}
