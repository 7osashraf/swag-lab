package comp_Sidebar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SidebarComp extends SidebarWebElement{

	public void checkIfSidebarIsDisplayed() {
		logger.debug("Verify the sidebar is displayed.");

		WebElement sidebar = getSidebar();
		explicitlyWaitForVisibility(sidebar);
		checkIfNotNull(sidebar, "Sidebar");
		CheckIfTextIsDiplayed(sidebar, "Sidebar");
	}


	public void checkIfSidebarMenuOptions() {
		logger.debug("Check the sidebar menu options.");

		WebElement menuBtn = getMenuBtn();
		explicitlyWaitForClickability(menuBtn);
		menuBtn.click();

		WebElement sidebarMenu = getSidebarMenu();
		//explicitlyWaitForVisibility(sidebarMenu);
		checkIfNotNull(sidebarMenu, "Sidebar Menu");

	}




	public void checkIfAllItemsButton() throws InterruptedException {
		logger.debug("Check All Items button.");

		WebElement menuBtn = getMenuBtn();
		explicitlyWaitForClickability(menuBtn);
		menuBtn.click();

		WebElement allItemsButton = getAllItemsButton();
		explicitlyWaitForClickability(allItemsButton);

		Actions action = new Actions(driver);
		action.moveToElement(allItemsButton).build().perform();

		allItemsButton.click();

		String currentUrl = getDriver().getCurrentUrl();
		checkIfEqual(currentUrl, "https://www.saucedemo.com/inventory.html");
	}


	public void checkIfLogoutFromSidebar() throws InterruptedException {
		logger.debug("Check  logout.");

		WebElement menuBtn = getMenuBtn();
		explicitlyWaitForClickability(menuBtn);
		menuBtn.click();

		WebElement logoutButton = getLogoutButton();
		explicitlyWaitForClickability(logoutButton);
		checkIfNotNull(logoutButton, "Logout Button");

		Actions action = new Actions(driver);
		action.moveToElement(logoutButton).build().perform();

		logoutButton.click();

		String currentUrl = getDriver().getCurrentUrl();
		checkIfEqual(currentUrl, "https://www.saucedemo.com/");
	}



	public void checkIfAboutButton() throws InterruptedException {
		logger.debug("Check About button.");

		WebElement menuBtn = getMenuBtn();
		explicitlyWaitForClickability(menuBtn);
		menuBtn.click();

		WebElement aboutButton = getAboutButton();
		explicitlyWaitForClickability(aboutButton);

		Actions action = new Actions(driver);
		action.moveToElement(aboutButton).build().perform();

		aboutButton.click();

		String currentUrl = getDriver().getCurrentUrl();
		checkIfEqual(currentUrl, "https://saucelabs.com/");
	}

	public void checkIfResetAppStateButton() throws InterruptedException {
		logger.debug("Check Reset App State button.");

		WebElement menuBtn = getMenuBtn();
		explicitlyWaitForClickability(menuBtn);
		menuBtn.click();

		WebElement resetAppStateButton = getResetAppStateButton();
		explicitlyWaitForClickability(resetAppStateButton);

		Actions action = new Actions(driver);
		action.moveToElement(resetAppStateButton).build().perform();

		resetAppStateButton.click();
	}
}
