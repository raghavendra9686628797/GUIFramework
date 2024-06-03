package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class CreateNewOpportunityPage {
	WebDriver driver;
	public CreateNewOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname")
	private WebElement oppNameTxtBox;
	@FindBy(xpath = "//select[@name=\"related_to_type\"]")
	private WebElement relatedToDD;
	@FindBy(xpath = "//input[@id=\"related_to\"]/following-sibling::img")
	private WebElement addRelatedToBtn;
	@FindBy(xpath = "//input[@id=\"related_to_display\"]")
	private WebElement relatedTxtBox;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Creating New Opportunity']")
	private WebElement createNewOppText;
	
	public WebElement getCreateNewOppText() {
		return createNewOppText;
	}
	public WebElement getOppNameTxtBox() {
		return oppNameTxtBox;
	}
	public WebElement getRelatedToDD() {
		return relatedToDD;
	}
	public WebElement getAddRelatedToBtn() {
		return addRelatedToBtn;
	}
	public WebElement getRelatedTxtBox() {
		return relatedTxtBox;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

}
