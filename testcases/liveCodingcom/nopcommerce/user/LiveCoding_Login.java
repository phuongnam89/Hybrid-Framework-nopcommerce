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
import PageObjectsNewTest.PageGenerator;
import PageObjectsNewTest.RegisterPO;
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_Login extends BaseTest{
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	

	public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		email = "namphuong"+generalFakeNumber()+"@gmail.com";
		unRegisterEmail ="phuongnam"+generalFakeNumber()+"@gmail.com";
		password = "12345678";
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver,"Register");
		
		registerPage = PageGenerator.getRegisterPage(driver);
		registerPage.checkToRadioByID(driver,"gender-female");
		registerPage.enterToTextboxByID(driver,"FirstName","Nam");
		registerPage.enterToTextboxByID(driver,"LastName","Phuong");
		registerPage.enterToTextboxByID(driver,"Email",email);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "2", "DateOfBirthMonth", "May", "DateOfBirthYear", "1989");
		registerPage.enterToTextboxByID(driver,"Password",password);
		registerPage.enterToTextboxByID(driver,"ConfirmPassword","12345678");
		registerPage.clickToButtonByID(driver, "register-button");
		
		homePage.clickToLinkByText(driver,"Log in");
		loginPage = PageGenerator.getLoginPage(driver);

			
	}
	@Test
		public void Login_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login: Login to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Click To Log In Button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 2: Verify Error Message");
		verifyEquals(loginPage.getMessageByID(driver, "Email-error"),"Please enter your email");
		
	}
	
	@Test
	public void Login_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login: Login to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: input invalid Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", "a");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		verifyEquals(loginPage.getMessageByID(driver, "Email-error"),"Wrong email");

	}
	
	@Test
	public void Login_03_Email_Not_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login: Login to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: input Unregister Email to Email textbox");
		loginPage.enterToTextboxByID(driver, "Email", unRegisterEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 2: Click To Log In Button");
		loginPage.clickToButtonByText(driver, "Log in");
	
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		verifyEquals(loginPage.getMessageByClass(driver,"message-error validation-summary-errors"),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	@Test		
	public void Login_04_Not_Enter_WrongPassword(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");	
		loginPage.enterToTextboxByID(driver, "Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		verifyEquals(loginPage.getMessageByClass(driver,"message-error validation-summary-errors"),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	
	}
	@Test		
	public void Login_05_WrongPassword(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");	
		loginPage.enterToTextboxByID(driver, "Password", "123");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		verifyEquals(loginPage.getMessageByClass(driver,"message-error validation-summary-errors"),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	
	}
	@Test		
	public void Login_06_Success_LogIn(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");
		loginPage.enterToTextboxByID(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");
		loginPage.enterToTextboxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Link Displayed");
		homePage = PageGenerator.getHomePage(driver);
		verifyTrue(homePage.checkLinkDisplayedByText(driver,"My account"));
		verifyTrue(homePage.checkLinkDisplayedByText(driver,"Log out"));
	
	}
	@Parameters({"browser"})
	@AfterClass(alwaysRun= true)
		public void cleanBrowser(String browsername) {
		cleanBrowserDriver();
	}
	HomePO homePage;
	RegisterPO registerPage;
	LoginPO loginPage;
	private String email,unRegisterEmail,password;
}