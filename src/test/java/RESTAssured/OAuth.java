package RESTAssured;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;
public class OAuth {
	  public static void main (String[]args) throws InterruptedException
	  {
		  
		  
		  /*System.getProperty("webdriver.chrome.driver","C://Program Files//Google//Chrome//Application//chromedriver.exe");
		  WebDriver driver= new ChromeDriver();
		  driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyjdss");
		  driver.findElement(By.cssSelector("input[type='email']")).sendKeys("aninardrishti");
		  driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		  Thread.sleep(4000);
		  String url=driver.getCurrentUrl();*/
		  String url="https://rahulshettyacademy.com/getCourse.php?state=verifyjdss&code=4%2F0AVHEtk4JTp7KIxsAOWxHg64Qu82A-VkM74Jggx4DpGtAtLpGxb-XEHyfpcXRk0RR3Fwr8A&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		  
		  String partialcode=url.split("code=")[1];
		  String code=partialcode.split("&scope")[0];
		  System.out.println(code);
		  
		  
		  
		  String accessTokenResponse=given().urlEncodingEnabled(false)
				  .queryParams("code",code)
				  .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				  .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				  .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
				  .queryParams("grant_type","authorization_code")
				  .when().log().all()
				  .post("https://www.googleapis.com/oauth2/v4/token").asString();
		  JsonPath js=new JsonPath(accessTokenResponse);
		  String accessToken=js.getString("access_token");
		  
		  
		  
		  String response=given().queryParam("access_token",accessToken)
		  .when().log().all()
		  .get("https://rahulshettyacademy.com/getCourse.php").asString();
		  System.out.println(response);
	  }

}
