import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class screenshot {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testScreen() {
	   
		driver.findElement(By.id("user-name")).sendKeys("standard_use");
		driver.findElement(By.id("password")).sendKeys("standard_use");
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		
	}
	
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@org.testng.annotations.Test
	public void test() {
		driver.findElement(By.id("pass"));
	}
	
	@AfterMethod
	public void Check(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
		    TakesScreenshot screenshot = (TakesScreenshot) driver;
		    File source = screenshot.getScreenshotAs(OutputType.FILE);

		    FileUtils.copyFile(source, new File("./ScreenShots/" + result.getName()+ ".png"));
		}
	}
}
