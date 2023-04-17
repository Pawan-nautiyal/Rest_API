package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element1= null;
	public static WebElement textboxsearch(WebDriver driver)
	{
		 element1= driver.findElement(By.name("q"));
		return element1;
		
	}
	public static WebElement button_search(WebDriver driver)
	{
		
		element1=driver.findElement(By.name("btnK"));
		return element1;
	}
}
