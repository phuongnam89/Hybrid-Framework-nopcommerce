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

import PageObjectsNewTest.HomePO;
import PageObjectsNewTest.LoginPO;
import PageObjectsNewTest.MyAccountPO;
import PageObjectsNewTest.PageGenerator;
import PageObjectsNewTest.RegisterPO;
import PageObjectsNewTest.ShoppingCartPO;
import PageObjectsNewTest.WishlistPO;
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_Wishlist extends BaseTest{
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

	}
	@Test
		public void Wishlist_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add To Wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		
		homePage.clickToLinkByText(driver, "Apple MacBook Pro 13-inch");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 2: Click To Add Apple MacBook Pro 13-inch To Wishlist");	
		wishlistPage = PageGenerator.getWishlistPage(driver);
		wishlistPage.clickToButtonByText(driver, "Add to wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 3: Verify Add To Wishlist Success Message");	
		verifyEquals(wishlistPage.getSuccessMessageByClass(driver, "content"),"The product has been added to your wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 3: Close Message");	
		wishlistPage.clickToCloseButtonAtMessage(driver);
	
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 4: Open Wishlist Page");	
		wishlistPage.clickToLinkBySpanText(driver, "Wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 5: Verify Add Apple MacBook Pro 13-inch To Wishlist Success");	
		verifyEquals(wishlistPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver,"cart","Product(s)","1"),"Apple MacBook Pro 13-inch");
		verifyEquals(wishlistPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver,"cart","Price","1"),"$1,800.00");
		verifyEquals(wishlistPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver,"cart","Total","1"),"$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 6: Open Your Wishlist Link");	
		wishlistPage.clickToYourWishlistShareLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 7: Verify Your Wishlist Displayed");	
		verifyTrue(wishlistPage.isWishlistDisplayed(driver));
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 8: Verify Your Wishlist Title");	
		verifyEquals(wishlistPage.getWishlistValue(driver), "Wishlist of Nam Phuong");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 8: Open Shopping Cart Page");	
		wishlistPage.clickToLinkByClass(driver, "ico-cart");

	}
	@Test
	public void Wishlist_02_Add_product_To_Cart_From_Wishlist_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");		
		wishlistPage.clickToLinkByClass(driver,"ico-wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 2: Click To Add To Cart Check Box");	
		wishlistPage.clickToAddToCartCheckBoxInTableClassAtColumnNameAndRowIndex(driver,"cart","Add to cart","1");

		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 3: Click To Add To Cart Button");
		wishlistPage.clickToButtonByText(driver, "Add to cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 4: Verify Apple MacBook Pro 13-inch add to Shopping Cart Success");
		shoppingCartPage = PageGenerator.getShoppingCartPage(driver);
		shoppingCartPage.isPageLoadedSuccess(driver);
		verifyEquals(shoppingCartPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver,"cart","Product(s)","1"),"Apple MacBook Pro 13-inch");

		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 5: Open Wishlist Page");
		shoppingCartPage.clickToLinkByClass(driver,"ico-wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 6: Verify Apple MacBook Pro 13-inch remove from Wishlist Success");
		wishlistPage = PageGenerator.getWishlistPage(driver);
		verifyEquals(wishlistPage.getMessageByClass(driver,"no-data"),"The wishlist is empty!");
		


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
	private String email,newEmail,password,newPassword;
}