package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class screenShot extends E2Logger{
	
	// Method to capture screenshot of the whole page
	public static void captureScreenshot(WebDriver driver, String testClassName, String testMethodName) {
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    // Define the directory path based on the class and method name
	    String directoryPath = "./ScreenShots/" + testClassName;

	    File targetDirectory = new File(directoryPath);
	    if (!targetDirectory.exists()) {
	        targetDirectory.mkdirs();
	    }

	    File targetFile = new File(targetDirectory, testClassName + "_" + testMethodName + ".png");

	    try {
	        FileUtils.copyFile(scrFile, targetFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	 // Method to capture screenshot of a specific element
	public static void captureElementScreenshot(WebElement element, String testClassName, String testMethodName) {
	    File scrFile = element.getScreenshotAs(OutputType.FILE);

	    String directoryPath = "./ScreenShots/";
	    File targetDirectory = new File(directoryPath);

	    if (!targetDirectory.exists()) {
	        targetDirectory.mkdirs();
	    }

	    File targetFile = new File(targetDirectory, testClassName + "_" + testMethodName + ".png");

	    try {
	        FileUtils.copyFile(scrFile, targetFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
