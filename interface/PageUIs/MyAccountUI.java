package PageUIs;

import commons.BasePage;

public class MyAccountUI extends BasePage {
	//packet chua locator
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String FEMALE_RADIO_BUTTON = "//input[@id='gender-female']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
	
	
	
	public static final String ADDRESSES_BUTTON = "//a[text()='Addresses']";
	public static final String ADD_NEW_BUTTON = "//button[@class='button-1 add-address-button']";
	public static final String ADDRESS_FIRST_NAME_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String ADDRESS_LAST_NAME_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String ADDRESS_EMAIL_ADDRESS_TEXTBOX = "//input[@id='Address_Email']";
	public static final String ADDRESS_COMPANY_NAME_TEXTBOX = "//input[@id='Address_Company']";
	public static final String ADDRESS_COUNTRY_DROPDOWN = "//select[@id='Address_CountryId']";
	public static final String ADDRESS_STATE_DROPDOWN = "//select[@id='Address_StateProvinceId']";
	public static final String ADDRESS_CITY_TEXTBOX = "//input[@id='Address_City']";
	public static final String ADDRESS_ADDRESS1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ADDRESS_ADDRESS2_TEXTBOX = "//input[@id='Address_Address2']";
	public static final String ADDRESS_ZIPCODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String ADDRESS_PHONE_NUMBER_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	public static final String ADDRESS_FAX_NUMBER_TEXTBOX = "//input[@id='Address_FaxNumber']";
	public static final String ADDRESS_SAVE_BUTTON = "//button[@class='button-1 save-address-button']";
	public static final String ADDRESS_VERIFY_NAME_FIELD = "//li[@class='name']";
	public static final String ADDRESS_VERIFY_EMAIL_FIELD = "//li[@class='email']";
	public static final String ADDRESS_VERIFY_PHONE_NUMBER_FIELD = "//li[@class='phone']";
	public static final String ADDRESS_VERIFY_FAX_NUMBER_FIELD = "//li[@class='fax']";
	public static final String ADDRESS_VERIFY_COMPANY_FIELD = "//li[@class='company']";
	public static final String ADDRESS_VERIFY_ADDRESS1_FIELD = "//li[@class='address1']";
	public static final String ADDRESS_VERIFY_ADDRESS2_FIELD = "//li[@class='address2']";
	public static final String ADDRESS_VERIFY_CITY_AND_ZIPCODE_FIELD = "//li[@class='city-state-zip']";
	public static final String ADDRESS_VERIFY_COUNTRY_FIELD = "//li[@class='country']";
	
	public static final String CHANGE_PASSWORD_BUTTON = "//a[text()='Change password']";
	public static final String OLD_PASSWORD_TEXTBOX = "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD_TEXTBOX = "//input[@id='NewPassword']";
	public static final String CONFIRM_NEW_PASSWORD_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	public static final String SAVE_CHANGED_PASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";
	public static final String PASSWORD_CHANGED_SUCCESS_MESSAGE = "//p[@class='content']";
	public static final String CLOSE_CHANGED_SUCCESS_MESSAGE_BUTTON = "//span[@class='close']";
	
	public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTBOX = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String RATE_FIVE_STAR_RADIO = "//input[@id='addproductrating_5']";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[@name='add-review']";
	public static final String SUCCESS_REVIEW_MESSAGE = "//div[@class='result']";
	public static final String SUCCESS_REVIEW_TITLE_MESSAGE = "//div[@class='review-title']";
	public static final String SUCCESS_REVIEW_TEXT_MESSAGE = "//div[@class='review-text']";
	public static final String LOGOUT_LINK = "//a[text()='Log out']";
}
