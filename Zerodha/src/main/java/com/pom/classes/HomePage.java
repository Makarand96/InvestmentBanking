package com.pom.classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	@FindBy(tagName = "a")
	private List<WebElement> links;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchStock;

	@FindBy(xpath = "//ul[@class='omnisearch-results']//li")
	private List<WebElement> relianceNse;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectorders(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(links));

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getText().equalsIgnoreCase("Orders")) {
				System.out.println(links.get(i).getText());
				links.get(i).click();
			}

		}

	}

	public void selectRelianceStock() {
		searchStock.sendKeys("Reliance");
		System.out.println(relianceNse.size());
		relianceNse.iterator().next().click();
	}

}
