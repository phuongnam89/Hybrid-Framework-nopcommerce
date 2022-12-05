package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import java.util.Random;
public class User_01_Resgister {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	
@BeforeClass
 public void beforeClass() {
		System.getProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\gecko.driver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
	}
  @Test
  public void TC_01_Register_Empty_Data() {
  }
  @Test
  public void TC_02_Register_invalid_email() {
  }@Test
  public void TC_03_Register_Success() {
  }@Test
  public void TC_04_Register_Exiting_Email() {
  }
  
  public int getRandomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
  }
		  
	  
  @AfterClass
  public void afterClass() {
	  
	  
	  }
}
