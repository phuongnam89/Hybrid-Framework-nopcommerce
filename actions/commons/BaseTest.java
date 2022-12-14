package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
private WebDriver driver;
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
}
