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



import PageObjectsFacebook.LoginPageObject;
import PageObjectsFacebook.PageGeneratorManager;
//import ReportConfig.ExtentManager;
import commons.BasePage;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Topic_15_Allure_Report extends BaseTest {
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
	
	
	
	@Description("Register to System")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Verify_01_element_displayed(Method method) {
		

		loginPage.clickToCreateNewAccountButton();
		
		
		loginPage.enterToEmailAddressTextbox("");
		sleepInSecond(3);
		
		
		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
		
		
	}
	@Test
	public void Verify_02_Verify_Element_Undisplayed_in_Dom(Method method) {
		
		loginPage.enterToEmailAddressTextbox("1235345");
		sleepInSecond(3);
		
		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
		
	
	}
		
	

	@Test
	public void Verify_03_Element_Undisplayed_not_in_dom(Method method) {
		
		loginPage.clickCloseIconAtRegisterForm();
		sleepInSecond(3);
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
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