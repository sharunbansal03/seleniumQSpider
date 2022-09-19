package com.timeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {
	WebDriver driver;

	// Constructor which will load all the findBy during object creation
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="preInsertedTransformedMoireId")
	private WebElement hiddenInterceptingElement;

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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(addNewButton));
		addNewButton.click();
		newCustomerButton.click();
	}

	public String verifyCustomerName(String customerName) {
		return driver.findElement(By.xpath("//div[@title='" + customerName + "']")).getText();
	}
}
