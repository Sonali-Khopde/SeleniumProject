package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerGroupPOM_UNF_051 {
	private WebDriver driver;

	public AddCustomerGroupPOM_UNF_051(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// entering new customer group and details:customer group name
	@FindBy(xpath = "//input[@placeholder='Customer Group Name']")
	private WebElement custGroupName;

	public void setCustGroupName(String groupName) {
		this.custGroupName.sendKeys(groupName);
		;
	}

	// entering new customer group and details:customer group desc
	@FindBy(xpath = "//textarea[@id='input-description1']")
	private WebElement custGroupDesc;

	public void setCustGroupDesc(String groupDesc) {
		this.custGroupDesc.sendKeys(groupDesc);
		;
	}

	// entering new customer group and details:Approve New Customers
	@FindBy(xpath = "//input[@value='1']")
	private WebElement optApproveNewCustomers;

	public void setOptApproveNewCustomers() {
		this.optApproveNewCustomers.click();
	}

	// save new customer group and details
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSave;

	public void clickBtnSave() {
		this.btnSave.click();
	}

}
