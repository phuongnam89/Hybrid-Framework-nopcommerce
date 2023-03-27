package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
private WebDriver driver;
public LoginPageObject(WebDriver driver) {
	this.driver = driver;
}
	public HomePageObject clickToHomePageLink() {
		waitForElementClickable(driver, LoginPageUI.HOMEPAGE_LINK);
		clickToElement(driver, LoginPageUI.HOMEPAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
		
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	
}
	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getExisErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_EXES_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_EXES_ERROR_MESSAGE);
	}
	

	public void inputToEmailTextBox(String textValue) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.EMAIL_TEXTBOX, textValue);
		}

	public void inputToPasswordTextBox(String textValue) {
		waitForElementVisible(driver, LoginPageUI.PASSWROD_TEXTBOX);
		sendkeyElement(driver, LoginPageUI.PASSWROD_TEXTBOX, textValue);
	}


	


}
