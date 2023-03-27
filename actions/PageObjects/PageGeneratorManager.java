package PageObjects;

import org.openqa.selenium.WebDriver;

import PageObjectsJQuery.JQHomePageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
	return new HomePageObject(driver);
}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static CustomerInfoPageObject getMyAccountPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	//public static RegisterPage getRegisterPage(WebDriver driver) {
		//return new RegisterPage(driver);
	//}
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	public static CustomerInfoPageObject getCustomerInfoPage (WebDriver driver) {
		return new CustomerInfoPageObject(driver);
		
	}
	public static AddressPageObject getAddressesPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	public static BackInStockSubscriptionsPageObject getBackInStockSubscriptionsPage(WebDriver driver) {
		return new BackInStockSubscriptionsPageObject(driver);
	}
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
		public static DownloadableProductsPageObject getDownloadableProductsPage(WebDriver driver) {
			return new DownloadableProductsPageObject(driver);
		}
		public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
			return new MyProductReviewsPageObject(driver);
			
		}
		public static OrdersPageObject getOrdersPage(WebDriver driver) {
			return new OrdersPageObject(driver);
		}
		public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
			return new RewardPointsPageObject(driver);
		}
		
		
			
					
		
}

