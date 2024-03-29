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
import PageObjectsNewTest.ComputersPO;
import PageObjectsNewTest.ElectronicsPO;
import PageObjectsNewTest.HomePO;
import PageObjectsNewTest.LoginPO;
import PageObjectsNewTest.MyAccountPO;
import PageObjectsNewTest.NotebooksPO;
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
		ExtentTestManager.startTest(method.getName(), "Sort: Sort Name A To Z");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Open To Electronics Link");
		homePage.clickToLinkByText(driver, "Electronics ");
		electronicsPage = PageGenerator.getElectronicsPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 2: Open To Cell Phones Link");
		electronicsPage.clickToLinkByText(driver, " Cell phones ");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 3: Select Value Name: A To Z Dropdown");
		cellPhonesPage = PageGenerator.getCellPhonesPage(driver);
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Name: A to Z");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 4: Verify");
		verifyTrue(cellPhonesPage.isProductNameSortByAscendingByLambda());

	}
	
	@Test
	public void Sort_02_Name_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort: Sort Name Z To A");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Click To Addresses Link");
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Name: Z to A");
	
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 2: Verify");
		verifyTrue(cellPhonesPage.isProductNameSortByDescendingByLambda());

	}
	
	@Test
	public void Sort_03_Price_Low_To_High(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort: Sort Price Low To High");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Click To Addresses Link");
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Price: Low to High");
	
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 2: Verify");
		verifyTrue(cellPhonesPage.isProductPriceSortByAscending());


	}
	
	@Test		
	public void Sort_04_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort: Sort Price High To Low");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Select Price: High to Low From Dropdown");
		cellPhonesPage.selectDefaultDropdownByID(driver, "products-orderby", "Price: High to Low");
	
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 2: Verify");
		verifyTrue(cellPhonesPage.isProductPriceSortByDescending());
		
	}
	@Test		
	public void Sort_05_Three_Products_Displayed_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort: 3 Products Displayed Per Page");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Click To Computers Link");
		cellPhonesPage.clickToLinkByText(driver, "Computers ");
	
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 2: Click To Notebooks Link");
		computersPage = PageGenerator.getComputersPage(driver);
		computersPage.clickToLinkByText(driver," Notebooks ");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 3:  Select Display 3 per page From Dropdown");
		notebooksPage = PageGenerator.getNotebooksPage(driver);
		notebooksPage.selectDefaultDropdownByID(driver,"products-pagesize","3");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 4: Verify Display 3 per page");
		verifyTrue(notebooksPage.isThreeProductsDislayedPerPage());
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 5: Verify next page icon displayed");
		verifyTrue(notebooksPage.isNextPageIconDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 6: Click To Next Page Icon");
		notebooksPage.clickToLinkByText(driver, "Next");
		
		ExtentTestManager.getTest().log(Status.INFO, "MyAccount: - Step 7: Verify Previous Page Icon Displayed");
		verifyTrue(notebooksPage.isPreviousPageIconDisplayed());
		

	}
	@Test		
	public void Sort_06_Six_Products_Displayed_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort: 6 Products Displayed Per Page");
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 1: Select Display 6 per page From Dropdown");
		notebooksPage = PageGenerator.getNotebooksPage(driver);
		notebooksPage.selectDefaultDropdownByID(driver,"products-pagesize","6");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 2: Verify Display 6 per page");
		verifyTrue(notebooksPage.isSixProductsDislayedPerPage());
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort: - Step 3: Verify next page icon Undisplayed");
		verifyTrue(notebooksPage.isNextPageIconUnDisplayed());
		
	}
	@Parameters({"browser"})
	@AfterClass(alwaysRun= true)
		public void cleanBrowser(String browsername) {
		cleanBrowserDriver();
	}
	HomePO homePage;
	RegisterPO registerPage;
	LoginPO loginPage;
	MyAccountPO myAccountPage;
	ElectronicsPO electronicsPage;
	CellPhonesPO cellPhonesPage;
	ComputersPO computersPage;
	NotebooksPO notebooksPage;
	private String email,password;
}