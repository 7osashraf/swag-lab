package test_Footer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_Footer.FooterComp;
import comp_LoginPage.LoginPageComp;

public class FooterCompTest extends FooterComp{

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws Exception {
		driver.quit();
	}


	@Test(priority = 1)
	public void CheckFooterIsDisplayed() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkIfFooterIsDisplayed();
	}

	@Test(priority = 2)
	public void CheckFooterCopyrightTest() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkFooterCopyright();
	}

	@Test(priority = 3)
	public void CheckSocialMediaIconsTest() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkSocialMediaIcons();
	}

	@Test(priority = 4)
	public void CheckFooterLinksTest() {
		LoginPageComp loginPageComp = new LoginPageComp();
		loginPageComp.testIfSuccessfulLogin();

		checkFooterLinks();
	}


}
