package PageObjectsJQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;

public class JQHomePageObject extends BasePage {
	WebDriver  driver;
	public JQHomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, JQHomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, JQHomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}
	//Dynamic value luôn phải đứng cuối cùng
	public void enterToheaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, JQHomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyElement(driver, JQHomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, JQHomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}
		
	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, JQHomePageUI.HEADER_TEXTBOX_LABEL_ACTIVED, pageNumber);
		return isElementDisplayed(driver, JQHomePageUI.HEADER_TEXTBOX_LABEL_ACTIVED);
		}

	public List<String> getValuesEachRowAtAllPage() {
		int totalPage = getElementSize(driver, JQHomePageUI.TOTAL_PAGINATION);
		System.out.println("Total page = "+ totalPage);
		
		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		//Duyệt qua tất cả các trang ( hiện tại là có 24 trang)
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, JQHomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
		List<WebElement> allRowElementEachPage = getWebElements(driver, JQHomePageUI.ALL_ROW_COUNTRY);
		for (WebElement eachRow : allRowElementEachPage) {
			
			allRowValuesAllPage.add(eachRow.getText());
			
		}
		}
		//In tất cả giá row- tất cả các page
		for(String value : allRowValuesAllPage) {
			System.out.println("----------------------");
			System.out.println(value);
		}
		return allRowValuesAllPage;
	}
	public void enterToTextboxAtRowNumerByColumnname(String columnName, String rowNumber, String value) {
		//Lấy ra column index dựa vào cột
		//Trước nó có bao người anh thì bản thân sẽ là index+1
		int columnIndex = getElementSize(driver, JQHomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		
		//sendkey vaò dòng
		//"xpath=//tbody/tr[1]/td[2]/input";
	waitForElementVisible(driver, JQHomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	sendkeyElement(driver, JQHomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,String.valueOf(columnIndex));
	
	}
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, JQHomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver, JQHomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDropdown(driver, JQHomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}
	public void clickToLoadButton() {
		waitForElementClickable(driver, JQHomePageUI.LOAD_BUTTON);
		clickToElement(driver, JQHomePageUI.LOAD_BUTTON);
	}
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, JQHomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver, JQHomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckBoxOrRadio(driver,JQHomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
	}
	public void uncheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, JQHomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickable(driver, JQHomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckBox(driver,JQHomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		
	}
	public void clickToIconByRowNumber(String columnName, String iconName) {
		
		waitForElementClickable(driver, JQHomePageUI.ICON_BUTTON_BY_ROW_NUMBER, columnName, iconName);
		clickToElement(driver, JQHomePageUI.ICON_BUTTON_BY_ROW_NUMBER, columnName, iconName);
		
	}
	public boolean isFileLoadedByName(String csharpFileName) {
		// TODO Auto-generated method stub
		return false;
	}
	}
	
		
	

