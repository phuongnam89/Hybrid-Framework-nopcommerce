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
import PageObjects.RegisterPageObject;
import commons.BasePage;

public class Topic_03_Page_Object_Pattern extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	private String emailAddress; 
	private String firstName; 
	private String lastName; 
	private String password;
	
	
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	HomePageObject homePage ;
	RegisterPageObject registerPage;
	
	

	@BeforeClass
		public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Khởi tạo đúng thời điểm
		//Khởi tạo bên trên thì driver chưa được New
		//sẽ bị lỗi Null Pointer
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
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
		
		
		driver.get("https://demo.nopcommerce.com/");
	}
	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register 01 Page Step 2: Click to Register Button");

		registerPage.clickToRegisterButton();
		
		System.out.println("Register 01 Page Step 3: Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");

		
	
		}

	@Test
	public void Register_02_invalid_email() {
		
		
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
	
		System.out.println("Register 02 Page Step 2: Input to text box");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox("123@231@.net");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		System.out.println("Register 02 Page Step 3: Click to Register Button");

		registerPage.clickToRegisterButton();
	
		System.out.println("Register 02 Page Step 4: Verify error message displayed");
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
		
	}

	@Test
	public void Register_03_Success() {
		
		
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register 03 Page Step 2: Input to text box");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		System.out.println("Register 03 Page Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		
		System.out.println("Register 03 Page Step 4: Verify success message displayed");

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register 03 Page Step 5: Click to Logout Link");
		registerPage.clickToLogoutLink();
		
	}
	@Test
	public void Register_04_Exiting_Email() {
		
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
		
		System.out.println("Register 04 Page Step 2: Input to text box");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		
		System.out.println("Register 04 Page Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 04 Page Step 4: Verify error existing email message displayed");

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
		
		
		
		
				

	}
	@Test
	public void Register_05_Password_Less_Than_6() {
		
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register 05 Page Step 2: Input to text box");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("123");
		registerPage.inputToConfirmPasswordTextBox("123");
		
		System.out.println("Register 05 Page Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 05 Page Step 4: Verify error password message less than 6");
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}
	@Test
	public void Register_06_Password_not_the_same() {
		System.out.println("Home Page Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register 06 Page Step 2: Input to text box");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox("123456543231221");
		
		System.out.println("Register 06 Page Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 06 Page Step 4: Verify error password message less than 6");

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");

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