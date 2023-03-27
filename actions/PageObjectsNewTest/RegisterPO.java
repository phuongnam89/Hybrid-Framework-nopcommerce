package PageObjectsNewTest;

import org.openqa.selenium.WebDriver;

import PageUisNewTest.RegisterPageUI;
import commons.BasePage;

public class RegisterPO extends BasePage {
WebDriver driver;
public RegisterPO(WebDriver driver) {
	this.driver = driver;
	}
public Object getRegisterSuccessMessage(WebDriver driver) {
	waitForElementVisible(driver, RegisterPageUI.LIVE_CODING_REGISTER_SUCCESS_MESSAGE);
	return getElementText(driver, RegisterPageUI.LIVE_CODING_REGISTER_SUCCESS_MESSAGE);
}
public void clickToContinueButton(WebDriver driver) {
waitForElementClickable(driver, RegisterPageUI.LIVE_CODING_REGISTER_CONTINUE_BUTTON);
clickToElement(driver, RegisterPageUI.LIVE_CODING_REGISTER_CONTINUE_BUTTON);
}
public Object getRegisterEmailAlreadyExistMessage() {
	waitForElementVisible(driver, RegisterPageUI.LIVE_CODING_REGISTER_EMAIL_ALREADY_EXISTS);
	return getElementText(driver, RegisterPageUI.LIVE_CODING_REGISTER_EMAIL_ALREADY_EXISTS);
}




}
