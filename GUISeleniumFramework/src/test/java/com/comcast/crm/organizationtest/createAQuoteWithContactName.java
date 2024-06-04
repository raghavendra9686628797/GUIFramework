package com.comcast.crm.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.objectrepositoryutility.quotesPage;
import com.comcast.crm.objectrepositoryutility.moreInformationPage;

public class createAQuoteWithContactName extends BaseClass {
	
	@Test(groups = "regessionTest")
	public void  user_is_able_to_add_a_note() throws Throwable
	{

		HomePage hp=new HomePage(driver);
		

		/**
		 * generating random number
		 */
		
		JavaUtility ju = new JavaUtility();
		int num = ju.getRandomNumber();
		
		/* Create New Product*/
		
		hp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductImg().click();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName= eLib.getDataFromExcel("Organizations",13,2)+num;
		cnp.getProductnameEdt().sendKeys(productName);
		cnp.getSaveBtn().click();
		
		/**
		 * Navigating organization page
		 */
		hp.getOrgLink().click();
		String createOrgText = eLib.getDataFromExcel("Organizations", 13, 3);
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage newOrgPage = new CreatingNewOrganizationPage(driver);
		String createNewOrgPage = newOrgPage.getCreatingNewOrganizationText().getText();
		Assert.assertEquals(createOrgText, createNewOrgPage);
		
		
		String orgName = eLib.getDataFromExcel("Organizations", 13, 4) + num;
		
		/** creating organization and validation
		 * 
		 */
		
		newOrgPage.createOrg(orgName);
		Thread.sleep(3000);
		String OrganizationInformationText = eLib.getDataFromExcel("Organizations", 13, 5);
		System.out.println(OrganizationInformationText);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String TosterMessage = oip.getHeaderMsg().getText();
		System.out.println(TosterMessage);
		
		boolean getBoolean = TosterMessage.contains(OrganizationInformationText);
		Assert.assertTrue(getBoolean);
		
		oip.getmoreInformationLink().click();

		String moreInfoText = eLib.getDataFromExcel("Organizations", 13, 6);

		

		moreInformationPage mip = new moreInformationPage(driver);
		mip.getcontactsTab().click();
		
		String moreInformationPageText = mip.getHeaderMsg().getText();

		boolean getBooleanValue = moreInformationPageText.contains(moreInfoText);
		Assert.assertTrue(getBooleanValue);

		

		/**
		 * creating contact from more info page
		 */
		
		mip.getcontactsTab().isDisplayed();
		String contactText = eLib.getDataFromExcel("Organizations", 13, 7);
		mip.getcontactsTab().click();
		mip.getaddcontactButton().click();

		ContactInformationPage cip = new ContactInformationPage(driver);
		String creatingNewContactText = cip.getHeaderTxt().getText();
		Assert.assertEquals(creatingNewContactText, contactText);

		String contactName = eLib.getDataFromExcel("Organizations", 13, 8) + num;
		cip.createContact(contactName);
		driver.findElement(By.xpath("//tr[@bgcolor=\"white\"]//td//a[text()='" + contactName + "']")).isDisplayed();
		
		/**
		 * navigating to quote page and validation
		 */
		
		quotesPage qp = new quotesPage(driver);
		mip.getquotesTab().click();
		mip.getaddQuoteButton().isDisplayed();
		String quoteText = eLib.getDataFromExcel("Organizations", 13, 9);
		mip.getaddQuoteButton().click();
		String creatingNewQuoteText = qp.getheaderMessage().getText();
		Assert.assertEquals(creatingNewQuoteText, quoteText);
		
		/**
		 * creating quote
		 */
		
		String subjectName = eLib.getDataFromExcel("Organizations", 13, 10);
		qp.getsubjectTextfield().sendKeys(subjectName);
		
		String billingAddress = eLib.getDataFromExcel("Organizations", 13, 11);
		qp.getbillingAddressTextarea().sendKeys(billingAddress);
		
		String shippingAddress = eLib.getDataFromExcel("Organizations", 13, 12);
		qp.getshippingAddressTextarea().sendKeys(shippingAddress);
		
		wLib.scrollUntilElementIsVisible(driver, qp.getsearchIcon1());
		System.out.println("failed to scroll");
		
		String QTY = eLib.getDataFromExcel("Organizations", 13, 13);
		qp.getqtyTextfiled().sendKeys(QTY);
		
		qp.getsearchIcon1().click();
		
		/**
		 * switching the window to child 
		 */
		
		wLib.switchToTabOnURL(driver, "module=Products&action");
		qp.getsearchBasicModeTexfield().sendKeys(productName);
		qp.getsearchNowButton().click();
		driver.findElement(By.linkText(productName)).click();
		
		/* switching window back to parent window */
		
		
		wLib.switchToTabOnURL(driver,"index.php");
		newOrgPage.getSaveBtn().click();
		driver.findElement(By.xpath("//a[text()='"+subjectName+"']")).isDisplayed();
		
		
		
		

	}
}
