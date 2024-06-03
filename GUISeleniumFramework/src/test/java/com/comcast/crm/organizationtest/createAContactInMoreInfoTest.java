package com.comcast.crm.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.moreInformationPage;

public class createAContactInMoreInfoTest extends BaseClass {

	@Test
	
	public void  creata_A_Contact() throws Throwable
	{
		WebDriverUtility wd = new WebDriverUtility();
		wd.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		String createOrgText = eLib.getDataFromExcel("Organizations", 1, 1);
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage newOrgPage = new CreatingNewOrganizationPage(driver);
		String createNewOrgPage = newOrgPage.getCreatingNewOrganizationText().getText();
		Assert.assertEquals(createOrgText, createNewOrgPage);
		
		/**
		 * generating random number
		 */
		
		JavaUtility ju = new JavaUtility();
		int num = ju.getRandomNumber();
		
		String orgName = eLib.getDataFromExcel("Organizations", 1, 2) + num;
		String IndustryValue = eLib.getDataFromExcel("Organizations", 1, 3);
		
		
		/**
		 * creating organization with industry
		 */
		newOrgPage.createOrg(orgName, IndustryValue);
		
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
		
		/** navigating to more info page
		 * 
		 */
		
		oip.getmoreInformationLink().click();
		String moreInfoText = eLib.getDataFromExcel("Organizations", 4, 5);
		moreInformationPage mip = new moreInformationPage(driver);
		wd.waitandClickAjaxElement(driver,(By) mip.getmoreInformationLink());
		mip.getmoreInformationLink().click();
		String moreInformationPageText = mip.getHeaderMsg().getText();
		
		boolean getBooleanValue = moreInformationPageText.contains(moreInfoText);
		Assert.assertTrue(getBooleanValue);
		
		/**
		 * creating contact from more info page
		 */
		mip.getcontactsTab().click();
		mip.getaddcontactButton().click();
		String contactText = eLib.getDataFromExcel("Organizations", 4, 6);
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String creatingNewContactText = cip.getHeaderTxt().getText();
		Assert.assertEquals(creatingNewContactText, contactText);
		
		String contactName = eLib.getDataFromExcel("Organizations", 4, 7)+num;
		cip.createContact(contactName);
		driver.findElement(By.xpath("//tr[@bgcolor=\"white\"]//td//a[text()='"+contactName+"']")).isDisplayed();
}
}
