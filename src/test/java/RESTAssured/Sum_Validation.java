package RESTAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Sum_Validation {

	@Test
	public void sumOfCourses()
	{
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int sum=0;
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			int price =js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			 sum=sum+(price*copies);
		}
		int purchaseamt=js.getInt("dashboard.purchaseAmount");
		
		if(sum==purchaseamt)
			System.out.println("Success");
		
		Assert.assertEquals(sum,purchaseamt);

}
}
