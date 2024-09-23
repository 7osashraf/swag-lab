package comp_CheckoutOverview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewComp extends CheckoutOverviewWebElement{


	public void checkIfCheckoutOverviewPageIsDisplayed() {
		logger.debug("Verify if checkout overview page is displayed.");

		//checkk URL
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/checkout-step-two.html");

		//Check Page Title
		String pageTitle = driver.getTitle();
		checkIfEqual(pageTitle, "Swag Labs");
	}


	public void checkTotalPrice(String expectedPrice) {
		logger.debug("Check the total price on the overview page");

		WebElement totalPrice = getTotalPrice();
		checkIfNotNull(totalPrice, "Total Price");
		checkIfEqual(totalPrice.getText().replace("Item total: $", ""), expectedPrice);
	}


	public void finishCheckout() {
		logger.debug("Finish the checkout process");

		WebElement finishButton = getFinishButton();
		checkIfNotNull(finishButton, "Finish Button");
		finishButton.click();
	}




	public double calculateSumOfItemPrices() {
		logger.debug("Calculate the sum of the item prices in the checkout overview page");

		//get the list of items
		List<WebElement> items = getItemList();
		CheckIfNotNullForList(items, "Item List");

		double totalSum = 0.0;
		int numberOfItems = items.size();
		System.out.println("The number of items in the cart is " + numberOfItems);

		for(int i  = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);

			WebElement itemPriceElement = item.findElement(By.className("inventory_item_price"));

			//get the price as a string, remove the currency symbol, and convert to double
			String priceText = itemPriceElement.getText().replace("$", "");
			double itemPrice = Double.parseDouble(priceText);

			//Add the item price to the total sum
			totalSum += itemPrice;


		}
		System.out.println("The total sum of the item prices is: $" + totalSum);

		return totalSum;

	}








}
