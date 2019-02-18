package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPOM {
	private WebDriver driver;

	public CustomersPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Entering customer name to find and delete
	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement customerName;

	public void setCustomerName(String custName) {
		this.customerName.sendKeys(custName);
		;
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

}
