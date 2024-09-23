package test_homePage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;

public class HomePageCompTest extends HomePageComp{


	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws Exception {
		closeDriver(result);
	}


	@Test
	public void checkPageTitle() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfHomePageOpened();

	}

	@Test
	public void checkIfAllItemsAreDisplayed() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		// Ensures page elements like product list are displayed
		verifyIfPageElement();  

	}


	@Test(priority = 1)
	public void CheckIfClickOnAddToCartButton() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		ClickOnAddToCartButton();


	}

	@Test(priority = 2)
	public void CheckIfNumberBadgetAddedToCartIcon() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		ClickOnAddToCartButton();

		CheckTheNumberBadgedAddedToCartIcon();

	}

	@Test(priority = 3)
	public void CheckTextAndColorForRemoveButton() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		ClickOnAddToCartButton();
		CheckTheNumberBadgedAddedToCartIcon();
		CheckIfTextAndColorForRemoveButton();

	}

	@Test(priority = 4)
	public void ClickOnTheRemoveButton() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		ClickOnAddToCartButton();
		ClickOnRemoveButton();
		CheckTextForAddToCartButton();


	}

	@Test(priority = 5)
	public void CheckIfSpecificThreeItemsAreAddedToCart() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		addAllItemToCart();

	}

	@Test(priority = 6)
	public void CheckIfAllItemsAreAddedAndBadgeUpdates() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		addAllItemToCartAndVerifyBadgeUpdate();

	}

	@Test(priority = 7)
	public void CheckIfAllItemsAreRemovedAndBadgeUpdates() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		// Remove all items from the cart and verify the badge update
		removeAllItemsAndVerifyBadgeUpdate();

	}
	
	@Test(priority = 8)
	public void testIfProductSortAndValidation() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		// Remove all items from the cart and verify the badge update
		testProductSortAndValidation();

	}



}
