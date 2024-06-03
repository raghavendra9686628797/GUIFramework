package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	@FindBy(name="productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath="//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDateEdt;
	
	@FindBy(xpath="//input[@name=\"vendor_id\"]/following-sibling::img")
	private WebElement vendorSelectImg;
	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public WebElement getVendorSelectImg() {
		return vendorSelectImg;
	}

	

}
