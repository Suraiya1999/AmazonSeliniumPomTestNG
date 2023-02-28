package com.amazon_SigninTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon_DataManagers.ExcelManager;
import com.amazon_SigninPage.SigninPageOne;
import com.amazon_TestManager.BasePage;
import com.amazon_baseTest.NewBaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SigninTest_Four extends NewBaseTest {

	WebDriver driver;
	BasePage basePage;
	SigninPageOne signinOnePage;
	ExcelManager excel;

//Handling excel data
	String projectpath = System.getProperty("user.dir");
	String filepath = "\\src\\main\\resources\\config\\data.xlsx";
	String excelPath = projectpath + filepath;

	@BeforeMethod
	public void openApplication() {
		basePage = new BasePage();
		driver = basePage.getDriver();
		
		System.out.println("app open");
	}

	@Test(priority = 0)
	public void maxCharterPasswordTest() {
		ExtentTest testLog = extent.createTest("maxCharterPasswordTest").assignAuthor("Suchi")
				.assignCategory("Smoke Test").assignDevice("Windows 11").assignDevice("Edge").assignDevice("Java-1.8")
				.assignDevice("Selenium-4.4.0").assignDevice("Maven-3.00").assignDevice("Enviroment-QA")
				.assignDevice("Release-1.1.0");

		testLog.info("maxCharterPasswordTest >> started");

		// excel
		excel = new ExcelManager(excelPath, "Sheet1");

		// basePage = new BasePage();
		// driver = basePage.getDriver();
		signinOnePage = new SigninPageOne(driver);
		signinOnePage.signinButton();
		signinOnePage.createAmazonAccount();
		signinOnePage.firstAndlastName(excel.getStringCellData(1, 0));
		WebElement fullName = driver.findElement(By.name("customerName"));
		testLog.warning("dynamic locators");
		basePage.takeSpecificScreenShot(fullName, "firstAndlastName");
		signinOnePage.mobileNoOremail(excel.getStringCellData(1, 1));
		signinOnePage.password(excel.getStringCellData(1, 2));
		signinOnePage.reEnterpassword(excel.getStringCellData(1, 3));
		signinOnePage.continueButton();
		System.out.println("maxCharterPasswordTest done");

		String actualTitle = driver.getTitle();
		testLog.info(actualTitle);
		System.out.println(actualTitle);
		String expectedTitle = "Authentication required";
		Assert.assertEquals(actualTitle, expectedTitle);
		testLog.pass("maxCharterPasswordTest");
		testLog.info("maxCharterPasswordTest >> finish");
		// driver.quit();
	}

	@Test(priority = 1)
	public void outOfBoundTest() {
		ExtentTest testLog = extent.createTest("outOfBoundTest").assignAuthor("Sami").assignCategory("Regression Test")
				.assignDevice("Windows 11").assignDevice("Edge");
		testLog.info("outOfBoundTest");

		// basePage = new BasePage();
		// driver = basePage.getDriver();

		// excel
		excel = new ExcelManager(excelPath, "Sheet1");

		signinOnePage = new SigninPageOne(driver);
		WebElement signSection = driver.findElement(By.id("nav-xshop"));
		basePage.takeSpecificScreenShot(signSection, "SignSection");
		signinOnePage.signinButton();
		signinOnePage.createAmazonAccount();
		signinOnePage.firstAndlastName(excel.getStringCellData(2, 0));
		signinOnePage.mobileNoOremail(excel.getStringCellData(2, 1));
		signinOnePage.password(excel.getStringCellData(2, 2));
		signinOnePage.reEnterpassword(excel.getStringCellData(2, 3));
		signinOnePage.continueButton();
		System.out.println("invalidmobileNoOremai done");
		testLog.pass("outOfBoundTest");
		// driver.quit();

	}

	@Test(priority = 2)
	public void failSigninTest() {
		ExtentTest testLog = extent.createTest("failSigninTest").assignAuthor("Sura").assignCategory("Regression Test")
				.assignDevice("Windows 11").assignDevice("Edge");
		testLog.info("failSigninTest");

		String expectedTitle = driver.getTitle();
		String actualTitle = "www.amazone.com/";
		Assert.assertEquals(actualTitle, expectedTitle);
		testLog.fail("failSigninTest");
	}

	@Test(priority = 3)
	public void skipSigninTest() {
		ExtentTest testLog = extent.createTest("failSigninTest").assignAuthor("Lisa").assignCategory("Regression Test")
				.assignDevice("Windows 11").assignDevice("Chrome");
		testLog.skip("skipSigninTest");

		throw new SkipException("this method is not ready");

	}

	@AfterMethod
	public void closeApp() {
		basePage.destroy();

		System.out.println("app close");
	}

}
