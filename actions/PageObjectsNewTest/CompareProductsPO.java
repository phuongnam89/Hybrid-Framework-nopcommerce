package PageObjectsNewTest;

import org.openqa.selenium.WebDriver;

import PageUIs.BasePageUI;
import PageUisNewTest.CompareProductsPageUI;
import commons.BasePage;

public class CompareProductsPO	extends BasePage {
WebDriver driver;
public CompareProductsPO(WebDriver driver) {
	this.driver = driver;
	}
public Object isValueDisplayedInTableClassAtColumnNameAndRowIndex(WebDriver driver,String headerValue, String rowIndex) {
	int columnIndex = getElementSize(driver, CompareProductsPageUI.LIVE_CODING_DYNAMIC_HEADER_BY_INDEX, headerValue)+1;		
	waitForElementVisible(driver, CompareProductsPageUI.LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
	return getElementText(driver, CompareProductsPageUI.LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, rowIndex,String.valueOf(columnIndex));

}

}
