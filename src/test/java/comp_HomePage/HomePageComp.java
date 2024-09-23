package comp_HomePage;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

public class HomePageComp extends HomePageWebElement{


	// Verify that the home page is opened by checking the URL and page title
	public void checkIfHomePageOpened() {
		logger.debug("Checking the home page is opened.");

		//check URL and Home Page
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/inventory.html");

		//Check Page Title
		String pageTitle = driver.getTitle();
		checkIfEqual(pageTitle, "Swag Labs");
	}

	public void verifyIfPageElement() {

		logger.debug("Verifying if page elements are displayed.");

		//Check if the product list is displayed
		WebElement productList = getProductList();
		explicitlyWaitForVisibility(productList);
		checkIfNotNull(productList, "Product List");
		CheckIfTextIsDiplayed(productList, "Product List");

		//Check if the cart icon is displayed
		WebElement cartIcon = getCartIcon();
		explicitlyWaitForVisibility(cartIcon);
		checkIfNotNull(cartIcon, "Cart Icon");
		CheckIfTextIsDiplayed(cartIcon, "Cart Icon");

		// Check if the menu button is displayed
		WebElement menuButton = getMenuButton();
		explicitlyWaitForVisibility(menuButton);
		checkIfNotNull(menuButton, "Menu Button");
		CheckIfTextIsDiplayed(menuButton, "Menu Button");


		// check if  Products title is displayed
		WebElement productTitle = getproductTitle();
		explicitlyWaitForVisibility(productTitle);
		checkIfNotNull(productTitle, "Product Title");
		CheckIfTextIsDiplayed(productTitle, "Product Title");
		checkIfEqual(productTitle.getText(), "Products");
	}

	public void ClickOnAddToCartButton() {
		logger.debug("Clicking on Add To Cart Button.");

		WebElement addToCartButton = getAddToCartBtn();
		explicitlyWaitForClickability(addToCartButton);
		checkIfNotNull(addToCartButton, "Add to Cart Button");

		String textAddToCartButton = addToCartButton.getText();
		checkIfContain(textAddToCartButton, "Add to cart");

		CheckIfButtonIsEnable(addToCartButton, "Add to Cart Button");
		addToCartButton.click();
	}


	public void CheckTheNumberBadgedAddedToCartIcon() {
		logger.debug("Checking number badge on Cart Icon.");

		WebElement numberBadge = getCartBadge();
		explicitlyWaitForVisibility(numberBadge);
		checkIfNotNull(numberBadge, "Cart Badge");

		String numberBadgeText = numberBadge.getText();
		checkIfContain(numberBadgeText, "1");
	}

	public void CheckIfTextAndColorForRemoveButton() {
		logger.debug("Checking text and color of Remove Button.");
		WebElement removeButton = getRemoveBtn();
		explicitlyWaitForVisibility(removeButton);
		checkIfNotNull(removeButton, "Remove Button");

		String textRemoveButton = removeButton.getText();
		checkIfContain(textRemoveButton, "Remove");

		String color = removeButton.getCssValue("color");
		System.out.println("Remove Button Color: " + color);
	}


	public void ClickOnRemoveButton() {
		logger.debug("Clicking on Remove Button.");

		WebElement removeButton = getRemoveBtn();
		explicitlyWaitForClickability(removeButton);
		checkIfNotNull(removeButton, "Remove Button");

		String textRemoveButton = removeButton.getText();
		checkIfContain(textRemoveButton, "Remove");

		CheckIfButtonIsEnable(removeButton, "Remove Button");
		removeButton.click();

	}

	public void CheckTextForAddToCartButton() {
		logger.debug("Checking text for Add To Cart Button.");

		WebElement addToCartButton = getAddToCartBtn();
		explicitlyWaitForVisibility(addToCartButton);
		checkIfNotNull(addToCartButton, "Add to Cart Button");

		String textAddToCartButton = addToCartButton.getText();
		checkIfContain(textAddToCartButton, "Add to cart");

		String color = addToCartButton.getCssValue("color");
		System.out.println("Add to Cart Button Color: " + color);
	}

	public void CheckTheNumberBadgeUpdatedInCartIcon() {
		logger.debug("Checking updated number badge on Cart Icon.");

		WebElement numberBadge = getCartBadge();
		explicitlyWaitForVisibility(numberBadge);

		checkIfNotNull(numberBadge, "Cart Badge");
		String numberBadgeText = numberBadge.getText();
		checkIfContain(numberBadgeText, "0");
	}




	public void addAllItemToCart() throws InterruptedException {
		logger.debug("Adding all items to the cart.");

		//get the list of items
		List<WebElement> items = getItemList();
		CheckIfNotNullForList(items, "Item List");

		int numberOfItems = items.size();
		System.out.println("the number of items is " + numberOfItems);
		checkIfEqual(String.valueOf(numberOfItems), "6");


		for(int i = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);

			//check the item name 
			WebElement itemName = item.findElement(By.className("inventory_item_name"));
			explicitlyWaitForVisibility(itemName);

			String nameText = itemName.getText();
			System.out.println("Item Name: " + nameText);
			checkIfNotNull(itemName, "Item Name");

			// ================= new added ======================// 
			itemName.click();

			WebElement itemTitleOnPage = getItemTitleOnPage();
			explicitlyWaitForVisibility(itemTitleOnPage);

			//check the URL
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Navigated to URL: " + currentUrl);
			checkIfContain(currentUrl, "/inventory-item.html");

			//check if the same name
			checkIfEqual(itemTitleOnPage.getText(), nameText);

			driver.navigate().back();

			explicitlyWaitForVisibility(driver.findElement(By.className("inventory_item_name")));

			//Re-fetch the list of items to avoid stale element exceptions
			items = getItemList();
			item = items.get(i);



			//check the item image
			WebElement itemImage = item.findElement(By.xpath("//img[@class=\"inventory_item_img\"]"));
			explicitlyWaitForVisibility(itemImage);

			String imageUrl = itemImage.getAttribute("src");
			checkIfContain(imageUrl, "https://");


			//check the item description
			WebElement itemDescription = item.findElement(By.className("inventory_item_desc"));
			explicitlyWaitForVisibility(itemDescription);

			String descriptionText = itemDescription.getText();
			System.out.println("Item Description: " + descriptionText);
			checkIfNotNull(itemDescription, "Item Description");

			//check the item price
			WebElement itemPrice = item.findElement(By.className("inventory_item_price"));
			explicitlyWaitForVisibility(itemPrice);
			String priceText = itemPrice.getText();
			System.out.println("Item Price: " + priceText);
			checkIfNotNull(itemPrice, "Item Price");
			checkIfContain(priceText, "$");


			//check if item can add  to cart
			WebElement addToCartButton = item.findElement(By.tagName("button"));
			explicitlyWaitForClickability(addToCartButton); 
			String buttonText = addToCartButton.getText();
			System.out.println("Button Text: " + buttonText);
			checkIfEqual(buttonText, "Add to cart");

			CheckIfButtonIsEnable(addToCartButton, "Add to Cart Button");
			//add the item to the cart
			addToCartButton.click();     
		}

		System.out.println("All items have been added to the cart.");
	}


	public void addAllItemToCartAndVerifyBadgeUpdate() throws InterruptedException {
		logger.debug("Adding all items to the cart and verifying badge updates.");

		//get the list of items
		List<WebElement> items = getItemList();
		CheckIfNotNullForList(items, "Item List");

		int numberOfItems = items.size();
		System.out.println("The number of items is " + numberOfItems);
		checkIfEqual(String.valueOf(numberOfItems), "6");

		for(int i = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);


			WebElement addToCartButton = item.findElement(By.tagName("button"));
			explicitlyWaitForClickability(addToCartButton);

			//add the item to the cart
			addToCartButton.click();

			WebElement numberBadge = getCartBadge();
			explicitlyWaitForVisibility(numberBadge); 

			checkIfNotNull(numberBadge, "Cart Badge");
			String numberBadgeText = numberBadge.getText();
			System.out.println("Number of items in the cart: " + numberBadgeText);

			//verify that the number of items in the cart is updated correctly
			checkIfEqual(numberBadgeText, String.valueOf(i + 1));
		}

		System.out.println("All items have been added to the cart and the badge is updated correctly.");

	}

	public void removeAllItemsAndVerifyBadgeUpdate() throws InterruptedException{
		logger.debug("Removing all items from the cart and verifying badge updates.");

		//get the list of items
		List<WebElement> items = getItemList();
		CheckIfNotNullForList(items, "Item List");

		int numberOfItems = items.size();
		System.out.println("The number of items in the cart is " + numberOfItems);
		checkIfEqual(String.valueOf(numberOfItems), "6");

		//add all items to the cart
		addAllItemToCartAndVerifyBadgeUpdate();

		for(int i  = 0; i < numberOfItems; i++) {
			WebElement item = items.get(i);

			WebElement removeBtn = item.findElement(By.tagName("button"));
			explicitlyWaitForClickability(removeBtn);

			CheckIfButtonIsEnable(removeBtn, "Remove Button");

			String buttonText = removeBtn.getText();
			System.out.println("Button Text: " + buttonText);
			checkIfEqual(buttonText, "Remove");


			//remove the item from the cart
			removeBtn.click();


			// i add this code because after you remove all item the class will disspear 
			if(5 == i) {
				System.out.println("Number of items in the cart after removal: 0");
				break;
			}

			//get the Cart icon to check
			WebElement numberBadge = getCartBadge();
			explicitlyWaitForVisibility(numberBadge);

			checkIfNotNull(numberBadge, "Cart Badge");

			//verify that the  badge updates correctly
			String numberBadgeText = numberBadge.getText();
			int expectedBadgeNumber = numberOfItems - (i + 1);
			System.out.println("Number of items in the cart after removal: " + numberBadgeText);


			//verify that  the number of items in the cart is updated
			checkIfEqual(numberBadgeText, String.valueOf(expectedBadgeNumber));


		}
		System.out.println("All items have been removed from the cart and the badge is updated ");
	}

	public void clickOnCartIcon() {
		logger.debug("click on cart button to navigate to cart page.");

		WebElement cartIcon = getCartIcon();
		explicitlyWaitForClickability(cartIcon);

		checkIfNotNull(cartIcon, "Cart Icon");
		CheckIfButtonIsEnable(cartIcon, "Cart Icon");

		cartIcon.click();
	}


	public void testProductSortAndValidation() throws InterruptedException {

		//		WebElement sortButton = getSortButtong();
		//		explicitlyWaitForClickability(sortButton);
		//		
		//		checkIfNotNull(sortButton, "Sort Button");
		//		CheckIfButtonIsEnable(sortButton, "Sort Button");
		//		
		//		sortButton.click();


		// Locate all dropdown options
		List<WebElement> dropDown = getDropDown();

		// Get the size of the dropdown options
		int options = dropDown.size();
		System.out.println("The Size Of DropDown Is: " + options);

		// Select a dropdown option using a random selection
		Random random = new Random();
		int randomButtonIndex = random.nextInt(options);

		// Print the selected dropdown index and the selected option text
		System.out.println("The Number Of Button Clicked Is = " + randomButtonIndex);
		String selectedText = dropDown.get(randomButtonIndex).getText();
		System.out.println("Selected Option: " + selectedText);

		// Click the selected dropdown option
		dropDown.get(randomButtonIndex).click();

		// Retrieve and print all information about the logged-in user (cookies)
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);

		// Get all products displayed on the page
		List<WebElement> allProducts = getItemList();
		System.out.println("Total Products Displayed: " + allProducts.size());

		// Get the text of the first product for validation
		String firstProductText = allProducts.get(0).getText();
		System.out.println("First Product Text: " + firstProductText);

		// Check if the products are sorted correctly based on the selected option
		if (selectedText.contains("Name (Z to A)")) {
			// Example check for sorting Z to A
			checkIfContain(firstProductText, "Test");
			System.out.println("Selected Z to A sorting.");

		} else if (selectedText.contains("Name (A to Z)")) {
			// Example check for sorting A to Z
			checkIfContain(firstProductText, "Sauce");
			System.out.println("Selected A to Z sorting.");

		} else if (selectedText.contains("Price (low to high)")) {
			// Example check for low to high price sorting
			checkIfContain(firstProductText, "$7.99");
			System.out.println("Selected Price (low to high) sorting.");

		} else if (selectedText.contains("Price (high to low)")) {
			// Example check for high to low price sorting
			checkIfContain(firstProductText, "$49.99");
			System.out.println("Selected Price (high to low) sorting.");

		} else {
			System.out.println("Unexpected sorting option.");
		}
	}


	public void selectRandomItemAndClick() {
		logger.debug("Selecting a random item and clicking on it.");

		List<WebElement> itemNames  = getItemssName();
		CheckIfNotNullForList(itemNames, "Item Names List");

		// Verify that the item list is not empty
		int numberOfItems = itemNames.size();
		System.out.println("Total number of items: " + numberOfItems);
		checkIfEqual(String.valueOf(numberOfItems), "6");

		// Generate a random index to select an item
		Random random = new Random();
		int randomIndex = random.nextInt(numberOfItems);

		// Retrieve and print the selected item's name
		WebElement selectedItem = itemNames.get(randomIndex);
		String selectedItemName = selectedItem.getText();
		System.out.println("Selected item: " + selectedItemName);
		
		// Click on the selected item
	    explicitlyWaitForClickability(selectedItem);
	    selectedItem.click();
	    
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println("Navigated to URL: " + currentUrl);
	    checkIfContain(currentUrl, "/inventory-item.html");

	}





}
