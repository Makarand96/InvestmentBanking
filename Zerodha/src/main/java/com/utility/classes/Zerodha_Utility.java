package com.utility.classes;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Zerodha_Utility {
	WebDriver driver;
	
	
	public void screenshotmethod(WebDriver driver) throws IOException
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user:dir"+" /Screenshot.jpeg"));
		FileHandler.copy(source, destination);
	}

}
