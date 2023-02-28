package com.amazon_TestManager;



import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amazon_Managers.FileReadermanager;
import com.amazon_enam.DriverType;
import com.amazon_enam.EnvironmentType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	private WebDriver driver;
	private DriverType driverType;
	private EnvironmentType enviromentType;

	public BasePage() {

		driverType = FileReadermanager.getInstance().getConfigReader().getBrowser();
		enviromentType = FileReadermanager.getInstance().getConfigReader().getEnvironment();
	}
	public WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	

	public WebDriver createDriver() {
		switch (enviromentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;

	}

	private WebDriver createRemoteDriver() {
		switch (driverType) {
		case CHROME:
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(BrowserType.CHROME);
			try {
				driver = new RemoteWebDriver(new URL(FileReadermanager.getInstance().getConfigReader().getRemoteUrl()),
						cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case EDGE:
			DesiredCapabilities cap1 = new DesiredCapabilities();
			cap1.setBrowserName(BrowserType.EDGE);
			try {
				driver = new RemoteWebDriver(new URL(FileReadermanager.getInstance().getConfigReader().getRemoteUrl()),
						cap1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case FIREFOX:
			DesiredCapabilities cap2 = new DesiredCapabilities();
			cap2.setBrowserName(BrowserType.FIREFOX);
			try {
				driver = new RemoteWebDriver(new URL(FileReadermanager.getInstance().getConfigReader().getRemoteUrl()),
						cap2);
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		}
		driver.get(FileReadermanager.getInstance().getConfigReader().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {

		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		driver.get(FileReadermanager.getInstance().getConfigReader().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
		return driver;
	}
		
		public void destroy() {

		if (driver != null) {
			driver.quit();
		}
		}	
		public void takeSpecificScreenShot(WebElement locator, String name) {
			//TakesScreenshot specificShot= (TakesScreenshot) driver;
			File src=locator.getScreenshotAs(OutputType.FILE);
			File target= new File("./SpecificScreenShot/"+name+".png");
			try {
				FileUtils.copyFile(src, target);
			} catch (IOException e) {
				System.out.println(e.getMessage()+"could not take the specific screen shot");
			}
		}
	

	}

