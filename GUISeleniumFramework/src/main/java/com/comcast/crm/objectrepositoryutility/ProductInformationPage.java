package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;

	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerMsg;
	@FindBy(id = "dtlview_Product Category")
	private WebElement productCategoryTxt;
	public WebElement getProductCategoryTxt() {
		return productCategoryTxt;
	}
	@FindBy(xpath =  "//a[text()=\"More Information\"]")
	private WebElement moreInformationBtn;
	public WebElement getmoreInformationBtn() {
		return moreInformationBtn;
	}
	@FindBy(id = "show_Products_Accounts")
	private WebElement organizationTable;
	public WebElement getorganizationTable() {
		return organizationTable;
	}
	@FindBy(xpath =  "//input[@value=\"Select Organizations\"]")
	private WebElement selectOrganizationsBtn;
	public WebElement getselectOrganizationsBtn() {
		return selectOrganizationsBtn;
	}
	@FindBy(xpath =  "(//a[contains(text(),'Organization Name')]/../../../tr//td[@onmouseover=\"vtlib_listview.trigger('cell.onmouseover', $(this))\"])")
	private WebElement organizationNameinMoreTxt;
	public WebElement getorganizationNameinMoreTxt() {
		return organizationNameinMoreTxt;
	}
	
	public WebElement getMoreInformationBtn() {
		return moreInformationBtn;
	}
	public WebElement getOrganizationTable() {
		return organizationTable;
	}
	public WebElement getSelectOrganizationsBtn() {
		return selectOrganizationsBtn;
	}
	public WebElement getOrganizationNameinMoreTxt() {
		return organizationNameinMoreTxt;
	}

	@FindBy(id="show_Products_Leads")
	private WebElement showLeadsImg;
	
	@FindBy(xpath = "//input[@title=\"Select Leads\"]")
	private WebElement selectLeadsBtn;
	
	@FindBy(xpath="//span[@vtfieldname=\"lastname\"]/../a")
	private WebElement lastNameLnk;

	public WebElement getLastNameLnk() {
		return lastNameLnk;
	}
	public WebElement getShowLeadsImg() {
		return showLeadsImg;
	}
	public WebElement getSelectLeadsBtn() {
		return selectLeadsBtn;
	}
	
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement productNameTxt;
	@FindBy(xpath = "//td[@id=\"mouseArea_Vendor Name\"]")
	private WebElement vendorNameTxt;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getProductNameTxt() {
		return productNameTxt;
	}
	public WebElement getVendorNameTxt() {
		return vendorNameTxt;
	}

}
