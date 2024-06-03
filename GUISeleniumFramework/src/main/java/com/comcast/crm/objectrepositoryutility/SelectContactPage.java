package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class SelectContactPage {
	WebDriver driver;
	public SelectContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id=\"search_txt\"]")
	private WebElement searchTxtBox;
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchBtn;
	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
