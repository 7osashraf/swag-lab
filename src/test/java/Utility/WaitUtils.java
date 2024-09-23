package Utility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends TestingMethod {

	public static void explicitlyWaitForClickability(WebElement element) {
		
		new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT"))))
		.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void explicitlyWaitForVisibility(WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_EXPLICIT"))))
			.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			System.out.println("The Element Is: " + e);
		}
	}

	public static void implicitlyWait() {
		getDriver().manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(Integer.parseInt(getConfigValue("config", "WAIT_IMPLICIT"))));
	}

	public static void Thread(int duration) throws InterruptedException {
		Thread.sleep(duration);
	}
}
