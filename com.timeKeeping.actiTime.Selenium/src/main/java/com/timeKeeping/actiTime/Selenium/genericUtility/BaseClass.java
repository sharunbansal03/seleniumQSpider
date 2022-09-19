package com.timeKeeping.actiTime.Selenium.genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.timeKeeping.actiTime.Selenium.pomRepository.CreateNewCustomerPage;
import com.timeKeeping.actiTime.Selenium.pomRepository.HomePage;
import com.timeKeeping.actiTime.Selenium.pomRepository.LoginPage;
import com.timeKeeping.actiTime.Selenium.pomRepository.TaskPage;

public class BaseClass {

	public WebDriver driver;
	public JavaUtility jUtils = new JavaUtility();
	public ExcelUtility excel = new ExcelUtility();
	public LoginPage login;
	public HomePage home;
	public TaskPage task;
	public CreateNewCustomerPage createCustomer;

	public void initializePages() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		task = new TaskPage(driver);
		createCustomer = new CreateNewCustomerPage(driver);
	}

	@BeforeSuite
	public void bsConfig() {
		System.out.println("========== Establish database connectivity ===========");
	}

	@BeforeClass
	public void bcConfig() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		initializePages();

		System.out.println("========== The browser has been launched ===========");
		String url = jUtils.fetchDataFromPropertyFile("url");
		driver.get(url);
		System.out.println("============= Navigated to URL =============");
	}

	@BeforeMethod
	public void bmConfig() throws IOException, InterruptedException {
		// LoginPage login = new LoginPage(driver);
		String username = jUtils.fetchDataFromPropertyFile("username");
		String password = jUtils.fetchDataFromPropertyFile("password");
		login.loginAction(username, password);

		System.out.println("========== Logged in to the application ===========");
	}

	@AfterMethod
	public void amConfig() {
		// HomePage home = new HomePage(driver);
		// home.logoutAction();
		System.out.println("========== Log out from the application ===========");
	}

	@AfterClass(alwaysRun = true)
	public void acConfig() {
		// driver.quit();
		System.out.println("========== Closed the browser ===========");
	}

	@AfterSuite
	public void asConfig() {
		System.out.println("========== Closed database connection ===========");
	}
}
