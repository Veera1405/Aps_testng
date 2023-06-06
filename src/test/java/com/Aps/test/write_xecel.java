package com.Aps.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Aps.confic.DiverManager;

public class write_xecel extends TestBase {
	@Test
	public void name() {
		WebDriver driver = DiverManager.getInstance().getDriver();

		// Open Google search page
		driver.get("https://www.google.com");

		// Search for a specific keyword
		String keyword = "computer";
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(keyword);
		searchBox.submit();

		// Retrieve search results
		List<WebElement> searchResults = driver.findElements(By.xpath("//body[@class='srp EIlDfe']"));

		// Create a new Excel workbook and sheet
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Google Search Results");

		// Write search results to Excel sheet
		for (int i = 0; i < searchResults.size(); i++) {
			String title = searchResults.get(i).getText();
			String link = searchResults.get(i).getAttribute("href");

			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(title);
			row.createCell(1).setCellValue(link);
		}

		// Auto-size columns for better readability
		for (int i = 0; i < 10; i++) {
			sheet.autoSizeColumn(i);
		}

		// Save the workbook to a file
		try {
			FileOutputStream fileOut = new FileOutputStream("GoogleSearchResults.xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

			System.out.println("Google search results saved to GoogleSearchResults.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the browser
		driver.quit();
	}
}
