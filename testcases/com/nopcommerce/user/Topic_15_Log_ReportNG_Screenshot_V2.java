package com.nopcommerce.user;


import java.lang.reflect.Method;
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

//import com.relevantcodes.extentreports.LogStatus;

import PageObjectsFacebook.LoginPageObject;
import PageObjectsFacebook.PageGeneratorManager;
//import ReportConfig.ExtentManager;
import commons.BasePage;
import commons.BaseTest;

public class Topic_15_Log_ReportNG_Screenshot_V2 extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
		public void beforeClass(String browserName, String appUrl) {
			driver = getBrowserDriver(browserName, appUrl);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	
	//Bài này dùng Extent Report V2
	//Cần thêm thư viện mới không bị báo lỗi

	@Test
	public void Verify_01_element_displayed(Method method) {
//		ExtentManager.startTest(method.getName(), "Verify_01_element_displayed");
//		ExtentManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Click To New Customer Button");
//
//		loginPage.clickToCreateNewAccountButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Create Account - Step 2: Enter to Email Address Textbox");
//		loginPage.enterToEmailAddressTextbox("");
//		sleepInSecond(3);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Create Account - Step 3:Verify Confirm Email Textbox Display");
//		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
//		ExtentManager.endTest();
//		
		
	}
	@Test
	public void Verify_02_Verify_Element_Undisplayed_in_Dom(Method method) {
//		ExtentManager.startTest(method.getName(), "Verify_02_Verify_Element_Undisplayed_in_Dom");
//		ExtentManager.getTest().log(LogStatus.INFO, "Verify Element Undisplay In Dom - Step 1: Enter to Email Address Textbox");
//		loginPage.enterToEmailAddressTextbox("1235345");
//		sleepInSecond(3);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Verify Element Undisplay In Dom - Step 2: Verify Confirm Email Textbox UnDisplay");
//		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
//		ExtentManager.endTest();
//	
	}
		
	

	@Test
	public void Verify_03_Element_Undisplayed_not_in_dom(Method method) {
//		ExtentManager.startTest(method.getName(), "Verify_03_Element_Undisplayed_not_in_dom");
//		ExtentManager.getTest().log(LogStatus.INFO, "Verify Element Undisplay Not In Dom - Step 1: Click To Close Icon At Register Form");
//		
//		loginPage.clickCloseIconAtRegisterForm();
//		sleepInSecond(3);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Verify Element Undisplay Not In Dom - Step 2: Verify Confirm Email Textbox UnDisplay");
//		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
//		ExtentManager.endTest();
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
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