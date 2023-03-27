package PageUIs;
import commons.BasePage;
public class SearchPageUI extends BasePage {
	
	public static final String SEARCH_LINK = "//a[text()='Search']";
	public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
	public static final String SEARCH_TEXTBOX = "//input[@class='search-text']";
	public static final String ERROR_EMPTY_DATA_MESSAGE= "//div[@class='warning']";
	
	public static final String THINKPAD_MESSAGE = "//a[text()='Lenovo Thinkpad X1 Carbon Laptop']";
	public static final String NO_RESULT_MESSAGE = "//div[@class='no-result']";
	public static final String ADVANCE_SEARCH_CHECKBOX = "//input[@data-val-required='The Advanced search field is required.']";
	public static final String MANUFACTURER_DROPDOWN = "//select[@data-val-required='The Manufacturer field is required.']";
	public static final String CATEGORY_DROPDOWN = "//select[@data-val-required='The Category field is required.']";
	public static final String AUTOMATIC_SEARCH_CHECKBOX = "//input[@data-val-required='The Automatically search sub categories field is required.']";
	public static final String MACBOOK_RESULT_MESSAGE = "//a[text()='Apple MacBook Pro 13-inch']";
}
