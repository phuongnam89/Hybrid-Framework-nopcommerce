package PageObjectsFacebook;

import org.openqa.selenium.WebDriver;

import PageUIFacebook.FacebookPageObjectUI;
import commons.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginPageObject extends BasePage {
 WebDriver driver;
public boolean isConfirmEmailAddressTextboxDisplayed;
	public  LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click To Create New Account Button")
	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, FacebookPageObjectUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, FacebookPageObjectUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}
	
	@Step("Enter to Email Address Textbox with value is {0}")
	public void enterToEmailAddressTextbox(String string) {
		waitForElementVisible(driver, FacebookPageObjectUI.EMAIL_TEXTBOX);
		sendkeyElement(driver, FacebookPageObjectUI.EMAIL_TEXTBOX, string);		
	}
	
	@Step("Verify Confirm Email Address Textbox Displayed")
	public boolean isConfirmEmalAddressTextboxDisplayed() {
		waitForElementVisible(driver, FacebookPageObjectUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, FacebookPageObjectUI.CONFIRM_EMAIL_TEXTBOX);
	}
	
	@Step("Verify Confirm Email Address Textbox Undisplayed")
	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, FacebookPageObjectUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, FacebookPageObjectUI.CONFIRM_EMAIL_TEXTBOX);
	}
	
	@Step("Click To Close Icon At Register Form")
	public void clickCloseIconAtRegisterForm() {
	waitForElementClickable(driver, FacebookPageObjectUI.CLOSE_ICON);
	clickToElement(driver, FacebookPageObjectUI.CLOSE_ICON);
	}
}
