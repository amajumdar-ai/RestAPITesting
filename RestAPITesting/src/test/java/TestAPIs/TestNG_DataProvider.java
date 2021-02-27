package TestAPIs;

import org.json.JSONObject;
import org.testng.Assert;

import org.testng.annotations.Test;

import TestData.testData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNG_DataProvider extends testData{
	
	
	
	@Test(dataProvider="POSTExample1")
	public void POSTExample1(String name, String job)
	{
		
		RequestSpecification request=RestAssured.given();
		JSONObject body=new JSONObject();
		body.put("name", name);
		body.put("job", job);
		Response resp=request.get("https://reqres.in/api/users");
		request.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type","application/json").body(body.toString());
		int statuscode=resp.statusCode();
		System.out.print(statuscode);
		resp.getBody().prettyPrint();
		
		Assert.assertEquals(statuscode,200);
		
		
		
	}
	
	
	
	


	@Test(dataProvider="POSTExample2")
	public void POSTExample2(String name, String job)
	{
		JSONObject obj=new JSONObject();
		obj.put("name", name);
		obj.put("job", job);
		RestAssured.given()
		
		
		
		.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type", "application/json").body(obj.toString())
		
		.when().get("https://reqres.in/api/users")
		.then().log().body().toString();
		
		
	}
}