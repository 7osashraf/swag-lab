package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;

public class settingUpWebDriver extends ScreenRecord {
	public static WebDriver driver;

	 public void SetupTheDriver() throws Exception {
	        //ScreenRecorderUtil.startRecord("Setup TheDriver");
	        //ScreenRecorderUtils2.startRecording("Setup TheDriver");
		 //ScreenRecord.startRecording("LoginPage");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to(getConfigValue("config", "URL"));
	    }
	 
	 public static WebDriver getDriver() {
	        return driver;

	    }
	 
	 public void closeDriver(ITestResult result) throws Exception {
		 //ScreenRecord.stopRecording();
	        if(!result.isSuccess()) {
	            String testClassName = result.getTestClass().getName();
	            String testMethodName = result.getMethod().getMethodName();
	            screenShot.captureScreenshot(driver, testClassName, testMethodName);
	        }
	        
	        Thread.sleep(2000);
	        driver.quit();
	    }
	 
	 public void setup(ITestResult result) throws Exception {

		    // Initialize the WebDriver using the factory
		    driver = getBrowser("chrome-headless");

		    driver.manage().window().maximize();

		    driver.get("https://www.saucedemo.com/");
		    
		    

		    //ScreenRecorderUtils2.startRecording(result.getMethod().getMethodName());
		}
	 
	 public static WebDriver getBrowser(String browserType) {
		    switch (browserType.toLowerCase()) {
		        case "chrome":
		            driver = new ChromeDriver();
		            break;
		        case "firefox":
		            driver = new FirefoxDriver();
		            break;
		        case "edge":
		            driver = new EdgeDriver();
		            break;
		        case "safari":
		            driver = new SafariDriver(); // SafariDriver comes pre-installed with macOS
		            break;
		        case "chrome-headless":
		            ChromeOptions options = new ChromeOptions();
		            options.addArguments("--headless");
		            options.addArguments("--disable-gpu"); // Applicable for Windows
		            options.addArguments("--window-size=1920,1080");
		            driver = new ChromeDriver(options);
		            break;
		        default:
		            System.out.println("Invalid browser type! Please check the input.");
		    }
		    return driver;
		}
}
