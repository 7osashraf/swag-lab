package comp_CheckoutPage;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class CheckoutPageWebElement extends FindingElements{
	
	public WebElement getFirstNameField() {return findElementById("first-name");}
	public WebElement getLastNameField() {return findElementById("last-name");}
	public WebElement getPostalCodeField() {return findElementById("postal-code");}
	public WebElement getContinueButton() {return findElementById("continue");}
	
	

}
