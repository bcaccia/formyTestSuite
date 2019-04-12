package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class KeypressTest {
	
	// Define all the page element variables
	private final String fullNameField = "name";
	private final String submitButton = "button";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("https://formy-project.herokuapp.com/keypress");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void keyboardMouseInput() {
		driver.findElement(By.id(fullNameField)).sendKeys("John Doe");
		driver.findElement(By.id(submitButton)).click();
		
	}

}
