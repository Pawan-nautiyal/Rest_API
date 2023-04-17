package RESTAssured;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Complex_Json_Parse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(Payload.CoursePrice());
		
		//print total number of courses return by the Api
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//print purchase amount
		int amount=js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		//print title of the first course
		String title=js.get("courses[0].title");
		System.out.println(title);
		
		//retreiving data dynamically
		for(int i=0;i<count;i++) {
			String str=js.get("courses["+i+"].title");
			int price =js.getInt("courses["+i+"].price");
			System.out.println(str+"-"+price);
			
		}
		for(int i=0;i<count;i++) {
			String str=js.get("courses["+i+"].title");
			if (str.equalsIgnoreCase("RPA"))
			{
				int copies=js.getInt("courses["+i+"].copies");
				System.out.println("copies sold by RPA is : "+copies);
				break;
			}
		}
	
	}

}
