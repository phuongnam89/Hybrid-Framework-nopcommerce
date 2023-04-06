package PageObjectsNewTest;

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
waitForElementVisible(driver, ShoppingCartPageUI.LIVE_CODING_PRODUCT_NAME);

return isElementDisplayed(driver, ShoppingCartPageUI.LIVE_CODING_PRODUCT_NAME);
}



}
