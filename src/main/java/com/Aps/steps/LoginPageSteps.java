package com.Aps.steps;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.Aps.pages.LoginPage;

import io.qameta.allure.Step;

public class LoginPageSteps {

	private Logger log = LogManager.getLogger(this.getClass().getName());
	private LoginPage loginPage;

	public LoginPageSteps(WebDriver driver) {
		this.loginPage = new LoginPage(driver);
	}

	@Step("Enter login credentials: {0} | {1}")
	public void enterLoginDetails(String email, String password) {
		log.info("Entering login details");
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
	}

	@Step("Click on Login button")
	public void clickLoginButton() {
		loginPage.clickLoginButton();
	}

	@Step("Verifying the error message for invalid credentials")
	public void verifyErrorMessage(String errorMessage) {
		loginPage.getErrorMessage(errorMessage);
		log.info("Displayed Error Message: " + errorMessage);
	}

	@Step("Login into the shop with credentials: {0}/{1}")
	public void login(String email, String password) {
		enterLoginDetails(email, password);
		clickLoginButton();
		assertTrue(loginPage.isUserEmailDisplayed(email), "User login failed");
	}
}
