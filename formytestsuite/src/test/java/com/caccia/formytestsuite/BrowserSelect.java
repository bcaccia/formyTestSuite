package com.caccia.formytestsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class sets the browser that should be tested for all tests in the suite
 * @author bcaccia
 *
 */
public class BrowserSelect {
	
	public static WebDriver chrome() {
		System.setProperty("webdriver.chrome.driver", "/home/bcaccia/Downloads/chromedriver");
		final WebDriver chrome = new ChromeDriver();
		return chrome;
	}
	
	public static WebDriver firefox() {
		System.setProperty("webdriver.gecko.driver", "/home/bcaccia/Downloads/geckodriver");
		final WebDriver firefox = new FirefoxDriver();
		return firefox;
	}
	
	public static WebDriver BrowserChoice() {
		// Change this value to change the browser for all tests
		WebDriver browserChoice = chrome();
		return browserChoice;
	}
	

}
