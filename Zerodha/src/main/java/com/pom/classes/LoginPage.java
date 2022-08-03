package com.pom.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	PinPage pg;

	@FindBy(id = "userid")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername() {
		Assert.assertTrue(username.isEnabled());
		username.sendKeys("IT4879");
	}

	public void enterPassword() {
		password.sendKeys("Mak@71196");
	}

	public void clickSubmitButton() {
		if (submit.isEnabled()) {
			submit.click();
		} else {
			System.out.println("Button not enabled");
		}

	}

}
