package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPOM_UNF_085 {
	private WebDriver driver;

	public OrdersPOM_UNF_085(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enter valid credentials in Order ID textbox
	@FindBy(id = "input-order-id")
	private WebElement orderId;

	public void setOrderId(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
	}

	// Select Valid credentials in Order Status textbox
	@FindBy(id = "input-order-status")
	private WebElement orderStatus;

	public void setOrderStatus(String orderStatus) {
		Select orderStatusSel = new Select(this.orderStatus);
		orderStatusSel.selectByVisibleText(orderStatus);
	}

	// Click on Date icon of Date Added list box
	@FindBy(xpath = "//div[@class='row']//div[1]//div[1]//span[1]//button[1]//i[1]")
	private WebElement dateAdded;

	public void clickDateAdded() {
		this.dateAdded.click();
	}

	// Select values from Calendar
	@FindBy(id = "input-date-added")
	private WebElement calDate;

	public void setCalDate(String dateAdd) {
		this.calDate.clear();
		// SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		this.calDate.sendKeys(dateAdd);
	}

	// Enter Valid credentials in Customer textbox
	@FindBy(id = "input-customer")
	private WebElement custName;

	public void setCustName(String customerName) {
		this.custName.clear();
		this.custName.sendKeys(customerName);
	}

	// Enter Valid credentials in Total textbox
	@FindBy(id = "input-total")
	private WebElement total;

	public void setTotal(String totalVal) {
		this.total.sendKeys(totalVal);
	}

	// Click on Calendar icon in the Date Modified list box and Select values from
	// Calendar
	@FindBy(id = "input-date-modified")
	private WebElement calDateMod;

	public void setCalDateMod(String dateMod) {
		this.calDateMod.clear();
		this.calDateMod.sendKeys(dateMod);
	}

	// Click on Filter button
	@FindBy(xpath = "//*[@id=\'button-filter\']")
	private WebElement btnFilter;

	public void clickBtnFilter() {
		this.btnFilter.click();
	}

	// read the confirmation msg
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/h1")
	private WebElement readMsg;

	public String getReadMsg() {
		return this.readMsg.getText();
	}
}
