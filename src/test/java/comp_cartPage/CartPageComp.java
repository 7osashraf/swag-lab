package comp_cartPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageComp extends CartPageWebElement{






	public void checkIfCartPageOpened() {
		logger.debug("Checking if Cart Page is opened.");

		//check URL and Cart Page
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/cart.html");

		// Check Page Title
		String pageTitle = driver.getTitle();
		checkIfEqual(pageTitle, "Swag Labs");
	}

	public void checkIfCartPageIsDisplayed() {
		logger.debug("Verify if the cart page is displayed.");

		WebElement cartPage = getCartPage();
		checkIfNotNull(cartPage, "Cart Page");
		CheckIfTextIsDiplayed(cartPage, "Your Cart");
	}

	//	// Check the number of items in the cart
	//    public void checkNumberOfItemsInCart(int expectedItemCount) {
	//        int actualItemCount = getCartItems().size();
	//        checkIfEquals(actualItemCount, expectedItemCount, "Number of Items in Cart");
	//    }

	public void checkIFQuantityIsDisplayed() {
		WebElement quantity = getQuant();
		checkIfNotNull(quantity, "QTY");
		CheckIfTextIsDiplayed(quantity, "QTY");
	}

	public void checkIFDiscriptionIsDisplayed() {
		WebElement desription = getQuant();
		checkIfNotNull(desription, "Description");
		CheckIfTextIsDiplayed(desription, "Description");
	}


	public void verifyIfItemsInCart() {
		logger.debug("Verifying items in the cart.");

		List<WebElement> cartItems = getCartItems();
		CheckIfNotNullForList(cartItems, "Cart Items");

		for (WebElement item : cartItems) {
			WebElement itemName = item.findElement(By.className("inventory_item_name"));
			WebElement itemDesc = item.findElement(By.className("inventory_item_desc"));
			WebElement itemPrice = item.findElement(By.className("inventory_item_price"));


			checkIfNotNull(itemName, "Item Name in Cart");
			checkIfNotNull(itemDesc, "Item Description in Cart");
			checkIfNotNull(itemPrice, "Item Price in Cart");

			String itemText = itemName.getText();
			String itemDescriptionText = itemDesc.getText();
			String itemPriceText = itemPrice.getText();


			System.out.println("Item in Cart: " + itemText);
			System.out.println("Item Description: " + itemDescriptionText);
			System.out.println("Item Price: " + itemPriceText);
		}
	}


	
	public void removeItemFromCart() {
		logger.debug("Removing all items from the cart.");

		verifyIfItemsInCart();
		
		List<WebElement> cartItems = getCartItems();
		CheckIfNotNullForList(cartItems, "Cart Items");

		for (WebElement item : cartItems) {
			WebElement removeButton = item.findElement(By.tagName("button"));
			checkIfNotNull(removeButton, "Remove Button");

			CheckIfButtonIsEnable(removeButton, "Remove Button");
			removeButton.click();
		}
		System.out.println("all items are removed");
	}

	public void proceedToCheckout() {
		logger.debug("Proceed to checkout.");

		WebElement checkoutButton = getCheckoutButton();
		checkIfNotNull(checkoutButton, "Checkout Button");
		checkoutButton.click();
	}
	
	public void proccedToHomePage() {
		logger.debug("Proceed to Home Page.");
		
		WebElement contShoppingBtn = getContShopping();
		checkIfNotNull(contShoppingBtn, "Continue Shopping");
		contShoppingBtn.click();
		
	}
	
	
	
	// for TRY
	public void removeThenBackToHomePage() throws InterruptedException {
		logger.debug("Proceed to Home Page After Remove All Items.");
		
		List<WebElement> removeButtons = getRemovesButton();
		for (WebElement button : removeButtons) {
            checkIfNotNull(button, "Remove Button");
            CheckIfButtonIsEnable(button, "Remove Button");
            button.click();
            Thread.sleep(500);
        }
		
	}
	
}
