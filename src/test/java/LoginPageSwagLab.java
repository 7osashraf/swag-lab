import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import comp_LoginPage.LoginPageWebElement;

public class LoginPageSwagLab extends LoginPageWebElement{
	
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
