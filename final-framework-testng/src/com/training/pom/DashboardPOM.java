package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {
	private WebDriver driver;

	public DashboardPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Reading Dashboard header
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement dashboardHeader;
	
	public String getDashboardHeaders() {
		return this.dashboardHeader.getText();
	}
	
	// click first customer link
	@FindBy(xpath = "//i[@class='fa fa-user fa-fw']")
	private WebElement customerLnk;

	public void clickCustomerLnk() {
		this.customerLnk.click();
	}

	// click sub customers link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]")
	private WebElement customersLnk;

	public void clickCustomersLnk() {
		this.customersLnk.click();
	}

	// click cust grp under customers
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[2]/a[1]")
	private WebElement customerGroup_Customers;

	public void clickCustomerGroup_Customers() {
		this.customerGroup_Customers.click();
	}

	// click Returns
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[1]/ul[1]/li[4]/a[1]")
	private WebElement returnsLnk;

	public void clickReturnsLnk() {
		this.returnsLnk.click();
	}

	// click shipping
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[1]/ul[1]/li[3]/a[1]")
	private WebElement shippingLnk;

	public void clickShippingLnk() {
		this.shippingLnk.click();
	}

	// click reports
	@FindBy(xpath = "//i[@class='fa fa-bar-chart-o fa-fw']")
	private WebElement reportsLink;

	public void clickReport() {
		this.reportsLink.click();
	}

	// click tax
	@FindBy(xpath = "//ul[@class='collapse in']//a[contains(text(),'Tax')]")
	private WebElement taxLink;

	public void clickTax() {
		this.taxLink.click();
	}

	// click sales
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/a[1]")
	public WebElement sales;

	public void clickSales() {
		this.sales.click();
	}

	// click orders
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]")
	public WebElement orders;

	public void clickOrder() {
		this.orders.click();
	}

	// click Customers under report
	@FindBy(xpath = "//a[@class='parent'][contains(text(),'Customers')]")
	public WebElement customersReportLnk;

	public void clickCustomersReportLnk() {
		this.customersReportLnk.click();
	}

	// click Reports under Customers under report
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[3]/ul[1]/li[4]/a[1]")
	public WebElement rewardPointsCustomersReportLnk;

	public void clickRewardPointsCustomersReportLnk() {
		this.rewardPointsCustomersReportLnk.click();
	}

	//clicking on new order under Sales -> Order
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement btnAddOrder;
	
	public void clickBtnAddOrder() {
		this.btnAddOrder.click();
	}
}
