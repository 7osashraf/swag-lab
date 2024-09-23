package test_CheckoutComplete;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_CheckoutComplete.CheckoutCompleteComp;
import comp_CheckoutOverview.CheckoutOverviewComp;
import comp_CheckoutPage.CheckoutPageComp;
import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;
import comp_cartPage.CartPageComp;

public class CheckoutCompleteCompTest extends CheckoutCompleteComp{
	
	@BeforeMethod(alwaysRun = true)
    public void openBrowser() throws Exception {
        SetupTheDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws Exception {
        driver.quit();
    }
    
    @Test(priority = 1)
    public void checkCheckoutCompletePageIsDisplayed() throws InterruptedException {
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
        
        CheckoutOverviewComp checkoutOverviewComp = new CheckoutOverviewComp();
        checkoutOverviewComp.finishCheckout();
        
        checkIfCheckoutCompletePageIsDisplayed();
        
    }

    @Test(priority = 2)
    public void checkOrderConfirmation() throws InterruptedException {
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
        
        CheckoutOverviewComp checkoutOverviewComp = new CheckoutOverviewComp();
        checkoutOverviewComp.finishCheckout();
        
        checkOrderConfirmationMessage();
        
    }

}
