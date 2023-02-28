package com.amazon_Listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon_TestManager.BasePage;

public class AmazonListener extends BasePage implements ITestListener {
   private WebDriver driver;
   
    public void takePageScreenShot(String name) {
		driver = getDriver();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./pageScreenShot/" + name + ".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			System.out.println("picture could not taken" + e.getMessage());
		}
    }
	
	@Override
	public void onTestStart(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"  >>>Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"  >>> PASSED");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"  >>>FAILED");
		takePageScreenShot(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"  >>>SKIPPED");
		takePageScreenShot(result.getMethod().getMethodName());
	}

	
	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+ "  >>>STARTED");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+ "  >>>FINISHED");
	}

}
