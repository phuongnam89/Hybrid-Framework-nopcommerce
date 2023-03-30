package PageObjectsNewTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUisNewTest.CellPhonesPageUI;
import commons.BasePage;

public class CellPhonesPO	extends BasePage {
WebDriver driver;
public CellPhonesPO(WebDriver driver) {
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
				List<WebElement> productPriceText = getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
				
				//Dung vong lap de getText va add vao ArrayList
				for (WebElement productPrice : productPriceText) {
					String priceText = productPrice.getText();
					
					//xóa kí tự $ đi
					priceText.replace("$", "");
					
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
					productUIList.add(productName);
					System.out.println("Product Name Sau Khi Sort Ascending:"+productName);
				}
				
				return productSortList.equals(productUIList);
}

				public boolean isProductPriceSortByDescending() {
				//khai bao ra 1 arraylist de chua cac ten san pham tren UI
				//Price nen chuyen sang dang Float
				ArrayList<Float> productUIList = new ArrayList<Float>();
			
			//Lay ra het tat ca cac ten san pham dang co tren UI
			List<WebElement> productPriceText = getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
			
			//Dung vong lap de getText va add vao ArrayList
			for (WebElement productPrice : productPriceText) {
				String priceText = productPrice.getText();
				
				//xóa kí tự $ đi
				priceText.replace("$", "");
				
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
				productUIList.add(productName);
				System.out.println("Product Name Sau Khi Sort Ascending:"+productName);
			}
			//Reverse cai productSortList ( dao nguoc lai list)
			Collections.reverse(productSortList);
			for (Float productName : productSortList) {
				productUIList.add(productName);
				System.out.println("Product Name Sau Khi Reverse(Descending):"+productName);
			}
			return productSortList.equals(productUIList);
			
}
				public boolean isProductPriceSortByAscendingByLambda() {
					List<WebElement> elementList =	getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
					List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
					List<String> sortedName = new ArrayList<String>(names);
					Collections.sort(sortedName);
					return names.equals(sortedName);
					
				}
				public boolean isProductPriceSortByDescendingByLambda() {
					List<WebElement> elementList =	getWebElements(driver, CellPhonesPageUI.PRODUCT_NAME_LIST);
					List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
					List<String> sortedName = new ArrayList<String>(names);
					Collections.sort(sortedName);
					Collections.reverse(sortedName);
					return names.equals(sortedName);
					
				}
				
				


}
