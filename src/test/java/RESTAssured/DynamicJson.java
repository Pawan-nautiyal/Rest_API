package RESTAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable_methods;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	
	public void addBook(String asilezn, String isbntx) {
		RestAssured.baseURI="http://216.10.245.166";
		String Response=given().log().all().header("Content-Type","application/json")
		.body(Payload.Addbook(isbntx,asilezn))
		.when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).
		extract().response().asString();
		JsonPath js= Reusable_methods.rawToJson(Response);
		String id=js.get("ID");
		System.out.println(id);
	}
	@DataProvider(name="BooksData")
	public Object[][] getData(){
		return new Object[][] {{"omkkty","9363"},{"Cewwerr","25637"}};
	}

}
