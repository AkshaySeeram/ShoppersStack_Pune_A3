package com.ShoppersStack.GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack.POM.Home_Page;
import com.ShoppersStack.POM.Login_Page;
import com.ShoppersStack.POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility fileUtility = new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public WebDriverWait wait;
	public Home_Page homePage;
	public JavaUtility javaUtility = new JavaUtility();
	public WebDriverUtility webDriverUtility=new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
		spark = new ExtentSparkReporter(
				FrameWorkConstants.extentReportsPath + javaUtility.getLocalDateTime() + ".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Demo");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");

//		String browserName = fileUtility.readDataFromPropertyFile("browserName");
//		String url = fileUtility.readDataFromPropertyFile("url");

		String url = System.getProperty("url");
		String browserName = System.getProperty("browser");
		
		
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Please Enter Valid Browser Name");
		}
		sDriver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		homePage = new Home_Page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("@BeforeMethod");

		welcomePage = new Welcome_Page(driver);
		wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginBtn()));
		Thread.sleep(5000);

		welcomePage.getLoginBtn().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("userName"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");

		homePage.getAccountSettingsBtn().click();
		homePage.getLogOutBtn().click();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}

}
