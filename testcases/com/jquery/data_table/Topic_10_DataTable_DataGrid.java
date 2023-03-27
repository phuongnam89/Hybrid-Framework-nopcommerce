package com.jquery.data_table;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.pqc.crypto.xmss.XMSSMTKeyPairGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AddressPageObject;
import PageObjects.CustomerInfoPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.MyProductReviewsPageObject;
import PageObjects.PageGeneratorManager;
import PageObjects.CustomerInfoPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.RewardPointsPageObject;
import PageObjectsJQuery.JQHomePageObject;
import PageObjectsJQuery.JQPageGeneratorManager;
import commons.BasePage;
import commons.BaseTest;

public class Topic_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	List<String> actualAllCountryValues ;
	List<String> expectedAllCountryValues;
	String osName = System.getProperty("os.name");
	
	JQHomePageObject homePage ;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
		public void beforeClass(String browserName, String appUrl) {
			driver = getBrowserDriver(browserName, appUrl);
		
		
		homePage = JQPageGeneratorManager.getJQtHomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	
	
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPagingByPageNumber("15");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("15"));
		
		homePage.openPagingByPageNumber("2");
		sleepInSecond(1);	
		Assert.assertTrue(homePage.isPageNumberActived("2"));
		
		
		
		}

	
	public void Table_02_Enter_to_header_textbox() {
			homePage.enterToheaderTextboxByLabel("Country","Argentina");
			homePage.enterToheaderTextboxByLabel("Females", "338282");
			homePage.enterToheaderTextboxByLabel("Males","349238");
			homePage.enterToheaderTextboxByLabel("Total","687522");	
			
			homePage.refreshCurrentPage(driver);
			
			homePage.enterToheaderTextboxByLabel("Country","Albania");
			homePage.enterToheaderTextboxByLabel("Females", "24128");
			homePage.enterToheaderTextboxByLabel("Males","25266");
			homePage.enterToheaderTextboxByLabel("Total","49397");
	}
	
	public void Table_03() {
		//Đọc dữ liệu file country.txt
		//Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues
		
		//Actual Value
		actualAllCountryValues = homePage.getValuesEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);	
		}
		
	

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		
		//Có value để nhập vào- tham số 1
		//Row number: vị trí cái row nào
		//Ví dụ: nhập vào textobx tại dòng(row) số 3/5/7
		//Column name:: company/contact person/country
		homePage.enterToTextboxAtRowNumerByColumnname("Company", "1", "Michae97");
		homePage.enterToTextboxAtRowNumerByColumnname("Contact Person", "2", "Michae97");
		homePage.enterToTextboxAtRowNumerByColumnname("Order Placed", "3", "1989");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1" ,"Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2" ,"Germany");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3" ,"United Kingdom");
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.uncheckToCheckBoxByColumnNameAtRowNumber("NPO?","1");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.uncheckToCheckBoxByColumnNameAtRowNumber("NPO?","4");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.clickToIconByRowNumber("1","Remove Current Row");
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.clickToIconByRowNumber("4","Remove Current Row");
	}
	
	
	

	public void My_Account_04_My_Product_Review() {
		
		
		}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
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