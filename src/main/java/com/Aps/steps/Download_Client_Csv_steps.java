package com.Aps.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.Aps.pages.Clientspage;

import io.qameta.allure.Step;

public class Download_Client_Csv_steps {

	private Logger log = LogManager.getLogger(this.getClass().getName());
	private Clientspage Clientspage;

	public Download_Client_Csv_steps(WebDriver driver) {
		this.Clientspage = new Clientspage(driver);
	}

	@Step("Click on Click Admin Btn")
	public void Click_Admin_Btn() {
		log.info("Click on Click Admin Btn");

		Clientspage.Click_Admin_Btn();

	}

	@Step("Click on Import")
	public void clickImport() {
		log.info("Click on Import");
		Clientspage.Import();

	}

	@Step("Click on Download sample CSV")
	public void Download_sample_CSV() {

		log.info("Click on Download sample CSV");
		Clientspage.sample_file();

	}

}
