package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesTest {
	
	// Define all page elements
	private final String CHECKBOX1 = "checkbox-1";
	private final String CHECKBOX2 = "checkbox-2";
	private final String CHECKBOX3 = "checkbox-3";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/checkbox");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	void clickEachCheckbox() {
		
		driver.findElement(By.id(CHECKBOX1)).click();
		driver.findElement(By.id(CHECKBOX2)).click();
		driver.findElement(By.id(CHECKBOX3)).click();
		
	}

}
