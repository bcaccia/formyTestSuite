package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonsTest {
	
	// Define all page elements
	private final String RADIOBUTTON1 = "radio-button-1";
	private final String RADIOBUTTON2 = "input[value='option2']";
	private final String RADIOBUTTON3 = "input[value='option3']";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("https://formy-project.herokuapp.com/radiobutton");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	void clickEachRadioButton() {
		
		driver.findElement(By.id(RADIOBUTTON1)).click();
		driver.findElement(By.cssSelector(RADIOBUTTON2)).click();
		driver.findElement(By.cssSelector(RADIOBUTTON3)).click();
		
	}

}
