package PageObjectsJQuery.uploadFiles;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	
	public static  HomePageObject getJQtHomePage (WebDriver driver) {
		return new HomePageObject(driver);
		
	}
}
