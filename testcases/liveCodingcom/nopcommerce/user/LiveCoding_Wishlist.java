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
	
		@Test
		public void Wishlist_03_Add_product_To_Compare(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		wishlistPage.clickToLogoNopcommerce(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToButtonByProductNameAndButtonName(driver, "Apple MacBook Pro 13-inch", "Add to compare list");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		homePage.clickToButtonByProductNameAndButtonName(driver, "$25 Virtual Gift Card", "Add to compare list");
	
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		verifyEquals(homePage.getSuccessMessageByClass(driver,"content"),"The product has been added to your product comparison");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		homePage.clickToLinkByText(driver, "product comparison");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		compareProductsPage = PageGenerator.getCompareProductsPage(driver);
		verifyEquals(compareProductsPage.isValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "2","3"),"$25 Virtual Gift Card");
		verifyEquals(compareProductsPage.isValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "2","4"),"$25.00");
		//verifyEquals(compareProductsPage.isValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "3","3"),"Apple MacBook Pro 13-inch");
		//verifyEquals(compareProductsPage.isValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "3","4"),"$1,800.00");

		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		compareProductsPage.clickToLinkByText(driver, "Clear list");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		verifyEquals(compareProductsPage.getMessageByClass(driver, "no-data"),"You have no items to compare.");
				
		}
		@Test
		public void Wishlist_04_Recently_viewed_products(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		compareProductsPage.clickToLogoNopcommerce(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver, "Computers ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		computerPage = PageGenerator.getComputersPage(driver);
		computerPage.clickToLinkByText(driver, " Notebooks ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage = PageGenerator.getNotebooksPage(driver);
		notebooksPage.clickToProductTitleLink(driver, "Apple MacBook Pro 13-inch");
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToProductTitleLink(driver, "Asus N551JK-XO076H Laptop");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToProductTitleLink(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToProductTitleLink(driver, "HP Spectre XT Pro UltraBook");

		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToProductTitleLink(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToProductTitleLink(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.backtoPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage.clickToLinkByText(driver, "Recently viewed products");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		recentlyViewedProductsPage = PageGenerator.getRecentlyViewedProductsPage(driver);
		verifyTrue(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"Samsung Series 9 NP900X4C Premium Ultrabook"));
		verifyTrue(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"Lenovo Thinkpad X1 Carbon Laptop"));
		verifyTrue(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"HP Spectre XT Pro UltraBook"));
//		verifyFalse(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"Apple MacBook Pro 13-inch"));
//		verifyFalse(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"Asus N551JK-XO076H Laptop"));
//		verifyFalse(recentlyViewedProductsPage.isProductsTittleLinkDisplayedByText(driver,"HP Envy 6-1180ca 15.6-Inch Sleekbook"));

		
		
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
	private String email,newEmail,password,newPassword;
}