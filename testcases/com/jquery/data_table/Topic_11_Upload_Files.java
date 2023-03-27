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

public class Topic_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	
	String osName = System.getProperty("os.name");
	
	PageObjectsJQuery.uploadFiles.HomePageObject homePage;
	String csharpFileName = "Csharp.png";
	String javaFileName = "Java.png";
	String pythonFileName = "Python.png";
	
	String[] multipleFileNames = {csharpFileName, javaFileName, pythonFileName};
	
	@Parameters({"browser", "url"})
	@BeforeClass
		public void beforeClass(String browserName, String appUrl) {
			driver = getBrowserDriver(browserName, appUrl);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageObjectsJQuery.uploadFiles.PageGeneratorManager.getJQtHomePage(driver);
		}
	
	
	

	@Test
	public void Upload_01_One_File_Per_Time() {
		//Stop 1 - Load Single File
		homePage.uploadMultipleFiles(driver, csharpFileName);
		
		//Verify đã load thành công
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		
		//Bấm vào start button
		homePage.clickToStartButton();
		
		//Verify upload link thành công
		homePage.isFileLinkUploadedByName(csharpFileName);
		//Verify ảnh đã upload thành công
		homePage.isFileImageUploadedByName(csharpFileName);
		
		
	}
	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		//Verify đã load thành công
				Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
				Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
				Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
				//Bấm vào start button
				homePage.clickToStartButton();
				
				//Verify upload link thành công
				homePage.isFileLinkUploadedByName(csharpFileName);
				homePage.isFileLinkUploadedByName(javaFileName);
				homePage.isFileLinkUploadedByName(pythonFileName);
				
				//Verify ảnh đã upload thành công
				homePage.isFileImageUploadedByName(csharpFileName);
				homePage.isFileImageUploadedByName(javaFileName);
				homePage.isFileImageUploadedByName(pythonFileName);
	
	
	}
		
	

	
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		
	}
	
	
	

	public void My_Account_04_My_Product_Review() {
		
		
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