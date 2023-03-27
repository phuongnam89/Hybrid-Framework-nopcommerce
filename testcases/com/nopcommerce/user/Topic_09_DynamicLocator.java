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

import PageObjects.AddressPageObject;
import PageObjects.CustomerInfoPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.MyProductReviewsPageObject;
import PageObjects.PageGeneratorManager;
import PageObjects.CustomerInfoPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.RewardPointsPageObject;
import commons.BasePage;
import commons.BaseTest;

public class Topic_09_DynamicLocator extends BaseTest {
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
	AddressPageObject addressPage;
	CustomerInfoPageObject customerInfoPage;
	MyProductReviewsPageObject myProductReviewPage;
	RewardPointsPageObject rewardPointPage;
	
	@Parameters("browser")
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
		
		registerPage = homePage.clickToRegisterLink(driver);
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailAddressTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		
		
		}
	
	@Test
	public void Dynamic_page() {
		//Register>>customer info
		customerInfoPage = registerPage.openCustomerInfoPage(driver);
		
		//Customer Info>>>Address
		addressPage = customerInfoPage.openAddressPage(driver);
		
		
		//AddressPage >>>My product review
		myProductReviewPage = addressPage.openMyProductReviewsPage(driver);
		
		//My product review >>>reward point
		rewardPointPage = myProductReviewPage.openRewardPointsPage(driver);
		
		//reward point >>>Address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		//address>>>reward point
		rewardPointPage = addressPage.openRewardPointsPage(driver);
		
		//reward point>>> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewsPage(driver);
		
		//my product review >>> address
		addressPage = myProductReviewPage.openAddressPage(driver);
		
		
		}

	@Test
	public void Dynamic_page_01() {
				
				//AddressPage >>>My product review
				myProductReviewPage = (MyProductReviewsPageObject) addressPage.openPageAtMyAccountByName(driver, "My product reviews");
				
				//My product review >>>reward point
				rewardPointPage = (RewardPointsPageObject) myProductReviewPage.openPageAtMyAccountByName(driver,"Reward point");
				
				//reward point >>>Address
				addressPage = (AddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
				
				//address>>>reward point
				rewardPointPage = (RewardPointsPageObject) addressPage.openPageAtMyAccountByName(driver,"Reward point");
				
				//reward point>>> My product review
				myProductReviewPage = (MyProductReviewsPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");
				
				//my product review >>> address
				addressPage = (AddressPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Addresses");
		
				//Address>>Customer info
				customerInfoPage = (CustomerInfoPageObject) addressPage.openPageAtMyAccountByName(driver, "Customer info");
		
	}
	public void Dynamic_page_02() {
		//Cach nay su dung khi co it page
		//Van che dau viec khoi tao page
		//customer info>>addresses
		customerInfoPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressesPage(driver);
		
		//Address>>>Customer Info
		addressPage.openPageAtMyAccountByPageName(driver,"Customer Info");
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);		
		}

	
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
		
		loginPage = homePage.clickToLoginLink(driver);
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextBox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
		homePage = loginPage.clickToHomePageLink();
		homePage.clickToLoginLink();
		
		loginPage = homePage.getLoginPage();
		loginPage.inputToEmailTextBox(newEmailAddress);
		loginPage.inputToPasswordTextBox(newPassword);
		loginPage.clickToLoginButton();
		
		homePage = loginPage.clickToHomePageLink();
		Assert.assertTrue(homePage.isMyAccountdisplayed());
		
		
}
	
	

	public void My_Account_04_My_Product_Review() {
		
		
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