package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDropTest {
	
	// Define all page elements
	private final String IMAGE = "image";
	private final String BOX = "box";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/dragdrop");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	void dragAndDrop() {
		
		WebElement image = driver.findElement(By.id(IMAGE));
		WebElement box = driver.findElement(By.id(BOX));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(image, box);
		
	}

}
