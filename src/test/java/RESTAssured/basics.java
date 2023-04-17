package RESTAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.Reusable_methods;
/**
 * @author Pawan Nautiyal
 *
 */
public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//validate if ADD Api is working as expected or not 
		
		//given - all input details
		//when - submit the api -resource http method
		//Then - validate the Response
		//Add Place->update place with new Address->Get Place to validate if new address is present in response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.Addplace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		//System.out.println(response);
		JsonPath js= new JsonPath(response); //for parsing Json
		String placeId=js.getString("place_id");
		System.out.println(placeId);
		
		//update place
		String newadr= "Dhalwala, Rishikesh";
		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newadr+"\",\r\n"
				+ "\"types\": [\r\n"
				+ "\r\n"
				+ "    \"shoe park\",\"Mussorie\"\r\n"
				+ "  ],\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
			when().put("maps/api/place/update/json").
			then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		String getPlaceResponse=given().log().all().queryParam("key","qaclick123")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=Reusable_methods.rawToJson(getPlaceResponse);
		String Actualadr=js1.getString("address");		
		System.out.println(Actualadr);
		
		//assertion using TestNG for validation
		Assert.assertEquals(Actualadr,newadr);
		
		
	}

}
