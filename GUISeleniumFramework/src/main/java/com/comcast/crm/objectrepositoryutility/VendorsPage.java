package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Sanjay
 * This contains elements of Vendors page
 */
public class VendorsPage {
	WebDriver driver;
	public VendorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Vendor...\"]")
	private WebElement createVendorImg;
	
	public WebElement getCreateVendorImg() {
		return createVendorImg;
	}

	public WebElement getSearchForedt() {
		return searchForedt;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	@FindBy(name="search_text")
	private WebElement searchForedt;
	
	@FindBy(name="bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(xpath="//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;

}
