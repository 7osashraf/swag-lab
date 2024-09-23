import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class contextMenu {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/3.x/demo.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void contxtMenu() {
	    WebElement BoxClick = driver.findElement(By.cssSelector(".context-menu-one"));
	    Actions actions = new Actions(driver);
	    actions.contextClick(BoxClick).click().perform();
	    
	    
	    WebElement firstMenuItem = driver.findElement(By.cssSelector(".context-menu-item.context-menu-icon-edit"));
        firstMenuItem.click();
	    
	    Alert alert = driver.switchTo().alert();
	    String Message = alert.getText();
	    System.out.println(Message);
	    alert.accept();
	    
	}
	
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
