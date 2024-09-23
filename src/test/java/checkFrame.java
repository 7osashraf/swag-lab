import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class checkFrame {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.seleniumacademy.com/cookbook/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckFrame() {
	    driver.switchTo().frame(0);

	    WebElement FrameLeft = driver.findElement(By.tagName("p"));
	    Assert.assertEquals(FrameLeft.getText(), "This is Left Frame");

	    driver.switchTo().defaultContent();
	}
	
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
