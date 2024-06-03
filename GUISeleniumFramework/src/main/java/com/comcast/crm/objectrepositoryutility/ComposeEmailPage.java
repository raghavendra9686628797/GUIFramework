package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage {
	WebDriver driver;

	public ComposeEmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="parent_name")
	private WebElement toEdt;
	
	@FindBy(id="cc_name")
	private WebElement ccEdt;
	
	@FindBy(id="subject")
	private WebElement subjectEdt;
	
	@FindBy(id="my_file_element")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath="//input[@title=\"Select Email Template\"]")
	private WebElement selectEmailTemplateBtn;
	
	@FindBy(xpath="//input[contains(@title,\"Save\")]")
	private WebElement saveBtn;

	public WebElement getToEdt() {
		return toEdt;
	}

	public WebElement getCcEdt() {
		return ccEdt;
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getChooseFileBtn() {
		return chooseFileBtn;
	}

	public WebElement getSelectEmailTemplateBtn() {
		return selectEmailTemplateBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
