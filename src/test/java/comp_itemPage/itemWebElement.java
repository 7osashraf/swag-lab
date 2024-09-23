package comp_itemPage;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class itemWebElement extends FindingElements{

	public WebElement getItemName() {return findElementByClassName("inventory_details_name");}
	public WebElement getItemDesc() {return findElementByClassName("inventory_details_desc");}
	public WebElement getItemPrice() {return findElementByClassName("inventory_details_price");}
	public WebElement getItemImage() {return findElementByClassName("inventory_details_img");}
	public WebElement getAddToCartButton() {return findElementByClassName("btn_inventory");}
	public WebElement getRemoveFromCartButton() {return findElementByClassName("btn_inventory");}
	public WebElement getCartPageIcon() {return findElementByClassName("shopping_cart_badge");}
	
	public WebElement getBackButton() {return findElementById("back-to-products");}
}
