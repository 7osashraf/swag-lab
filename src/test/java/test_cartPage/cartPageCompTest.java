package test_cartPage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;
import comp_cartPage.CartPageComp;

public class cartPageCompTest extends CartPageComp{
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws Exception {
        closeDriver(result);
    }
	
	@Test(priority = 1)
	public void checkCartPageOpened() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
	    
	    checkIfCartPageOpened();
	    checkIfCartPageIsDisplayed();
	    checkIFQuantityIsDisplayed();
	    checkIFDiscriptionIsDisplayed();
	    
	}
	
	@Test(priority = 2)
	public void verifyItemsInCart() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
	    
	    verifyIfItemsInCart();
	    
	}
	
	@Test(priority = 3)
	public void removesItemFromCart() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
	    
	    removeItemFromCart();
	    
	    // note add some delay
	    
	}
	
	
	// for try
	@Test(priority = 4)
	public void Try() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.addAllItemToCart();
	    homePageComp.clickOnCartIcon();
	    
	    removeThenBackToHomePage();
	    homePageComp.checkIfHomePageOpened();
	    
	    // note add some delay
	    
	}

}
