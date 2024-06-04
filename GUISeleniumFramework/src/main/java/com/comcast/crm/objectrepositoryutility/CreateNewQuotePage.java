package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewQuotePage {
	WebDriver driver;
	public CreateNewQuotePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[text()='Creating New Quote']") private WebElement newQuoteTxt;
	@FindBy(xpath = "//input[@name=\"subject\"]") private WebElement subjectTxtBox;
	public WebElement getNewQuoteTxt() {
		return newQuoteTxt;
	}
	public WebElement getSubjectTxtBox() {
		return subjectTxtBox;
	}
	
}
