package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM__UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.ReturnPOM;
import com.training.pom.OrderReportPOM;
import com.training.pom.ShippingReportPOM;
import com.training.pom.TaxReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnReportTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM__UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF_025_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void taxReport() {
		DashboardPOM dPOM = new DashboardPOM(driver);
		dPOM.clickReport();
		dPOM.clickSales();
		dPOM.clickReturnsLnk();
		ReturnPOM rPOM = new ReturnPOM(driver);
		rPOM.setGroupByList();
		rPOM.clickFilterBtn();
		String title = "Returns Report";
		Assert.assertEquals(title, rPOM.getPagerHeaderTitle());
		screenShot.captureScreenShot("UNF_025_Final");
	}
}
