package com.mystore.base;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;	
	// Declare ThreadLocal Driver
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		
	@BeforeSuite
	public static void BeforeSuit() {
		String log4JFilePath = "D:\\Automation\\abc\\MyStoreProject\\Log4j.xml";		
		LoggerContext loggerContext = (LoggerContext)LogManager.getContext(false);
		File file = new File(log4JFilePath);
		loggerContext.setConfigLocation(file.toURI());
	}
	

	@BeforeTest
	public static void loadConfig() {
		try {
			prop = new Properties();
			System.out.println("Super Constructor Invoked");
			FileInputStream ip = new FileInputStream("D:\\Automation\\abc\\MyStoreProject\\Configuration\\config.properties");
			prop.load(ip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void launchApp()throws InterruptedException {
		
		loadConfig();
		String browserName =  prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{				
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//PageLoad TimeOuts
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launching the URL
		driver.get(prop.getProperty("url"));	
					
		Action.implicitWait(driver, 10000);
		//Action.pageLoadTimeOut(driver, 10000);
		driver.manage().window().maximize();	
		Thread.sleep(1000000);
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(3000);
		//WebElement frame = driver.findElement(By.xpath("//iframe"));
		//driver.switchTo().frame(frame);
		
		//Alert alt = driver.switchTo().alert();
		//driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']")).sendKeys("9689902460");
		driver.findElement(By.cssSelector("input[placeholder='Enter email/mobile']")).sendKeys("9689902460");
		driver.findElement(By.cssSelector("input[placeholder='Enter password']")).sendKeys("1234");
		driver.findElement(By.cssSelector("input[value='Login'][class='submit-btn login-btn btn']")).click();

		
	}

}
