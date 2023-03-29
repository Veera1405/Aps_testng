package com.Aps.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.Aps.confic.DiverManager;
import com.Aps.confic.Globalvariables;
import com.Aps.reports.ReportManager;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtil implements Globalvariables {
	private static final Logger log = LogManager.getLogger(ScreenshotUtil.class);

	public static String takeScreenShot(String testCaseName) {
		// Take screenshot and store as a file format
		String screenShotFilePath = SCREENSHOT_FOLDER + testCaseName + DateUtil.getStringDate("_ddMMyyyy_HHmmss")
				+ IMAGE_TYPE;
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(DiverManager.getInstance().getDriver());
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(screenShotFilePath));
		} catch (IOException exp) {
			log.error("Exception occured while taking ScreenShot: ", exp);
		}
		return screenShotFilePath;
	}

	public static void attachScreenshotToReport(ITestResult result, Status status) {
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) DiverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
		// ExtentReports log and screenshot operations for failed tests.
		ReportManager.getTest().log(status, result.getMethod().getMethodName() + " " + FAIL, result.getThrowable(),
				ReportManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia()
						.get(0));
	}

	@Attachment(value = "{0}", type = "image/png")
	public static byte[] attachImageToAllure(String testName) {
		return ((TakesScreenshot) DiverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
	}

}
