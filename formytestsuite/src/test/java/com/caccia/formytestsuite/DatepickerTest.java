package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatepickerTest {
	
	// Define all page elements
	private final String DATEPICKER = "datepicker";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/datepicker");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	void clickEachRadioButton() {
		
		WebElement datepicker = driver.findElement(By.id(DATEPICKER));
		datepicker.sendKeys("05/15/2030");
		datepicker.sendKeys(Keys.RETURN);
	}

}
