import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataTables {
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
	}
	
	@Test
	public void WebTable() {
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.print(rows.size());
		
		for(int i = 1; i < rows.size(); i++) {
			
			WebElement row = rows.get(i);
			WebElement UrlEdit = row.findElement(By.linkText("edit"));
			UrlEdit.click();
			
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#edit");
			
			WebElement UrlDelete = row.findElement(By.linkText("delete"));
			UrlDelete.click();
			
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#delete");
			
			System.out.println(row.getText());
			
		}
		
	}
	
	@Test
	public void WebTable2() {
		WebElement table = driver.findElement(By.id("table2"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		for(int j = 1; j < rows.size(); j++) {
			WebElement row = rows.get(j);
			WebElement UrlEdit = row.findElement(By.linkText("edit"));
			UrlEdit.click();
			
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#edit");
			
			WebElement UrlDelete = row.findElement(By.linkText("delete"));
			UrlDelete.click();
			
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#delete");
			
			System.out.println(row.getText());
			
		}
		
		
		
		
		
		
	}
	
	
	@Test
	public void Alert() {
		WebElement simpleBtn = driver.findElement(By.id("simple"));
		simpleBtn.click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		alert.dismiss();
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
