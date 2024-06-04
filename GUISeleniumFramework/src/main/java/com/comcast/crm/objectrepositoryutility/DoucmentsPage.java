package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Elements related to calendar
 * created by - jhanvi
 */
public class DoucmentsPage {

	WebDriver driver;

	public DoucmentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Creating New Document']")
	private WebElement headerMsg;
	

	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement titleTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	
	public WebElement getheaderMsg() {
		return headerMsg;
	}
	
	public WebElement titleTextfield() {
		return titleTextfield;
	}
	
	public void createDoucment(String titleName) {
		titleTextfield.sendKeys(titleName);
		saveButton.click();
	}
	
}
