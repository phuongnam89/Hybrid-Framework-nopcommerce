package PageObjectsNewTest;

import org.openqa.selenium.WebDriver;

import PageUisNewTest.MyAccountPageUI;
import PageUisNewTest.RegisterPageUI;
import commons.BasePage;

public class MyAccountPO extends BasePage {
WebDriver driver;
public MyAccountPO(WebDriver driver) {
	this.driver = driver;
	}

public Object getUpdatedSuccessMessage(WebDriver driver) {
	waitForElementVisible(driver,MyAccountPageUI.LIVE_CODING_UPDATED_SUCCESS_MESSAGE);
	return getElementText(driver, MyAccountPageUI.LIVE_CODING_UPDATED_SUCCESS_MESSAGE);
}

public boolean UpdatedSuccessMessageDisplayed(WebDriver driver) {
	waitForElementVisible(driver,MyAccountPageUI.LIVE_CODING_UPDATED_SUCCESS_MESSAGE);	
	return isElementDisplayed(driver, MyAccountPageUI.LIVE_CODING_UPDATED_SUCCESS_MESSAGE);
}

public void closePasswordChangeMessage() {
	waitForElementClickable(driver, MyAccountPageUI.LIVE_CODING_PASSWORD_CHANGED_MESSAGE);
	clickToElement(driver, MyAccountPageUI.LIVE_CODING_PASSWORD_CHANGED_MESSAGE);
}



}
