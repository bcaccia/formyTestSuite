package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class PageScrollTest {
	
	// Define all the page element variables
	private final String NAME_FIELD = "name";
	private final String DATE_FIELD = "date";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/scroll");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void scrollPage() {
		
		WebElement nameField = driver.findElement(By.id(NAME_FIELD));
		Actions actions = new Actions(driver);
		actions.moveToElement(nameField);
		nameField.sendKeys("John Doe");
		driver.findElement(By.id(DATE_FIELD)).sendKeys("05/15/2030");
	}

}
