package comp_cartPage;

import java.util.List;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class CartPageWebElement extends FindingElements{
	
	
	public WebElement getCartPage() {return findElementById("shopping_cart_container");}
	//public WebElement getRemoveButton() {return findElementById("remove-sauce-labs-backpack");}
	public WebElement getCheckoutButton() {return findElementById("checkout");}
	public WebElement getContShopping() {return findElementById("continue-shopping");}
	
	public WebElement getQuant() {return findElementByClassName("cart_quantity_label");}
	public WebElement getDiscription() {return findElementByClassName("cart_desc_label");}
	
	
	
	public List<WebElement> getCartItems() {return findElementsByClassName("cart_item");}
	public List<WebElement> getRemovesButton() {return findElementsByClassName("btn_secondary");}
	
	

}
