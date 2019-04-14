package com.caccia.formytestsuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class AutocompleteTest {
	
	// Define all the page element variables
	private final String ADDRESS = "autocomplete";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		private WebDriverWait wait;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/autocomplete");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void testAutocomplete() {
		
		wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.id(ADDRESS)).sendKeys("702");
		// Create an explicit wait for the element to appear, then click it
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("pac-item")));
		driver.findElement(By.className("pac-item")).click();
	
	}

}
