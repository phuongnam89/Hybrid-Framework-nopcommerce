package PageObjectsJQuery;

import commons.BasePage;

public class JQHomePageUI extends BasePage {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div//following-sibling::input";
	public static final String HEADER_TEXTBOX_LABEL_ACTIVED = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]";
	public static final String ALL_PAGE_ROW = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY = "xpath=//tbody/tr/td[@data-key='country']";
	
	//Index của cái cột cần enter/click/select vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String LOAD_BUTTON = "xpath=//button[@id='load']";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";

	public static final String ICON_BUTTON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";
	
}
