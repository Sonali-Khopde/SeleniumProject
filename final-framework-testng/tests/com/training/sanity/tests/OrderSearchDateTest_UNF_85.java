package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.OrderReturnsPOM_UNF_082;
import com.training.pom.OrdersPOM_UNF_085;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderSearchDateTest_UNF_85 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	/*
	 * To Verify whether application allows admin to filter details of order placed
	 * by the user
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
		screenShot.captureScreenShot("UNF_085_Login");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void fetchOrder(String orderId, String orderStatus, String dateAdded, String customerName, String totalVal,
			String dateMod) throws AWTException, InterruptedException {
		DashboardPOM dPOM = new DashboardPOM(driver);
		OrderReturnsPOM_UNF_082 orpPOM = new OrderReturnsPOM_UNF_082(driver);
		OrdersPOM_UNF_085 oPOM = new OrdersPOM_UNF_085(driver);
		// click on Sales icon
		dPOM.clickSales();
		// click on Orders link
		orpPOM.clickOrdersLnk();
		// Enter valid credentials in Order ID textbox
		oPOM.setOrderId(orderId);
		// Select Valid credentials in Order Status textbox
		oPOM.setOrderStatus(orderStatus);
		// Click on Date icon of Date Added list box and Select values from Calendar
		oPOM.setCalDate(dateAdded);
		// Enter Valid credentials in Customer textbox
		oPOM.setCustName(customerName);
		// Enter Valid credentials in Total textbox
		oPOM.setTotal(totalVal);
		// Click on Calendar icon in the Date Modified list box and Select values from
		// Calendar
		oPOM.setCalDateMod(dateMod);
		// Click on Filter button
		oPOM.clickBtnFilter();
		Assert.assertTrue(oPOM.getReadMsg().contains("Orders"));
		screenShot.captureScreenShot("UNF_085_Confirmation Msg" + orderId);
	}

}
