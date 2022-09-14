package com.timeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	//Constructor which will load all the findBy during object creation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	@FindBy(id="container_tasks")
	private WebElement taskButton;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTaskButton() {
		return taskButton;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	//Business logic
	public void logoutAction() {
		logoutLink.click();
	}
	
	public void clickOnTaskButton() {
		taskButton.click();
	}
}
