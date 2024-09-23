package test_ItemPage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_HomePage.HomePageComp;
import comp_LoginPage.LoginPageComp;
import comp_itemPage.itemComp;

public class itemPageCompTest extends itemComp{
	
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws Exception {
        closeDriver(result);
    }
	
	@Test(priority = 1)
	public void checkItemDetails() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.selectRandomItemAndClick();
	    
	    testItemDetails();
	   
	}
	
	@Test(priority = 2)
	public void testAddRemoveItemFromCart() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.selectRandomItemAndClick();
	    
	    addItemToCart();
	    isItemInCart();
	    checkItemQuantity();
	    removeItemFromCart();
	   
	}
	
	@Test(priority = 3)
	public void checkBackToProductsBtnFunctionallity() throws InterruptedException {
		LoginPageComp loginPageComp = new LoginPageComp();
	    loginPageComp.testIfSuccessfulLogin();
	    
	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.selectRandomItemAndClick();
	    
	    checkIfBackToProductsBtnFunctionallity();
	   
	}

}
