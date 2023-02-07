package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
private WebDriver driver;
protected final Log log;

	protected BaseTest() {
	log = LogFactory.getLog(getClass());
}
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	public void deleteAllureReport() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}


private String projectPath = System.getProperty("user.dir");

protected WebDriver getBrowserDriver(String browserName) {
	if(browserName.equals("firefox")) {
		//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else if(browserName.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (browserName.equals("edge")) {
		//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else {
		throw new RuntimeException("browser name invalid");
	}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	return driver;
}



protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("browser name invalid");
		}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(appUrl);
	return driver;
}
	
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			log.info(" -------------------------- PASSED -------------------------- ");	
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			log.info(" -------------------------- PASSED -------------------------- ");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}



	public WebDriver getDriverInstance() {
		
		return this.driver;
	}

	
}

