package test_header;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_Header.HeaderComp;
import comp_LoginPage.LoginPageComp;

public class headerTest extends HeaderComp{

	@BeforeMethod(alwaysRun = true)
    public void openBrowser() throws Exception {
        SetupTheDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws Exception {
        driver.quit();
    }
    
    @Test(priority = 1)
    public void CheckHeaderIsDisplayed() {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();

        checkIfHeaderIsDisplayed();
        //screenShot.captureScreenshot(driver, "HeaderCompTest", "CheckHeaderIsDisplayed");
    }

    @Test(priority = 2)
    public void testLogoIsPresent() {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();

        testIfLogoIsPresent();
        //screenShot.captureScreenshot(driver, "HeaderCompTest", "CheckLogoInHeader");
    }

    @Test(priority = 3)
    public void testCartIconFunctionality() {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();

        testIfCartIconFunctionality();
        //screenShot.captureScreenshot(driver, "HeaderCompTest", "CheckCartIconInHeader");
    }

    @Test(priority = 4)
    public void CheckHeaderNavigation() {
        LoginPageComp loginPageComp = new LoginPageComp();
        loginPageComp.testIfSuccessfulLogin();

        testMenuButtonFunctionality();
        //screenShot.captureScreenshot(driver, "HeaderCompTest", "CheckHeaderNavigation");
    }
}
