package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.MyAccountUI;
import commons.BasePage;

public class AddressPageObject extends BasePage {
	WebDriver driver;
	public AddressPageObject(WebDriver driver) {
	this.driver = driver;

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
}
