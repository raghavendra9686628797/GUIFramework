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

public class createOrganization  extends BaseClass {

	@Test(groups = "smokeTest")
	public void  user_is_able_to_create_a_Organization() throws Throwable
	{
		WebDriverUtility wd = new WebDriverUtility();
		wd.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		String createOrgText = eLib.getDataFromExcel("Organizations", 4, 2);
		
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
		
		String orgName = eLib.getDataFromExcel("Organizations", 4, 3) + num;
		
		/** creating organization
		 * 
		 */
		newOrgPage.createOrg(orgName);
		Thread.sleep(3000);
		String OrganizationInformationText = eLib.getDataFromExcel("Organizations", 4, 4);
		System.out.println(OrganizationInformationText);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String TosterMessage = oip.getHeaderMsg().getText();
		System.out.println(TosterMessage);
		
		boolean getBoolean = TosterMessage.contains(OrganizationInformationText);
		Assert.assertTrue(getBoolean);
		hp.getOrgLink().click();
		driver.findElement(By.linkText(orgName)).isDisplayed();

}
}
