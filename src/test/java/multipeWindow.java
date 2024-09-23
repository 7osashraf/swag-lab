import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class multipeWindow {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.seleniumacademy.com/cookbook/Config.html");
		driver.manage().window().maximize();
	}
	
	
	
	@Test
	public void HandleMultipleWindow() {
		
		String CurrentWindow = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		driver.findElement(By.id("chatbutton")).click();
		driver.findElement(By.id("helpbutton")).click();
		
	for (String Window : driver.getWindowHandles()) {
		
		String Url = driver.switchTo().window(Window).getCurrentUrl();
		System.out.println(Url);
		
		if(Url.equals("https://www.seleniumacademy.com/cookbook/VisitUs.html")) {
			Assert.assertEquals(Url, driver.getCurrentUrl());
			driver.close();
		}
		else if(Url.equals("https://www.seleniumacademy.com/cookbook/OnlineChat.html")) {
			Assert.assertEquals(Url, driver.getCurrentUrl());
			driver.close();
		}
		else if(Url.equals("https://www.seleniumacademy.com/cookbook/Help.html")) {
			Assert.assertEquals(Url, driver.getCurrentUrl());
			driver.close();
		}
		
	}
	driver.switchTo().window(CurrentWindow);
	}
		
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
