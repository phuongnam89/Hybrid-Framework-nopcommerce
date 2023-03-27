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

//import com.aventstack.extentreports.Status;

import PageObjectsFacebook.LoginPageObject;
import PageObjectsFacebook.PageGeneratorManager;
//import ReportConfig.ExtentManager;
//import ReportConfig.ExtentTestManager;
import commons.BasePage;
import commons.BaseTest;

public class Topic_15_Extent_Report_V5 extends BaseTest {
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
	
	
	//Cần thư viện của Extent Report V5

	@Test
	public void Verify_01_element_displayed(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Verify_01_element_displayed");
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to Create New Account Button");
//
//		loginPage.clickToCreateNewAccountButton();
//		
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Email Address Textbox");
//		loginPage.enterToEmailAddressTextbox("");
//		sleepInSecond(3);
//		
//		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Confirmed Email Address Textbox Displayed");
//		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
//		
//		
		
	}
	@Test
	public void Verify_02_Verify_Element_Undisplayed_in_Dom(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Verify_02_Verify_Element_Undisplayed_in_Dom");
//		ExtentTestManager.getTest().log(Status.INFO, "Verify_02 - Step 01: Enter to Email Address Textbox");
//		loginPage.enterToEmailAddressTextbox("1235345");
//		sleepInSecond(3);
//		ExtentTestManager.getTest().log(Status.INFO, "Verify_02 - Step 02: Verify Confirmed Email Address Textbox");
//		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
//	
	}
		
	

	@Test
	public void Verify_03_Element_Undisplayed_not_in_dom(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Verify_03_Element_Undisplayed_not_in_dom");
//		ExtentTestManager.getTest().log(Status.INFO, "Verify_03 - Step 01: Enter to Email Address Textbox");
//		loginPage.clickCloseIconAtRegisterForm();
//		sleepInSecond(3);
//		
//		ExtentTestManager.getTest().log(Status.INFO, "Verify_03 - Step 02: Verify Confirmed Email Address Textbox Undisplayed");
//		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
//		
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