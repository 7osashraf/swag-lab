package comp_CheckoutComplete;

import org.openqa.selenium.WebElement;

public class CheckoutCompleteComp extends CheckoutCompleteWebElement{

	
    public void checkIfCheckoutCompletePageIsDisplayed() {
    	logger.debug("Verify if the checkout complete page is displayed.");
    	
    	String url = driver.getCurrentUrl();
    	checkIfEqual(url, "https://www.saucedemo.com/checkout-complete.html");
    	
    	//Check Page Title
        WebElement checkoutComplete = getCheckoutCompletePage();
        checkIfNotNull(checkoutComplete, "Checkout Complete Page");
        CheckIfTextIsDiplayed(checkoutComplete, "Checkout: Complete!");
    }
    
    
    public void checkOrderConfirmationMessage() {
    	logger.debug("Check the order confirmation message.");
    	
        WebElement confirmationMessage = getOrderConfirmationMessage();
        checkIfNotNull(confirmationMessage, "Order Confirmation Message");
        CheckIfTextIsDiplayed(confirmationMessage, "THANK YOU FOR YOUR ORDER");
    }

   
}
