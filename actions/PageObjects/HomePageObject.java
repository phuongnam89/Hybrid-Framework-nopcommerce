package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	//Màn hình này chứa action
	private WebDriver driver;
	
	//Đoạn này để tránh bị lỗi Null Pointer ( thiếu driver)
	//Hiện tại đang viết trên các Object
	public HomePageObject(WebDriver driver) {
	this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public boolean isMyAccountdisplayed() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public void clickToBuildYourComPuterLink() {
		// TODO Auto-generated method stub
		
	}

	public LoginPageObject getLoginPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToMyAccount() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public RegisterPageObject clickToRegisterLink(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginPageObject clickToLoginLink(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	


		
	

	
	 
		
	
}
