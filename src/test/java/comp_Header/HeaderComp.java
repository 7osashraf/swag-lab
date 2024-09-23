package comp_Header;

import org.openqa.selenium.WebElement;

public class HeaderComp extends HeaderWebElement{

	//verify the header is visible
	public void checkIfHeaderIsDisplayed() {
        WebElement header = getHeader();
        checkIfNotNull(header, "Header");
        CheckIfTextIsDiplayed(header, "Header");
    }
	
	
	//check the logo in the header
	public void testIfLogoIsPresent() {
        WebElement logo = getHeaderLogo();
        checkIfNotNull(logo, "Logo in Header");
        String logoSrc = logo.getAttribute("src");
        checkIfContain(logoSrc, "https://");
    }
	
	
	//Check if the header navigation links work
	public void testIfCartIconFunctionality() {
        WebElement cartIcon = getCartIcon();
        cartIcon.click();
        checkIfEqual(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
	
	
	
	public void testMenuButtonFunctionality() {
        WebElement menuButton = getMenuButton();
        checkIfNotNull(menuButton, "Menu Button");
        
        menuButton.click();

        //Verify the menu is opened
        WebElement sidebar = getSidebar();
        checkIfNotNull(sidebar, "Sidebar");
    }
	
	
}
