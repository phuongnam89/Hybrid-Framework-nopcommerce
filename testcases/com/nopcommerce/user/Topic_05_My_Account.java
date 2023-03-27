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

public class Topic_05_My_Account extends BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
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
	CustomerInfoPageObject CustomerInfoPage;
	
	
	@Parameters({"browser" , "url"})
	@BeforeClass
		public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Khởi tạo đúng thời điểm
		//Khởi tạo bên trên thì driver chưa được New
		//sẽ bị lỗi Null Pointer
		homePage = new HomePageObject(driver);
		
		
		driver.manage().window().maximize();
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
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
		
		driver.get("https://demo.nopcommerce.com/");
		
		//registerPage= homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		
		
		}
	
	@Test
	public void My_Account_01_Custom_Info() {
		CustomerInfoPage = registerPage.openCustomerInfoPage(driver);
		
		CustomerInfoPage.checkToFemaleRadioButton();
		
		CustomerInfoPage.inputToFirstNameTextbox(newFirstName);
		CustomerInfoPage.inputToLastNameTextbox(newLastName);
		CustomerInfoPage.inputToEmailAddressTextbox(newEmailAddress);
		CustomerInfoPage.inputToCompanyTextbox(companyName);
		
		CustomerInfoPage.clickToSaveButton();
		
		Assert.assertEquals(CustomerInfoPage.getNewFirstnameChanged("value"), newFirstName);
		Assert.assertEquals(CustomerInfoPage.getNewLastnameChanged("value"),newLastName);
		Assert.assertEquals(CustomerInfoPage.getnewEmailAddressChanged("value"), newEmailAddress);
		Assert.assertEquals(CustomerInfoPage.getNewCompanyNameChanged("value"), companyName);

		
		
		
		
		
		}

	@Test
	public void My_Account_02_Address() {
		//myAccountPage = new MyAccountObject(driver);
		CustomerInfoPage.clickToAddressesButton();
		CustomerInfoPage.clickToAddNewButton();
		
		CustomerInfoPage.inputToAddressFirstNameTextbox(newFirstName);
		CustomerInfoPage.inputToAddressLastNameTextbox(newLastName);
		CustomerInfoPage.inputToAddressEmailAddressTextbox(newEmailAddress);
		CustomerInfoPage.inputToAddressCompanyNameTextbox(companyName);
		CustomerInfoPage.selectToCityDropdown(dropdownCity);
		CustomerInfoPage.inputCityNameTextBox(city);
		CustomerInfoPage.inputZipCode(zipCode);
		CustomerInfoPage.inputToAddress1Textbox(address1);
		CustomerInfoPage.inputToAddress2Textbox(address2);
		CustomerInfoPage.inputToPhoneNumberTextbox(phoneNumber);
		CustomerInfoPage.inputToFaxNumberTextbox(faxNumber);
		
		CustomerInfoPage.clickToSaveNewAddressButton();
		
		Assert.assertEquals(CustomerInfoPage.newAddressNameAdded(), newFirstName + " " + newLastName);
		
		Assert.assertEquals(CustomerInfoPage.newAddressEmailAddressAdded(),"Email: " + newEmailAddress);
		Assert.assertEquals(CustomerInfoPage.newAddressCompanyAdded(), companyName);
		Assert.assertEquals(CustomerInfoPage.newAddressCityAndStateAdded(), city+", " + zipCode);
		
		Assert.assertEquals(CustomerInfoPage.newAddress1Added(), address1);
		Assert.assertEquals(CustomerInfoPage.newAddress2Added(), address2);
		Assert.assertEquals(CustomerInfoPage.newAddressPhoneNumberAdded(),"Phone number: "+ phoneNumber);
		Assert.assertEquals(CustomerInfoPage.newAddressFaxNumberAdded(),"Fax number: "+ faxNumber);
		
		
		

		
		

		
		
		
		
		
		}

	@Test
	public void My_Account_03_Change_Password() {
		CustomerInfoPage.clickToChangePasswordButton();
		
		CustomerInfoPage.inputToOldPasswordTextbox(password);
		CustomerInfoPage.inputToNewPasswordTextbox(newPassword);
		CustomerInfoPage.inputToConfirmedPasswordTextbox(newPassword);
		CustomerInfoPage.clickToChangeNewPasswordButton();
		
		Assert.assertEquals(CustomerInfoPage.getPasswordChangedMessage(), "Password was changed");
		
		CustomerInfoPage.clickToCloseMessage();
		sleepInSecond(3);
		
		homePage = CustomerInfoPage.clickToLogoutLink();
		//registerPage.clickToLogoutLink();
		
		//homePage = registerPage.clickToLogoutLink();
		//homePage.clickToLoginLink();
		
		//loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
		homePage = loginPage.clickToHomePageLink();
		homePage.clickToLoginLink();
		
		//loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(newEmailAddress);
		loginPage.inputToPasswordTextBox(newPassword);
		loginPage.clickToLoginButton();
		
		homePage = loginPage.clickToHomePageLink();
		Assert.assertTrue(homePage.isMyAccountdisplayed());
		
		
}
	
	
	@Test
	public void My_Account_04_My_Product_Review() {
		
		//CustomerInfoPage = homePage.clickToBuildYourComPuterLink();
		sleepInSecond(2);
		CustomerInfoPage.clickToAddYourReviewLink();
		CustomerInfoPage.inputToReviewerTitleTextbox(reviewTitle);
		CustomerInfoPage.inputToReviewerTextTextbox(reviewerText);
		CustomerInfoPage.clickToRateFiveStarButton();
		CustomerInfoPage.clickToSubmitReviewButton();
		
		Assert.assertEquals(CustomerInfoPage.getSuccessReviewMessage(), "Product review is successfully added.");
		Assert.assertEquals(CustomerInfoPage.getSuccessReviewTitle(), reviewTitle);
		Assert.assertEquals(CustomerInfoPage.getSuccessReviewText(), reviewerText);
		
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