package commons;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.AddressPageObject;
import PageObjects.BackInStockSubscriptionsPageObject;
import PageObjects.ChangePasswordPageObject;
import PageObjects.CustomerInfoPageObject;
import PageObjects.DownloadableProductsPageObject;
import PageObjects.MyProductReviewsPageObject;
import PageObjects.OrdersPageObject;
import PageObjects.PageGeneratorManager;
import PageObjects.RewardPointsPageObject;
import PageObjects.SearchPageObject;
import PageObjectsJQuery.uploadFiles.HomePageUI;
import PageUIs.BasePageUI;
import PageUisNewTest.MyAccountPageUI;
import pageUiIs.jQuery.uploadFile.BasePageJqueryUI;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
		
	}

	
	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("Locator type =" + locatorType);
		
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
		 by = By.id(locatorType.substring(3));
	} else if(locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
		by = By.className(locatorType.substring(6));
		
	} else if(locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
		by = By.cssSelector(locatorType.substring(4));
		
	} else if(locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
		by = By.name(locatorType.substring(5));
		
	} else if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
		by = By.xpath(locatorType.substring(6));
	} else {
		throw new RuntimeException("Locator type is not supported.");
	}
	return by;
}
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
		}	
	
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
			return driver.findElement(getByLocator(xpathLocator));
		}
		
	public List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByLocator(xpathLocator));
	}
	
	
	public void clearTextInTextbox(WebDriver driver, String xpathLocator) {
		waitForElementVisible(driver, xpathLocator);
		getWebElement(driver, xpathLocator).clear();
	}
	protected void selectFromDropdown(WebDriver driver,String xpathLocator, String textValue) {
		waitForElementVisible(driver, xpathLocator);
		new Select(getWebElement(driver, xpathLocator)).selectByVisibleText(textValue); 
	}
	
		public void setCookies (WebDriver driver, Set<Cookie> cookies) {
			for (Cookie cookie:cookies) {
			driver.manage().addCookie(cookie);
		}
			sleepInSecond(3);
		}
		
		public Set<Cookie> getAllCookies(WebDriver driver) {
			return driver.manage().getCookies();
		}
		
		public int generalFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
		protected void openPageUrl(WebDriver driver, String pageUrl) {
			driver.get(pageUrl);
	}
		protected String getPageTitle(WebDriver driver ) {
		return driver.getTitle();
	}
	
		protected String getPageUrl(WebDriver driver ) {
		return driver.getTitle();
	}
	
		protected String getPageSource(WebDriver driver) {

		return driver.getPageSource();
	}
	
		public void backtoPage(WebDriver driver) {
		driver.navigate().back();
	}
		public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
		public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//Ham nay doi cho alert hien thi
	//ham nay da switch qua alert roi
		protected Alert waitForAlertPresence(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			return explicitWait.until(ExpectedConditions.alertIsPresent());
		}

		protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
		protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
		protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
		protected void sendKeyToAlert (WebDriver driver, String textAlert) {
		waitForAlertPresence(driver).sendKeys(textAlert);
	}
	
		protected void switchWindowByID (WebDriver driver, String windowID) {
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for (String id : allWindowIds) {
			
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
		public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String...dynamicValues) {
			Actions action = new Actions(driver);
			action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
		}
		protected void switchWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			driver.switchTo().window(id);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(tabTitle)) {
				break;
			}
		}
	}
		protected void closeAllWindowsWithoutParent(WebDriver driver, String parentPage) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id: allWindowIds ) {
			driver.switchTo().window(id);
			if(!id.equals(parentPage)) {
				driver.close();
			}
			driver.switchTo().window(parentPage);
			
		}
	}
		protected void clickToElement(WebDriver driver, String xpathLocator) {
			getWebElement(driver, xpathLocator).click();
		}
	
		protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues){
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		
	}
		protected void sendkeyElement(WebDriver driver, String xpathLocator, String textValue) {
		getWebElement(driver, xpathLocator).clear();
		getWebElement(driver, xpathLocator).sendKeys(textValue);
	}
		
		protected void sendkeyElement(WebDriver driver, String locatorType, String textValue, String...dynamicValues) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).clear();
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).sendKeys(textValue);
		}
		protected String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
		
		protected String getElementText(WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
		}
		
		protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
			return getWebElement(driver,locatorType).getAttribute(attributeName);
		}
		
		protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String...dynamicValues) {
			return getWebElement(driver,getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
		}
		
		protected void selectItemInDropdown (WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	
		protected String getFirstSelectedItemInDropdown (WebDriver driver, String locatorType, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
		
	}
		protected boolean isDropdownMultiple (WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
		protected boolean isDropdownMultiple (WebDriver driver, String locatorType, String...dynamicValues) {
			Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
			return select.isMultiple();
		}
		public void overrideImplicitTimeout(WebDriver driver, int Timeout) {
			driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
		}
		protected boolean isElementUndisplayed(WebDriver driver, String locator) {
			System.out.println("Start time = " + new Date().toString());
			
			overrideImplicitTimeout(driver,5 );
			List<WebElement> elements = getWebElements(driver, locator);
			
			//Nếu như mình gán =5 thì sẽ apply cho tất cả các step về sau đó khi findelement/fineElements
			overrideImplicitTimeout(driver, 30);
			
			if (elements.size() == 0) {
				// = 0 thì ko có trong Dom
				System.out.println("Element not in Dom");
				System.out.println("End time = " + new Date().toString());
				return true;
			} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
				// Nó có kích thước =1 thì có trong Dom
				// Và không được hiển thị
			System.out.println("Element in Dom but not visible/undisplayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in Dom and visible");
			return false;
		}
		
		
			
		}
		
	
		protected void selectItemInCustomDropdown (WebDriver driver, String xpathParent, String xpathChild, String expectedItem) {
		getWebElement(driver, xpathParent).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));
		for (WebElement item : allItem) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExcecutor = (JavascriptExecutor) driver;
				jsExcecutor.executeScript("argument[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
		}
		protected void selectItemInCustomDropdownByName (WebDriver driver,String xpathChild, String expectedItem, String...dynamicValue) {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicXpath(xpathChild, dynamicValue))));
			for (WebElement item : allItem) {
				if (item.getText().trim().equals(expectedItem)) {
					JavascriptExecutor jsExcecutor = (JavascriptExecutor) driver;
					//jsExcecutor.executeScript("argument[0].scrollIntoView(true);", item);
					sleepInSecond(1);
					item.click();
					break;
			
				}
	}
		}
		
		protected String getAttributeValue (WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
		
	}
		protected String getAttributeValue (WebDriver driver, String locatorType, String attributeName, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
			
		}
		protected String getAttributeText (WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
		protected String getAttributeText (WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
		}
		
		protected String getCssValue(WebDriver driver, String locatorType, String cssItemValue, String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getCssValue(cssItemValue);
	}
		protected String getHexaValueFromRGBA (WebDriver driver, String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
		protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getWebElements(driver,xpathLocator).size();
		
	}
		protected int getElementSize(WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElements(driver,getDynamicXpath(locatorType, dynamicValues)).size();
			
		}
		protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected());
		element.click();
	}
		protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType, String...dynamicValues) {
			WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
			if(!element.isSelected());
			element.click();
		}
		
		protected void uncheckToDefaultCheckBox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected());
		element.click();
	}
		protected void uncheckToDefaultCheckBox(WebDriver driver, String locatorType, String...dynamicValues) {
			WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
			if(element.isSelected());
			element.click();
		}
	
		protected boolean isControlDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
		
	}
		protected boolean isControlDisplayed(WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
			
		}
		protected boolean isControlSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
		protected boolean isControlSelected(WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
		}
		protected boolean isControlEnable(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
		protected boolean isControlEnable(WebDriver driver, String locatorType, String...dynamicValues) {
			return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
		}
	
		protected void switchToFrameIFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
		protected void switchToFrameIFrame(WebDriver driver, String locatorType, String...dynamicValues) {
			driver.switchTo().frame(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		}
	
		protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
		protected void doubleClickToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, xpathLocator)).perform();
	}
		protected void doubleClickToElement(WebDriver driver, String locatorType, String...dynamicValues) {
			Actions action = new Actions(driver);
			action.doubleClick(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
		}
	
		protected void HoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
		protected void HoverMouseToElement(WebDriver driver, String locatorType, String...dynamicValues) {
			Actions action = new Actions(driver);
			action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
		}
		
		protected Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

		protected String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

		protected boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

		public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

		protected void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

		protected void highlightElement(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
		protected void highlightElement(WebDriver driver, String locator) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			WebElement element = getWebElement(driver, locator);
			String originalStyle = element.getAttribute("style");
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
			sleepInSecond(1);
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
		}
		
		

		protected void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
		protected void clickToElementByJS(WebDriver driver, String locatorType, String...dynamicValues) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		}

		protected void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}
		protected void scrollToElement(WebDriver driver, String locatorType, String...dynamicValues) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		}

		protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}
		protected void sendkeyToElementByJS(WebDriver driver, String locatorType, String value, String...dynamicValues) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		}

		protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove, String...dynamicValues) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

		protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

		protected String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}
		protected String getElementValidationMessage(WebDriver driver, String locatorType,String...dynamicValues) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		}

		protected boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
		protected boolean isImageLoaded(WebDriver driver, String locatorType,String...dynamicValues) {
			JavascriptExecutor jsExecutor;
			jsExecutor = (JavascriptExecutor) driver;
			boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
			if (status) {
				return true;
			} else {
				return false;
			}
		}
		
		
	
		protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));
		
	}
		protected void waitForElementVisible(WebDriver driver, String locatorType,String...dynamicValues) {
			WebDriverWait explicitWait;
			explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
			
		}
		
	
		protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathLocator)));
	}
		protected void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicValues) {
			WebDriverWait explicitWait;
			explicitWait = new WebDriverWait(driver, 10);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		}
	
		protected void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
	}
		protected void waitForElementInvisible(WebDriver driver, String locatorType,String...dynamicValues) {
			WebDriverWait explicitWait;
			explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		}
		
		public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
			WebDriverWait explicitWait =  new WebDriverWait(driver, 30);
			overrideImplicitTimeout(driver, 5);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
			overrideImplicitTimeout(driver, 30);
		}
		
		protected void waitForAllElementInvisible(WebDriver driver, String locatorType) {
			WebDriverWait explicitWait =  new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, locatorType)));
		}
		
		public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
			clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
			return PageGeneratorManager.getCustomerInfoPage(driver);
		}
		public AddressPageObject openAddressPage (WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.ADDRESSES_LINK);
			clickToElement(driver, BasePageUI.ADDRESSES_LINK);
			return PageGeneratorManager.getAddressesPage(driver);
		}
		
		public  OrdersPageObject openOrdersPage (WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.ORDERS_LINK);
			clickToElement(driver, BasePageUI.ORDERS_LINK);
			return PageGeneratorManager.getOrdersPage(driver);
		}
		public DownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
			clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
			return PageGeneratorManager.getDownloadableProductsPage(driver);
		}
		public BackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
			clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
			return PageGeneratorManager.getBackInStockSubscriptionsPage(driver);
			
		}
		public RewardPointsPageObject openRewardPointsPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.REWARD_POINTS_LINK);
			clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
			return PageGeneratorManager.getRewardPointsPage(driver);
		}
		public ChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
			clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
			return PageGeneratorManager.getChangePasswordPage(driver);
		}
		public MyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEWS);
			clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS);
			return PageGeneratorManager.getMyProductReviewsPage(driver);
		}
		
		protected SearchPageObject openSearchPage (WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.SEARCH_LINK);
			clickToElement(driver, BasePageUI.SEARCH_LINK);
			return PageGeneratorManager.getSearchPage(driver);
		}
		//Tối ưu ở bài Topic09_DynamicLocator
		//Case này trả về 4 lần return nên để là BasePage do nó đều được kế thừa BasePage
		//Cach này dùng khi có nhiều page ( 10 15..pages)
		public BasePage openPageAtMyAccountByName (WebDriver driver, String pageName) {
			waitForElementClickable(driver, BasePageUI.DYNAMIC_LINK_AT_MY_ACCOUNT_ARE, pageName);
			clickToElementByJS(driver, BasePageUI.DYNAMIC_LINK_AT_MY_ACCOUNT_ARE, pageName);
			switch(pageName) {
			case "Customer info":
				return PageGeneratorManager.getCustomerInfoPage(driver);
			case "Addresses":
				return PageGeneratorManager.getAddressesPage(driver);
			case "My product reviews":
				return PageGeneratorManager.getMyProductReviewsPage(driver);
			case "Reward point":
				return PageGeneratorManager.getRewardPointsPage(driver);
				default:
					throw new RuntimeException("Invalid page name at My Account area");
					
			}
		}
		//Cach nay dung khi co it page hon
		//Trong du an chi dung 1 trong 2 cach
		public void openPageAtMyAccountByPageName (WebDriver driver, String pageName) {
			waitForElementClickable(driver,BasePageUI.DYNAMIC_LINK_AT_MY_ACCOUNT_ARE, pageName);
			clickToElement(driver, BasePageUI.DYNAMIC_LINK_AT_MY_ACCOUNT_ARE, pageName);
		}
		
		public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
			//Đường dẫn của thư mục upload file
			//Chạy được cho cả win/mac/linux
			String filePath = GlobalConstants.UPLOAD_FILE;
			//String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
			//Đường dẫn của tất cả các file
			//1 file: java.png
			//Trường hợp nhiều file: String[] fileNames = {"Csharp.png, "Java.png", "Python.png"};
			String fullFileName = "";
			for(String file:fileNames) {
				fullFileName = fullFileName + filePath + file + "\n";
			}
			//Hàm trim để xóa kí tự khoảng trắng/tab/xuống dòng ở đầu hoặc cuối chuỗi
			fullFileName = fullFileName.trim();
			getWebElement(driver, BasePageJqueryUI.UPLOAD_FILE).sendKeys(fullFileName);
			
		}
			protected boolean isElementDisplayed(WebDriver driver, String locator) {
				return getWebElement(driver, locator).isDisplayed();
			}
			
			protected boolean isElementDisplayed(WebDriver driver, String locatorType, String...dynamicValues) {
				return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
			}
			/**Enter to dynamic Textbox by ID
			 * @author Nam Phuong
			 * @param driver
			 * @param textboxID
			 * @param value
			 * @return
			 */
			public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
				waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
				sendkeyElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);	
			}
			
			
			/**
			 * Select item in dropdown by Name attribute
			 * @param driver
			 * @param dropdownAttributeName
			 * @author Nam Phuong
			 */
			public void selectDropDownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
				waitForElementClickable(driver,BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
				selectItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
			}
			
			public void checkToRadioByLabel(WebDriver driver, String labelValue) {
				waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BY_LABEL, labelValue);
				checkToDefaultCheckBoxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BY_LABEL, labelValue);
			}

			public void checkToCheckboxByLabel(WebDriver driver, String labelValue) {
				waitForElementClickable(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelValue);	
				checkToDefaultCheckBoxOrRadio(driver, BasePageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelValue);
			}
			
			/**
			 * Get Value in textbox by textbox ID
			 * @param driver
			 * @param textboxID
			 * @return
			 */
			public String getTextboxValueByID(WebDriver driver, String textboxID) {
				waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
				return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID,"value", textboxID);
				
			}
	
		protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
		public boolean isPageLoadedSuccess(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
				}
			};

			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
				}
			};
			return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		}
		//NopCommerce Live Coding
		
		protected void clearTextboxByDeleteKeyboardButton(WebDriver driver, String locatorType, String...dynamicValues) {
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).sendKeys(Keys.DELETE);
		}
		/**Clear Text Box By Delete Key and ID Value
		 * @param driver
		 * @param dynamicValues
		 */
		public void clearTextboxByID(WebDriver driver,String...dynamicValues) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID, dynamicValues);
			clearTextboxByDeleteKeyboardButton(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID, dynamicValues);
		}
		public Object getElementAttributeValueByID(WebDriver driver,String textboxID, String attributeName) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID, textboxID);		
			return getElementAttribute(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID,attributeName, textboxID);
		}
		
		/**Click To Link By Text
		 * @param driver
		 * @param textValue
		 */
		public void clickToLinkByText(WebDriver driver, String textValue) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT, textValue);
			clickToElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT, textValue);
		}
		public void clickToLinkBySpanText(WebDriver driver, String textValue) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_SPAN_TEXT, textValue);
			clickToElementByJS(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_SPAN_TEXT, textValue);
		}
		
		public void clickToLinkByClass(WebDriver driver, String classValue) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_CLASS, classValue);
			clickToElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_CLASS, classValue);
		}
		
		/**Check Link is Displayed
		 * @param driver
		 * @param textValue
		 * @return
		 */
		public boolean checkLinkDisplayedByText(WebDriver driver, String textValue) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT, textValue);
			return isElementDisplayed(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT, textValue);
			
		}
		/**Click To Button By Text
		 * @param driver
		 * @param textValue
		 */
		public void clickToButtonByText(WebDriver driver, String textValue ) {
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_BUTTON_BY_TEXT,textValue);
			clickToElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_BUTTON_BY_TEXT,textValue,textValue);
		}
		
		/**Click To Button By ID
		 * @param driver
		 * @param idValue
		 */
		public void clickToButtonByID(WebDriver driver, String idValue) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_BUTTON_BY_ID, idValue);
			clickToElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_BUTTON_BY_ID, idValue);
		}
		
		/**Get Error Message By ID
		 * @param driver
		 * @param idValue
		 * @return
		 */
		public String getErrorMessageByID(WebDriver driver, String idValue) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_GET_ERROR_MESSAGE_BY_ID, idValue);
			return getElementText(driver, BasePageUI.LIVE_CODING_DYNAMIC_GET_ERROR_MESSAGE_BY_ID, idValue).trim();
		}
		
		/**Get Message Displayed By Class
		 * @param driver
		 * @param idValue
		 * @return
		 */
		/**
		 * @param driver
		 * @param idValue
		 * @return
		 */
		public String getMessageByClass(WebDriver driver, String idValue) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_GET_MESSAGE_BY_CLASS, idValue);
			return getElementText(driver, BasePageUI.LIVE_CODING_DYNAMIC_GET_MESSAGE_BY_CLASS, idValue).trim();
		}
		
		public Object getSuccessMessageByClass(WebDriver driver, String value) {
			waitForElementVisible(driver,BasePageUI.LIVE_CODING_DYNAMIC_GET_SUCCESS_MESSAGE_BY_CLASS,value);
			return getElementText(driver, BasePageUI.LIVE_CODING_DYNAMIC_GET_SUCCESS_MESSAGE_BY_CLASS,value);
		}
		public void clickToCloseButtonAtMessage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_CLOSE_ICON_AT_SUCCESS_MESSAGE);
			clickToElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_CLOSE_ICON_AT_SUCCESS_MESSAGE);
		}
			
		/**Get Information Text By Class
		 * @param driver
		 * @param Value
		 * @return
		 */
		public String getInformationByClass(WebDriver driver, String value) {
			waitForElementVisible(driver,BasePageUI.LIVE_CODING_DYNAMIC_GET_INFORMATION_BY_CLASS,value);
			return getElementText(driver,BasePageUI.LIVE_CODING_DYNAMIC_GET_INFORMATION_BY_CLASS,value);
		}

		
		/**Input To Textbox By ID
		 * @param driver
		 * @param idValue
		 * @param textValue
		 */
		public void enterToTextboxByID(WebDriver driver,String idValue, String textValue) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID, idValue);
			sendkeyElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_TEXT_BOX_BY_ID,textValue, idValue);
			
		}
		/**Check To Radio By ID
		 * @param driver
		 * @param idValue
		 */
		public void checkToRadioByID(WebDriver driver, String idValue) {
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_RADIO_BY_ID ,idValue);
			checkToDefaultCheckBoxOrRadio(driver,BasePageUI.LIVE_CODING_DYNAMIC_RADIO_BY_ID ,idValue);
		}
		/**Check To Checkbox By ID
		 * @param driver
		 * @param idValue
		 */
		public void checkToCheckboxByID(WebDriver driver, String idValue) {
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_RADIO_BY_ID ,idValue);
			checkToDefaultCheckBoxOrRadio(driver,BasePageUI.LIVE_CODING_DYNAMIC_RADIO_BY_ID ,idValue);
		}

		
		/**Select From  Dropdown By Name
		 * @param driver
		 * @param day
		 * @param dayValue
		 * @param month
		 * @param monthValue
		 * @param year
		 * @param yearValue
		 */
		public void selectDropdownByName(WebDriver driver, String day,String dayValue,String month, String monthValue, String year, String yearValue) {
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,day);
			clickToElement(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,day);
			selectItemInCustomDropdownByName(driver,BasePageUI.LIVE_CODING_DYNAMIC_SELECT_FROM_DROPDOWN,dayValue,day);
			
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,month);
			clickToElement(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,month);
			selectItemInCustomDropdownByName(driver,BasePageUI.LIVE_CODING_DYNAMIC_SELECT_FROM_DROPDOWN,monthValue,month);
			
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,year);
			clickToElement(driver,BasePageUI.LIVE_CODING_DYNAMIC_DROPDOWN_BY_NAME,year);
			selectItemInCustomDropdownByName(driver,BasePageUI.LIVE_CODING_DYNAMIC_SELECT_FROM_DROPDOWN,yearValue,year);
		}
		/**Select Default Dropdown By ID
		 * @param driver
		 * @param idValue
		 * @param expectedValue
		 */
		public void selectDefaultDropdownByID(WebDriver driver, String idValue, String expectedValue) {
			waitForElementClickable(driver,BasePageUI.LIVE_CODING_DYNAMIC_DEFAULT_DROPDOWN_BY_ID,idValue);
			selectItemInDropdown(driver, BasePageUI.LIVE_CODING_DYNAMIC_DEFAULT_DROPDOWN_BY_ID,expectedValue,idValue);
			sleepInSecond(2);
		}
		/**Click To Button By JSExcutor
		 * @param driver
		 * @param textValue
		 */
		public void clickToButtonByJS(WebDriver driver, String textValue) {
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT,textValue);
			clickToElementByJS(driver,BasePageUI.LIVE_CODING_DYNAMIC_LINK_BY_TEXT,textValue);
		}
		/**Input To Text Area By ID
		 * @param driver
		 * @param idValue
		 * @param textValue
		 */
		public void inputToTextAreaByID(WebDriver driver,String idValue, String textValue) {
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_COMMEND_TEXT_BOX_BY_ID, idValue);
			sendkeyElement(driver, BasePageUI.LIVE_CODING_DYNAMIC_COMMEND_TEXT_BOX_BY_ID,textValue, idValue);
		}
		
		/**Get Value Displayed At Table
		 * @param driver
		 * @param tableClass
		 * @param headerName
		 * @param rowIndex
		 * @return
		 */
		public Object getValueDisplayedInTableClassAtColumnNameAndRowIndex(WebDriver driver, String tableClass, String headerName,String rowIndex) {
			int columnIndex = getElementSize(driver, BasePageUI.LIVE_CODING_DYNAMIC_HEADER_BY_ID_AND_TEXT_NAME, tableClass,headerName)+1;		
			waitForElementVisible(driver, BasePageUI.LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableClass,rowIndex,String.valueOf(columnIndex));
			return getElementText(driver, BasePageUI.LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableClass,rowIndex,String.valueOf(columnIndex));
		}
		
		/**Click To Check Box Add To Cart At Table
		 * @param driver
		 * @param tableClass
		 * @param headerName
		 * @param rowIndex
		 */
		public void clickToAddToCartCheckBoxInTableClassAtColumnNameAndRowIndex(WebDriver driver, String tableClass, String headerName,String rowIndex) {
			int columnIndex = getElementSize(driver, BasePageUI.LIVE_CODING_DYNAMIC_HEADER_BY_ID_AND_TEXT_NAME, tableClass,headerName)+1;		
			waitForElementClickable(driver, BasePageUI.LIVE_CODING_DYNAMIC_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableClass,rowIndex,String.valueOf(columnIndex));
			checkToDefaultCheckBoxOrRadio(driver, BasePageUI.LIVE_CODING_DYNAMIC_CHECK_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX, tableClass,rowIndex,String.valueOf(columnIndex));
		}
		
		/**Sort By Ascending
		 * @param driver
		 * @param locatorType
		 * @param dynamicValues
		 * @return
		 */
		public boolean isProductPriceSortByAscendingByLambda(WebDriver driver,String locatorType, String...dynamicValues) {
			List<WebElement> elementList =	getWebElements(driver, getDynamicXpath(locatorType, dynamicValues));
			List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
			List<String> sortedName = new ArrayList<String>(names);
			Collections.sort(sortedName);
			return names.equals(sortedName);
			
		}
		/**Sort By Descending
		 * @param driver
		 * @param locatorType
		 * @param dynamicValues
		 * @return
		 */
		public boolean isProductPriceSortByDescendingByLambda(WebDriver driver,String locatorType, String...dynamicValues) {
			List<WebElement> elementList =	getWebElements(driver,getDynamicXpath(locatorType, dynamicValues));
			List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
			List<String> sortedName = new ArrayList<String>(names);
			Collections.sort(sortedName);
			Collections.reverse(sortedName);
			return names.equals(sortedName);
		}
}	


	



		
	
	
	
	
	
	
	

