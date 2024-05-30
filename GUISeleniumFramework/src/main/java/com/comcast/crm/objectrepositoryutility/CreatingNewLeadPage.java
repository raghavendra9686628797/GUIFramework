package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	WebDriver driver;

	public CreatingNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="company")
	private WebElement companyEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(id="designation")
	private WebElement titleEdt;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	@FindBy(id="fax")
	private WebElement faxEdt;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	@FindBy(name="website")
	private WebElement websiteEdt;

	@FindBy(name="annualrevenue")
	private WebElement annualRevenueEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDD;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="lane")
	private WebElement streetTxtArea;
	
	@FindBy(name="code")
	private WebElement postalCodeEdt;
	
	@FindBy(id="country")
	private WebElement countryEdt;
	
	@FindBy(id="state")
	private WebElement stateEdt;
	
	@FindBy(id="city")
	private WebElement cityEdt;
	
	@FindBy(name="description")
	private WebElement descriptionTxtArea;
	
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getFaxEdt() {
		return faxEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getWebsiteEdt() {
		return websiteEdt;
	}

	public WebElement getAnnualRevenueEdt() {
		return annualRevenueEdt;
	}

	public WebElement getLeadSourceDD() {
		return leadSourceDD;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getStreetTxtArea() {
		return streetTxtArea;
	}

	public WebElement getPostalCodeEdt() {
		return postalCodeEdt;
	}

	public WebElement getCountryEdt() {
		return countryEdt;
	}

	public WebElement getStateEdt() {
		return stateEdt;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getDescriptionTxtArea() {
		return descriptionTxtArea;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createLead(String lastName, String company) {
		lastnameEdt.sendKeys(lastName);
		companyEdt.sendKeys(company);
		saveBtn.click();
	}
}
