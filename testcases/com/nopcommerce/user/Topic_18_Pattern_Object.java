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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.CustomerInfoPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.PageGeneratorManager;
import PageObjects.RegisterPageObject;
import commons.BasePage;
import commons.BaseTest;

public class Topic_18_Pattern_Object extends BaseTest {
	private WebDriver driver;
	
	String osName = System.getProperty("os.name");
	
	private String emailAddress; 
	private String firstName; 
	private String lastName; 
	private String password;
	private String day;
	private String month;
	private String year;

	
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	HomePageObject homePage ;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInFoPage;
	
	@Parameters({"browser"})
	@BeforeClass
		
		public void beforeClass(String browserName) {
			driver = getBrowserDriver(browserName);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
		day = "2";
		month = "May";
		year = "1989";
	}
		
	@Test
		public void Login_01_Register() {
		driver.get("https://demo.nopcommerce.com/");
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.checkToRadioByLabel(driver,"Male");
		registerPage.checkToRadioByLabel(driver,"Female");

		//5 dòng bên dưới chỉ thay bằng 1 hàm locator
		
		//registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToTextboxByID(driver,"FirstName",firstName);

		//registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToTextboxByID(driver,"LastName",lastName);
		
		registerPage.selectDropDownByName(driver, "DateOfBirthDay", day);
		registerPage.selectDropDownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectDropDownByName(driver, "DateOfBirthYear", year);

		//registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToTextboxByID(driver,"Email",emailAddress);

		registerPage.checkToCheckboxByLabel(driver, "Newsletter");
		//registerPage.inputToPasswordTextBox(password);
		registerPage.inputToTextboxByID(driver,"Password",password);

		//registerPage.inputToConfirmPasswordTextBox(password);	
		registerPage.inputToTextboxByID(driver,"ConfirmPassword",password);
		
		
		//Thay bấm vào nút bằng 1 locator
		//registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver,"Register");
		verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		}
	
	@Test
	public void Login_02_Login_Success() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToLoginLink();
		
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
//		loginPage.inputToEmailTextBox(emailAddress);
//		loginPage.inputToPasswordTextBox(password);
		
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		//loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Log in");
		
		//Chuyen tu trang Login ve HomePage
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountdisplayed());
	}
	@Test
	public void Login_03_My_Account() {
		homePage.clickToMyAccount();
		customerInFoPage = homePage.openCustomerInfoPage(driver);
		
		
		Assert.assertEquals(customerInFoPage.getTextboxValueByID(driver, "FirstName"),firstName);
		
		Assert.assertEquals(customerInFoPage.getTextboxValueByID(driver, "LastName"),lastName);
		
		Assert.assertEquals(customerInFoPage.getTextboxValueByID(driver, "Email"),emailAddress);


	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	cleanBrowserDriver();
	
	}
	
}