package PageObjectsNewTest;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
WebDriver driver;
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);		
	}
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
}
	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		return new MyAccountPO(driver);
	}	
		public static WishlistPO getWishlistPage(WebDriver driver) {
			return new WishlistPO(driver);
	
	}
		public static ShoppingCartPO getShoppingCartPage(WebDriver driver) {
			return new ShoppingCartPO(driver);
	
	}
		public static ElectronicsPO getElectronicsPage(WebDriver driver) {
			return new ElectronicsPO(driver);
	
	}
		public static CellPhonesPO getCellPhonesPage(WebDriver driver) {
			return new CellPhonesPO(driver);
	
	}
		public static ComputersPO getComputersPage(WebDriver driver) {
			return new ComputersPO(driver);
}
		public static NotebooksPO getNotebooksPage(WebDriver driver) {
			return new NotebooksPO(driver);
		}
		public static CompareProductsPO getCompareProductsPage(WebDriver driver) {
			return new CompareProductsPO(driver);
		}
		public static RecentlyViewedProductsPO getRecentlyViewedProductsPage(WebDriver driver) {
			return new RecentlyViewedProductsPO(driver);
		}		
}
