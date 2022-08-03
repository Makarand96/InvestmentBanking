package com.pom.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PinPage {
	WebDriver driver;
	
	@FindBy(id="pin")
	private WebElement pin;
	
	@FindBy(xpath="//div[@class='actions']/button")
	private WebElement submit;
	
	public PinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPin(WebDriver driver)
	{
		if(pin.isDisplayed())
		{
			pin.sendKeys("789123");
		}
		else
		{
			WebDriverWait w =new WebDriverWait(driver,5);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("pin")));
				pin.sendKeys("961107");
		}
	}
	
	public void clickSubmitofPinPage()
	{
		if(submit.isEnabled())
		{
			submit.click();
		}
		else
		{
			System.out.println("Button not enabled");
		}
	}
}
