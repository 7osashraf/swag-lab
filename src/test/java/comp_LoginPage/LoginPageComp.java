package comp_LoginPage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.github.javafaker.Faker;

import Utility.DataUtils;
import Utility.ExcelUtils;
import comp_HomePage.HomePageComp;

public class LoginPageComp extends LoginPageWebElement {




	public void checkIfLoginPageOpened() {
		logger.debug("check if Login Page Opened.");

		// check URL and Login page
		String url = driver.getCurrentUrl();
		checkIfEqual(url, "https://www.saucedemo.com/");

		// Check if the "Swag Labs" logo is displayed
		WebElement logo = getUrl();
		explicitlyWaitForVisibility(logo);
		String logoText = logo.getText();
		checkIfEqual(logoText, "Swag Labs");


	}

	public void verifyPageElements() {
		logger.debug("Verify Page Element.");

		WebElement userName = getUserNameField();
		explicitlyWaitForVisibility(userName);
		CheckIfTextIsDiplayed(userName, "Username field");


		WebElement password  = getPassField();
		explicitlyWaitForVisibility(password);
		CheckIfTextIsDiplayed(password, "Password field");


		WebElement loginBtn = getLoginBtnField();
		explicitlyWaitForClickability(loginBtn);
		CheckIfTextIsDiplayed(loginBtn, "Login button");


	}

	public void CheckIfFieldsAddToWebSite() {
		logger.debug("check if Fields Added To The WebSite.");

		// check container of login button
		WebElement container = getContainer();
		explicitlyWaitForVisibility(container);
		checkIfNotNull(container, "Login Button Container");

		// Locate userName and password fields
		WebElement userName = getUserNameField();
		explicitlyWaitForVisibility(userName);
		WebElement password = getPassField();
		explicitlyWaitForVisibility(password);

		checkIfNotNull(userName, "Username Field");
		checkIfNotNull(password, "Password Field");

	}

	public void testIfLoginButtonFunctionality() {
		logger.debug("test If Login Button Functionality.");

		WebElement loginBtn = getLoginBtnField();
		explicitlyWaitForClickability(loginBtn);

		checkIfNotNull(loginBtn, "Login Button");
		CheckIfTextIsDiplayed(loginBtn, "Login button");
		CheckIfButtonIsEnable(loginBtn, "Login button");

		loginBtn.click();

		WebElement getErrorMsg = getErrorMsg();
		explicitlyWaitForVisibility(getErrorMsg);
		checkIfNotNull(getErrorMsg, "Error message");


	}

	public void testIfSuccessfulLogin() {
		logger.debug("test If Successful Login.");

		WebElement userName = getUserNameField();
		WebElement password = getPassField();
		WebElement loginBtn = getLoginBtnField();

		explicitlyWaitForVisibility(userName);
		explicitlyWaitForVisibility(password);
		explicitlyWaitForClickability(loginBtn);

		userName.clear();
		userName.sendKeys(getConfigValue("config", "UserName"));

		password.clear();
		password.sendKeys(getConfigValue("config", "Password"));

		loginBtn.click();

		// Wait for the new page to load
		explicitlyWaitForVisibility(getHomePageContaainer());

		String currentUrl = driver.getCurrentUrl();
		checkIfEqual(currentUrl, "https://www.saucedemo.com/inventory.html");

	}

	public void testIfInvalidCredentials() {
		logger.debug("test If Invalid Credentials.");

		WebElement userName = getUserNameField();
		WebElement password = getPassField();
		WebElement loginBtn = getLoginBtnField();


		explicitlyWaitForVisibility(userName);
		explicitlyWaitForVisibility(password);
		explicitlyWaitForClickability(loginBtn);

		userName.clear();
		userName.sendKeys("invalid_user");

		password.clear();
		password.sendKeys("invalid_password");

		loginBtn.click();

		WebElement getErrorMsg = getErrorMsg();
		explicitlyWaitForVisibility(getErrorMsg);
		checkIfNotNull(getErrorMsg, "Error message");

		String errMsg = getErrorMsg.getText();
		checkIfEqual(errMsg, "Epic sadface: Username and password do not match any user in this service");

	}

	public void testIfErrorMessageForMissingPassword() {
		logger.debug("test If Error Message For Missing Password.");

		WebElement usernameField = getUserNameField();
		WebElement loginButton = getLoginBtnField();


		explicitlyWaitForVisibility(usernameField);
		explicitlyWaitForClickability(loginButton);

		usernameField.sendKeys(getConfigValue("config", "UserName"));
		loginButton.click();

		WebElement getErrorMsgPass = getErrorMsg();
		explicitlyWaitForVisibility(getErrorMsgPass);
		checkIfNotNull(getErrorMsgPass, "Error Message");

		String errMsg = getErrorMsgPass.getText();
		System.out.println(errMsg);

		checkIfEqual(errMsg, "Epic sadface: Password is required");

	}

	public void testIfErrorMessageForMissingUsername() {
		logger.debug("test If Error Message For Missing Username.");

		WebElement passwordField = getPassField();
		WebElement loginButton = getLoginBtnField();

		explicitlyWaitForVisibility(passwordField);
		explicitlyWaitForClickability(loginButton);

		// Leave username field empty
		passwordField.sendKeys(getConfigValue("config", "Password")); 
		loginButton.click();

		WebElement getErrorMsgPass = getErrorMsg();
		explicitlyWaitForVisibility(getErrorMsgPass);
		checkIfNotNull(getErrorMsgPass, "Error Message");

		String errMsg = getErrorMsgPass.getText();
		System.out.println(errMsg);
		checkIfEqual(errMsg, "Epic sadface: Username is required");
	}



	public void testIfAllUsers() throws InterruptedException {
		logger.debug("test All user using array.");

		String[] users = {
				"standard_user",
				"locked_out_user",
				"problem_user",
				"performance_glitch_user",
				"error_user",
				"visual_user"
		};

		for (String user : users) {
			// Clear existing username and password
			getUserNameField().clear();
			getPassField().clear();

			// Enter username and password
			getUserNameField().sendKeys(user);
			getPassField().sendKeys(getConfigValue("config", "Password"));

			// Click the login button
			WebElement loginBtn = getLoginBtnField();
			explicitlyWaitForClickability(loginBtn);
			loginBtn.click();

			//			// Wait for page to load 
			//			explicitlyWaitForVisibility(getHomePageContaainer());

			// Check the result of the login attempt
			String currentUrl = driver.getCurrentUrl();

			if (user.equals("locked_out_user")) {
				// Check for error message specific to locked_out_user
				WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
				explicitlyWaitForVisibility(errorMessage);
				CheckIfTextIsDiplayed(errorMessage, "Error Message");
				String errMsg = errorMessage.getText();
				checkIfEqual(errMsg, "Epic sadface: Sorry, this user has been locked out.");

			} else if (currentUrl.contains("inventory.html")) {
				// Check successful login
				checkIfContain(currentUrl, "inventory.html");
				System.out.println("Login successful for user: " + user);

				// Logout after successful login
				WebElement menuButton = getMenuBtn();
				explicitlyWaitForClickability(menuButton);
				menuButton.click();

				WebElement logoutButton = getLogoutButton();
				explicitlyWaitForClickability(logoutButton);


				Actions action = new Actions(driver);
				action.moveToElement(logoutButton).build().perform();

				explicitlyWaitForClickability(logoutButton);
				logoutButton.click();



				// Wait for the logout to complete
				explicitlyWaitForVisibility(getUserNameField());

			} else {
				// Handle invalid users 
				WebElement errorMessage = getErrorMsg();
				explicitlyWaitForVisibility(errorMessage);
				CheckIfTextIsDiplayed(errorMessage, "Error Message");
				System.out.println("Error for user: " + user + " - " + errorMessage.getText());
			}

			// Clear cookies or reset session after each login attempt
			driver.manage().deleteAllCookies();
		}
	}


	public void checkCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Number of cookies: " + cookies.size());

		Iterator<Cookie> iterator = cookies.iterator();
		while (iterator.hasNext()) {
			Cookie cookie = iterator.next();
			System.out.println("Cookie Name: " + cookie.getName());
			System.out.println("Cookie Value: " + cookie.getValue());
		}


	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		driver.manage().addCookie(cookie);


	}

	public void deleteCookie(String name) {
		driver.manage().deleteCookieNamed(name);


	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();


	}

	public void verifyCookieExists(String name, String expectedValue) {
		Cookie cookie = driver.manage().getCookieNamed(name);
		Assert.assertNotNull(cookie, "Cookie with name " + name + " was not found");
		Assert.assertEquals(cookie.getValue(), expectedValue, "Cookie value did not match");

	}

	public void EnterLoginDataWithExcelFile() throws IOException {
		logger.debug("Enter data with Excel sheet.");

		// Path to the Excel file
		String excelFilePath = "./Resources/LoginData.xlsx";

		// Create instance of ExcelUtils to read login data
		ExcelUtils excelUtils = new ExcelUtils(excelFilePath);

		// Get login data (sheet name is "Sheet1")
		String[][] loginData = excelUtils.getLoginData("loginData");

		// Loop through the login data and perform login
		for (int i = 0; i < loginData.length; i++) {
			System.out.println(loginData.length);
			String username = loginData[i][0];
			String password = loginData[i][1];

			System.out.println("Logging in with Username: " + username + " and Password: " + password);

			WebElement userNameField = getUserNameField();
			WebElement passwordField = getPassField();
			WebElement loginButton = getLoginBtnField();


			// Wait for fields to be visible
			explicitlyWaitForVisibility(userNameField);
			explicitlyWaitForVisibility(passwordField);
			explicitlyWaitForClickability(loginButton);

			userNameField.clear();
			userNameField.sendKeys(username);

			passwordField.clear();
			passwordField.sendKeys(password);

			loginButton.click();


			if(username.equals("locked_out_user")) {
				WebElement errorMessage = getErrorMsg();
				explicitlyWaitForVisibility(errorMessage);
				CheckIfTextIsDiplayed(errorMessage, "Error Message");
				String errMsg = errorMessage.getText();
				checkIfEqual(errMsg, "Epic sadface: Sorry, this user has been locked out.");
				driver.navigate().back();
				continue;

			}
			//explicitlyWaitForVisibility(getHomePageContaainer());

			checkIfContain(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

			driver.navigate().back();

			//explicitlyWaitForVisibility(userNameField);
			checkIfContain(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		}

		excelUtils.workbook.close();
	}

	public void ExcelFileAnotherWay() {
		logger.debug("Excel File with another way");

		String excelFilePath = "./Resources/";  
		String excelFilename = "LoginData.xlsx";  
		String sheetName = "loginData";  


		DataUtils ExcelData = new DataUtils();
		String username = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 0);
		System.out.println("Username: " + username);

		WebElement userNameField = getUserNameField();
		explicitlyWaitForVisibility(userNameField);
		userNameField.sendKeys(username);

		String password = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 1);
		System.out.println("Password: " + password);

		WebElement passwordField = getPassField();
		explicitlyWaitForVisibility(passwordField);
		passwordField.sendKeys(password);

		WebElement loginButton = getLoginBtnField();
		explicitlyWaitForClickability(loginButton);
		loginButton.click();
	}

	public void ExcelFileAnotherWayForAllData() {
		logger.debug("Excel File Another Way For All Data");

		String excelFilePath = "./Resources/";  
		String excelFilename = "LoginData.xlsx";  
		String sheetName = "loginData";  

		DataUtils ExcelData = new DataUtils();
		ExcelData.getAllExcelData(excelFilePath, excelFilename, sheetName);

	}

	public void LoginWithConfig() throws InterruptedException {
		logger.debug("Login With Config Data");

		System.out.println("The Name Is: " + getConfigValue("config", "UserName"));

		WebElement UserNameField = getUserNameField();
		WebElement PasswordField = getPassField();
		//WebElement loginButton = getLoginBtnField();

		explicitlyWaitForVisibility(UserNameField);
		explicitlyWaitForVisibility(PasswordField);

		UserNameField.sendKeys(getConfigValue("config", "UserName"));
		PasswordField.sendKeys(getConfigValue("config", "Password"));
	}
	
	public void CheckLoginWithValidDataByJason() throws IOException, InterruptedException {

	    logger.debug("Check Login With Valid Data By Json");

	    WebElement UserNameField = getUserNameField();
	    checkIfNotNull(UserNameField, "User Name Field");

	    UserNameField.sendKeys(DataUtils.getJsonValue("LoginData", "UserLogin.UserName"));
	    logger.info("UserName: " + UserNameField.getAttribute("value"));

	    WebElement PasswordField = getPassField();

	    checkIfNotNull(PasswordField, "Password Field");

	    PasswordField.sendKeys(DataUtils.getJsonValue("LoginData", "UserLogin.Password"));
	    logger.info("Password: " + PasswordField.getAttribute("value"));

	    WebElement LoginButton = getLoginBtnField();

	    checkIfNotNull(LoginButton, "Login Button");
	    explicitlyWaitForClickability(LoginButton);

	    LoginButton.click();

	    HomePageComp homePageComp = new HomePageComp();
	    homePageComp.checkIfHomePageOpened();
	}
	
	public void CheckLoginWithJavaFaker() {
	    logger.debug("Checking Login With Java Faker");

	    Faker faker = new Faker();

	    String randomUserName = faker.name().username();
	    String randomPassword = faker.internet().password();

	    WebElement UserNameField = getUserNameField();
	    checkIfNotNull(UserNameField, "User Name Field");
	    UserNameField.sendKeys(randomUserName);
	    logger.info("UserName: " + randomUserName);

	    WebElement PasswordField = getPassField();
	    checkIfNotNull(PasswordField, "Password Field");
	    PasswordField.sendKeys(randomPassword);
	    logger.info("Password: " + randomPassword);

	    WebElement LoginButton = getLoginBtnField();
	    explicitlyWaitForClickability(LoginButton);
	    LoginButton.click();

	    checkIfEqual(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

}
