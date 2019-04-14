package com.caccia.formytestsuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class EnabledDisabledTest {

	// Define all the page element variables
	private final String DISABLED_INPUT = "disabledInput";
	private final String ENABLED_INPUT = "input";
	
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/enabled");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void checkEnabledDisabled() {
		
		wait = new WebDriverWait(driver, 10);
		
		Boolean disabledInputState = driver.findElement(By.id(DISABLED_INPUT)).isEnabled();
		assertEquals(false, disabledInputState);
		
		Boolean enabledInputState = driver.findElement(By.id(ENABLED_INPUT)).isEnabled();
		assertEquals(true, enabledInputState);

		
	}

}
