package com.comcast.crm.oppotunityTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewInvoicePage;
import com.comcast.crm.objectrepositoryutility.CreateNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.CreateNewQuotePage;
import com.comcast.crm.objectrepositoryutility.DoucmentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.OpportunityMoreInfoPage;
import com.comcast.crm.objectrepositoryutility.OpportunityPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.objectrepositoryutility.SelectContactPage;
/**
 * 
 * @author Asha R
 */
public class OpportunityTest  extends BaseClass{

	@Test(groups = "regressionTest")
	public void Create_opportunity_with_ContactTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		OpportunityPage op = new OpportunityPage(driver);
		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		ExcelUtility elib= new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		SelectContactPage scp= new SelectContactPage(driver);
		OpportunityInformationPage oip = new OpportunityInformationPage(driver);

		/* Navigate to HomePage and verify*/
		boolean flag = wlib.verifyElementDisplayedOrNot(driver, hp.getHomeLink());
		Assert.assertEquals(true, flag);

		/* Navigate to Opportunity page*/
		hp.getOpportunitiesLink().click();
		Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, op.getOppLink()));

		/* Create New opportunity*/
		op.getAddNewOppBtn().click();
		Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, cnop.getCreateNewOppText()));

		/* Fetchinf opportunity name from excel and entering it */
		String oppName = elib.getDataFromExcel("Opportunities", 1, 2);
		cnop.getOppNameTxtBox().sendKeys(oppName);

		/*Slecting contact from related to dropdown*/
		wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("Opportunities", 1, 3));
		cnop.getAddRelatedToBtn().click();

		/*switching to select contact window */
		wlib.switchToTabOnURL(driver,"module=Contacts&action");

		/* Fetchinf ocontact name from excel and entering it */
		String contactName = elib.getDataFromExcel("Opportunities", 1, 4);
		scp.getSearchTxtBox().sendKeys(contactName);
		scp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]")).click();


		/* switching to pareent window */
		wlib.switchToTabOnURL(driver, "module=Potentials&action");
		boolean flag2 = cnop.getRelatedTxtBox().getText().contains(contactName);
		Assert.assertEquals(true, flag2);
		cnop.getSaveBtn().click();
		String headertxt = oip.getHeaderTxt().getText();

		/* verifying if the header text contains the opportunity name*/
		Assert.assertEquals(true,headertxt.contains(oppName));
		Reporter.log("Create_opportunity_with_ContactTest is created",true);
	}
@Test(groups = "regreesionTest")
public void Create_Invoice_For_OpportunityTest() throws Throwable {
	HomePage hp = new HomePage(driver);
	OpportunityPage op = new OpportunityPage(driver);
	CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
	ExcelUtility elib= new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	SelectContactPage scp= new SelectContactPage(driver);
	OpportunityInformationPage oip = new OpportunityInformationPage(driver);
	CreateNewInvoicePage cnip = new CreateNewInvoicePage(driver);
	OrganizationsPage orp= new OrganizationsPage(driver);
	
	/* Navigate to HomePage and verify*/
	boolean flag = wlib.verifyElementDisplayedOrNot(driver, hp.getHomeLink());
	Assert.assertEquals(true, flag);

	/* Navigate to Opportunity page*/
	hp.getOpportunitiesLink().click();
	Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, op.getOppLink()));

	/* Create New opportunity*/
	op.getAddNewOppBtn().click();
	Assert.assertEquals(true,true);

	/* Fetchinf opportunity name from excel and entering it */
	String oppName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "OpportunityName");
	cnop.getOppNameTxtBox().sendKeys(oppName);

	/*Slecting contact from related to dropdown*/
	wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "RelatedTo"));
	cnop.getAddRelatedToBtn().click();

	/*switching to select contact window */
	wlib.switchToTabOnURL(driver,"module=Contacts&action");

	/* Fetching contact name from excel and entering it */
	String contactName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "ContactName");
	scp.getSearchTxtBox().sendKeys(contactName);
	scp.getSearchBtn().click();
	driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]")).click();


	/* switching to parent window */
	wlib.switchToTabOnURL(driver, "module=Potentials&action");
	

	cnop.getSaveBtn().click();
	String headertxt = oip.getHeaderTxt().getText();

	/* verifying if the header text contains the opportunity name*/
	Assert.assertEquals(headertxt.contains(oppName),true);
	Reporter.log("Create_opportunity_with_ContactTest is created",true);

	/*Navigating to invoice page*/
	oip.getCreateInvoiceLink().click();

	/*Verifying the invoice page*/
	boolean flag3=wlib.verifyElementDisplayedOrNot(driver,cnip.getCreateNewInvoiceTxt());
	Assert.assertEquals(flag3,true );

	/* fetching subject from excel and entering it in Subject text field*/
	cnip.getSubjectTxtBox().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "Subject"));

	/* switching to Org window and selecting organization*/
	cnip.getSelectorgBtn().click();
	wlib.switchToTabOnURL(driver,"module=Accounts&action");
	String orgName= elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "OrganizationName");
	orp.getSerchEdt().sendKeys(orgName);
	orp.getSearchNowBtn().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();

	wlib.switchtoAlertAndAccept(driver);
	/*Switch to parent window*/
	wlib.switchToTabOnURL(driver, "module=Potentials&return_action");
	cnip.getBillingAddTextArea().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "BillingAddress"));
	cnip.getCopyBilAddRadioBtn().click();

	/*Selecting a product*/
	cnip.getSelectItemBtn().click();
	wlib.switchToTabOnURL(driver, "module=Products&action");
	ProductsPage pp= new ProductsPage(driver);
	String pname = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "ProductName");
	pp.getSearchForEdt().sendKeys(pname);
	pp.getSearchNowBtn().click();
	driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
	wlib.switchToTabOnURL(driver, "module=Potentials&return");
	cnip.getQtyTxtBox().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_012", "Qty"));
	cnip.getSaveBtn().click();
	String actTxt =oip.getHeaderTxt().getText();
	Assert.assertEquals(true, actTxt.contains(oppName));
}
@Test(groups = "regressionTest")
public void Add_Document_to_OpportunityTest() throws Throwable {
	HomePage hp = new HomePage(driver);
	OpportunityPage op = new OpportunityPage(driver);
	CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
	ExcelUtility elib= new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	SelectContactPage scp= new SelectContactPage(driver);
	OpportunityInformationPage oip = new OpportunityInformationPage(driver);
	OpportunityMoreInfoPage omip = new OpportunityMoreInfoPage(driver);
	DoucmentsPage dp = new DoucmentsPage(driver);
	/* Navigate to HomePage and verify*/
	boolean flag = wlib.verifyElementDisplayedOrNot(driver, hp.getHomeLink());
	Assert.assertEquals(true, flag);

	/* Navigate to Opportunity page*/
	hp.getOpportunitiesLink().click();
	Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, op.getOppLink()));

	/* Create New opportunity*/
	op.getAddNewOppBtn().click();
	Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, cnop.getCreateNewOppText()));

	/* Fetching opportunity name from excel and entering it */
	String oppName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_013", "OpportunityName");
	cnop.getOppNameTxtBox().sendKeys(oppName);

	/*Selecting contact from related to drop down*/
	wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_013", "RelatedTo"));
	cnop.getAddRelatedToBtn().click();

	/*switching to select contact window */
	wlib.switchToTabOnURL(driver,"module=Contacts&action");

	/* Fetching contact name from excel and entering it */
	String contactName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_013", "ContactName");
	scp.getSearchTxtBox().sendKeys(contactName);
	scp.getSearchBtn().click();
	driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]")).click();

	/* switching to parent window */
	wlib.switchToTabOnURL(driver, "module=Potentials&action");
	
	cnop.getSaveBtn().click();
	String headertxt = oip.getHeaderTxt().getText();

	/* verifying if the header text contains the opportunity name*/
	Assert.assertEquals(true,headertxt.contains(oppName));
	Reporter.log("Create_opportunity_with_ContactTest is created",true);
	
	/* Navigating to more information page*/
	wlib.mousemoveOnElement(driver, oip.getMoreInfoLink());
	oip.getDocumentLink().click();
	omip.getAddDocBtn().click();
	
	/* Verifying the documents page*/
	Assert.assertEquals(wlib.verifyElementDisplayedOrNot(driver, dp.getheaderMsg()), true);
	dp.createDoucment(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_013", "Title"));
	}


	@ Test(groups = "regressionTest")
	public void add_Quote_To_OpportunityTest() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		OpportunityPage op = new OpportunityPage(driver);
		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		ExcelUtility elib= new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		SelectContactPage scp= new SelectContactPage(driver);
		OpportunityInformationPage oip = new OpportunityInformationPage(driver);
		OpportunityMoreInfoPage omip = new OpportunityMoreInfoPage(driver);
		CreateNewQuotePage cnqip = new CreateNewQuotePage(driver);
		CreateNewInvoicePage cnip = new CreateNewInvoicePage(driver);
		OrganizationsPage orp = new OrganizationsPage(driver);		
		
		/* Navigate to HomePage and verify*/
		boolean flag = wlib.verifyElementDisplayedOrNot(driver, hp.getHomeLink());
		Assert.assertEquals(true, flag);

		/* Navigate to Opportunity page*/
		hp.getOpportunitiesLink().click();
		Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, op.getOppLink()));

		/* Create New opportunity*/
		op.getAddNewOppBtn().click();
		Assert.assertEquals(true, wlib.verifyElementDisplayedOrNot(driver, cnop.getCreateNewOppText()));

		/* Fetching opportunity name from excel and entering it */
		String oppName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "OpportunityName");
		cnop.getOppNameTxtBox().sendKeys(oppName);

		/*Selecting contact from related to drop down*/
		wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "RelatedTo"));
		cnop.getAddRelatedToBtn().click();

		/*switching to select contact window */
		wlib.switchToTabOnURL(driver,"module=Contacts&action");

		/* Fetching contact name from excel and entering it */
		String contactName = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "ContactName");
		scp.getSearchTxtBox().sendKeys(contactName);
		scp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]")).click();

		/* switching to parent window */
		wlib.switchToTabOnURL(driver, "module=Potentials&action");
		
		cnop.getSaveBtn().click();
		String headertxt = oip.getHeaderTxt().getText();

		/* verifying if the header text contains the opportunity name*/
		Assert.assertEquals(true,headertxt.contains(oppName));
		Reporter.log("Create_opportunity_with_ContactTest is created",true);
		
		/* Navigating to more information page*/
		wlib.mousemoveOnElement(driver, oip.getMoreInfoLink());
		oip.getQuotesLink().click();
		omip.getAddQuoteBtn().click();
		cnqip.getSubjectTxtBox().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "Subject"));
		
		/*Switch to org window and select org*/
		cnip.getSelectorgBtn().click();
		wlib.switchToTabOnURL(driver,"module=Accounts&action");
		String orgName= elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "OrganizationName");
		orp.getSerchEdt().sendKeys(orgName);
		orp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		/*handling pop up*/
		wlib.switchtoAlertAndAccept(driver);
		
		/*Switch to parent window*/
		wlib.switchToTabOnURL(driver, "http://localhost:8888/index.php");
		cnip.getBillingAddTextArea().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "BillingAddress"));
		cnip.getCopyBilAddRadioBtn().click();

		/*Selecting a product*/
		cnip.getSelectItemBtn().click();
		wlib.switchToTabOnURL(driver, "module=Products&action");
		ProductsPage pp= new ProductsPage(driver);
		String pname = elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "ProductName");
		pp.getSearchForEdt().sendKeys(pname);
		pp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+pname+"']")).click();
		wlib.switchToTabOnURL(driver, "http://localhost:8888/index.php");
		cnip.getQtyTxtBox().sendKeys(elib.getDataFromExcel("./testScriptdata.xlsx", "Opportunities", "TC_016", "Qty"));
		cnip.getSaveBtn().click();
		wlib.switchToTabOnURL(driver, "action=CallRelatedList&module=Potentials&parenttab");
		String actTxt =omip.getHeaderTxt().getText();
		Assert.assertEquals( actTxt.contains(oppName),true);
		}

}
