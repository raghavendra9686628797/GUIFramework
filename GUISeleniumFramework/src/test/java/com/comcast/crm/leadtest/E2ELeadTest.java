package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CalendarPage;
import com.comcast.crm.objectrepositoryutility.ComposeEmailPage;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.EmailPage;
import com.comcast.crm.objectrepositoryutility.EmailTemplatesPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.MyPreferencesPage;
import com.comcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.OpportunityPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;

public class E2ELeadTest extends BaseClass {

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

	@Test(groups = "regressionTest")
	public void add_Event_For_Created_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_020", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_020", "Company");
		String eventName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_020", "Event Name")
				+ jLib.getRandomNumber();
		String searchInOption = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_020", "In");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, company);

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);

		/* Create Event */
		lip.getAddeventLnk().click();
		CalendarPage cp = new CalendarPage(driver);
		cp.getEventNameEdt().sendKeys(eventName);
		String eventStartDate = jLib.getRequriedDateYYYYDDMM(1);
		cp.getStartDateEdt().clear();
		cp.getStartDateEdt().sendKeys(eventStartDate);
		cp.getSaveBtn().click();

		/* Navigate to Calendar Page */
		hp.getCalendarLnk().click();
		cp.getAllEventsAndTodoslnk().click();

		/* Search For the Event */
		cp.getSearchForEdt().sendKeys(eventName);
		wLib.select(cp.getSearchFieldDD(), searchInOption);
		cp.getSearchNowBtn().click();
		driver.findElement(By.linkText(eventName)).click();

		/* Verify Event Details */
		String actEventName = cp.getEventNameTxt().getText();
		Assert.assertEquals(actEventName, eventName);
		String actEventStartDate = cp.getEventStartDateTxt().getText();
		Assert.assertEquals(actEventStartDate, eventStartDate);

	}

	@Test(groups = "regressionTest")
	public void add_ToDo_For_Created_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_021", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_021", "Company");
		String toDo = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_021", "To Do")
				+ jLib.getRandomNumber();
		String searchInOption = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_021", "In");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, company);

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);

		/* Create To Do */
		lip.getAddeventLnk().click();
		CalendarPage cp = new CalendarPage(driver);
		cp.getToDoEdt().sendKeys(toDo);

		cp.getSaveBtn().click();

		/* Navigate to Calendar Page */
		hp.getCalendarLnk().click();
		cp.getAllEventsAndTodoslnk().click();

		/* Search For the To Do */
		cp.getSearchForEdt().sendKeys(toDo);
		wLib.select(cp.getSearchFieldDD(), searchInOption);
		cp.getSearchNowBtn().click();
		driver.findElement(By.linkText(toDo)).click();

		/* Verify To Do Details */
		String actToDo = cp.getToDoTxt().getText();
		Assert.assertEquals(actToDo, toDo);

	}

	@Test(groups = "regressionTest")
	public void convert_Lead_Into_Org_And_Contact() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_022", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_022", "Company");
		String searchInOption = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_022", "In");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, company);

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);

		/* Convert Lead */
		lip.getConvertLeadLnk().click();
		wLib.waitForElementPresent(driver, lip.getConvertLeadPopupHdr());
		String hdrText = lip.getConvertLeadPopupHdr().getText();
		getBoolean = hdrText.contains(lastName);
		lip.getSaveBtn().click();

		/* Verify Org Name */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgName = oip.getOrgNameText().getText();
		Assert.assertEquals(orgName, company);

		/* Navigate to Contacts and Search the Contact */
		hp.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getSearchForEdt().sendKeys(lastName);
		wLib.select(cp.getSearchFieldDD(), searchInOption);
		cp.getSearchNowBtn().click();
		driver.findElement(By.linkText(lastName)).click();

		/* Verify contact */
		ContactInformationPage cip = new ContactInformationPage(driver);
		actLastName = cip.getLastnameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		orgName = cip.getOrgNamelnk().getText();
		Assert.assertEquals(orgName, company);
	}

	@Test(groups = "regressionTest")
	public void convert_Lead_To_Opportunity() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_023", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_023", "Company");
		String opportunityName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_023", "Opportunity Name")+ jLib.getRandomNumber();
		String searchInOption = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_023", "In");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, company);

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);

		/* Convert Lead */
		lip.getConvertLeadLnk().click();
		wLib.waitForElementPresent(driver, lip.getConvertLeadPopupHdr());
		String hdrText = lip.getConvertLeadPopupHdr().getText();
		getBoolean = hdrText.contains(lastName);
		lip.getOpportunityCheckBox().click();
		lip.getOpportunityNameEdt().sendKeys(opportunityName);
		lip.getExpectedCloseDateEdt().sendKeys(jLib.getRequriedDateYYYYDDMM(7));
		lip.getSaveBtn().click();
		
		/* Verify Org Name */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgName = oip.getOrgNameText().getText();
		Assert.assertEquals(orgName, company);
		
		/* Navigate to opportunity Page and search the created opportunity*/
		hp.getOpportunitiesLink().click();
		OpportunityPage opp = new OpportunityPage(driver);
		opp.getSearchForEdt().sendKeys(opportunityName);
		wLib.select(opp.getSearchFieldDD(), searchInOption);
		opp.getSearchNowBtn().click();
		driver.findElement(By.linkText(opportunityName)).click();
		
		/* Verify the opportunity */
		OpportunityInformationPage oppip  = new OpportunityInformationPage(driver);
		
	}
}
