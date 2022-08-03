package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pom.classes.HomePage;
import com.pom.classes.LoginPage;
import com.pom.classes.PinPage;

import Pojo.Base;

public class SelectRelianceShare extends Base {
	WebDriver driver;
	LoginPage login;
	PinPage pg;
	HomePage homepage;
//	static ExtentTest test;
//	static ExtentHtmlReporter reporter;

	@Parameters({"browser"})
	@BeforeTest
	public void invokeBrowser(String browsername) {
//		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html");
//		ExtentReports extend = new ExtentReports();
//		extend.attachReporter(reporter);
		if (browsername.equalsIgnoreCase("Chrome")) 
		{
			driver = invokeChromeBrowser();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			driver = invokeFirefoxbrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void launchApplication() throws IOException {
	invokeUrl();
	driver.get(prop.getProperty("url"));

	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
		// Thread.sleep(2000);
		login = new LoginPage(driver);
		login.enterUsername();
		login.enterPassword();
		login.clickSubmitButton();
		pg= new PinPage(driver);
		pg.enterPin(driver);
		pg.clickSubmitofPinPage();
	}

	@Test
	public void demo(){
	
		homepage = new HomePage(driver);
		homepage.selectRelianceStock();
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException
	{
	//	driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void cleargarbagecollection()
	{
		
		driver=null;
		System.gc();

	}
}
