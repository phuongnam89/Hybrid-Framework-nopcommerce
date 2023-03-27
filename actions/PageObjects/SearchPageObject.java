package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.SearchPageUI;
import commons.BasePage;

public class SearchPageObject extends BasePage {
private WebDriver driver;
public SearchPageObject(WebDriver driver) {
	this.driver = driver;
}

public void clickToSearchButton() {
	waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
	clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
}

public String getNoResultMessage() {
	waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE);
	return getElementText(driver, SearchPageUI.NO_RESULT_MESSAGE);
}

public SearchPageObject clickToSearchButtonLink() {
	waitForElementClickable(driver, SearchPageUI.SEARCH_LINK);
	clickToElement(driver, SearchPageUI.SEARCH_LINK);
	return PageGeneratorManager.getSearchPage(driver);
}

public void inputToSearchBox(String searchKeyworldMacbook) {
	waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
	sendkeyElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKeyworldMacbook);
}



public String getSearchLenovoMessage() {
	waitForElementVisible(driver, getEmptyDataMessage());
	return null;
}

public String getMessageThinkpadProduct() {
	waitForElementVisible(driver, SearchPageUI.THINKPAD_MESSAGE);
	return getElementText(driver, SearchPageUI.THINKPAD_MESSAGE);
}

public void checkToAdvanceSearchCheckbox() {
	waitForElementClickable(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
	checkToDefaultCheckBoxOrRadio(driver, SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
	
	}

public void selectCategoryDropdown(String string) {
	waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
	selectFromDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, string);
}
public void selectManufacturerDropdown(String string) {
	waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
	selectFromDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, string);
}


public void uncheckToAutomaticSearchCheckbox() {
	waitForElementClickable(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
	uncheckToDefaultCheckBox(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
	
}

public void checkToAutomaticSearchCheckbox() {
	waitForElementClickable(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
	checkToDefaultCheckBoxOrRadio(driver, SearchPageUI.AUTOMATIC_SEARCH_CHECKBOX);
}

public String getMessageMacbookPro() {
	waitForElementVisible(driver, SearchPageUI.MACBOOK_RESULT_MESSAGE);
	return getElementText(driver, SearchPageUI.MACBOOK_RESULT_MESSAGE);
}

public String getEmptyDataMessage() {
	waitForElementVisible(driver, SearchPageUI.ERROR_EMPTY_DATA_MESSAGE);
	return getElementText(driver, SearchPageUI.ERROR_EMPTY_DATA_MESSAGE);
}
}

