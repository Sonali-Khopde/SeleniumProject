package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCustomerDetailsPOM_UNF_051;
import com.training.pom.AdminLoginPOM_UNF_051;
import com.training.pom.CustRewardPointsReportPOM_UNF_052;
import com.training.pom.CustomersPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.EditCustPOM_UNF_052;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RewardPointsTest_UNF_052 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	String balRewardPts;

	/*
	 * TO verify whether application allows admin to add reward points to the
	 * customer & view reward points in Reports section
	 */

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM_UNF_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Login_UNF_052");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test(priority = 0)
	public void customerGroupCreation() {
		DashboardPOM dpom = new DashboardPOM(driver);
		CustomersPOM_UNF_051 cPOM = new CustomersPOM_UNF_051(driver);
		// 1. click on Customer icon
		dpom.clickCustomerLnk();
		// 2. Click on Customers link
		dpom.clickCustomersLnk();
		// 3. click on Edit icon of the Customer
		cPOM.clickEditCustBtn();
	}

	@Test(priority = 1)
	public void addCustomer() {
		EditCustPOM_UNF_052 ecPOM = new EditCustPOM_UNF_052(driver);
		AddCustomerDetailsPOM_UNF_051 acdPOM = new AddCustomerDetailsPOM_UNF_051(driver);
		// 4. Clear First Name textbox
		ecPOM.clearFirstName();
		// 5. Enter valid credentials in First Name textbox
		ecPOM.setFirstName("Deepa");
		// 6. Click on Address1 tab
		acdPOM.clickLnkAddress1();
		// 7. Enter valid credentials in PostCode textbox
		acdPOM.setPostCodeTxt("8796545");
		// 8. Click on Reward Points tab
		ecPOM.clickRewardPointsLnk();
		// 9. Enter valid credentials in Description textbox
		ecPOM.setDescTxt("Festival bonanza");
		// 10. Enter valid credentials in Points textbox
		ecPOM.setPointsTxt("30");
		// 11. click on Add reward Points button
		ecPOM.clickBtnAddRewardPoint();
		// after adding reward points checking the total
		balRewardPts = ecPOM.setBalRewardPoint();
		// 12. Click on Save button
		ecPOM.clickBtnSave();
		String confMsg = ecPOM.readConfirmTxt();
		Assert.assertTrue(confMsg.contains("Success: You have "));
		screenShot.captureScreenShot("AddCustomerConfirmationMsg_UNF_052");
	}

	@Test(priority = 2)
	public void verifyReport() {
		DashboardPOM dPOM = new DashboardPOM(driver);
		CustRewardPointsReportPOM_UNF_052 crpPOM = new CustRewardPointsReportPOM_UNF_052(driver);
		// 13. Click on Reports icon
		dPOM.clickReport();
		// 14. click on Customers link
		dPOM.clickCustomersReportLnk();
		// 15. Click on Reward Points link
		dPOM.clickRewardPointsCustomersReportLnk();
		String totRewardPoints = crpPOM.getRewardPntTotal();
		assertEquals(totRewardPoints, balRewardPts);
	}
}
