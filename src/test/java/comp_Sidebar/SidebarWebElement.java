package comp_Sidebar;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class SidebarWebElement extends FindingElements{

	public WebElement getSidebar() {return findElementByClassName("bm-menu");}
	public WebElement getSidebarMenu() {return findElementByClassName("bm-item-list");}
	public WebElement getLogoutButton() {return findElementById("logout_sidebar_link");}


	public WebElement getLoginButton() {return findElementById("login-button");}
	public WebElement getMenuBtn() {return findElementById("react-burger-menu-btn");}
	public WebElement getAllItemsButton() {return findElementById("inventory_sidebar_link");}
	public WebElement getAboutButton() {return findElementById("about_sidebar_link");}
	public WebElement getResetAppStateButton() {return findElementById("reset_sidebar_link");}
}
