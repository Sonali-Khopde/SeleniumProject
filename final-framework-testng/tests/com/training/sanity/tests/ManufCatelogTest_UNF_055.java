package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM__UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ManufCatelogPOM_UNF_55;
import com.training.pom.OrderReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ManufCatelogTest_UNF_055 {

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
		screenShot.captureScreenShot("UNF_055_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void manufacturerCatelog() {
		ManufCatelogPOM_UNF_55 mcPOM = new ManufCatelogPOM_UNF_55(driver);
		String mfName = "Smart Uniforms";
		String pdtName = "Socks";
		String metaTag = "Student Socks";
		String model = "SCK-101";
		String category = "Sports Uniform";
		// 1. Click on Catelog icon
		mcPOM.clickLnkCatelog();
		// 2. Click on Manufacturers link
		mcPOM.clickLnkManuf();
		// 3. Click on Add new icon
		mcPOM.clickBtnAddManuf();
		// 4. Enter valid credentials in Manufacturer name textbox
		mcPOM.setManufName(mfName);
		// 5. Click on Save icon
		mcPOM.clickBtnSaveManuf();
		Assert.assertTrue(mcPOM.readConfirmTxt().contains("Success: You have modified manufacturers"));
		// 6. Click on Catelog icon
		mcPOM.clickLnkCatelog();
		// 7. Click on Products link
		mcPOM.clickLnkPdt();
		// 8. Click on Add New icon
		mcPOM.clickBtnAddPdt();
		// 9. Enter Valid credentials in Product Name of General tab
		mcPOM.setPdtName(pdtName);
		// 10. Enter Valid credentials in Meta Tag Title of General tab
		mcPOM.setMetaTagTitle(metaTag);
		// 11. Click on Data tab
		mcPOM.clickLnkData();
		// 12. Enter valid credentials in Model textbox
		mcPOM.setModelData(model);
		// 13. Enter valid credentials in Price textbox
		mcPOM.setPriceData("100");
		// 14. Enter valid credentials in Quantity textbox
		mcPOM.setQtyData("2");
		// 15. Click on Links tab
		mcPOM.clickLnkLink();
		// 16. Enter valid credentials in Manufacturer textbox
		mcPOM.setManufracturer(mfName);
		// 17. Click on Categories textbox and 18. Select Category from displayed
		// category list
		mcPOM.setCategory(category);
		// 20. Click on Save icon
		mcPOM.clickBtnFinalSave();
		System.out.println(mcPOM.readFinalConfirmTxt());
		Assert.assertTrue(mcPOM.readFinalConfirmTxt().contains("Success: You have modified products!"));
		screenShot.captureScreenShot("UNF_055_Final");
	}
}
