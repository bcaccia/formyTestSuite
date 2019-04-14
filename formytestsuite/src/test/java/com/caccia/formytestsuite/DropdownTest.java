package com.caccia.formytestsuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownTest {
	
	// Define all page elements
	private final String DROPDOWN_BUTTON = "dropdownMenuButton";
	private final String DROPDOWN_MENU = "div[class='dropdown-menu show']";
	private final String AUTOCOMPLETE = "Autocomplete";
	private final String BUTTONS = "Buttons";
	private final String CHECKBOX = "Checkbox";
	private final String DATEPICKER = "Datepicker";
	private final String DRAG_AND_DROP = "Drag and Drop";
	
	// Instantiate a variable to contain the WebDriver instance.
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Setup the WebDriver before each test
	@BeforeEach
	void setUp() throws Exception {
		driver = BrowserSelect.BrowserChoice();
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/dropdown");
	}

	// Close the WebDriver after each test
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	void clickDropdown() {
		driver.findElement(By.id(DROPDOWN_BUTTON)).click();
	}
	
	void menuWait() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DROPDOWN_MENU)));
	}
//	@Test
	void clickAutocomplete() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(AUTOCOMPLETE)).click();
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(AUTOCOMPLETE, actual);
	}
	
//	@Test
	void clickButtons() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(BUTTONS)).click();
		// Get text from the Primary button on the Buttons page.
		String actual = driver.findElement(By.xpath("//button[contains(.,'Primary')]")).getText();
		// Verify that the button text on the page matches the expected text. 
		assertEquals("Primary", actual);
	}
	
//	@Test
	void clickCheckbox() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(CHECKBOX)).click();
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Checkboxes", actual);
	}
	
//	@Test
	void clickDatepicker() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(DATEPICKER)).click();
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(DATEPICKER, actual);
	}
	
	@Test
	void clickDragAndDrop() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(DRAG_AND_DROP)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Drag the image into the box", actual);
	}
}
