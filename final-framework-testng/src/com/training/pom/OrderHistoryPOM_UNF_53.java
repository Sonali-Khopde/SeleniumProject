package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderHistoryPOM_UNF_53 {
	private WebDriver driver;

	public OrderHistoryPOM_UNF_53(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click view order
	@FindBy(xpath = "//tbody//tr[1]//td[8]//a[1]//i[1]")
	private WebElement viewOrder;

	public void clickViewOrder() {
		this.viewOrder.click();
	}

	// click generate invoice
	@FindBy(xpath = "//button[@id='button-invoice']//i[@class='fa fa-cog']")
	private WebElement generateInvoice;

	public void clickGenerateInvoice() {
		this.generateInvoice.click();
	}

	// update orderstatus
	@FindBy(xpath = "//select[@id='input-order-status']")
	private WebElement orderStatus;

	public void setOrderStatus(String status) {
		Select statusOrder = new Select(this.orderStatus);
		this.orderStatus.click();
		statusOrder.selectByVisibleText(status);
	}

	// click on add history button
	@FindBy(xpath = ("//button[@id='button-history']"))
	private WebElement btnAddHistory;

	public void clickBtnAddHistory() {
		this.btnAddHistory.click();
	}

	// read the confirmation message
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirMsg;

	public String getConfirMsg() {
		System.out.println(this.confirMsg.getText());
		return this.confirMsg.getText();

	}

}
