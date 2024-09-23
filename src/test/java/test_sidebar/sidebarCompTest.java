package test_sidebar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_LoginPage.LoginPageComp;
import comp_Sidebar.SidebarComp;

public class sidebarCompTest extends SidebarComp{
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {
		driver.quit();
	}

	@Test(priority = 1)
	public void CheckSidebarIsDisplayed() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfSidebarIsDisplayed();
	}

	@Test(priority = 2)
	public void CheckSidebarMenuOptions() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfSidebarMenuOptions();

	}

	@Test(priority = 3)
	public void checkAllItemsButton() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfAllItemsButton();
	}
	@Test(priority = 3)
	public void CheckLogoutFromSidebar() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfLogoutFromSidebar();
	}
	@Test(priority = 3)
	public void checkAboutButton() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfAboutButton();
	}
	@Test(priority = 3)
	public void checkResetAppStateButton() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfResetAppStateButton();
	}
}
