package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement createProductImg;
	
	@FindBy(name="search_text")
	private WebElement searchForEdt;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProductImg() {
		return createProductImg;
	}

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	@FindBy(name="bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(xpath="//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;


}
