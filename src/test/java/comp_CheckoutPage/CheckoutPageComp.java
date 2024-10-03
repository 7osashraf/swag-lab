package comp_CheckoutPage;

import org.openqa.selenium.WebElement;

import Utility.DataUtils;

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

	public void enterCheckoutInformationFromExcel() {
		logger.debug("Entering checkout information from Excel.");
		
		String excelFilePath = "./Resources/";
		String excelFilename = "checkouData.xlsx";
		String sheetName = "loginData";
		
		DataUtils ExcelData = new DataUtils();
		String firstName = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 0, 0);
		System.out.println("First name: " + firstName);
		String lastName = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 0);
		System.out.println("Last Name: " + lastName);
        String postalCode = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 2, 0);
        System.out.println("Postal Code: " + postalCode);
        
		
		enterCheckoutInformation(firstName, lastName, postalCode);
		
		
	}


}
