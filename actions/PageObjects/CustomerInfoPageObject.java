package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClearElement;
import org.openqa.selenium.remote.server.handler.GetElementText;

import PageUIs.MyAccountUI;
import commons.BasePage;

public class CustomerInfoPageObject extends BasePage{
	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
	this.driver = driver;
}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, MyAccountUI.REGISTER_LINK);
		clickToElement(driver, MyAccountUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public void checkToFemaleRadioButton() {
		waitForElementClickable(driver, MyAccountUI.FEMALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountUI.FEMALE_RADIO_BUTTON);
	}

	public void inputToFirstNameTextbox(String newFirstName) {
		clearTextInTextbox(driver, MyAccountUI.FIRST_NAME_TEXTBOX);
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.FIRST_NAME_TEXTBOX, newFirstName);
	}

	public void inputToLastNameTextbox(String newLastName) {
		clearTextInTextbox(driver, MyAccountUI.LAST_NAME_TEXTBOX);
		waitForElementVisible(driver, MyAccountUI.LAST_NAME_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.LAST_NAME_TEXTBOX, newLastName);		
	}

	public void inputToEmailAddressTextbox(String newEmailAddress) {
		clearTextInTextbox(driver, MyAccountUI.EMAIL_TEXTBOX);
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.EMAIL_TEXTBOX, newEmailAddress);				
	}

	public void inputToCompanyTextbox(String companyName ) {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.COMPANY_TEXTBOX, companyName);
		
	}
	public String getNewFirstnameChanged(String text) {
		waitForElementVisible(driver, MyAccountUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.FIRST_NAME_TEXTBOX, text);
		
	}
	
	public String getNewLastnameChanged(String text) {
		waitForElementVisible(driver, MyAccountUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.LAST_NAME_TEXTBOX, text);
		
	}
	public String getnewEmailAddressChanged(String text) {
		waitForElementVisible(driver, MyAccountUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.EMAIL_TEXTBOX, text);
		
	}
	public String getNewCompanyNameChanged(String text) {
		waitForElementVisible(driver, MyAccountUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountUI.COMPANY_TEXTBOX, text);
	}

	public void clickToAddressesButton() {
		waitForElementClickable(driver, MyAccountUI.ADDRESSES_BUTTON);
		clickToElement(driver, MyAccountUI.ADDRESSES_BUTTON);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, MyAccountUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountUI.ADD_NEW_BUTTON);
		
	}

	public void inputToAddressFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_FIRST_NAME_TEXTBOX, newFirstName);
	}

	public void inputToAddressLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_LAST_NAME_TEXTBOX, newLastName);		
	}

	public void inputToAddressEmailAddressTextbox(String newEmailAddress) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_EMAIL_ADDRESS_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_EMAIL_ADDRESS_TEXTBOX, newEmailAddress);		
	}	
	
	public void inputToAddressCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_COMPANY_NAME_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_COMPANY_NAME_TEXTBOX, companyName);			
	}

	public void selectToCityDropdown(String city) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_COUNTRY_DROPDOWN);
		selectFromDropdown(driver, MyAccountUI.ADDRESS_COUNTRY_DROPDOWN, city);
		
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_ADDRESS1_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_ADDRESS1_TEXTBOX, address1);
		}
	
	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_ADDRESS2_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_ADDRESS2_TEXTBOX, address2);		
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_PHONE_NUMBER_TEXTBOX, phoneNumber);
		
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_FAX_NUMBER_TEXTBOX, faxNumber);
		
	}
	public String newAddressNameAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_NAME_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_NAME_FIELD);
	}
	public String newAddressEmailAddressAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_EMAIL_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_EMAIL_FIELD);
	}
	public String newAddressCompanyAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_COMPANY_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_COMPANY_FIELD);
	}
	public void inputZipCode(String zipCode) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_ZIPCODE_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_ZIPCODE_TEXTBOX, zipCode);
	}

	public String newAddressCityAndStateAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_CITY_AND_ZIPCODE_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_CITY_AND_ZIPCODE_FIELD);
	}
	public String newAddress1Added() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_ADDRESS1_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_ADDRESS1_FIELD);
	}
	public String newAddress2Added() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_ADDRESS2_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_ADDRESS2_FIELD);
	}
	public String newAddressPhoneNumberAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_PHONE_NUMBER_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_PHONE_NUMBER_FIELD);
	}
	public String newAddressFaxNumberAdded() {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_VERIFY_FAX_NUMBER_FIELD);
		return getElementText(driver, MyAccountUI.ADDRESS_VERIFY_FAX_NUMBER_FIELD);
	}

	public void clickToAddYourReviewLink() {
		waitForElementClickable(driver, MyAccountUI.ADD_YOUR_REVIEW_LINK);	
		clickToElement(driver, MyAccountUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewerTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, MyAccountUI.REVIEW_TITLE_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewerTextTextbox(String reviewText) {
		waitForElementVisible(driver, MyAccountUI.REVIEW_TEXT_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}

	public void clickToRateFiveStarButton() {
		waitForElementClickable(driver, MyAccountUI.RATE_FIVE_STAR_RADIO);
		clickToElement(driver, MyAccountUI.RATE_FIVE_STAR_RADIO);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, MyAccountUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, MyAccountUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getSuccessReviewMessage() {
		waitForElementVisible(driver, MyAccountUI.SUCCESS_REVIEW_MESSAGE);
		return getElementText(driver, MyAccountUI.SUCCESS_REVIEW_MESSAGE);
	}

	public String getSuccessReviewTitle() {
		waitForElementVisible(driver, MyAccountUI.SUCCESS_REVIEW_TITLE_MESSAGE);
		return getElementText(driver, MyAccountUI.SUCCESS_REVIEW_TITLE_MESSAGE);
	}

	public String getSuccessReviewText() {
		waitForElementVisible(driver, MyAccountUI.SUCCESS_REVIEW_TEXT_MESSAGE);
		return getElementText(driver, MyAccountUI.SUCCESS_REVIEW_TEXT_MESSAGE);
	}

	

	public void clickToSaveNewAddressButton() {
		waitForElementClickable(driver, MyAccountUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.ADDRESS_SAVE_BUTTON);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_BUTTON);
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, MyAccountUI.OLD_PASSWORD_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.OLD_PASSWORD_TEXTBOX, oldPassword);
		
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, MyAccountUI.NEW_PASSWORD_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.NEW_PASSWORD_TEXTBOX, newPassword);
		
	}

	public void inputToConfirmedPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, MyAccountUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);
		
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, MyAccountUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountUI.CHANGE_PASSWORD_BUTTON);
	}


	public String getPasswordChangedMessage() {
		waitForElementVisible(driver, MyAccountUI.PASSWORD_CHANGED_SUCCESS_MESSAGE);
		return getElementText(driver, MyAccountUI.PASSWORD_CHANGED_SUCCESS_MESSAGE);
				
	}


	public void inputCityNameTextBox(String city) {
		waitForElementVisible(driver, MyAccountUI.ADDRESS_CITY_TEXTBOX);
		sendkeyElement(driver, MyAccountUI.ADDRESS_CITY_TEXTBOX, city);
	}


	public void clickToChangeNewPasswordButton() {
		waitForElementClickable(driver, MyAccountUI.SAVE_CHANGED_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountUI.SAVE_CHANGED_PASSWORD_BUTTON);
	
	}


	public void clickToCloseMessage() {
		waitForElementClickable(driver, MyAccountUI.CLOSE_CHANGED_SUCCESS_MESSAGE_BUTTON);
		clickToElement(driver, MyAccountUI.CLOSE_CHANGED_SUCCESS_MESSAGE_BUTTON);

		
	}
	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyAccountUI.LOGOUT_LINK);
		clickToElement(driver, MyAccountUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}


	
	
	
	
	

	

	

}
