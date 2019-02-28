package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM__UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.OrderHistoryPOM_UNF_53;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderHistoryTest_UNF_053 {
	private AdminLoginPOM__UNF_051 adminLoginPOM;
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM__UNF_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF_053_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validLoginTest() throws AWTException, InterruptedException {
		OrderHistoryPOM_UNF_53 ohPOM = new OrderHistoryPOM_UNF_53(driver);
		DashboardPOM dPOM = new DashboardPOM(driver);
		// 1. Click on view icon of order placed by the customer in Latest Orders
		// section
		dPOM.clickSales();
		dPOM.clickOrder();
		ohPOM.clickViewOrder();
		// 2. Click on Generate icon of options section
		ohPOM.clickGenerateInvoice();
		// 3. Select valid credentials in Order status list box
		ohPOM.setOrderStatus("Complete");
		// 4. Click on Add history button
		ohPOM.clickBtnAddHistory();
		Thread.sleep(3000);
		Assert.assertTrue(ohPOM.getConfirMsg().contains("Success: You have modified orders!"));
		screenShot.captureScreenShot("UNF_053_Confirmation message");

	}
}
