package comp_Footer;

import org.openqa.selenium.WebElement;

public class FooterComp extends FooterWebElement{


	public void checkIfFooterIsDisplayed() {
		logger.debug("verify the footer is displayed.");

		WebElement footer = getFooter();
		explicitlyWaitForVisibility(footer);
		checkIfNotNull(footer, "Footer");
		CheckIfTextIsDiplayed(footer, "Footer");
	}


	public void checkFooterCopyright() {
		logger.debug("check the copyright information.");

		WebElement copyright = getFooterCopyright();
		explicitlyWaitForVisibility(copyright);
		checkIfNotNull(copyright, "Footer Copyright");
		String copyrightText = copyright.getText();
		checkIfContain(copyrightText, "©");
		checkIfContain(copyrightText, "2024");
		checkIfContain(copyrightText, " Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
	}


	public void checkSocialMediaIcons() {
		logger.debug("check the social media icons ");

		WebElement socialIcons = getSocialMediaIcons();
		explicitlyWaitForVisibility(socialIcons);
		checkIfNotNull(socialIcons, "Social Media Icons");
	}


	public void checkFooterLinks() {
		logger.debug("check footer links");

		WebElement footerXlink = getFooterXlink();
		explicitlyWaitForVisibility(footerXlink);
		checkIfNotNull(footerXlink, "Footer Links");

		WebElement footerFacebooklink = getfooterFacebooklink();
		explicitlyWaitForVisibility(footerFacebooklink);
		checkIfNotNull(footerFacebooklink, "Footer Links");

		WebElement footerLinkedInlink = getfooterLinkedInlink();
		explicitlyWaitForVisibility(footerLinkedInlink);
		checkIfNotNull(footerLinkedInlink, "Footer Links");

		//click and verify individual links
		verifySocialMediaLink(footerFacebooklink, "https://www.facebook.com/saucelabs");
		verifySocialMediaLink(footerLinkedInlink, "https://www.linkedin.com/company/sauce-labs/");
		verifySocialMediaLink(footerXlink, "https://x.com/saucelabs");
	}

	public void verifySocialMediaLink(WebElement link, String expectedUrl) {
		logger.debug("verify Social Media Link");

		// Store the current window handle
		String mainWindow = driver.getWindowHandle(); 

		explicitlyWaitForClickability(link);
		link.click(); 

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle); // Switch to the new window
				String currentUrl = driver.getCurrentUrl();
				

				// Verify the current URL matches the expected URL
				checkIfEqual(currentUrl, expectedUrl);
				driver.close(); 
			}
		}

		driver.switchTo().window(mainWindow); // Switch back to the main window
	}

}
