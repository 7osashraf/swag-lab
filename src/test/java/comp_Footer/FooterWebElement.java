package comp_Footer;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class FooterWebElement extends FindingElements{
	
	public WebElement getFooter() {return findElementByClassName("footer");}
	public WebElement getFooterCopyright() {return findElementByClassName("footer_copy");}
	public WebElement getSocialMediaIcons() {return findElementByClassName("social");}
	
	public WebElement getFooterXlink() {return findElementByClassName("social_twitter");}
	public WebElement getfooterFacebooklink() {return findElementByClassName("social_facebook");}
	public WebElement getfooterLinkedInlink() {return findElementByClassName("social_linkedin");}

}
