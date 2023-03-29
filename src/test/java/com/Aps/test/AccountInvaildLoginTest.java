package com.Aps.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aps.confic.DiverManager;
import com.Aps.steps.LoginPageSteps;
import com.Aps.utils.Log;
import com.Aps.utils.ScreenshotUtil;

import io.qameta.allure.Description;

public class AccountInvaildLoginTest extends TestBase {
	@Test(dataProvider = "testData", testName = "Account Invaild Login Test", description = "Account Login")
	@Description("Test Description: To Invalidate login feature")
	public void LoginTest(Map<String, String> map) throws Exception {
		WebDriver driver = DiverManager.getInstance().getDriver();
		Log.info("Test Data: \n" + map);
		LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
		loginPageSteps.enterLoginDetails(map.get("email"), map.get("password"));
		ScreenshotUtil.takeScreenShot(map.get("Test_Case"));
		loginPageSteps.clickLoginButton();
		loginPageSteps.verifyErrorMessage(map.get("message"));
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws Exception {
		return getTestData(this.getClass().getSimpleName());
	}

	
	
}
