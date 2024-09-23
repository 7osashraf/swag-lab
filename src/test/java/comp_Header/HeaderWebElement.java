package comp_Header;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class HeaderWebElement extends FindingElements{
	
	public WebElement getHeader() {return findElementByClassName("header_secondary_container");}
	public WebElement getHeaderLogo() {return findElementByClassName("app_logo");}
	public WebElement getCartIcon() {return findElementByClassName("shopping_cart_link");}
	public WebElement getSidebar() {return findElementByClassName("bm-item-list");}
	
	
	public WebElement getMenuButton() {return findElementById("react-burger-menu-btn");}
	
}
