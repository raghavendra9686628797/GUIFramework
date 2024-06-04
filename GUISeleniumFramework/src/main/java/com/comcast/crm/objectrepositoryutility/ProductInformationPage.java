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
	@FindBy(xpath =  "//td[text()=\"More Information\"]")
	private WebElement moreInformationBtn;
	public WebElement getmoreInformationBtn() {
		return moreInformationBtn;
	}
	@FindBy(xpath =  "(//*[@id=\"RLContents\"]/table[9]/tbody/tr[1]/td/div/text())[2]")
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
