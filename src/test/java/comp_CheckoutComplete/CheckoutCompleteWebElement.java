package comp_CheckoutComplete;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class CheckoutCompleteWebElement extends FindingElements{
	
	public WebElement getCheckoutCompletePage() {return findElementByClassName("title");}

	public WebElement getOrderConfirmationMessage() {return findElementByClassName("complete-header");}

	

}
