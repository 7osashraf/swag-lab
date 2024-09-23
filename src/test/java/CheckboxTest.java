import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest {

    private WebDriver driver;
    
    private final String baseUrl = "https://the-internet.herokuapp.com/checkboxes";
    private final String checkBoxXPath = "//input[@type='checkbox']";

    @BeforeTest
    public void OpenBrowser() {
        
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        
    }

    @Test
    public void testCheckboxes(){
        List<WebElement> checkboxe1 = driver.findElements(By.xpath(checkBoxXPath));
        System.out.println(checkboxe1.size());
       

        for (int i = 0; i < 2; i++) {
            // Click the checkbox
            WebElement checkbox = checkboxe1.get(i);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            // Verify checkbox is selected
            if (!checkbox.isSelected()) {
                throw new AssertionError("Checkbox " + (i + 1) + " is not selected after clicking.");
            }

            // Optional: Add a short pause for visual confirmation (uncomment if needed)
            // Thread.sleep(1000);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}