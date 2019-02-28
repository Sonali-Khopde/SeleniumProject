package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerGroupsPOM_UNF_051 {
	private WebDriver driver;

	public CustomerGroupsPOM_UNF_051(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// clicking on add button to add new customer group
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addCustGroup;

	public void clickAddCustGroup() {
		this.addCustGroup.click();
	}
}
