package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ComposeEmailPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.EmailPage;
import com.comcast.crm.objectrepositoryutility.EmailTemplatesPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.MyPreferencesPage;

public class E2ELeadTest extends BaseClass{
	
	@Test(groups = "regressionTest")
	public void save_Mail_For_Created_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019", "Company");
		String email = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019", "Email");
		String subject = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019", "Subject");
		String composeEmailPartialURL = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019",
				"ComposeEmailPartialURL");
		String emailTemplatePartialURL = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_019",
				"EmailTemplatePartialURL");

		/* Fetch user email address */
		HomePage hp = new HomePage(driver);
		wLib.mousemoveOnElement(driver, hp.getAdminImg());
		hp.getMyPreferenceLnk().click();

		MyPreferencesPage mpp = new MyPreferencesPage(driver);
		String userEmail = mpp.getEmailLnk().getText();

		/* Navigate to Create Lead Page */
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getEmailEdt().sendKeys(email);
		cnlp.getSaveBtn().click();

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);
		String actEmail = lip.getEmailLnk().getText();
		Assert.assertEquals(actEmail, email);

		/* Send Mail */
		lip.getSendMailLnk().click();
		lip.getSelectBtn().click();
		wLib.switchToTabOnURL(driver, composeEmailPartialURL);

		ComposeEmailPage cep = new ComposeEmailPage(driver);
		String toEmail = cep.getToEdt().getAttribute("value");
		getBoolean = toEmail.contains(email);
		Assert.assertTrue(getBoolean);

		/* Select Email template */
		cep.getSelectEmailTemplateBtn().click();
		wLib.switchToTabOnURL(driver, emailTemplatePartialURL);
		EmailTemplatesPage etp = new EmailTemplatesPage(driver);
		etp.getFollowUpLnk().click();

		/* Enter subject and Save the Mail */
		wLib.switchToTabOnURL(driver, composeEmailPartialURL);
		cep.getSubjectEdt().clear();
		cep.getSubjectEdt().sendKeys(subject);
		cep.getSaveBtn().click();

		/* Navigate to Email Page */
		wLib.switchToTabOnURL(driver, "module=Leads");
		hp.getEmailLink().click();

		EmailPage ep = new EmailPage(driver);
		ep.getSearchEdt().sendKeys(subject);
		ep.getFindBtn().click();
		
		driver.findElement(By.xpath("//b[contains(.,'" + subject + "')]")).click();
		/* Verify Email details */
		String actFromEmail = ep.getFromEmailtxt().getText();
		Assert.assertEquals(actFromEmail.trim(), userEmail);
		String actToEmail = ep.getToEmailtxt().getText();
		System.out.println(actToEmail);
		getBoolean = actToEmail.contains(lastName);
		Assert.assertTrue(getBoolean);
		getBoolean = actToEmail.contains(email);
		Assert.assertTrue(getBoolean);
		String actSubject = ep.getSubjecttxt().getText();
		Assert.assertEquals(actSubject.trim(), subject);

	}
	
}
