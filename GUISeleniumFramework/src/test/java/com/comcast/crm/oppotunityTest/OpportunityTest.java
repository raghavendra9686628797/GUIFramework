package com.comcast.crm.oppotunityTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
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
	
@Test
public void Create_opportunity_with_ContactTest() throws Throwable {
	HomePage hp = new HomePage(driver);
	OpportunityPage op = new OpportunityPage(driver);
	CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
	ExcelUtility elib= new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	SelectContactPage scp= new SelectContactPage(driver);
	OpportunityInformationPage oip = new OpportunityInformationPage(driver);
	hp.getOpportunitiesLink().click();
	op.getAddNewOppBtn().click();
	String oppName = elib.getDataFromExcel("Opportunities", 1, 1);
	cnop.getOppNameTxtBox().sendKeys(oppName);
	wlib.selectByValue(cnop.getRelatedToDD(),elib.getDataFromExcel("Opportunities", 1, 2));
	cnop.getAddRelatedToBtn().click();
	wlib.switchToTabOnURL(driver,"module=Contacts&action");
	String contactName = elib.getDataFromExcel("Opportunities", 1, 3);
	scp.getSearchTxtBox().sendKeys(contactName);
	scp.getSearchBtn().click();
	driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]")).click();
	wlib.switchToTabOnURL(driver, "module=Potentials&action");
	cnop.getSaveBtn().click();
	String headertxt = oip.getHeaderTxt().getText();
	
}
}
