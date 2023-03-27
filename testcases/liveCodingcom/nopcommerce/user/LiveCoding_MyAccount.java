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
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_MyAccount extends BaseTest{
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
		public void MyAccount_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: Empty_Data");
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Click To Log In Button");
		homePage.clickToLinkByText(driver, "My account");
			
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Clear First Name TextBox");
		myAccountPage = PageGenerator.getMyAccountPage(driver);
		myAccountPage.clearTextboxByID(driver, "FirstName");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Clear Last Name TextBox");
		myAccountPage.clearTextboxByID(driver, "LastName");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 3: Check To Check Box Male");
		myAccountPage.checkToRadioByID(driver, "gender-male");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 4: Input Automation Value To First Name Text Box");
		myAccountPage.enterToTextboxByID(driver,"FirstName","Automation");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 5: Input FC Value To Last Name Text Box");
		myAccountPage.enterToTextboxByID(driver,"LastName","FC");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 6: Select Date Of Birthday From Dropdown");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthDay", "29", "DateOfBirthMonth", "December", "DateOfBirthYear", "1990");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Input Email Value To First Name Text Box");
		myAccountPage.enterToTextboxByID(driver,"Email",newEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Input TSB Viet Nam Value To Company Text Box");
		myAccountPage.enterToTextboxByID(driver,"Company","TSB Viet Nam");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Click TO Save Button");
		myAccountPage.clickToButtonByID(driver, "save-info-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Verify All Fields");
		verifyTrue(myAccountPage.UpdatedSuccessMessageDisplayed(driver));
		verifyEquals(myAccountPage.getUpdatedSuccessMessage(driver), "The customer info has been updated successfully.");
		verifyEquals(myAccountPage.getElementAttributeValueByID(driver,"FirstName","value"), "Automation");
		verifyEquals(myAccountPage.getElementAttributeValueByID(driver,"LastName","value"), "FC");
		verifyEquals(myAccountPage.getElementAttributeValueByID(driver,"Email","value"), newEmail);
		verifyEquals(myAccountPage.getElementAttributeValueByID(driver,"Company","value"), "TSB Viet Nam");

	}
	
	@Test
	public void MyAccount_02_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: Address");
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 1: Click To Addresses Link");
		myAccountPage.clickToLinkByText(driver, "Addresses");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Click To Add New Button");
		myAccountPage.clickToButtonByText(driver, "Add new");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 3: Input Valid Info To First Name Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_FirstName", "Automation");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 4: Input Valid Info To Last Name Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_LastName", "FC");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 5: Input Valid Info To Email Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_Email", email);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 6: Input Valid Info To Company Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_Company", "TSB");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 7: Select Info From Country Dropdown");
		myAccountPage.selectDefaultDropdownByID(driver,"Address_CountryId","Viet Nam");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 8: Input Valid Info To City Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_City", "Ho Chi Minh");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 9: Input Valid Info To Address 1 Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_Address1", "36/280 Lac Long Quan");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 10: Input Valid Info To Address 2 Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_Address2", "36/281 Lac Long Quan");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 11: Input Valid Info To Zip / postal code Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_ZipPostalCode", "251989");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 12: Input Valid Info To Phone number Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_PhoneNumber", "0948416789");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 13: Input Valid Info To Fax number Text Box");
		myAccountPage.enterToTextboxByID(driver, "Address_FaxNumber", "98765");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 15: Click To Save Button");
		myAccountPage.clickToButtonByText(driver, "Save");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 16 :Verify New Addresses Added Mesage Success");
		verifyEquals(myAccountPage.getMessageByClass(driver, "bar-notification success"),"The new address has been added successfully.");

		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 17: Verify All Information");
		verifyEquals(myAccountPage.getInformationByClass(driver, "name"),"Automation FC");
		verifyEquals(myAccountPage.getInformationByClass(driver, "email"),"Email:"+" "+ email);
		verifyEquals(myAccountPage.getInformationByClass(driver, "phone"),"Phone number: 0948416789");
		verifyEquals(myAccountPage.getInformationByClass(driver, "fax"),"Fax number: 98765");
		verifyEquals(myAccountPage.getInformationByClass(driver, "company"),"TSB");
		verifyEquals(myAccountPage.getInformationByClass(driver, "address1"),"36/280 Lac Long Quan");
		verifyEquals(myAccountPage.getInformationByClass(driver, "address2"),"36/281 Lac Long Quan");
		verifyEquals(myAccountPage.getInformationByClass(driver, "city-state-zip"),"Ho Chi Minh, 251989");
		verifyEquals(myAccountPage.getInformationByClass(driver, "country"),"Viet Nam");
		
	}
	
	@Test
	public void MyAccount_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: Change Password");
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 1: Click To Change Password Link");
		myAccountPage.clickToLinkByText(driver, "Change password");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Input To Old Password Text Box");
		myAccountPage.inputToTextboxByID(driver, "OldPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 3: Input To New Password Text Box");
		myAccountPage.inputToTextboxByID(driver, "NewPassword", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 4: Input To Confirm Password Text Box");
		myAccountPage.inputToTextboxByID(driver, "ConfirmNewPassword", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 5: Input To Confirm Password Text Box");
		myAccountPage.clickToButtonByText(driver, "Change password");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 6: Verify Password Changed Success Message Displayed");
		verifyEquals(myAccountPage.getSuccessMessageByClass(driver, "content"),"Password was changed");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 7: Close Message");
		myAccountPage.closePasswordChangeMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 8: Click To Logout Button");
		myAccountPage.clickToButtonByJS(driver, "Log out");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 9: Click To Login Button");
		homePage = PageGenerator.getHomePage(driver);
		homePage.clickToLinkByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 10: Input New Email TO Email Text Box");
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.inputToTextboxByID(driver, "Email", newEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 11: Input Old Password To Password Text Box");
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 12: Click To Login Button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 13: Verify error message");
		verifyEquals(loginPage.getMessageByClass(driver, "message-error validation-summary-errors"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 14: Input New Password To Password Text Box");
		loginPage.inputToTextboxByID(driver, "Password", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 15: Click To Login Button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 16: Verify My Account Link Displayed");
		homePage = PageGenerator.getHomePage(driver);
		verifyTrue(homePage.checkLinkDisplayedByText(driver, "My account"));

	}
	@Test		
	public void MyAccount_04_Add_Review(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: My Product Review");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Click To Build your own computer Link ");	
		homePage.clickToLinkByText(driver, "Build your own computer");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 2: Click To Add your review Link");
		homePage.clickToLinkByText(driver, "Add your review");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 3: Input  To Review Title Text Box");
		homePage.inputToTextboxByID(driver, "AddProductReview_Title", "My Computer");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 4: Input  To Review Text Text Box");
		homePage.inputToTextAreaByID(driver, "AddProductReview_ReviewText", "Good");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Click To Submit Review Button");
		homePage.clickToButtonByText(driver, "Submit review");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Add Success Message");
		verifyEquals(homePage.getMessageByClass(driver, "result"), "Product review is successfully added.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Review Title");
		verifyEquals(homePage.getMessageByClass(driver, "review-title"), "My Computer");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Commend Text");
		verifyEquals(homePage.getMessageByClass(driver, "text-body"), "Good");
		
		
		
		
	}
			
	public void Login_05_WrongPassword(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");	
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
	
	}
			
	public void Login_06_Success_LogIn(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register: register to sytem");
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");

		ExtentTestManager.getTest().log(Status.INFO, "Register: - Step 1: Input to password textbox");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Error Message");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login: - Step 1: Verify Link Displayed");
		
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
	private String email,newEmail,password,newPassword;
}