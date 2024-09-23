package comp_CheckoutOverview;

import java.util.List;

import org.openqa.selenium.WebElement;

import Utility.FindingElements;

public class CheckoutOverviewWebElement extends FindingElements{
	
	public WebElement getTotalPrice() {return findElementByClassName("summary_subtotal_label");}

	public WebElement getFinishButton() {return findElementById("finish");}
	
	
	
	
	public List<WebElement> getItemList() { return findElementsByClassName("cart_item");}

	

}
