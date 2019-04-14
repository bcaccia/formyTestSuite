package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ModalTest {
	
	// Define all the page element variables
	private final String MODAL_BUTTON = "modal-button";
	private final String CLOSE_BUTTON = "close-button";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/modal");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void checkModal() {
		
		driver.findElement(By.id(MODAL_BUTTON)).click();
		WebElement closeButton = driver.findElement(By.id(CLOSE_BUTTON));
		// Use Javascript to click the modal dialog closeButton		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", closeButton);
	}

}
