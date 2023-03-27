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
import PageObjectsNewTest.PageGenerator;
import PageObjectsNewTest.RegisterPO;
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_Register extends BaseTest{
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	

	public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
//		homePage.clickToLinkByText();
//		
//		registerPage = PageGenerator.getRegisterPage(driver);
//		registerPage.checkToRadioByID();
//		registerPage.enterToTextboxByID();
			
	}
	@Test
		public void Register_01_Empty_Data(Method method) {
			ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
			ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Click To Register Link");	
			homePage = PageGenerator.getHomePage(driver);
			homePage.clickToLinkByText(driver,"Register");
			
			ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 2: Click To Register Button");	
			registerPage = PageGenerator.getRegisterPage(driver);
			registerPage.clickToButtonByID(driver,"register-button");
			
			ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 3: Verify all error messages");	
			Assert.assertEquals(registerPage.getErrorMessageByID(driver,"FirstName-error"), "First name is required.");
			Assert.assertEquals(registerPage.getErrorMessageByID(driver,"LastName-error"), "Last name is required.");
			Assert.assertEquals(registerPage.getErrorMessageByID(driver,"Email-error"), "Email is required.");
			Assert.assertEquals(registerPage.getErrorMessageByID(driver,"Password-error"),"Password is required.");
			Assert.assertEquals(registerPage.getErrorMessageByID(driver,"ConfirmPassword-error"),"Password is required.");
		}
	
	@Test
	public void Register_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: Invalid_Email");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: input invalid information to Email Textbox");	
		registerPage.enterToTextboxByID(driver,"Email","a");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 2: Verify error message");	
		Assert.assertEquals(registerPage.getErrorMessageByID(driver,"Email-error"),"Wrong email");
	}
	
	@Test
	public void Register_03_Password_Less_Than_6(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: Password_Less_Than_6");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 3: input invalid information to Email Textbox");	
		registerPage.enterToTextboxByID(driver,"Password","a");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 4: Verify error message");	
		Assert.assertEquals(registerPage.getErrorMessageByID(driver,"Password-error"),"Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void Register_04_Success_Register(Method method) {
		email = "namphuong"+generalFakeNumber()+"@gmail.com";
		
		ExtentTestManager.startTest(method.getName(), "Register: Success_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: input invalid information to Email Textbox");	
		registerPage.refreshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 2: Check To Male Radio");	
		registerPage.checkToRadioByID(driver,"gender-male");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 3: input invalid information to First Name Textbox");	
		registerPage.enterToTextboxByID(driver, "FirstName", "Phuong");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 4: input invalid information to Last Name Textbox");	
		registerPage.enterToTextboxByID(driver, "LastName", "Nam");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 5: input invalid information to Email Textbox");
		registerPage.enterToTextboxByID(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 6: Select Date Of Birth Dropdown");	
		registerPage.selectDropdownByName(driver,"DateOfBirthDay","2","DateOfBirthMonth","May","DateOfBirthYear","1989");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 7: Check To Newsletter Checkbox");
		registerPage.checkToCheckboxByID(driver,"Newsletter");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 8: input valid value to Pasword Textbox");
		registerPage.enterToTextboxByID(driver, "Password", "12345678");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 9: input valid value to Confirm Password Textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "12345678");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 10: Click To Register Button");	
		registerPage.clickToButtonByID(driver,"register-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 11: Verify Success Message");	
		verifyEquals(registerPage.getRegisterSuccessMessage(driver),"Your registration completed");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 12: Click To Continue Button");	
		registerPage.clickToContinueButton(driver);
	}
	@Test
	public void Register_05_Register_with_Email_Already_Exits(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Click To Register Link");	
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver,"Register");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 2: Click To Register Button");	
		registerPage = PageGenerator.getRegisterPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 3: Check To Male Radio");	
		registerPage.checkToRadioByID(driver,"gender-male");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 4: input invalid information to First Name Textbox");	
		registerPage.enterToTextboxByID(driver, "FirstName", "Phuong");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 5: input invalid information to Last Name Textbox");	
		registerPage.enterToTextboxByID(driver, "LastName", "Nam");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 6: input invalid information to Email Textbox");
		registerPage.enterToTextboxByID(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 7: Select Date Of Birth Dropdown");	
		registerPage.selectDropdownByName(driver,"DateOfBirthDay","2","DateOfBirthMonth","May","DateOfBirthYear","1989");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 8: Check To Newsletter Checkbox");
		registerPage.checkToCheckboxByID(driver,"Newsletter");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 9: input valid value to Pasword Textbox");
		registerPage.enterToTextboxByID(driver, "Password", "12345678");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 10: input valid value to Confirm Password Textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "12345678");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 11: Click To Register Button");	
		registerPage.clickToButtonByID(driver,"register-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 12: Verify error message");	
		Assert.assertEquals(registerPage.getRegisterEmailAlreadyExistMessage(),"The specified email already exists");
			
	}
	@Test
	public void Register_06_Password_And_Confirmed_Password_not_match(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");	
		registerPage.enterToTextboxByID(driver, "Password", "12345678");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: input not match value to Confirmed Pasword Textbox");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "123456789");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 2: Click To Register Button");	
		registerPage.clickToButtonByID(driver,"register-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 3: Verify error message");	
		verifyEquals(registerPage.getErrorMessageByID(driver,"ConfirmPassword-error"),"The password and confirmation password do not match.");		
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun= true)
		public void cleanBrowser(String browsername) {
		//cleanBrowserDriver();
	}
	HomePO homePage;
	RegisterPO registerPage;
	
	private String email;
}