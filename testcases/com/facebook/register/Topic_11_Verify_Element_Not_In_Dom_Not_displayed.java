package com.facebook.register;


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
import commons.BasePage;
import commons.BaseTest;

public class Topic_11_Verify_Element_Not_In_Dom_Not_displayed extends BaseTest {
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
	
	
	

	@Test
	public void Verify_01_element_displayed() {
		loginPage.clickToCreateNewAccountButton();
		loginPage.enterToEmailAddressTextbox("namphuong@gmail.com");
		sleepInSecond(3);
		
		//Case 1: element có trong dom, có hiển thị
		verifyTrue(loginPage.isConfirmEmalAddressTextboxDisplayed());
		
		
		
	}
	@Test
	public void Verify_02_Verify_Element_Undisplayed_in_Dom() {
		//Nếu mong đợi 1 hàm verify vừa Display vừa Undisplayed thì ko đc có hàm wait
		//IsElementDisplayed
		//Verify False : mong đợi unDisplayed ( False)
		loginPage.enterToEmailAddressTextbox("");
		sleepInSecond(3);
		//Case 2: Element có trong Dom nhưng không hiển thị( visible)
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
	
	}
		
	

	@Test
	public void Verify_03_Element_Undisplayed_not_in_dom() {
		loginPage.clickCloseIconAtRegisterForm();
		sleepInSecond(3);
		
		//IsElementDisplayed: Bản chất ko kiểm tra việc find element
		
		//Tắt register form thì  thằng Confirm Email sẽ không còn trong Dom
		//Hàm find element sẽ không tìm thấy element
		//1- Nó sẽ chờ hết timeout của implicit:30s
		//2- Nó sẽ đánh fail test case tại đúng step này
		//3- Không có chạy các step còn lại
		
		//Case 3: Element không trong Dom, không hiển thị( visible)
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
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