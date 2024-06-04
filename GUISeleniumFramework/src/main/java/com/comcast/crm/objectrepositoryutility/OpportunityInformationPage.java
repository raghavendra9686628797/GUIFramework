package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class OpportunityInformationPage {
	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")private WebElement headerTxt;
	@FindBy(xpath = "//a[text()='Create Invoice']") private WebElement createInvoiceLink;
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}
	@FindBy(id="dtlview_Opportunity Name")
	private WebElement opportunityNameTxt;
	@FindBy(xpath = "//a[text()='More Information']") private WebElement MoreInfoLink;
	
	public WebElement getMoreInfoLink() {
		return MoreInfoLink;
	}
	@FindBy(xpath="//a[@title=\"Organizations\"]")
	private WebElement organizationLnk;
	
	@FindBy(xpath="//td[.=\"Expected Close Date\"]/following-sibling::td")
	private WebElement expectedCloseDateTxt;
	
	public WebElement getOpportunityNameTxt() {
		return opportunityNameTxt;
	}
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
	public WebElement getExpectedCloseDateTxt() {
		return expectedCloseDateTxt;
	}
	@FindBy(xpath = "//div[@id=\"More_Information_Modules_List\"]//a[text()='Documents']")
	private WebElement documentLink;
	public WebElement getDocumentLink() {
		return documentLink;
	}
	
}
