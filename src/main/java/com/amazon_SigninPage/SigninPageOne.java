package com.amazon_SigninPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPageOne {
WebDriver driver;

public SigninPageOne(WebDriver driver) {
	super();
	this.driver = driver;
}
public WebElement signinButton() {
	driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	return null;
}
public WebElement createAmazonAccount() {
	 driver.findElement(By.id("createAccountSubmit")).click();
	return null;
}
public WebElement firstAndlastName(String enterfirstAndlastName) {
	driver.findElement(By.name("customerName")).sendKeys(enterfirstAndlastName);
	return null;
}
public WebElement mobileNoOremail(String entermobileNoOremail) {
	driver.findElement(By.id("ap_email")).sendKeys(entermobileNoOremail);
	return null;
}
public WebElement password(String enterpassword) {
	driver.findElement(By.id("ap_password")).sendKeys( enterpassword);
	return null;
}
public WebElement reEnterpassword(String enterreEnterpassword) {
	driver.findElement(By.name("passwordCheck")).sendKeys(enterreEnterpassword);
	return null;
}
public WebElement continueButton() {
	driver.findElement(By.className("a-button-input")).click();
	return null;

}
}
