//package com.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Topic_02_Apply_Base_Page_I	extends BasePage {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String osName = System.getProperty("os.name");
//	String emailAddress;
//	WebDriverWait explicitWait;
//	JavascriptExecutor jsExecutor;
//	Actions action;
//	
//	//Khai báo
//	//BasePage:Class
//	//basePage:Object
//	BasePage basePage;
//	
//
//	@BeforeClass
//		public void beforeClass() {
//		if (osName.contains("Mac OS")) {
//		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		
//		
//	} else {
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		
//	}
//		
//		
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		explicitWait = new WebDriverWait(driver, 10);
//		jsExecutor = (JavascriptExecutor) driver;
//		action = new Actions(driver);
//		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
//		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				
//		//Khởi tạo nó lên
//		//không new lên thì nó sẽ bị null
//		basePage = new BasePage();
//		
//		driver.get("https://demo.nopcommerce.com/");
//	}
//	@Test
//	public void TC_01_Empty_Data() {
//		//basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		
//		
//		//basePage.clickToElement(driver, "//a[@class='ico-register']");
//	
//		
//		//basePage.waitForElementClickable(driver, "//button[@name='register-button']");
//		//basePage.clickToElement(driver, "//button[@name='register-button']");
//		
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//		}
//
//	@Test
//	public void TC_02_Register_invalid_email() {
//		driver.get("https://demo.nopcommerce.com/");
//		
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//	
//		
//		basePage.sendkeyElement(driver,"//input[@id='FirstName']", "nam");
//		basePage.sendkeyElement(driver,"//input[@id='LastName']", "phuong");
//		basePage.sendkeyElement(driver,"//input[@id='Email']","nam@gmail@gmail.net");
//		basePage.sendkeyElement(driver,"//input[@id='Password']", "12345678");
//		basePage.sendkeyElement(driver,"//input[@id='ConfirmPassword']","12345678");
//		
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//		
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		driver.get("https://demo.nopcommerce.com/");
//		
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		
//		basePage.sendkeyElement(driver,"//input[@id='FirstName']", "nam");
//		basePage.sendkeyElement(driver,"//input[@id='LastName']", "phuong");
//		basePage.sendkeyElement(driver,"//input[@id='Email']",emailAddress);
//		basePage.sendkeyElement(driver,"//input[@id='Password']", "12345678");
//		basePage.sendkeyElement(driver,"//input[@id='ConfirmPassword']","12345678");
//		
//		
//		basePage.clickToElement(driver,"//button[@name='register-button']");
//		
//		
//		Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"), "Your registration completed");
//			
//
//		
//	}
//	@Test
//	public void TC_04_Register_Exiting_Email() {
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");
//		
//		
//		basePage.clickToElement(driver,"//a[@class='ico-register']");
//		
//		
//		basePage.sendkeyElement(driver,"//input[@id='FirstName']", "nam");
//		basePage.sendkeyElement(driver,"//input[@id='LastName']", "phuong");
//		basePage.sendkeyElement(driver,"//input[@id='Email']",emailAddress);
//		basePage.sendkeyElement(driver,"//input[@id='Password']", "12345678");
//		basePage.sendkeyElement(driver,"//input[@id='ConfirmPassword']","12345678");
//		
//		basePage.clickToElement(driver, "//button[@name='register-button']");
//		
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//li[text()='The specified email already exists']"), "The specified email already exists");
//				
//
//	}
//	@Test
//	public void TC_05_Password_Less_Than_6() {
//		
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		
//		basePage.sendkeyElement(driver, "//input[@id='Password']", "123");
//		basePage.sendkeyElement(driver, "//input[@id='ConfirmPassword']", "12345678");
//		
//		basePage.waitForElementVisible(driver, "//span[@id='Password-error']");
//		
//		Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//	}
//	@Test
//	public void TC_06_Password_not_the_same() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.sendkeyElement(driver, "//input[@id='Password']", "123");
//		basePage.sendkeyElement(driver, "//input[@id='ConfirmPassword']", "12345678");
//
//		basePage.waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	}
//	
//	
//	
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//	
//	public void sleepInSecond(long timeInSecond) {
//		try {
//			Thread.sleep(timeInSecond * 1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	public int generalFakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(99999);
//	}
//}