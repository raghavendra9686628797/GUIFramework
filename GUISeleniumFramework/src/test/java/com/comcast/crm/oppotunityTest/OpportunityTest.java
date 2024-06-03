package com.comcast.crm.oppotunityTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.OpportunityPage;
import com.comcast.crm.objectrepositoryutility.SelectContactPage;

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
	String oppName = elib.getDataFromExcel("Opportunities", 4, 2);
	cnop.getOppNameTxtBox().sendKeys(oppName);

	/*Slecting contact from related to dropdown*/
	wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("Opportunities", 4, 3));
	cnop.getAddRelatedToBtn().click();

	/*switching to select contact window */
	wlib.switchToTabOnURL(driver,"module=Contacts&action");

	/* Fetchinf ocontact name from excel and entering it */
	String contactName = elib.getDataFromExcel("Opportunities", 4, 4);
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
	
	/*Naviagting to invoice page*/
	oip.getCreateInvoiceLink().click();
	
}


}
