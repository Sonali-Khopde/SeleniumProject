package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReturnPOM {
	private WebDriver driver;

	public ReturnPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// select group by with weeks
	@FindBy(xpath = "//select[@name='filter_group']")
	private WebElement groupByLst;

	public void setGroupByList() {
		Select groupLst = new Select(groupByLst);
		groupLst.selectByIndex(3);
	}

	// click filter button
	@FindBy(xpath = "//button[@id='button-filter']")
	public WebElement filterBtn;

	public void clickFilterBtn() {
		this.filterBtn.click();
	}

	// Getting the value of Shipping Report(Page header)
	@FindBy(xpath = "//h1[contains(text(),'Returns Report')]")
	private WebElement pagerHeaderTitle;

	public String getPagerHeaderTitle() {
		return this.pagerHeaderTitle.getText();
	}
}
