package PageUIs;

import commons.BasePage;

public class ChangePasswordPageUI extends BasePage {

	public static final String CHANGE_PASSWORD_BUTTON = "//a[text()='Change password']";
	public static final String OLD_PASSWORD_TEXTBOX = "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD_TEXTBOX = "//input[@id='NewPassword']";
	public static final String CONFIRM_NEW_PASSWORD_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	public static final String SAVE_CHANGED_PASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";
	public static final String PASSWORD_CHANGED_SUCCESS_MESSAGE = "//p[@class='content']";
	public static final String CLOSE_CHANGED_SUCCESS_MESSAGE_BUTTON = "//span[@class='close']";
}
