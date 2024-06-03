package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class CreateNewInvoicePage {
	WebDriver driver;
	public CreateNewInvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Creating New Invoice']")private WebElement createNewInvoiceTxt;
	@FindBy(xpath = "//input[@name=\"subject\"]") private WebElement subjectTxtBox;
	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")private WebElement selectorgBtn;
	@FindBy(xpath = "//textarea[@name=\"bill_street\"]") private WebElement billingAddTextArea;
	@FindBy(xpath = "//input[@onclick=\"return copyAddressRight(EditView)\"]") private WebElement copyBilAddRadioBtn;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]") private WebElement saveBtn;
	@FindBy(id = "searchIcon1") private WebElement selectItemBtn;
	@FindBy(id="qty1") private WebElement qtyTxtBox;
	public WebElement getCreateNewInvoiceTxt() {
		return createNewInvoiceTxt;
	}
	public WebElement getSubjectTxtBox() {
		return subjectTxtBox;
	}
	public WebElement getSelectorgBtn() {
		return selectorgBtn;
	}
	public WebElement getBillingAddTextArea() {
		return billingAddTextArea;
	}
	public WebElement getCopyBilAddRadioBtn() {
		return copyBilAddRadioBtn;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSelectItemBtn() {
		return selectItemBtn;
	}
	public WebElement getQtyTxtBox() {
		return qtyTxtBox;
	}
	
}
