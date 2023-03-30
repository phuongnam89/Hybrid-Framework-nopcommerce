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

import PageObjectsNewTest.CellPhonesPO;
import PageObjectsNewTest.ElectronicsPO;
import PageObjectsNewTest.HomePO;
import PageObjectsNewTest.LoginPO;
import PageObjectsNewTest.MyAccountPO;
import PageObjectsNewTest.PageGenerator;
import PageObjectsNewTest.RegisterPO;
import ReportConfig.ExtentTestManager;
import commons.BaseTest;

public class LiveCoding_Sort_Display_Paging extends BaseTest{
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	

	public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		email = "namphuong"+generalFakeNumber()+"@gmail.com";
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
		public void Sort_01_Name_A_To_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: Empty_Data");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Open To Electronics Link");
		homePage.clickToLinkByText(driver, "Electronics ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Open To Electronics Link");
		electronicsPage = PageGenerator.getElectronicsPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Open To Cell Phones Link");
		electronicsPage.clickToLinkByText(driver, " Cell phones ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Select Value Name: A To Z Dropdown");
		cellPhonesPage = PageGenerator.getCellPhonesPage(driver);
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Name: A to Z");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Verify");
		verifyTrue(cellPhonesPage.isProductNameSortByAscending());

	}
	
	@Test
	public void Sort_02_Name_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount: Address");
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 1: Click To Addresses Link");
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Name: Z to A");
	
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Verify");
		verifyTrue(cellPhonesPage.isProductNameSortByDescending());

	}
	
	
	public void MyAccount_03_Change_Password(Method method) {
		
	}
	
			
	public void MyAccount_04_Add_Review(Method method) {
		
		
	}
			
	public void Login_05_WrongPassword(Method method) {
		
	}
			
	public void Login_06_Success_LogIn(Method method) {
		
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
	ElectronicsPO electronicsPage;
	CellPhonesPO cellPhonesPage;
	private String email,password;
}