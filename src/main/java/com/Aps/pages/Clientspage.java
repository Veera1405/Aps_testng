package com.Aps.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Clientspage extends BasePage {

	public Clientspage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[@class='menu-item ng-tns-c66-7'])[1]")
	private WebElement AdminSettingBtn;

	@FindBy(xpath = "//button[@class='menu-list-item ng-tns-c66-9']")
	private WebElement Clients;

	@FindBy(xpath = "//button[@class='menu-list-item ng-tns-c66-10']")
	private WebElement Companies;

	@FindBy(xpath = "//input[@placeholder='Search Client...']")
	private WebElement Search_Client;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement Search_btn;

	@FindBy(xpath = "//a[normalize-space()='Import']")
	private WebElement Import;

	@FindBy(xpath = "//a[normalize-space()='Add Client']")
	private WebElement Add_Client;

	@FindBy(xpath = "//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-auto-height ag-cell-value ag-cell-focus']//i[@class='bi bi-three-dots']")
	private WebElement Three_dot;

	@FindBy(xpath = "//div[@class='dropdown']//button[1]")
	private WebElement View;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//span[contains(text(),'Delete')]")
	private WebElement Delete;

	@FindBy(xpath = "//a[normalize-space()='sample file']")
	private WebElement sample_file;

	@FindBy(xpath = "//button[normalize-space()='Choose File']")
	private WebElement Choose_File;

	public void Search_Client(String value) {
		clearAndEnterText(Search_Client, value);
		Search_Client.sendKeys(Keys.ENTER);
	}

	public void Search_btn() {
		Search_btn.click();
	}

	public void Import() {

		Import.click();
	}

	public void sample_file() {

		sample_file.click();
	}

	public void Click_Admin_Btn() {

		WaituntillElementclickable(AdminSettingBtn);

	}

	public void Click_Clients_Btn() {

		Clients.click();

	}

	public void Click_Companies_Btn() {
		Companies.click();

	}

}
