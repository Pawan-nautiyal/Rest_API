package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPage;

public class Test1_GoogleSearchjava {
	
	private static WebDriver driver1=null;

	public static void main(String[] args) {
		googleSearch();
		// TODO Auto-generated method stub

	}


	public static void googleSearch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pawan Nautiyal\\Downloads\\chromedriver_mac64_m1\\chromedriver.exe");
		 driver1= new ChromeDriver();	
		
		driver1.get("https://google.com");
		GoogleSearchPage.textboxsearch(driver1).sendKeys("AutomationStepBy step");
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		GoogleSearchPage.button_search(driver1).sendKeys(Keys.RETURN);
	}
	
}