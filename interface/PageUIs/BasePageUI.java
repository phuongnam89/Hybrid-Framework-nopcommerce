package PageUIs;

import commons.BasePage;

public class BasePageUI extends BasePage {
	//Training
	public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCTS_LINK = "//a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "//a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINTS_LINK = "//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK= "//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEWS = "//a[text()='My product reviews']";
	public static final String SEARCH_LINK = "//a[text()='Search']";
	
	public static final String DYNAMIC_LINK_AT_MY_ACCOUNT_ARE = "//div[contains(@class, '%s')]////a[text()='%s";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	
		
	//Nopcommerce Live Coding
	
	public static final String LIVE_CODING_DYNAMIC_LINK_BY_TEXT = "xpath=//a[text()='%s']";
	public static final String LIVE_CODING_DYNAMIC_LINK_BY_SPAN_TEXT = "xpath=//span[text()='%s']";
	public static final String LIVE_CODING_DYNAMIC_LINK_BY_CLASS = "xpath=//a[@class='%s']";
	public static final String LIVE_CODING_DYNAMIC_LINK_BY_PRODUCT_TITTLE = "xpath=//h2[@class='product-title']/a[text()='%s']";

	
	public static final String LIVE_CODING_DYNAMIC_RADIO_BY_ID = "xpath=//input[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_CHECKBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ClASS = "xpath=//input[@class='%s']";
	public static final String LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_COMMEND_TEXT_BOX_BY_ID = "xpath=//textarea[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_GET_ERROR_MESSAGE_BY_ID = "xpath=//span[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_GET_MESSAGE_BY_CLASS = "xpath=//div[@class='%s']";
	public static final String LIVE_CODING_DYNAMIC_GET_SUCCESS_MESSAGE_BY_CLASS = "xpath=//p[@class='%s']";
	public static final String LIVE_CODING_DYNAMIC_GET_INFORMATION_BY_CLASS = "xpath=//li[@class='%s']";
	public static final String LIVE_CODING_DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String LIVE_CODING_DYNAMIC_BUTTON_BY_ID = "xpath=//button[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String LIVE_CODING_DYNAMIC_DEFAULT_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
	public static final String LIVE_CODING_DYNAMIC_SELECT_FROM_DROPDOWN = "xpath=//select[@name='%s']/option";
	public static final String LIVE_CODING_DYNAMIC_HEADER_BY_ID_AND_TEXT_NAME = "xpath=//table[@class='%s']//th[text()='%s']//preceding-sibling::th";
	public static final String LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@class='%s']//tbody/tr[%s]/td[%s]";
	public static final String LIVE_CODING_DYNAMIC_CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@class='%s']//tbody/tr[%s]/td[%s]//input";
	public static final String LIVE_CODING_DYNAMIC_BUTTON_BY_PRODUCT_NAME_AND_BUTTON_NAME = "xpath=//a[text()='%s']/parent::h2//following-sibling::div[@class='add-info']//div[@class='buttons']/button[text()='%s']";
	
	//Hard Locator
	public static final String LIVE_CODING_DYNAMIC_CLOSE_ICON_AT_SUCCESS_MESSAGE = "xpath=//span[@class='close']";
	public static final String LIVE_CODING_HEADER_LOGO = "xpath=//img[@alt='nopCommerce demo store']";

}

