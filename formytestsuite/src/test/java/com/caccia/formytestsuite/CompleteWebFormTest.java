package com.caccia.formytestsuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

class CompleteWebFormTest {
	
	// Define all the page element variables
	private final String FIRST_NAME = "first-name";
	private final String LAST_NAME = "last-name";
	private final String JOB_TITLE = "job-title";
	private final String EDUCATION = "radio-button-2";
	private final String SEX = "checkbox-1";
	private final String EXPERIENCE = "select-menu";
	private final String DATE = "datepicker";
	private final String SUBMIT_BUTTON = ".btn.btn-lg.btn-primary";
	private final String SUCCESS = ".alert.alert-success";

	// Instantiate a variable to contain the WebDriver instance.
		private WebDriver driver;
		
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/form");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void completeWebForm() {
		
		driver.findElement(By.id(FIRST_NAME)).sendKeys("John");
		driver.findElement(By.id(LAST_NAME)).sendKeys("Doe");
		driver.findElement(By.id(JOB_TITLE)).sendKeys("QA Tester");
		driver.findElement(By.id(EDUCATION)).click();
		driver.findElement(By.id(SEX)).click();
		
		Select dropdown = new Select(driver.findElement(By.id(EXPERIENCE)));
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id(DATE)).sendKeys("05/15/2030");
		driver.findElement(By.cssSelector(SUBMIT_BUTTON)).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String result = driver.findElement(By.cssSelector(SUCCESS)).getText();
		assertEquals("The form was successfully submitted!", result);
	}

}
