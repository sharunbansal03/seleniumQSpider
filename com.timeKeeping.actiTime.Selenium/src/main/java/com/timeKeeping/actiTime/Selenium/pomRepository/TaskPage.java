package com.timeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	WebDriver driver;

	// Constructor which will load all the findBy during object creation
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewButton;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustomerButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getNewCustomerButton() {
		return newCustomerButton;
	}

	public void clickNewCustomerButton() {
		addNewButton.click();
		newCustomerButton.click();
	}

	public String verifyCustomerName(String customerName) {
		return driver.findElement(By.xpath("//div[@title='" + customerName + "']")).getText();
	}
}
