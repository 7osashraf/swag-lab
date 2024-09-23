package comp_CheckoutPage;

import org.openqa.selenium.WebElement;

public class CheckoutPageComp extends CheckoutPageWebElement{


	public void checkIfCheckoutPageIsDisplayed() {
		logger.debug("Verify if checkout page is displayed.");

		//check URL and Home Page
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/checkout-step-one.html");

		//Check Page Title
		String pageTitle = driver.getTitle();
		checkIfEqual(pageTitle, "Swag Labs");
	}


	public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
		logger.debug("Enter first name, last name, and postal code.");

		WebElement firstNameField = getFirstNameField();
		WebElement lastNameField = getLastNameField();
		WebElement postalCodeField = getPostalCodeField();

		checkIfNotNull(firstNameField, "First Name Field");
		checkIfNotNull(lastNameField, "Last Name Field");
		checkIfNotNull(postalCodeField, "Postal Code Field");

		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		postalCodeField.sendKeys(postalCode);
	}

	public void proceedToCheckoutOverview() {
		logger.debug("Click the continue button to proceed to the overview page.");

		WebElement continueButton = getContinueButton();
		checkIfNotNull(continueButton, "Continue Button");
		continueButton.click();
	}



}
