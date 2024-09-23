package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindingElements extends WaitUtils{
	
	public WebElement findElementById(String id) {WebElement elemnt = driver.findElement(By.id(id));
	return elemnt;}
	
	public WebElement findElementByClassName(String className) {WebElement elemnt = driver.findElement(By.className(className));
	return elemnt;}
	
	public WebElement findElementByTagName(String tagName) {WebElement elemnt = driver.findElement(By.tagName(tagName));
	return elemnt;}
	
	public WebElement findElementByXPath(String xPath) {WebElement elemnt = driver.findElement(By.xpath(xPath));
	return elemnt;}
	
	
	public List<WebElement> findElementsById(String Id) {
	    List<WebElement> elements = driver.findElements(By.id(Id));
	    return elements;
	}
	
	public List<WebElement> findElementsByClassName(String className) {
	    List<WebElement> elements = driver.findElements(By.className(className));
	    return elements;
	}
	
	public List<WebElement> findElementsByXpath(String Xpath) {
	    List<WebElement> elements = driver.findElements(By.xpath(Xpath));
	    return elements;
	}
	
	public List<WebElement> findElementsByTagName(String tagName) {
	    List<WebElement> elements = driver.findElements(By.tagName(tagName));
	    return elements;
	}
	
	
	
}
