package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustRewardPointsReportPOM_UNF_052 {
	private WebDriver driver;

	public CustRewardPointsReportPOM_UNF_052(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// reading rewards point total
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
	private WebElement rewardPntTotal;

	public String getRewardPntTotal() {
		return this.rewardPntTotal.getAttribute("value");
	}
}
