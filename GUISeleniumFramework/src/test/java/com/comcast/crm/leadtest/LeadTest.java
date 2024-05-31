package com.comcast.crm.leadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;

public class LeadTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void edit_Last_Name_Of_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_012", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_012", "Company");
		String updatedLastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_012",
				"edit Last Name");

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

		/* Edit Last Name of Lead */
		lip.getEditBtn().click();
		cnlp.getLastnameEdt().clear();
		cnlp.getLastnameEdt().sendKeys(updatedLastName);
		cnlp.getSaveBtn().click();

		/* Verify the Updated Last Name of Lead */
		hdrMsg = lip.getHeaderMsg().getText();
		getBoolean = hdrMsg.contains(updatedLastName);
		Assert.assertTrue(getBoolean);
		actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, updatedLastName);
		Assert.assertNotEquals(lastName, updatedLastName);

	}

	@Test(groups = "regressionTest")
	public void edit_Company_Of_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_013", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_013", "Company");
		String updatedCompany = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_013",
				"Edit Company");

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

		/* Edit company of Lead */
		lip.getEditBtn().click();
		cnlp.getCompanyEdt().clear();
		cnlp.getCompanyEdt().sendKeys(updatedCompany);
		cnlp.getSaveBtn().click();

		/* Verify the Updated Last Name of Lead */
		actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, updatedCompany);
		Assert.assertNotEquals(company, updatedCompany);
	}

	@Test(groups = "regressionTest")
	public void delete_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Company");

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

		/* Delete the Lead */
		lip.getDeleteBtn().click();
		wLib.switchtoAlertAndAccept(driver);

		/* Verify the Lead is deleted */
		boolean isDisplayedOrNot = wLib.verifyElementDisplayedOrNot(driver, "//a[text()=" + lastName + "]");
		Assert.assertFalse(isDisplayedOrNot);
	}

	@Test(groups = "regressionTest")
	public void cancel_The_Deleting_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Company");

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

		/* Delete the Lead */
		lip.getDeleteBtn().click();
		wLib.switchtoAlertAndCancel(driver);

		/* Verify the Lead is not deleted */
		hdrMsg = lip.getHeaderMsg().getText();
		getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
	}

	@Test(groups = "regressionTest")
	public void duplicate_Lead() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Last Name")
				+ jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_014", "Company");

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

		/* Duplicate the Lead */
		lip.getDuplicateBtn().click();
		hdrMsg = lip.getDuplicatingHdrTxt().getText();
		getBoolean=hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		
		cnlp.getSaveBtn().click();
		
		/* Verify the duplicated Lead */
		hdrMsg = lip.getHeaderMsg().getText();
		getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);
		
	}
}
