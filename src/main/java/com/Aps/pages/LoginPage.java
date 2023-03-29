package com.Aps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	private WebElement emailTextbox;

	@FindBy(id = "password")
	private WebElement passwordTextbox;

	@FindBy(css = "button[type='submit'] span")
	private WebElement loginButton;

	@FindBy(className = "ngb-toasts")
	private WebElement errorMessageText;

	private static final String USER_EMAIL_XPATH = "//input[@id='email']";

	public void enterEmail(String email) {
		clearAndEnterText(emailTextbox, email);
	}

	public void enterPassword(String password) {
		clearAndEnterText(passwordTextbox, password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getErrorMessage(String errorMessage) {

		return Toastmassege(errorMessageText, errorMessage);
	}

	public boolean isUserEmailDisplayed(String email) {
		return isElementDisplayed(By.xpath(String.format(USER_EMAIL_XPATH, email)));
	}
}
