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
	private final String DROPDOWN_MENU_ITEM = "Dropdown";
	private final String ENABLED_AND_DISABLED = "Enabled and disabled elements";
	private final String FILE_UPLOAD = "File Upload";
	private final String FILE_DOWNLOAD = "File Download";
	private final String KEY_MOUSE = "Key and Mouse Press";
	private final String MODAL = "Modal";
	private final String PAGE_SCROLL = "Page Scroll";
	private final String RADIO_BUTTON = "Radio Button";
	private final String SWITCH_WINDOW = "Switch Window";
	private final String COMPLETE_WEB_FORM = "Complete Web Form";
	
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
		dropdownButtonWait();
		driver.findElement(By.id(DROPDOWN_BUTTON)).click();
	}
	
	void dropdownButtonWait() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(DROPDOWN_BUTTON)));
	}
	
	void menuWait() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(DROPDOWN_MENU)));
	}
	
	@Test
	void clickAutocomplete() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(AUTOCOMPLETE)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(AUTOCOMPLETE, actual);
	}
	
	@Test
	void clickButtons() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(BUTTONS)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the Primary button on the Buttons page.
		String actual = driver.findElement(By.xpath("//button[contains(.,'Primary')]")).getText();
		// Verify that the button text on the page matches the expected text. 
		assertEquals("Primary", actual);
	}
	
	@Test
	void clickCheckbox() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(CHECKBOX)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Checkboxes", actual);
	}
	
	@Test
	void clickDatepicker() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(DATEPICKER)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
	
	@Test
	void clickDropdownPage() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(DROPDOWN_MENU_ITEM)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(DROPDOWN_MENU_ITEM, actual);
	}
	
	@Test
	void clickEnabledAndDisabled() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(ENABLED_AND_DISABLED)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Enabled and Disabled elements", actual);
	}
	
	@Test
	void clickFileUpload() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(FILE_UPLOAD)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("File upload", actual);
	}
	
	// This test is meant to fail, the page does not exist.
	@Test
	void clickFileDownload() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(FILE_DOWNLOAD)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(FILE_DOWNLOAD, actual);
	}
	
	@Test
	void clickKeyAndMouse() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(KEY_MOUSE)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Keyboard and Mouse Input", actual);
	}
	
	@Test
	void clickModal() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(MODAL)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(MODAL, actual);
	}
	
	@Test
	void clickPageScroll() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(PAGE_SCROLL)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Large page content", actual);
	}
	
	@Test
	void clickRadioButton() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(RADIO_BUTTON)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals("Radio buttons", actual);
	}
	
	@Test
	void clickSwitchWindow() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(SWITCH_WINDOW)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(SWITCH_WINDOW, actual);
	}
	
	@Test
	void clickCompleteWebForm() {
		wait = new WebDriverWait(driver, 10);
		
		clickDropdown();
		menuWait();
		driver.findElement(By.linkText(COMPLETE_WEB_FORM)).click();
		// Wait for page to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Get text from the h1 element on the newly loaded page
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		// Verify that the h1 element text matches the text of the clicked link
		assertEquals(COMPLETE_WEB_FORM, actual);
	}
}
