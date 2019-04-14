package com.caccia.formytestsuite;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	public static WebDriver remote() throws MalformedURLException {
		final WebDriver remote = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		return remote;
	}
	
	public static WebDriver BrowserChoice() throws MalformedURLException {
		// Change this value to change the browser for all tests
		return firefox();
	}
	

}
