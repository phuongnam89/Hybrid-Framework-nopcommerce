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

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.CustomerInfoPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.SearchPageObject;
import commons.BaseTest;

public class Topic_07_Search extends BaseTest {
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

private String emailAddress; 
private String firstName; 
private String lastName; 
private String password;
private String newFirstName;
private String newLastName;

private String searchKeyworldMacbook;
private String searchkeyworldLenovo;
private String searchKeyworldThinkpad;
private String searchKeywordMacbookPro;


@Parameters("browser")
@BeforeClass
	public void beforeClass(String browserName) {
	driver = getBrowserDriver(browserName);
	searchPage = new SearchPageObject(driver);
	
	homePage = new HomePageObject(driver);
	driver.manage().window().maximize();
	explicitWait = new WebDriverWait(driver, 30);
	jsExecutor = (JavascriptExecutor) driver;
	action = new Actions(driver);
	
	firstName = "Thao";
	 lastName = "Le";
	 password = "12345678";
	 newFirstName = "Automation";
		newLastName = "FC";
		emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
		
	
	 searchKeyworldMacbook = "MacBook Pro 2050";
	 searchkeyworldLenovo = "Lenovo";
	 searchKeyworldThinkpad = "Thinkpad X1 Carbon";
	 searchKeywordMacbookPro = "Apple Macbook Pro";

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
//@Test
	public void Search_01_Empty_Data() {
	searchPage = new SearchPageObject(driver);
	searchPage.clickToSearchButtonLink();
	searchPage.clickToSearchButton();
	Assert.assertEquals(searchPage.getEmptyDataMessage(),"Search term minimum length is 3 characters");
	}
	
//@Test
	public void Search_02_Empty_Not_Exist() {
		searchPage = new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchKeyworldMacbook);
		searchPage.clickToSearchButton();
	
	Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	
}
//@Test
	public void Search_03_Search_with_Product_Name() {
		searchPage = new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchkeyworldLenovo);
		searchPage.clickToSearchButton();
		//Assert.assertEquals(searchPage.getSearchLenovoMessage(),"");
		
		
		}
//@Test
	public void Search_04_Search_with_Product_Name_2() {
		searchPage = new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchKeyworldThinkpad);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageThinkpadProduct(),"Lenovo Thinkpad X1 Carbon Laptop");
		}

//@Test
	public void Search_05_Advance_Search_With_Parent_Categories() {
		searchPage = new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchKeywordMacbookPro);
		
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		sleepInSecond(1);
		//searchPage.uncheckToAutomaticSearchCheckbox();
		searchPage.clickToSearchButton();
		
		Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
		
	}
//@Test
	public void Search_06_Advance_Search_With_Sub_Categories() {
		searchPage =  new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchKeywordMacbookPro);
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticSearchCheckbox();
		
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getMessageMacbookPro(), "Apple MacBook Pro 13-inch");
		
	}
	@Test
	public void Search_07_Advance_Search_With_Incorrect_Manufacturer() {
		searchPage =  new SearchPageObject(driver);
		searchPage.clickToSearchButtonLink();
		searchPage.inputToSearchBox(searchKeywordMacbookPro);
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.checkToAutomaticSearchCheckbox();
		searchPage.selectManufacturerDropdown("HP");
		
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
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
