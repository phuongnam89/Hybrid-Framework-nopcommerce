package PageObjectsJQuery.uploadFiles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUiIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver  driver;
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	//Đây mới chỉ là load lên thôi, chưa upload ảnh
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED);
	}
	
	//Cái này là đã được upload
	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK);
	}
		public boolean isFileImageUploadedByName(String fileName) {
			waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
			return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE);
	
	}
	public void clickToStartButton() {
		List<WebElement> startButtons = getWebElements(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
		
	}
	
	
	}
	
		
	

