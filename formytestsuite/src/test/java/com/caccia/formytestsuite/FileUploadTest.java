package com.caccia.formytestsuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class FileUploadTest {

	// Define all the page element variables
	private final String FILE_UPLOAD = "file-upload-field";
	
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/fileupload");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void checkFileUpload() {
		
		wait = new WebDriverWait(driver, 10);
		
		WebElement fileUploadField = driver.findElement(By.id(FILE_UPLOAD));
		fileUploadField.sendKeys("file_to_upload.png");

		
	}

}
