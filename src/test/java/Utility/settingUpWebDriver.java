package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
}
