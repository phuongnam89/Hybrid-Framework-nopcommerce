package pageUiIs.jQuery.uploadFile;

import commons.BasePage;

public class HomePageUI extends BasePage {
	public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
	public static final String FILE_NAME_UPLOADED_LINK = "xpath=//a[text()='%s']";
	public static final String FILE_NAME_UPLOADED_IMAGE = "xpath=//td//a[@title='%s']/img";
	public static final String START_BUTTON = "xpath=//table//button[@class='btn btn-primary start']";


}
