# formyTestSuite

This is a sample Selenium Test suite written in Java for the website http://formy-project.herokuapp.com/

## What does it demonstrate
* How to access and test different types of web elements. 
* Setting up a class that will allow selection of desired browser for cross-browser testing or execution on Selenium Grid.
* JUnit 5 for annotations and handling assertions.
* Project dependency management using Maven
* Execution of test suite(or individual tests) using Maven
* Test reporting using Maven Surefire

## Development Stack
* Java 11
* Maven 3.5.2
* JUnit 5
* Selenium Grid 3.141.59

## Set Browser target
The desired browser to be tested can be set by setting the return method in the BrowserChoice method of the BrowserSelect class.

As an example, if the user wants to target Firefox:
```
	public static WebDriver BrowserChoice() throws MalformedURLException {
		// Change this value to change the browser for all tests
		return firefox();
	}
```

## Running Tests with Maven
The following commands can be used to run the test suite in Maven. Note that after each test run, Maven Surefire test reports will be output to **/target/surefire-reports/**

### Run all tests
`mvn test`

### Run a specific test
`mvn test -Dtest=NameOfSpecificTest`