package PageObjectsFacebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager  {
WebDriver driver ;
	public static LoginPageObject getLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
