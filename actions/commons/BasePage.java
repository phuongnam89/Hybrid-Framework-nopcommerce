package commons;


import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
		
	}
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
			return driver.findElement(getByXpath(xpathLocator));
		}
		
	private List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	protected void clearTextInTextbox(WebDriver driver, String xpathLocator) {
		waitForElementVisible(driver, xpathLocator);
		getWebElement(driver, xpathLocator).clear();
	}
	protected void selectFromDropdown(WebDriver driver,String xpathLocator, String textValue) {
		waitForElementVisible(driver, xpathLocator);
		new Select(getWebElement(driver, xpathLocator)).selectByVisibleText(textValue); 
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
	
		protected void backtoPage(WebDriver driver) {
		driver.navigate().back();
	}
		protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
		protected void refreshCurrentPage(WebDriver driver) {
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
	
	
		protected void clickToElement(WebDriver driver, String xpathLocator){
		getWebElement(driver, xpathLocator).click();
		
	}
		protected void sendkeyElement(WebDriver driver, String xpathLocator, String textValue) {
		getWebElement(driver, xpathLocator).clear();
		getWebElement(driver, xpathLocator).sendKeys(textValue);
	}
		protected String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	
	}
	
		protected void selectItemInDropdown (WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
		protected String getFristSelectedItemInDropdown (WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
		
	}
		protected boolean isDropdownMultiple (WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
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
		protected String getAttributeValue (WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
		
	}
		protected String getAttributeText (WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
		protected String getCssValue(WebDriver driver, String XpathLocator, String cssItemValue) {
		return getWebElement(driver, XpathLocator).getCssValue(cssItemValue);
	}
		protected String getHexaValueFromRGBA (WebDriver driver, String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
		protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getWebElements(driver,xpathLocator).size();
		
	}
		protected void checkTheCheckBoxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected());
		element.click();
	}
	
		protected void uncheckToCheckBox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected());
		element.click();
	}
	
		protected boolean isControlDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
		
	}
		protected boolean isControlSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
		protected boolean isControlEnable(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
		protected void switchToFrameIFrame(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
		protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
		protected void doubleClickToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, xpathLocator)).perform();
	}
	
		protected void HoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
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

		protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

		protected void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
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

		protected void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

		protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

		protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
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
	
		protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
		
	}
	
		protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
		protected void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
			
		
	
	
	
	
	
	
		protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
}




		
	
	
	
	
	
	
	

