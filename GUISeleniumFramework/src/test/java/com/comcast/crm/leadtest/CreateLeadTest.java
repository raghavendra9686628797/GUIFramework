package com.comcast.crm.leadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;

public class CreateLeadTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void create_Lead_With_Mandatory_Fields() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_001", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_001", "Company");

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
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Phone_Number() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_002", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_002", "Company");
		String phoneNumber = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_002", "Phone");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getPhoneEdt().sendKeys(phoneNumber);
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
		String actPhoneNumber = lip.getPhoneTxt().getText();
		Assert.assertEquals(actPhoneNumber, phoneNumber);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Title() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_003", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_003", "Company");
		String title = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_003", "Title");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getTitleEdt().sendKeys(title);
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
		String actTitle = lip.getTitleTxt().getText();
		Assert.assertEquals(actTitle, title);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Fax() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_004", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_004", "Company");
		String fax = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_004", "Fax");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getFaxEdt().sendKeys(fax);
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
		String actFax = lip.getFaxTxt().getText();
		Assert.assertEquals(actFax, fax);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Lead_Source() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_005", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_005", "Company");
		String leadSource = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_005", "Lead Source");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		wLib.select(cnlp.getLeadSourceDD(), leadSource);
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
		String actLeadSource = lip.getLeadsourceTxt().getText();
		Assert.assertEquals(actLeadSource, leadSource);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Industry() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_006", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_006", "Company");
		String industry = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_006", "Industry");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		wLib.select(cnlp.getIndustryDD(), industry);
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
		String actIndustry = lip.getIndustryTxt().getText();
		Assert.assertEquals(actIndustry, industry);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Annual_Revenue() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_007", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_007", "Company");
		String annualRevenue = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_007",
				"Annual Revenue");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getAnnualRevenueEdt().sendKeys(annualRevenue);
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
		String actAnnualRevenue = lip.getAnnualRevenueTxt().getText();
		Assert.assertEquals(actAnnualRevenue, annualRevenue);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Email() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_008", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_008", "Company");
		String email = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_008", "Email");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
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
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Website() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_009", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_009", "Company");
		String website = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_009", "Website");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getWebsiteEdt().sendKeys(website);
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
		String actWebsite = lip.getWebsiteLnk().getText();
		getBoolean = actWebsite.contains(website);
		Assert.assertTrue(getBoolean);
	}

	@Test(groups = "regressionTest")
	public void create_Lead_With_Address_Information() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "Company");
		String street = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "street");
		String postalCode = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "Postal code");
		String city = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "city");
		String state = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "state");
		String country = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_010", "country");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getStreetTxtArea().sendKeys(street);
		cnlp.getPostalCodeEdt().sendKeys(postalCode);
		cnlp.getCityEdt().sendKeys(city);
		cnlp.getStateEdt().sendKeys(state);
		cnlp.getCountryEdt().sendKeys(country);
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
		String actStreet = lip.getStreetTxt().getText();
		Assert.assertEquals(actStreet, street);
		String actPostalCode = lip.getPostalCodeTxt().getText();
		Assert.assertEquals(actPostalCode, postalCode);
		String actCity = lip.getCityTxt().getText();
		Assert.assertEquals(actCity, city);
		String actState = lip.getStateTxt().getText();
		Assert.assertEquals(actState, state);
		String actCountry = lip.getCountryTxt().getText();
		Assert.assertEquals(actCountry, country);
	}
	
	@Test(groups = "regressionTest")
	public void create_Lead_With_Description_Information() throws Throwable {

		String lastName = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_011", "Last Name");
		String company = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_011", "Company");
		String description = eLib.getDataFromExcel("./testdata/testScriptdata.xlsx", "Leads", "LD_011", "Description");

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.getLastnameEdt().sendKeys(lastName);
		cnlp.getCompanyEdt().sendKeys(company);
		cnlp.getDescriptionTxtArea().sendKeys(description);
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
		String actdescription = lip.getDescriptionTxt().getText();
		Assert.assertEquals(actdescription, description);
	}
}
