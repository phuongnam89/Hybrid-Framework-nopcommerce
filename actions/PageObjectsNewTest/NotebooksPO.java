package PageObjectsNewTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUisNewTest.CellPhonesPageUI;
import PageUisNewTest.NotebooksPageUI;
import commons.BasePage;

public class NotebooksPO	extends BasePage {
WebDriver driver;
public NotebooksPO(WebDriver driver) {
	this.driver = driver;
	}
public boolean isProductNameSortByAscending() {
	//khai bao ra 1 arraylist de chua cac ten san pham tren UI
	ArrayList<String> productUIList = new ArrayList<String>();
	
	//Lay ra het tat ca cac ten san pham dang co tren UI
	List<WebElement> productNameText = getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
	
	//Dung vong lap de getText va add vao ArrayList
	for (WebElement productName : productNameText) {
		productUIList.add(productName.getText());
		System.out.println("Product Name ở trên UI:"+productName.getText());
	}
	//Tao ra 1 Array List moi de sort du lieu
	ArrayList<String> productSortList = new ArrayList<String>();
	for (String product : productUIList) {
		productSortList.add(product);	
	}
	//Sort cai productSortList
	Collections.sort(productSortList);
	for (String productName:productSortList) {
		System.out.println("Product Name Sau khi Sort:"+productName);
	}
	//So Sanh 2 list da bang nhau
	return productSortList.equals(productUIList);
}
public boolean isProductNameSortByDescending() {
		//khai bao ra 1 arraylist de chua cac ten san pham tren UI
		ArrayList<String> productUIList = new ArrayList<String>();
		
		//Lay ra het tat ca cac ten san pham dang co tren UI
		List<WebElement> productNameText = getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
		
		//Dung vong lap de getText va add vao ArrayList
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
			System.out.println("Product Name ở trên UI:"+productName.getText());

		}
		//Tao ra 1 Array List moi de sort du lieu
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);	
		}
		//Sort cai productSortList
		Collections.sort(productSortList);
		
		for (String productName : productSortList) {		
			System.out.println("Product Name Sau Khi Sort Ascending:"+productName);
		}
		//Reverse cai productSortList ( dao nguoc lai list)
		Collections.reverse(productSortList);
		
		for (String productName : productSortList) {		
			System.out.println("Product Name Sau Khi Reverse(Descending):"+productName);
		}
		return productSortList.equals(productUIList);
}


			public boolean isProductPriceSortByAscending() {
			//khai bao ra 1 arraylist de chua cac ten san pham tren UI
			//Price nen chuyen sang dang Float
				ArrayList<Float> productUIList = new ArrayList<Float>();
				
				//Lay ra het tat ca cac ten san pham dang co tren UI
				List<WebElement> productPriceText = getWebElements(driver, CellPhonesPageUI.PRODUCT_PRICE_LIST);
				
				//Dung vong lap de getText va add vao ArrayList
				for (WebElement productPrice : productPriceText) {
					String priceText = productPrice.getText();
					
					//xóa kí tự $ đi
					priceText = priceText.replace("$", "");
					
					//Convert String sang kieu Float
					Float priceTextFloat = Float.parseFloat(priceText);
										
					productUIList.add(priceTextFloat);
					System.out.println("Product Name ở trên UI:"+priceTextFloat);

				}
				//Tao ra 1 Array List moi de sort du lieu
				ArrayList<Float> productSortList = new ArrayList<Float>();
				for (Float product : productUIList) {
					productSortList.add(product);	
				}
				//Sort cai productSortList
				Collections.sort(productSortList);
				for (Float productName : productSortList) {				
					System.out.println("Product Name Sau Khi Sort Ascending:"+productName);
				}
				
				return productSortList.equals(productUIList);
}

				public boolean isProductPriceSortByDescending() {
				//khai bao ra 1 arraylist de chua cac ten san pham tren UI
				//Price nen chuyen sang dang Float
				ArrayList<Float> productUIList = new ArrayList<Float>();
			
			//Lay ra het tat ca cac ten san pham dang co tren UI
			List<WebElement> productPriceText = getWebElements(driver, CellPhonesPageUI.PRODUCT_PRICE_LIST);
			
			//Dung vong lap de getText va add vao ArrayList
			for (WebElement productPrice : productPriceText) {
				String priceText = productPrice.getText();
				
				//xóa kí tự $ đi
				priceText = priceText.replace("$","");
				
				//Convert String sang kieu Float
				Float priceTextFloat = Float.parseFloat(priceText);
				
				
				productUIList.add(priceTextFloat);
				System.out.println("Product Name ở trên UI:"+priceTextFloat);

			}
			//Tao ra 1 Array List moi de sort du lieu
			ArrayList<Float> productSortList = new ArrayList<Float>();
			for (Float product : productUIList) {
				productSortList.add(product);	
			}
			//Sort cai productSortList
			Collections.sort(productSortList);
			for (Float productName : productSortList) {				
				System.out.println("Product Name Sau Khi Sort Ascending:"+productName);
			}
			//Reverse cai productSortList ( dao nguoc lai list)
			Collections.reverse(productSortList);
			for (Float productName : productSortList) {
				System.out.println("Product Name Sau Khi Reverse(Descending):"+productName);
			}
			return productSortList.equals(productUIList);
			
}
				public boolean isProductNameSortByAscendingByLambda() {
					List<WebElement> elementList =	getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
					List<String> names = elementList.stream().map(n -> n.getText().replace("$","")).collect(Collectors.toList());
					List<String> sortedName = new ArrayList<String>(names);
					Collections.sort(sortedName);
					return names.equals(sortedName);
					
				}
				public boolean isProductNameSortByDescendingByLambda() {
					List<WebElement> elementList =	getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
					List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
					List<String> sortedName = new ArrayList<String>(names);
					Collections.sort(sortedName);
					Collections.reverse(sortedName);
					return names.equals(sortedName);
					
				}
				
				
				public boolean isThreeProductsDislayedPerPage() {					
					int size = getElementSize(driver, NotebooksPageUI.PRODUCT_LIST);		
						if (size <= 3) {			
						}
						return true;
				}
				
				public boolean isSixProductsDislayedPerPage() {					
							int size = getElementSize(driver, NotebooksPageUI.PRODUCT_LIST);		
								if (size <= 6) {			
								}
								return true;
			
				}
				public boolean isNextPageIconDisplayed() {
					waitForElementVisible(driver, NotebooksPageUI.NEXT_PAGE_ICON);				
					return isControlDisplayed(driver, NotebooksPageUI.NEXT_PAGE_ICON);
				}
				
				public boolean isNextPageIconUnDisplayed() {
					waitForElementInvisible(driver, NotebooksPageUI.NEXT_PAGE_ICON);				
					return isElementUndisplayed(driver, NotebooksPageUI.NEXT_PAGE_ICON);
				}


}
