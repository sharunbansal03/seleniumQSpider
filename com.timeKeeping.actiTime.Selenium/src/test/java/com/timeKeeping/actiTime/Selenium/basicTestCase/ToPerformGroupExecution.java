package com.timeKeeping.actiTime.Selenium.basicTestCase;


import org.testng.annotations.Test;


public class ToPerformGroupExecution {

	@Test(groups = "smokeTesting")
	public void login() {
		System.out.println("logged into flipkart");
	}

	@Test(groups = "regressionTesting")
	public void selectProduct() {
		System.out.println("selected product");
	}

	@Test(groups = "regressionTesting")
	public void addToCart() {
		System.out.println("added product to cart");
	}

	@Test(groups = "regressionTesting")
	public void payment() {
		System.out.println("payment done");
	}

	@Test(groups = "smokeTesting")
	public void logOut() {
		System.out.println("logged out");
	}

}
