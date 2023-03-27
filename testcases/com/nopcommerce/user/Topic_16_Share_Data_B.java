package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.PageGeneratorManager;
import PageObjects.CustomerInfoPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.SearchPageObject;
import commons.BaseTest;

public class Topic_16_Share_Data_B extends BaseTest {
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

public static String validEmailAddress; 
public static String password;
private String firstName;
private String lastName;

@Parameters("browser")
@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	
	
	homePage = PageGeneratorManager.getHomePage(driver);
	driver.manage().window().maximize();
	explicitWait = new WebDriverWait(driver, 30);
	jsExecutor = (JavascriptExecutor) driver;
	action = new Actions(driver);
	
	
	//Case này dùng riêng
	//Tự tạo account riêng, ko dùng chung như ở Case A
	//Nó tính là Pre-Condition
	
	firstName = "Thao";
	lastName = "Le";
	password = "12345678";
	validEmailAddress = "afc" + generalFakeNumber() + "@gmail.net";
	
	homePage.clickToRegisterLink();
	registerPage = new RegisterPageObject(driver);
	
	registerPage.inputToFirstNameTextBox(firstName);
	registerPage.inputToLastNameTextBox(lastName);
	registerPage.inputToEmailAddressTextBox(validEmailAddress);
	registerPage.inputToPasswordTextBox(password);
	registerPage.inputToConfirmPasswordTextBox(password);
	registerPage.clickToRegisterButton();
	
	
	homePage.clickToLoginLink();
	loginPage = PageGeneratorManager.getLoginPage(driver);
	loginPage.inputToEmailTextBox(validEmailAddress);
	loginPage.inputToPasswordTextBox(password);
	loginPage.clickToLoginButton();
}
//@Test
	public void Search_01_Empty_Data() {
		
	}
	
//@Test
	public void Search_02_Empty_Not_Exist() {
		
	
	
}
//@Test
	public void Search_03_Search_with_Product_Name() {
		
		
		
		}
//@Test
	public void Search_04_Search_with_Product_Name_2() {
	}

//@Test
	public void Search_05_Advance_Search_With_Parent_Categories() {
		
	}
//@Test
	public void Search_06_Advance_Search_With_Sub_Categories() {
		
	}
	@Test
	public void Search_07_Advance_Search_With_Incorrect_Manufacturer() {
		
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
