

package com.amazon_Configuration;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.amazon_enam.DriverType;
import com.amazon_enam.EnvironmentType;

public class ConfigFileReader {
	public static Properties properties;
	private final String propertyFilePath = "src/main/resources/config/Test.properties";

	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null ||browserName.equalsIgnoreCase("chrome"))
			{return DriverType.CHROME;}
		else if ( browserName.equalsIgnoreCase("edge"))
			{return DriverType.EDGE;}
		else if (browserName.equalsIgnoreCase("firefox"))
			{return DriverType.FIREFOX;}
		else throw new RuntimeException("Browser name does not exisist" + browserName);
	}
	
		
	public EnvironmentType getEnvironment() {
		String enviromentName=properties.getProperty("environment");
		if (enviromentName == null || enviromentName.equalsIgnoreCase("remote"))
			return EnvironmentType.REMOTE;
		else if (enviromentName == null || enviromentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else throw new RuntimeException("Enviroment name does not exisist" + enviromentName);
	}
	
	public String getUrl() {
		String appUrl= properties.getProperty("url");
		
   if(appUrl !=null) return appUrl;
   else throw new RuntimeException("we could not find url");
	}
	
	public String getRemoteUrl() {
		String remoteAppUrl=properties.getProperty("remoteUrl");
		if(remoteAppUrl !=null)
			return remoteAppUrl;
		else throw new RuntimeException("we could not find remoteUrl in the test .properties file");
	}
	
	

	public static void main(String[] args) {
		ConfigFileReader cf = new ConfigFileReader();
		System.out.println(cf.getEnvironment());
		System.out.println(cf.getUrl());
		System.out.println(cf.getRemoteUrl());
		System.out.println(cf.getBrowser());
		//System.out.println(cf.getRemoteUrl());
	}
	
}

