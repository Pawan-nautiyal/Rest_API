package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageobjects;

public class GoogleSearchPageTest {
	
	public static WebDriver driver=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		googleSearchTest();

	}
	public static void googleSearchTest()
	{System.setProperty("webdriver.chrome.driver","C:\\Users\\Pawan Nautiyal\\Downloads\\chromedriver_mac64_m1\\chromedriver.exe");
	 driver= new ChromeDriver();	
	 GoogleSearchPageobjects srchobj= new GoogleSearchPageobjects(driver);
	 driver.get("https://google.com");
	 srchobj.setTextInSearchBox("Pawan");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 srchobj.clickSearchButton();
	 
	 driver.close();
	}
} 
