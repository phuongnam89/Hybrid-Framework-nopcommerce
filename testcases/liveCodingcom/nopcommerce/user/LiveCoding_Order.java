package liveCodingcom.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjectsNewTest.CompareProductsPO;
import PageObjectsNewTest.ComputersPO;
import PageObjectsNewTest.DestopsPO;
import PageObjectsNewTest.HomePO;
import PageObjectsNewTest.LoginPO;
import PageObjectsNewTest.MyAccountPO;
import PageObjectsNewTest.NotebooksPO;
import PageObjectsNewTest.PageGenerator;
import PageObjectsNewTest.RecentlyViewedProductsPO;
import PageObjectsNewTest.RegisterPO;
import PageObjectsNewTest.ShoppingCartPO;
import PageObjectsNewTest.WishlistPO;
import PageUisNewTest.NotebooksPageUI;
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_Order extends BaseTest{
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	

	public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		email = "namphuong"+generalFakeNumber()+"@gmail.com";
		newEmail ="phuongnam"+generalFakeNumber()+"@gmail.com";
		password = "12345678";
		newPassword = "987654321";
		
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver,"Register");
		
		registerPage = PageGenerator.getRegisterPage(driver);
		registerPage.checkToRadioByID(driver,"gender-female");
		registerPage.enterToTextboxByID(driver,"FirstName","Nam");
		registerPage.enterToTextboxByID(driver,"LastName","Phuong");
		registerPage.enterToTextboxByID(driver,"Email",email);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "2", "DateOfBirthMonth", "May", "DateOfBirthYear", "1989");
		registerPage.enterToTextboxByID(driver,"Password",password);
		registerPage.enterToTextboxByID(driver,"ConfirmPassword",password);
		registerPage.clickToButtonByID(driver, "register-button");
		
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver,"Log in");
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToTextboxByID(driver, "Email", email);
		loginPage.enterToTextboxByID(driver, "Password", password);
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver, "Build your own computer");
	}
	@Test
		public void Order_01_Add_product_to_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order: Add produt to cart");
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage = PageGenerator.getDestopsPage(driver);
		destopsPage.selectDefaultDropdownByID(driver,"product_attribute_1","2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.selectDefaultDropdownByID(driver,"product_attribute_2","8GB [+$60.00]");

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToRadioByID(driver, "product_attribute_3_7");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToRadioByID(driver, "product_attribute_4_9");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToRadioByID(driver, "product_attribute_4_9");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToCheckboxByID(driver, "product_attribute_5_10");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToCheckboxByID(driver, "product_attribute_5_11");

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.checkToCheckboxByID(driver, "product_attribute_5_12");

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.clickToButtonByID(driver, "add-to-cart-button-1");

		
	}
	
	public void Wishlist_02_Add_product_To_Cart_From_Wishlist_Page(Method method) {
		
	}
	
	
		public void Wishlist_03_Add_product_To_Compare(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		
		
		}
		
		public void Wishlist_04_Recently_viewed_products(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		
			
		}
	@Parameters({"browser"})
	@AfterClass(alwaysRun= true)
		public void cleanBrowser(String browsername) {
		//cleanBrowserDriver();
	}
	HomePO homePage;
	RegisterPO registerPage;
	LoginPO loginPage;
	MyAccountPO myAccountPage;
	WishlistPO wishlistPage;
	ShoppingCartPO shoppingCartPage;
	CompareProductsPO compareProductsPage;
	ComputersPO computerPage;
	NotebooksPO notebooksPage;
	RecentlyViewedProductsPO recentlyViewedProductsPage;
	DestopsPO destopsPage;
	private String email,newEmail,password,newPassword;
}