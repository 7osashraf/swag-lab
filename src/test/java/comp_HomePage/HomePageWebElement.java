package comp_HomePage;

import java.util.List;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class HomePageWebElement extends FindingElements{


	public WebElement getProductList() {return findElementByClassName("inventory_list");}
	public WebElement getCartIcon() {return findElementByClassName("shopping_cart_link");}
	public WebElement getMenuButton() {return findElementById("react-burger-menu-btn");}
	public WebElement getLogoutButton() {return findElementById("logout_sidebar_link");}

	public WebElement getAddToCartBtn() {return findElementById("add-to-cart-sauce-labs-backpack");}
	public WebElement getRemoveBtn() {return findElementById("remove-sauce-labs-backpack");}
	public WebElement getCartBadge() {return findElementByClassName("shopping_cart_badge");}
	public WebElement getproductTitle() {return findElementByClassName("title");}
	public WebElement getItemTitleOnPage() {return findElementByClassName("inventory_details_name");}
	public WebElement getSortButtong() {return findElementByClassName("product_sort_container");}
	
	public List<WebElement> getDropDown() {return findElementsByTagName("option");}

	public List<WebElement> getItemList() { return findElementsByClassName("inventory_item");}
	
	public List<WebElement> getItemssName() { return findElementsByClassName("inventory_item_name");}


}

