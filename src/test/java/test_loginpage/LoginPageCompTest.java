package test_loginpage;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import comp_LoginPage.LoginPageComp;

public class LoginPageCompTest extends LoginPageComp{


	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws Exception {
		SetupTheDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws Exception {
		closeDriver(result);

	}

	@Test(priority = 1)
	public void CheckLoginPageOpened() {
		checkIfLoginPageOpened();
		verifyPageElements();
	}

	@Test (priority = 2)
	public void CheckFieldsAddToWebSite() {
		CheckIfFieldsAddToWebSite();
	}

	@Test (priority = 3)
	public void testLoginButtonFunctionality() {
		testIfLoginButtonFunctionality();
	}

	@Test (priority = 4)
	public void testSuccessfulLogin() {
		testIfSuccessfulLogin();
	}

	@Test (priority = 5)
	public void testInvalidCredentials() {
		testIfInvalidCredentials();
	}

	@Test (priority = 6)
	public void testErrorMessageForMissingPassword() {
		testIfErrorMessageForMissingPassword();
	}

	@Test (priority = 7)
	public void testErrorMessageForMissingUsername() {
		testIfErrorMessageForMissingUsername();
	}

	@Test(priority = 8)
	public void checkCookiesAfterLogin() {
		testIfSuccessfulLogin();
		checkCookies();
	}

	@Test (priority = 9)
	public void testAllUsers() throws InterruptedException, IOException {
		EnterLoginDataWithExcelFile();
	}

	@Test
	public void CheckTheLoginWithExcelFile() throws IOException{
		ExcelFileAnotherWayForAllData();
	}

	@Test
	public void CheckTheLoginWithcONFIGfILE() throws IOException, InterruptedException{
		testIfAllUsers();
	}





}
