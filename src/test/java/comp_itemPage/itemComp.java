package comp_itemPage;

import org.openqa.selenium.WebElement;

public class itemComp extends itemWebElement{

	public void testItemDetails() {
		logger.debug("test item details.");
		// check item name
		WebElement itemName = getItemName();
		explicitlyWaitForVisibility(itemName);
		String nameText = itemName.getText();
		System.out.println("Item Name: " + nameText);
		checkIfNotNull(itemName, "Item Name");

		//check the item description
		WebElement itemDescription = getItemDesc();
		explicitlyWaitForVisibility(itemDescription);
		String descriptionText = itemDescription.getText();
		System.out.println("Item Description: " + descriptionText);
		checkIfNotNull(itemDescription, "Item Description");


		//check the item price
		WebElement itemPrice = getItemPrice();
		explicitlyWaitForVisibility(itemPrice);
		String priceText = itemPrice.getText();
		System.out.println("Item Price: " + priceText);
		checkIfNotNull(itemPrice, "Item Price");
		checkIfContain(priceText, "$");

		// check the item image
		WebElement itemImage = getItemImage();
		explicitlyWaitForVisibility(itemImage);
		String imageSource = itemImage.getAttribute("src");
		System.out.println("Item Image Source: " + imageSource);
		checkIfNotNull(itemImage, "Item Image");

	}

	public void addItemToCart() {
		logger.debug("add the item to the cart");
		
        WebElement addToCartButton = getAddToCartButton();
        explicitlyWaitForClickability(addToCartButton);
        addToCartButton.click();
        System.out.println("Item added to cart.");
    }
	
	public void removeItemFromCart() {
		logger.debug("remove the item from the cart");
		
        WebElement removeFromCartButton = getRemoveFromCartButton();
        explicitlyWaitForClickability(removeFromCartButton);
        removeFromCartButton.click();
        System.out.println("Item removed from cart.");
    }
	
	public void isItemInCart() {
		logger.debug("check if the item is in the cart (button label changes to 'Remove')");
		
        WebElement cartButton = getAddToCartButton();
        explicitlyWaitForVisibility(cartButton);
        String buttonText = cartButton.getText();
        checkIfEqual(buttonText, "Remove");
    }
	
	public void checkItemQuantity() {
		logger.debug("check the item quantity");
		
        WebElement quantityInput = getCartPageIcon();
        explicitlyWaitForVisibility(quantityInput);
        String quantityValue = quantityInput.getText();
        System.out.println("Item Quantity: " + quantityValue);
        checkIfNotNull(quantityInput, "Item Quantity");
    }
	
	public void checkIfBackToProductsBtnFunctionallity() {
		logger.debug("check Back To Products Button Functionallity.");
		
		WebElement backButton = getBackButton();
		explicitlyWaitForClickability(backButton);
		checkIfNotNull(backButton, "Back To Products");
		CheckIfButtonIsEnable(backButton, "Back To Products");
		backButton.click();
		
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/inventory.html");
	}
}
