package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPOM_UNF_051 {
	private WebDriver driver;

	public CustomersPOM_UNF_051(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// adding new customer details(add button top right)
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement btnAddCustomer;

	public void clickBtnAddCustomer() {
		this.btnAddCustomer.click();
	}

	// confirmation message of adding a customer
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement msgAddCustomerConfirm;

	public String getMsgAddCustomerConfirm() {
		return this.msgAddCustomerConfirm.getText();
	}

	// Entering customer name to find and delete
	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement customerName;

	public void setCustomerName(String custName) {
		this.customerName.sendKeys(custName);
	}

	// click Filter button
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement filterBtn;

	public void clickFilterBtn() {
		this.filterBtn.click();
	}

	// select check box for deletion
	@FindBy(xpath = "//tbody//td[@class='text-center']")
	private WebElement checkBox;

	public void clickCheckBox() {
		this.checkBox.click();
	}

	// click on delete button
	@FindBy(xpath = "//div[@class='pull-right']//button[@type='button']")
	private WebElement deleteBtn;

	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}

	// clicking on edit customer link
	@FindBy(xpath = "//body/div[@id='container']/div[@id='content']/div[@class='container-fluid']/div[@class='panel panel-default']/div[@class='panel-body']/form[@id='form-customer']/div[@class='table-responsive']/table[@class='table table-bordered table-hover']/tbody/tr[1]/td[8]/a[1]")
	private WebElement editCustBtn;

	public void clickEditCustBtn() {
		this.editCustBtn.click();
	}
	
	//confirmtion message
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement confirmMsg;
	
	public String getConfirmMsg() {
		return this.confirmMsg.getText();
	}

}
