package com.timeKeeping.actiTime.Selenium.TaskTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.timeKeeping.actiTime.Selenium.genericUtility.BaseClass;


/**
 * This class Verifies New Customer Creation
 * 
 * @author sharun
 *
 */
public class CreateCustomerInTaskTest2 extends BaseClass {

	// Package name - should be that of Module in app
	// test class name - should be task name followed by "Test"
	// test case name - should be manual test case name followed by "Test"

	@Test
	public void createCustomerTest() throws IOException, InterruptedException {
		// Object creation statements
		/*
		 * HomePage home = new HomePage(driver); TaskPage task = new TaskPage(driver);
		 * CreateNewCustomerPage createCustomer = new CreateNewCustomerPage(driver);
		 */
		 

		// generating random number
		int randomNo = jUtils.generateRandomNumber(1000);
		// fetching data from excel sheet
		String expectedCustomerName = excel.fetchDataFromExcelFile("Sheet1", 1, 0) + randomNo;
		String customerDescription = excel.fetchDataFromExcelFile("Sheet1", 1, 1);
		String existingCustomerName = excel.fetchDataFromExcelFile("Sheet1", 1, 2);

		// clicking on Task button
		home.clickOnTaskButton();
		// clicking on New Customer button
		task.clickNewCustomerButton();
		// creating customer
		createCustomer.createCustomerAction(expectedCustomerName, customerDescription, existingCustomerName);

		// verification
		String actualNewCustomerNameTitle = task.verifyCustomerName(expectedCustomerName);
		Assert.assertEquals(actualNewCustomerNameTitle, expectedCustomerName);
		Reporter.log("PASS: New Customer added successfully", true);
	}
}