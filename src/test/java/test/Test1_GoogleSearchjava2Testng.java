package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;

public class Test1_GoogleSearchjava2Testng {
	
	private static WebDriver driver1=null;
	@BeforeTest
	public void setuptest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pawan Nautiyal\\Downloads\\chromedriver_mac64_m1\\chromedriver.exe");
		 driver1= new ChromeDriver();	
		
	}

	@Test
	public void googleSearch()
	{
		
		
		driver1.get("https://google.com");
		GoogleSearchPage.textboxsearch(driver1).sendKeys("AutomationStepBy step");
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		GoogleSearchPage.button_search(driver1).sendKeys(Keys.RETURN);
	}
	@AfterTest
	public void teardown() {
		driver1.close();
		driver1.quit();
		System.out.println("Test completed Successfully");
		
		
	}
	
}