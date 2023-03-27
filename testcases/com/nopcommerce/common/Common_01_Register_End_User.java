package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageObjects.CustomerInfoPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.SearchPageObject;
import commons.BaseTest;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	HomePageObject homePage ;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject myAccountPage;
	SearchPageObject searchPage;

	public static String emailAddress; 
	private String firstName; 
	private String lastName; 
	public static String password;



	@Parameters("browser")
	@BeforeClass
		public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		
		homePage = new HomePageObject(driver);
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		firstName = "Thao";
		 lastName = "Le";
		 password = "12345678";
		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
			

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		searchPage = new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		
	}
	public int generalFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
