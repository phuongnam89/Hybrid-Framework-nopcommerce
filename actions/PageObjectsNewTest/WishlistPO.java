package PageObjectsNewTest;

import org.openqa.selenium.WebDriver;

import PageUisNewTest.WishlistPageUI;
import commons.BasePage;

public class WishlistPO	extends BasePage {
WebDriver driver;
public WishlistPO(WebDriver driver) {
	this.driver = driver;
	}
public void clickToYourWishlistShareLink() {
waitForElementClickable(driver, WishlistPageUI.SHARE_WISHLIST_LINK);
clickToElement(driver, WishlistPageUI.SHARE_WISHLIST_LINK);
}

public boolean isWishlistDisplayed(WebDriver driver) {
	waitForElementVisible(driver, WishlistPageUI.SHARE_WISHLIST_DISPLAYED);
	return isElementDisplayed(driver, WishlistPageUI.SHARE_WISHLIST_DISPLAYED);
	}

public String getWishlistValue(WebDriver driver) {
	waitForElementVisible(driver, WishlistPageUI.SHARE_WISHLIST_DISPLAYED);
	return getElementText(driver, WishlistPageUI.SHARE_WISHLIST_DISPLAYED);
	

}


}
