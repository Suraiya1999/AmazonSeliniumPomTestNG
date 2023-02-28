package com.amazon_SigninTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon_SigninPage.SigninPageOne;
import com.amazon_baseTest.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninTest_One extends BaseTest {

	@BeforeMethod
	public void openApp() {
		openApplication();
	}

	@Test(priority = 0)
	private void SigninTest() {
		SigninPageOne sp = new SigninPageOne(driver);
		sp.signinButton();
		sp.createAmazonAccount();
		sp.firstAndlastName("Suraiya Khatun");
		sp.mobileNoOremail("suchita1.hossain@gmail.com");
		sp.password("suchita1234");
		sp.reEnterpassword("suchita1234");
		sp.continueButton();

	}

	// @Test(priority = 1)
	private void invalidFirstName() {
		SigninPageOne sp = new SigninPageOne(driver);
		sp.signinButton();
		sp.createAmazonAccount();
		sp.firstAndlastName("Suraiya Khatun");
		sp.mobileNoOremail("suchita.hossain@gmail.com");
		sp.password("suchita1234");
		sp.reEnterpassword("suchita1234");
		sp.continueButton();
	}

	// @Test(priority = 2)
	private void invalidEmail() {
		SigninPageOne sp = new SigninPageOne(driver);
		sp.signinButton();
		sp.createAmazonAccount();
		sp.firstAndlastName("Suraiya Khatun");
		sp.mobileNoOremail("suchita.hossain@gmail.com");
		sp.password("suchita1234");
		sp.reEnterpassword("suchita1234");
		sp.continueButton();
	}

	@AfterMethod
	public void closeApplication() {
		// driver.quit();
	}

}
