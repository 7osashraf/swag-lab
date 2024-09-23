package test_CheckoutOverview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_CheckoutOverview.CheckoutOverviewComp;
import comp_CheckoutPage.CheckoutPageComp;
import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;
import comp_cartPage.CartPageComp;

public class CheckoutOverviewCompTest extends CheckoutOverviewComp{

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {
		driver.quit();
	}
	
	@Test(priority = 1)
    public void checkCheckoutOverviewPageIsDisplayed() throws InterruptedException {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();
        
        HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
        
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.proceedToCheckout();
        
        CheckoutPageComp checkoutPageComp = new CheckoutPageComp();
        checkoutPageComp.enterCheckoutInformation("Hosam", "Ashraf", "12345");
        checkoutPageComp.proceedToCheckoutOverview();

        checkIfCheckoutOverviewPageIsDisplayed();
        
    }

	@Test(priority = 2)
    public void checkFinishCheckout() throws InterruptedException {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();
        
        HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
        
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.proceedToCheckout();
        
        CheckoutPageComp checkoutPageComp = new CheckoutPageComp();
        checkoutPageComp.enterCheckoutInformation("Hosam", "Ashraf", "12345");
        checkoutPageComp.proceedToCheckoutOverview();
        
        double totalPrice = calculateSumOfItemPrices();

        checkTotalPrice(String.valueOf(totalPrice));
        finishCheckout();
        
    }
}
