package PageObjectsNewTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageUisNewTest.ShoppingCartPageUI;
import commons.BasePage;

public class ShoppingCartPO	extends BasePage {
WebDriver driver;
public ShoppingCartPO(WebDriver driver) {
	this.driver = driver;
	}
public void clickToRemoveButton(WebDriver driver) {
waitForElementClickable(driver, ShoppingCartPageUI.LIVE_CODING_REMOVE_BUTTON);
clickToElement(driver, ShoppingCartPageUI.LIVE_CODING_REMOVE_BUTTON);

}
public boolean isProductNameDisplayed(WebDriver driver) {
driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
waitForElementVisible(driver, ShoppingCartPageUI.LIVE_CODING_PRODUCT_NAME);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
return isElementDisplayed(driver, ShoppingCartPageUI.LIVE_CODING_PRODUCT_NAME);
}
public void inputToQuantityTextbox(WebDriver driver, String quantityValue) {
	waitForElementVisible(driver,ShoppingCartPageUI.LIVE_CODING_QUANTITY_TEXTBOX);
	sendkeyElement(driver, ShoppingCartPageUI.LIVE_CODING_QUANTITY_TEXTBOX, quantityValue);
}



}
