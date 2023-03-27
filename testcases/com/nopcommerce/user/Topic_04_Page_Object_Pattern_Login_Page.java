package com.nopcommerce.user;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
import commons.BasePage;

public class Topic_04_Page_Object_Pattern_Login_Page extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	private String emailAddress; 
	private String firstName; 
	private String lastName; 
	private String password;
	private String wrongEmail;
	
	
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	HomePageObject homePage ;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	

	@BeforeClass
		public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Khởi tạo đúng thời điểm
		//Khởi tạo bên trên thì driver chưa được New
		//sẽ bị lỗi Null Pointer
		homePage = new HomePageObject(driver);
		
		
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 10);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		 emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
		 firstName = "Thao";
		 lastName = "Le";
		 password = "12345678";
		wrongEmail = "nam@123@.net";
		driver.get("https://demo.nopcommerce.com/");
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
		}

	@Test
	public void Login_02_invalid_email() {
		homePage.clickToLoginLink();
		
		//Chuyen trang thi phai khoi tao
		//Tu trang Home - Click Login link - Qua trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(wrongEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
		}

	@Test
	public void Login_03_Not_Existing_Email() {
		homePage.clickToLoginLink();
		
		//Chuyen trang thi phai khoi tao
		//Tu trang Home - Click Login link - Qua trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox("namtp@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getExisErrorMessageAtEmailTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		}
	
	@Test
	public void Login_04_No_Password() {
		homePage.clickToLoginLink();
		
		//Chuyen trang thi phai khoi tao
		//Tu trang Home - Click Login link - Qua trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		}
	
	@Test
	public void Login_05_Wrong_Password() {
		homePage.clickToLoginLink();
		
		//Chuyen trang thi phai khoi tao
		//Tu trang Home - Click Login link - Qua trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox("1");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		}
	
	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		
		//Chuyen trang thi phai khoi tao
		//Tu trang Home - Click Login link - Qua trang Login
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		
		//Chuyen tu trang Login ve HomePage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountdisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int generalFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}