import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cookies {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	
	
	@Test
	public void checkCookies() {
		WebElement getUserNameField = driver.findElement(By.id("user-name"));
		WebElement getPasswordField = driver.findElement(By.id("password"));
	    WebElement getLoginBtn = driver.findElement(By.id("login-button"));

	    getUserNameField.sendKeys("standard_user");
	    getPasswordField.sendKeys("secret_sauce");
	    getLoginBtn.click();

	    Set<Cookie> cookies = driver.manage().getCookies();
	    System.out.println(cookies.size());
	    System.out.println(cookies);

	    Iterator<Cookie> iterator = cookies.iterator();
	    while (iterator.hasNext()) {
	        Cookie cookie = (Cookie) iterator.next();
	        System.out.println(cookie.getValue());
	        System.out.println(cookie.getName());
	    }
	
	
	
	}
		
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
