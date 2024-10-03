package test_CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_CheckoutPage.CheckoutPageComp;
import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;
import comp_cartPage.CartPageComp;

public class CheckoutPageCompTest extends CheckoutPageComp{
	
	@BeforeMethod(alwaysRun = true)
    public void openBrowser() throws Exception {
        SetupTheDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws Exception {
        driver.quit();
    }
    
    @Test(priority = 1)
    public void checkCheckoutPageIsDisplayed() throws InterruptedException {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();
        
        HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
        
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.proceedToCheckout();
        
        checkIfCheckoutPageIsDisplayed();
        
    }
    
    @Test(priority = 2)
    public void checkProceedToCheckoutOverview() throws InterruptedException {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();
        
        HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
        
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.proceedToCheckout();
        
        enterCheckoutInformation("Hosam", "Ashraf", "12345");
        Thread.sleep(1000);
        proceedToCheckoutOverview();
    }

    @Test(priority = 2)
    public void checkProceedToCheckoutOverviewUsingExcel() throws InterruptedException {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();
        
        HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
        
        CartPageComp cartPageComp = new CartPageComp();
        cartPageComp.proceedToCheckout();
        
        enterCheckoutInformationFromExcel();
        Thread.sleep(1000);
        proceedToCheckoutOverview();
    }
}
