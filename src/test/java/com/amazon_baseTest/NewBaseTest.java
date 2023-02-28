package com.amazon_baseTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewBaseTest {
	// Extent reports
	public	ExtentReports extent=new ExtentReports();
	public	ExtentSparkReporter htmlReporter= new ExtentSparkReporter("reporter.html");
 
   @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
		System.out.println("test started");
		extent.attachReporter(htmlReporter);
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test finished");
	  extent.flush();
  }

  @BeforeSuite
  public void beforeSuite() {
	
  }

  @AfterSuite
  public void afterSuite() {
  }

}
