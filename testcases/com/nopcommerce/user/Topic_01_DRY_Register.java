package com.nopcommerce.user;



	

	import java.util.Random;
	import java.util.concurrent.TimeUnit;

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
	import org.testng.annotations.Test;

	import commons.BasePage;

	public class Topic_01_DRY_Register	 {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		String emailAddress;
		WebDriverWait explicitWait;
		JavascriptExecutor jsExecutor;
		Actions action;
		
		//Khai báo
		//BasePage:Class
		//basePage:Object
		BasePage basepage;
		

		@BeforeClass
			public void beforeClass() {
			if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			
			
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			
		}
			
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			explicitWait = new WebDriverWait(driver, 10);
			jsExecutor = (JavascriptExecutor) driver;
			action = new Actions(driver);
			emailAddress = "afc" + generalFakeNumber() + "@gmail.net";
			
					
				
		}
		@Test
		public void TC_01_Empty_Data() {
			driver.get("https://demo.nopcommerce.com/");
			
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(1);
			
			driver.findElement(By.xpath("//button[@name='register-button']")).click();
			
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(), "First name is required.");
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(), "Last name is required.");
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Email is required.");
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password is required.");
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "Password is required.");
			}

		@Test
		public void TC_02_Register_invalid_email() {
			driver.get("https://demo.nopcommerce.com/");
			
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(1);
			
			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("nam");
			driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("phuong");
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("nam@gmail@gmail.net");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
			
			
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Wrong email");
			
		}

		@Test
		public void TC_03_Register_Success() {
			driver.get("https://demo.nopcommerce.com/");
			
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(1);
			
			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("nam");
			driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("phuong");
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
			
			driver.findElement(By.xpath("//button[@name='register-button']")).click();
			sleepInSecond(1);
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
				

			
		}
		@Test
		public void TC_04_Register_Exiting_Email() {
			driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
			sleepInSecond(1);
			
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(1);
			
			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("nam");
			driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("phuong");
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678");
			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
			
			driver.findElement(By.xpath("//button[@name='register-button']")).click();
			sleepInSecond(1);
			
			Assert.assertEquals(driver.findElement(By.xpath("//li[text()='The specified email already exists']")).getText(), "The specified email already exists");
					

		}
		@Test
		public void TC_05_Password_Less_Than_6() {
			//driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(2);
			
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678");
			sleepInSecond(3);
			
			Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
		}
		@Test
		public void TC_06_Password_not_the_same() {
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			sleepInSecond(2);
			
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1234");

			sleepInSecond(3);
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");
					

			
		}
		public void sleepInSecond(long timeInSecond) {
			try {
				Thread.sleep(timeInSecond * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
		public int generalFakeNumber() {
			Random rand = new Random();
			return rand.nextInt(99999);
			
		}
		
	}

