package Pojo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	public Properties prop;

	public void invokeUrl() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Zerodha\\src\\test\\resources\\dependencies.properties");
		prop.load(fis);
		
	}
	public static WebDriver invokeChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browsers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		return driver;
	}
	
	public static WebDriver invokeFirefoxbrowser()
	{
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\browsers\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		return driver;
	}

}
