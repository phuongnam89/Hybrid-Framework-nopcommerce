package PageObjectsJQuery;

import org.openqa.selenium.WebDriver;

public class JQPageGeneratorManager {
	WebDriver driver;
	
	public static  JQHomePageObject getJQtHomePage (WebDriver driver) {
		return new JQHomePageObject(driver);
		
	}
}
