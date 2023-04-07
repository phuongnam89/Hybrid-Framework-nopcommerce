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
		verifyEquals(destopsPage.getMessageByID(driver, "price-value-1"), "$1,450.00");
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.clickToButtonByID(driver, "add-to-cart-button-1");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		verifyEquals(destopsPage.getSuccessMessageByClass(driver, "content"), "The product has been added to your shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		destopsPage.clickToLinkByText(driver, "shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		//verifyEquals(destopsPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "cart", "Product(s)", "1"),"Build your own computer");

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		shoppingCartPage = PageGenerator.getShoppingCartPage(driver);
		verifyEquals(shoppingCartPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "cart", "Price", "1"),"$1,450.00");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");
		verifyTrue(shoppingCartPage.isProductNameDisplayed(driver));

	}
	@Test
	public void Order_03_Add_product_to_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order: Add produt to cart");
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		shoppingCartPage.clickToRemoveButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		verifyEquals(shoppingCartPage.getMessageByClass(driver, "no-data"),"Your Shopping Cart is empty!");
		
		
	}
	
	@Test
		public void Order_04_Updated_Shopping_Cart(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Wishlist: Add Product to Cart From Wishlist Page");
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		shoppingCartPage.clickToLogoNopcommerce(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		homePage.clickToLinkByText(driver, "Apple MacBook Pro 13-inch");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");	
		notebooksPage = PageGenerator.getNotebooksPage(driver);
		verifyEquals(notebooksPage.getMessageByID(driver, "price-value-4"), "$1,800.00");
		
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist: - Step 1: Open Wishlist Page");
		notebooksPage.clickToButtonByID(driver, "add-to-cart-button-4");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		verifyEquals(notebooksPage.getSuccessMessageByClass(driver, "content"), "The product has been added to your shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		notebooksPage.clickToLinkByText(driver, "shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		shoppingCartPage = PageGenerator.getShoppingCartPage(driver);
		verifyEquals(shoppingCartPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "cart", "Price", "1"),"$1,800.00");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		verifyEquals(shoppingCartPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "cart", "Total", "1"),"$3,600.00");

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		shoppingCartPage.inputToQuantityTextbox(driver,"5");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		shoppingCartPage.clickToButtonByID(driver, "updatecart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		verifyEquals(shoppingCartPage.getElementAttributeValueByClass(driver, "qty-input", "value"),"5");
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click To Apple MacBook Pro 13-inch Link");	
		//verifyEquals(shoppingCartPage.getValueDisplayedInTableClassAtColumnNameAndRowIndex(driver, "cart", "Total", "1"),"$9,000.00");
		
		
	
	}
		
		
		public void Order_05_Checkout_Order(Method method) {	
		ExtentTestManager.startTest(method.getName(), "Order: Checkout order");
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Select Yes from dropdown Gift wrapping ");	
		shoppingCartPage.selectDefaultDropdownByID(driver, newEmail, email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Check to checkbox I Agree ");	
		shoppingCartPage.checkToCheckboxByID(driver, email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click to checkout button ");	
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Company textbox");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Select Vietnam from dropdown Country");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to City textbox");	
	
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Address 1 textbox");	
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Address 2 textbox");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Zip/postal code textbox");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Phone number textbox");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: input to Fax number textbox");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click to Continue button ");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Check to Shipping by land transport Radio ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Check to The one day air shipping  Radio ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Check to The two day air shipping  Radio ");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Click to Continue button ");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Check to Check / Money Order Radio ");	

		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Verify all information at Billing Address form ");	
		
		ExtentTestManager.getTest().log(Status.INFO, "Order: - Step 1: Verify all information at Shipping Address form ");
		
		


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