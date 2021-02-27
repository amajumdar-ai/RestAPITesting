package TestAPIs;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GETCall {
	@Test
	public void getcalltest()
	{
		
		RequestSpecification request= RestAssured.given();
		Response resp=request.get("https://gorest.co.in/public-api/posts");
		//ResponseSpecification response= RestAssured.responseSpecification;
	resp.getBody().prettyPrint();
	int statuscode=resp.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
		
		
		
	}
	
	@Test
	public void POSTTest()
	{
		
		RequestSpecification request=RestAssured.given();
		Response resp=request.get("https://reqres.in/api/users");
		
		JSONObject obj=new JSONObject();
		obj.put("name"," arpita");
		obj.put("job", "Tester");
		
		request.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type","application/json").body(obj.toString());
		int statuscode=resp.statusCode();
		System.out.print(statuscode);
		resp.getBody().prettyPrint();
		
		Assert.assertEquals(statuscode,200);
		
		
		
		
		
		
		
		
		
		
	}

}
