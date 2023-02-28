package com.amazon_Managers;

import com.amazon_Configuration.ConfigFileReader;

public class FileReadermanager {
	/**
	 * private constructor
	 */
	private FileReadermanager() {
}
	
	/**
	 * instantiating private class
	 */
	private static FileReadermanager fileReadermanager=new FileReadermanager();
	/**
	 * @return static getInstance method to acees the class for single threading
	 *         mechanism
	 */
public static FileReadermanager getInstance() {
	return fileReadermanager;	
	
}
 ConfigFileReader configFileReader;
 /**
	 * @return single threading method to access ConfigFileReader class.
	 */
 public ConfigFileReader getConfigReader() {
	 return (configFileReader==null)? new ConfigFileReader():configFileReader;
 }
 
}