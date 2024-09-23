package comp_LoginPage;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class LoginPageWebElement extends FindingElements {


	public WebElement getUrl() {return findElementByClassName("login_logo");}
	public WebElement getErrorMsg() {return findElementByClassName("error-message-container");}

	public WebElement getContainer() {return findElementById("login_button_container");}
	public WebElement getUserNameField() {return findElementById("user-name");}
	public WebElement getPassField() {return findElementById("password");}
	public WebElement getLoginBtnField() {return findElementById("login-button");}
	public WebElement getMenuBtn() {return findElementById("react-burger-menu-btn");}
	public WebElement getLogoutButton() {return findElementById("logout_sidebar_link");}
	public WebElement getHomePageContaainer() {return findElementById("inventory_container");}




}
