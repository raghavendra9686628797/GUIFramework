package com.comcast.crm.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class EditOrganizationTest extends BaseClass {
	
	@Test
	public void  user_is_able_to_edit_the_organization() throws Throwable
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
		String OrganizationInformationText = eLib.getDataFromExcel("Organizations", 1, 5);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String TosterMessage = oip.getHeaderMsg().getText();
		
		boolean getBoolean = TosterMessage.contains(OrganizationInformationText);
		Assert.assertTrue(getBoolean);
		
		hp.getOrgLink().click();
		String OrganizationText = eLib.getDataFromExcel("Organizations", 1, 8);
		
		wd.waitForElementPresent(driver,op.getorganizationText());
		
		String organizationsTextPage = op.getorganizationText().getText();
		System.out.println(organizationsTextPage);
		Assert.assertEquals(OrganizationText, organizationsTextPage);
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../..//a[text()=\"edit\"]")).click();
		String editedIndustryText = eLib.getDataFromExcel("Organizations", 1, 6);
		
		wd.select(newOrgPage.getIndustryDD(), editedIndustryText);
		newOrgPage.getSaveBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
		String industryText = oip.getIndustryText().getText();
		Assert.assertNotEquals(industryText, IndustryValue);
		
		hp.logout();
		
		
		
		
	}
}
