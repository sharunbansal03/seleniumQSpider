package com.timeKeeping.actiTime.Selenium.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage {
	WebDriver driver;

	// Constructor which will load all the findBy during object creation
	public CreateNewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement customerNameTextField;
	

	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescriptionTextArea;

	@FindBy(xpath = "//div[@class='selectedItem']//div[text()='- Select Customer -']")
	private WebElement selectCustomerDropdown;

	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerButton;

	@FindBy(xpath = "//div[@class='itemRow collapseHiddenButton']")
	private WebElement showArchivedCustomersLink;

	public WebElement getShowArchivedCustomersLink() {
		return showArchivedCustomersLink;
	}

	public WebElement getCreateCustomerButton() {
		return createCustomerButton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCustomerNameTextField() {
		return customerNameTextField;
	}

	public WebElement getCustomerDescriptionTextArea() {
		return customerDescriptionTextArea;
	}

	public WebElement getSelectCustomerDropdown() {
		return selectCustomerDropdown;
	}

	//// div[@class='itemRow cpItemRow ' and text()='Big Bang Company']
	// text() or class
	// waits where to keep - JavaUtility

	public void createCustomerAction(String customerName, String description, String existingCustomerName)
			throws InterruptedException {
		customerNameTextField.sendKeys(customerName);
		customerDescriptionTextArea.sendKeys(description);
		selectCustomerDropdown.click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='" + existingCustomerName + "']"))).click()
				.perform();
		createCustomerButton.click();
	}
}