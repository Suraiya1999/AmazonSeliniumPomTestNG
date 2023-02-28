package com.amazon_locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DirectLocators {
 public WebDriver driver;
 
 @BeforeMethod
 public void openApplication() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://www.amazon.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			 
 }

/**
 * This method is about direct locators
   * @throws InterruptedException
 * 
 */
@Test
 public void signinButton() throws InterruptedException {
 driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
 
 Thread.sleep(4000);
 
}

 @AfterMethod
 public void closeApplication() {
	 driver.quit();
}
}