package com.Aps.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TEST {
	static WebDriver driver;

	public static void main(String[] args) {

		try {
			ChromeOptions opt = new ChromeOptions();
			// opt.addArguments("--disable-notifications");
			// opt.addArguments("--headless");
			opt.addArguments("--remote-allow-origins=*");

			opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		driver.get("https://application.axisbank.co.in/");
		Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());

		try {
			Files.write(Paths.get("./selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
