package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageobjects {

		
	 WebDriver driver = null;
	 
	 By textbox_search = By.name("q");
	 By button_search = By.name("btnK");
	 
	 public GoogleSearchPageobjects(WebDriver driver1) {
		 
		 this.driver=driver1; 
		 
	 }
	 
	 public void setTextInSearchBox(String text)
	 {
		driver.findElement(textbox_search).sendKeys(text); 
	 }
	 public void clickSearchButton()
	 {
		driver.findElement(button_search).sendKeys(Keys.RETURN); 
	 }
	
}
