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

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.CustomerInfoPageObject;
import PageObjects.RegisterPageObject;
import commons.BasePage;
import commons.BaseTest;

public class Topic_06_Page_Factory extends BaseTest {
	private WebDriver driver;
	
	String osName = System.getProperty("os.name");
	
	private String emailAddress; 
	private String firstName; 
	private String lastName; 
	private String password;
	
	private String newPassword;
	
	private String newFirstName;
	private String newLastName;
	private String newEmailAddress;
	private String companyName;
	private String reviewTitle;
	private String reviewerText;
	
	
	private String city;
	private String address1;
	private String address2;
	private String zipCode;
	private String phoneNumber;
	private String faxNumber;
	private String dropdownCity;

	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	Actions action;
	HomePageObject homePage ;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject myAccountPage;
	
	
	@Parameters("browser")
	@BeforeClass
		public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = new HomePageObject(driver);
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
		
		 firstName = "Thao";
		 lastName = "Le";
		 password = "12345678";
		 newPassword = "87654321";
		newFirstName = "Automation";
		newLastName = "FC";
		newEmailAddress = "BG" + generalFakeNumber() + "@gmail.net";
		companyName = "BoardGameFC";
		
		
		city = "Da Nang";
		address1 = "123 le lai";
		address2 = "234 da nang";
		zipCode = "550000";
		phoneNumber ="0948416789";
		faxNumber = "09484156789";
		dropdownCity = "Viet Nam";
		reviewTitle = "Dell100";
		reviewerText = "Good";	
		
		
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		
		
		}
	
	@Test
	public void My_Account_01_Custom_Info() {
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccount();
		
		
		myAccountPage = new CustomerInfoPageObject(driver);
		myAccountPage.checkToFemaleRadioButton();
		
		myAccountPage.inputToFirstNameTextbox(newFirstName);
		myAccountPage.inputToLastNameTextbox(newLastName);
		myAccountPage.inputToEmailAddressTextbox(newEmailAddress);
		myAccountPage.inputToCompanyTextbox(companyName);
		
		myAccountPage.clickToSaveButton();
		
		Assert.assertEquals(myAccountPage.getNewFirstnameChanged("value"), newFirstName);
		Assert.assertEquals(myAccountPage.getNewLastnameChanged("value"),newLastName);
		Assert.assertEquals(myAccountPage.getnewEmailAddressChanged("value"), newEmailAddress);
		Assert.assertEquals(myAccountPage.getNewCompanyNameChanged("value"), companyName);

		
		
		
		
		
		}

	@Test
	public void My_Account_02_Address() {
		myAccountPage = new CustomerInfoPageObject(driver);
		myAccountPage.clickToAddressesButton();
		myAccountPage.clickToAddNewButton();
		
		myAccountPage.inputToAddressFirstNameTextbox(newFirstName);
		myAccountPage.inputToAddressLastNameTextbox(newLastName);
		myAccountPage.inputToAddressEmailAddressTextbox(newEmailAddress);
		myAccountPage.inputToAddressCompanyNameTextbox(companyName);
		myAccountPage.selectToCityDropdown(dropdownCity);
		myAccountPage.inputCityNameTextBox(city);
		myAccountPage.inputZipCode(zipCode);
		myAccountPage.inputToAddress1Textbox(address1);
		myAccountPage.inputToAddress2Textbox(address2);
		myAccountPage.inputToPhoneNumberTextbox(phoneNumber);
		myAccountPage.inputToFaxNumberTextbox(faxNumber);
		
		myAccountPage.clickToSaveNewAddressButton();
		
		Assert.assertEquals(myAccountPage.newAddressNameAdded(), newFirstName + " " + newLastName);
		
		Assert.assertEquals(myAccountPage.newAddressEmailAddressAdded(),"Email: " + newEmailAddress);
		Assert.assertEquals(myAccountPage.newAddressCompanyAdded(), companyName);
		Assert.assertEquals(myAccountPage.newAddressCityAndStateAdded(), city+", " + zipCode);
		
		Assert.assertEquals(myAccountPage.newAddress1Added(), address1);
		Assert.assertEquals(myAccountPage.newAddress2Added(), address2);
		Assert.assertEquals(myAccountPage.newAddressPhoneNumberAdded(),"Phone number: "+ phoneNumber);
		Assert.assertEquals(myAccountPage.newAddressFaxNumberAdded(),"Fax number: "+ faxNumber);
		
		
		

		
		

		
		
		
		
		
		}

	@Test
	public void My_Account_03_Change_Password() {
myAccountPage.clickToChangePasswordButton();
		
		myAccountPage.inputToOldPasswordTextbox(password);
		myAccountPage.inputToNewPasswordTextbox(newPassword);
		myAccountPage.inputToConfirmedPasswordTextbox(newPassword);
		myAccountPage.clickToChangeNewPasswordButton();
		
		Assert.assertEquals(myAccountPage.getPasswordChangedMessage(), "Password was changed");
		
		myAccountPage.clickToCloseMessage();
		sleepInSecond(2);
		
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(newEmailAddress);
		loginPage.inputToPasswordTextBox(newPassword);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountdisplayed());
		
		
}
	
	
	@Test
	public void My_Account_04_My_Product_Review() {
		homePage.clickToBuildYourComPuterLink();
		
		myAccountPage = new CustomerInfoPageObject(driver);
		myAccountPage.clickToAddYourReviewLink();
		myAccountPage.inputToReviewerTitleTextbox(reviewTitle);
		myAccountPage.inputToReviewerTextTextbox(reviewerText);
		myAccountPage.clickToRateFiveStarButton();
		myAccountPage.clickToSubmitReviewButton();
		
		Assert.assertEquals(myAccountPage.getSuccessReviewMessage(), "Product review is successfully added.");
		Assert.assertEquals(myAccountPage.getSuccessReviewTitle(), reviewTitle);
		Assert.assertEquals(myAccountPage.getSuccessReviewText(), reviewerText);
		
		}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
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