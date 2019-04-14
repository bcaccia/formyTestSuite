package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SwitchWindowTest {
	
	// Define all the page element variables
	private final String NEW_TAB_BUTTON = "new-tab-button";
	private final String ALERT_BUTTON = "alert-button";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/switch-window");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		// This quits all browser instances so that the new tab is also closed at the end of the test.
		driver.quit();
	}

	@Test
	void scrollPage() {
		
		WebElement alertButton = driver.findElement(By.id(ALERT_BUTTON));
		alertButton.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id(NEW_TAB_BUTTON)).click();
	}

}
