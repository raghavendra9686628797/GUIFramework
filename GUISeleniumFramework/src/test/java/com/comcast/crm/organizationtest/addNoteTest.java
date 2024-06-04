package com.comcast.crm.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.DoucmentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class addNoteTest extends BaseClass {

	@Test(groups = "regessionTest")
	public void  user_is_able_to_add_a_note() throws Throwable
	{
		WebDriverUtility wd = new WebDriverUtility();
		wd.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		String createOrgText = eLib.getDataFromExcel("Organizations", 10, 2);
		
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
		
		String orgName = eLib.getDataFromExcel("Organizations", 10, 3) + num;
		
		/** creating organization
		 * 
		 */
		
		newOrgPage.createOrg(orgName);
		Thread.sleep(3000);
		String OrganizationInformationText = eLib.getDataFromExcel("Organizations", 10, 4);
		System.out.println(OrganizationInformationText);
		
		/**
		 * validation
		 */
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String TosterMessage = oip.getHeaderMsg().getText();
		boolean getBoolean = TosterMessage.contains(OrganizationInformationText);
		Assert.assertTrue(getBoolean);
		
		/**
		 * navigating to documents page from organization page
		 */
		
		oip.getaddNoteLink().click();
		String doucumentsText = eLib.getDataFromExcel("Organizations", 10, 5);
			
		DoucmentsPage dp = new DoucmentsPage(driver);
		String documentHeaderMessage = dp.getheaderMsg().getText();
		Assert.assertEquals(documentHeaderMessage, doucumentsText);
		
		String TitleName = eLib.getDataFromExcel("Organizations", 10, 6)+num;
		dp.createDoucment(TitleName);
		oip.getHeaderMsg().isDisplayed();
		hp.getdocumentsLink().click();
		driver.findElement(By.xpath("//a[@title=\"Documents\" and text()='"+TitleName+"']")).isDisplayed();
		
		
		
     
		
		
}
}
