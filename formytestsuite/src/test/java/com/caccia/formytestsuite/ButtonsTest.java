package com.caccia.formytestsuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ButtonsTest {

	// Define all the page element variables
	private final String PRIMARY_BUTTON = "//button[contains(.,'Primary')]";
	private final String SUCCESS_BUTTON = "button[class='btn btn-lg btn-success']";
	private final String INFO_BUTTON = "button[class='btn btn-lg btn-info']";
	private final String WARNING_BUTTON = "button[class='btn btn-lg btn-warning']";
	private final String DANGER_BUTTON = "button[class='btn btn-lg btn-danger']";
	private final String LINK_BUTTON = "button[class='btn btn-lg btn-link']";
	private final String LEFT_BUTTON = "//button[contains(.,'Left')]";
	private final String MIDDLE_BUTTON = "//button[contains(.,'Middle')]";
	private final String RIGHT_BUTTON = "//button[contains(.,'Right')]";
	private final String ONE_BUTTON = "//button[contains(.,'1')]";
	private final String TWO_BUTTON = "//button[contains(.,'2')]";
	private final String DROPDOWN_BUTTON = "//button[contains(.,'Dropdown')]";
	private final String DROPDOWN_MENU = "div[class='dropdown-menu show']";
	private final String DROPDOWN_LINK1 = "Dropdown link 1";
	private final String DROPDOWN_LINK2 = "Dropdown link 2";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/buttons");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void clickEachButton() {
		
		wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath(PRIMARY_BUTTON)).click();
		driver.findElement(By.cssSelector(SUCCESS_BUTTON)).click();
		driver.findElement(By.cssSelector(INFO_BUTTON)).click();
		driver.findElement(By.cssSelector(WARNING_BUTTON)).click();
		driver.findElement(By.cssSelector(DANGER_BUTTON)).click();
		driver.findElement(By.cssSelector(LINK_BUTTON)).click();
		driver.findElement(By.xpath(LEFT_BUTTON)).click();
		driver.findElement(By.xpath(MIDDLE_BUTTON)).click();
		driver.findElement(By.xpath(RIGHT_BUTTON)).click();
		driver.findElement(By.xpath(ONE_BUTTON)).click();
		driver.findElement(By.xpath(TWO_BUTTON)).click();
		
		// Test the Dropdown button and options
		driver.findElement(By.xpath(DROPDOWN_BUTTON)).click();
		// Create an explicit wait for the element to appear, then click it
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DROPDOWN_MENU)));
		driver.findElement(By.linkText(DROPDOWN_LINK1)).click();
		
		// Pause before clicking the button element again. If you don't the test will fail
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DROPDOWN_BUTTON)));
		// Test the Dropdown button and options
		driver.findElement(By.xpath(DROPDOWN_BUTTON)).click();
		// Create an explicit wait for the element to appear, then click it
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DROPDOWN_MENU)));
		driver.findElement(By.linkText(DROPDOWN_LINK2)).click();

		
	}

}
