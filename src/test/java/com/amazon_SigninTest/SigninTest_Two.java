package com.amazon_SigninTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon_SigninPage.SigninPageOne;
import com.amazon_TestManager.BasePage;

public class SigninTest_Two {
	WebDriver driver;
	BasePage basePage;
	SigninPageOne signinOnePage;

	@BeforeTest
	public void testStarted() {
		System.out.println("test started");

	}

	@BeforeMethod
	public void openApplication() {
		basePage = new BasePage();
		driver = basePage.getDriver();
		System.out.println("app open");
	}

	@Test(priority = 1)
	public void validSigninTest() {
		basePage = new BasePage();
		driver = basePage.getDriver();
		signinOnePage = new SigninPageOne(driver);
		signinOnePage.signinButton();
		signinOnePage.createAmazonAccount();
		signinOnePage.firstAndlastName("Suraiya Hossain");
		signinOnePage.mobileNoOremail("suchita2.haque@gmail.com");
		signinOnePage.password("Lisa1234");
		signinOnePage.reEnterpassword("Lisa1234");
		signinOnePage.continueButton();
		System.out.println("validSigninTest done");
		// driver.quit();
	}

	@Test(priority = 2)
	public void invalidSigninTest() {
		// basePage = new BasePage();
		// driver = basePage.getDriver();
		signinOnePage = new SigninPageOne(driver);
		signinOnePage.signinButton();
		signinOnePage.createAmazonAccount();
		signinOnePage.firstAndlastName("Suraiya Haque");
		signinOnePage.mobileNoOremail("such2.haque@gmail.com");
		signinOnePage.password("Lisa123456");
		signinOnePage.reEnterpassword("Lisa123456");
		signinOnePage.continueButton();
		System.out.println("invalidSigninTest done");

		// driver.quit();

	}

	@AfterMethod
	public void closeApp() {
		basePage.destroy();

		System.out.println("app close");
	}

	@AfterTest
	public void testFinished() {
		System.out.println("Test finished");
	}

}
