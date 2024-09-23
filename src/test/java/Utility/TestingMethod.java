package Utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TestingMethod extends settingUpWebDriver{
	
	// 				assertNotNull ---> ==Null
	public void checkIfNotNull(WebElement webElement, String elementName) {
        if (webElement == null) {
            String ErrorMessage = String.format("Expected " + elementName + " to be exist, but it was not found");
            throw new AssertionError(ErrorMessage);
            
            
        }
    }
	
	
	// assert null
	public void checkIfNull(WebElement webElement, String elementName) {
		if (webElement != null) {
			String ErrorMessage = String.format("Expected " + elementName + " to be null, but it was not found");
			throw new AssertionError(ErrorMessage);
		}
		
	}
	
	// assert equal 
	public void checkIfEqual(String actualValue ,String expectedText) {
		
		if(!(actualValue.equals(expectedText))) {
			String ErrorMessage = String.format("Expected " + actualValue + " to have text \"%s\", but it actually has text \"%s\"", expectedText, actualValue);
			throw new AssertionError(ErrorMessage);
		}
	}
	
	// assert contain
	public void checkIfContain(String actualValue ,String expectedText) {
		if(!(actualValue.contains(expectedText))) {
			String ErrorMessage = String.format("Expected " + actualValue + " to contain text \"%s\", but it actually has text \"%s\"", expectedText, actualValue);
			throw new AssertionError(ErrorMessage);
		}
	}
	
	// assert.isenable
	public void CheckIfButtonIsEnable(WebElement webElement, String elementName) {
	    if (!webElement.isEnabled()) {
	        String ErrorMessage = String.format("Expected " + elementName + " is enable");
	        throw new AssertionError(ErrorMessage);
	    }
	}
	
	public void CheckIfNotNullForList(List<WebElement> webElements, String elementsName) {
	    if (webElements == null) {
	        String ErrorMessage = String.format("Expected " + elementsName + " to be exist, but they were not found");
	        throw new AssertionError(ErrorMessage);
	    }
	}

	public void CheckIfNullForList(List<WebElement> webElements, String elementsName) {
	    if (webElements != null) {
	        String ErrorMessage = String.format("Expected " + elementsName + " to be exist, but they were found");
	        throw new AssertionError(ErrorMessage);
	    }
	}

	// assert.isDisplayed
	public void CheckIfTextIsDiplayed(WebElement webElement, String elementName) {
	    if (!webElement.isDisplayed()) {
	        String ErrorMessage = String.format("Expected " + elementName + " to be exist, but it was not displayed");
	        throw new AssertionError(ErrorMessage);
	    }
	}
	
	
}
