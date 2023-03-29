package com.Aps.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Aps.confic.DiverManager;
import com.Aps.steps.Download_Client_Csv_steps;
import com.Aps.steps.LoginPageSteps;
import com.Aps.utils.Log;
import com.Aps.utils.ScreenshotUtil;

import io.qameta.allure.Description;

public class DownloadClientCSV extends TestBase {
	@Test(dataProvider = "testData", testName = "Download Client CSV", description = "CSV file")
	@Description("Test Description: To Download Client CSV File")
	public void downloadcsv(Map<String, String> map) {
		WebDriver driver = DiverManager.getInstance().getDriver();
		Log.info("Test Data: \n" + map);
		Download_Client_Csv_steps Client = new Download_Client_Csv_steps(driver);
		new LoginPageSteps(driver).login(map.get("email"), map.get("password"));
		ScreenshotUtil.takeScreenShot(map.get("Test_Case"));

		Client.Click_Admin_Btn();
		Client.clickImport();
		Client.Download_sample_CSV();
		ScreenshotUtil.takeScreenShot(map.get("Test_Case"));
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws Exception {
		return getTestData(this.getClass().getSimpleName());
	}
}
