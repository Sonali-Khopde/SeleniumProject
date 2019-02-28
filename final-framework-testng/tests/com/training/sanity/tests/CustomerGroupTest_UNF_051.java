package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCustomerDetailsPOM_UNF_051;
import com.training.pom.AddCustomerGroupPOM_UNF_051;
import com.training.pom.AdminLoginPOM__UNF_051;
import com.training.pom.CustomerGroupsPOM_UNF_051;
import com.training.pom.CustomersPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CustomerGroupTest_UNF_051 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM__UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String grpName = "Premium Member";
	private String groupDesc = "Premium Member";
	private String firstName = "Reena";
	private String lastName = "Sharma";

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM__UNF_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Login_UNF_051");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 0)
	public void customerGroupCreation() {
		DashboardPOM dpom = new DashboardPOM(driver);
		CustomerGroupsPOM_UNF_051 cPOM = new CustomerGroupsPOM_UNF_051(driver);
		AddCustomerGroupPOM_UNF_051 agPOM = new AddCustomerGroupPOM_UNF_051(driver);
		//1. click on Customer icon
		dpom.clickCustomerLnk();
		//2. Click on Customer Groups link
		dpom.clickCustomerGroup_Customers();
		//3. Click on Add New icon
		cPOM.clickAddCustGroup();
		//4. Enter valid credentials in Customer Group Name textbox
		agPOM.setCustGroupName(grpName);
		//5. Enter valid credentials in Description textbox
		agPOM.setCustGroupDesc(groupDesc);
		//6. Click yes radio button of Approve New Customers section
		agPOM.setOptApproveNewCustomers();
		//7. Click on Save button
		agPOM.clickBtnSave();
	}

	@Test(priority = 1)
	public void addCustomer() {
		DashboardPOM dpom = new DashboardPOM(driver);
		CustomersPOM_UNF_051 custPOM = new CustomersPOM_UNF_051(driver);
		AddCustomerDetailsPOM_UNF_051 acgPOM = new AddCustomerDetailsPOM_UNF_051(driver);
		//8. click on Customer icon
		dpom.clickCustomerLnk();
		//9. Click on Customers link
		dpom.clickCustomersLnk();
		//10. Click on Add new icon
		custPOM.clickBtnAddCustomer();
		//11. Select valid credentials in Customer group list box
		acgPOM.setdrpDownCustGroupName(grpName);
		//12. Enter valid credentials in First Name textbox
		acgPOM.setCustFirstName(firstName);
		//13. Enter valid credentials in Last Name textbox
		acgPOM.setCustLastName(lastName);
		//14. Enter valid credentials in E-Mail textbox
		acgPOM.setCustEMail("reenasharma@gmail.com");
		//15. Enter valid credentials in Telephone textbox
		acgPOM.setCustTelephoneNo("9765433214");
		//16. Enter valid credentials in Password textbox
		acgPOM.setCustPassword("reenas123");
		//17. Enter valid credentials in Confirm password textbox
		acgPOM.setCustConfPassword("reenas123");
	}

	@Test(priority = 2)
	public void addCustomerAddress() {
		AddCustomerDetailsPOM_UNF_051 acgPOM = new AddCustomerDetailsPOM_UNF_051(driver);
		CustomersPOM_UNF_051 custPOM = new CustomersPOM_UNF_051(driver);
		// opening and updating the address 1 page
		//18. Click on Address1 tab & 19. Enter valid credentials in Address1 textbox
		acgPOM.clickLnkAddress();
		acgPOM.clickLnkAddress1();
		acgPOM.setCustFirstNameAddr(firstName);
		acgPOM.setCustLastNameAddr(lastName);
		acgPOM.setAddress1Txt("4th Block");
		//20. Enter valid credentials in Address2 textbox
		acgPOM.setAddress2Txt("Jayanagar");
		//21. Enter valid credentials in City textbox
		acgPOM.setCityTxt("Bangalore");
		//22. Enter valid credentials in Post Code textbox
		acgPOM.setPostCodeTxt("560014");
		//23. Select credentials from Country list box
		acgPOM.setCountryTxt("India");
		//24. Select credentials from Region/State list box
		acgPOM.setStateTxt("Karnataka");
		// clicking save btn
		acgPOM.clickBtnSaveCustomer();
		String confMsg = custPOM.getMsgAddCustomerConfirm();
		Assert.assertTrue(confMsg.contains("Success: You have "));
		screenShot.captureScreenShot("AddCustomerConfirmationMsg_UNF_051");
	}
}
