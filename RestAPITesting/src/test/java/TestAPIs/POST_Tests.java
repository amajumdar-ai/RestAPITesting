package TestAPIs;

import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.DataDriven;



// POST Data Create-
// 1. if the payload is simple having only 2-3 key value pair without having any array >> we use HashMap or JsonObject
//2. If the payload is simple but there are huge no of data >> we prefer using excel sheet and then create the constructor of the class
// 3. other way is to use the DataProvider function
//4. If data is complex having multiple arrays and items within that then we create pojo--plain old java object--serialization deserialization



public class POST_Tests extends DataDriven {
	
	

	//@Test(priority=1)
	public void POSTCall1()
	{
		
		
		
		RequestSpecification request=RestAssured.given();
		
		JSONObject map= new JSONObject();
		map.put("id", 201);
		map.put("title", "SE");
		map.put("author", "abc");
		map.put("id", 212);
		map.put("title", "SED");
		map.put("author", "abcd");
		map.put("id", 223);
		map.put("title", "SEAD");
		map.put("author", "XYZ");
		
		
		request.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(map.toString());
		Response resp=request.post("http://localhost:3000/posts");
	
	String responsebody=resp.getBody().prettyPrint();
	System.out.print(responsebody);
	int statuscode=resp.getStatusCode();
	System.out.print(statuscode);
	Assert.assertEquals(statuscode, 201);
	JsonPath path=resp.jsonPath();
	String id=path.get("id");
	 Assert.assertTrue(id.equalsIgnoreCase("201"));
	
	
	
		
		
	
	 
		
	}
	@Test(priority=2)
	public void getRecords()
	{
		
		RequestSpecification request=RestAssured.given();
		Response response=request.get("http://localhost:3000/posts");
		String resp=response.getBody().prettyPrint();
		
		System.out.print(resp);
		int statuscode=response.getStatusCode();
		System.out.print(statuscode);
		
	}
	
	//@Test(priority=3)
	public void update()
	{
		RequestSpecification request=RestAssured.given();
		Map<String, Object>map=new HashMap<String,Object>();
		map.put("id", 201);
		map.put("title", "abc");
		map.put("id", 212);
		map.put("author", "null");
		request.contentType(ContentType.JSON).accept(ContentType.JSON).body(map.toString());
		Response response= request.put("http://localhost:3000/posts");
		String body=response.getBody().prettyPrint();
		System.out.print(body);
		//Cookies cookies=response.getDetailedCookies();
		//System.out.print(cookies);
		int statuscode=response.getStatusCode();
		System.out.print(statuscode);
		//Assert.assertEquals(body, body.contains("null"));
		Assert.assertEquals(statuscode, 200);
		
		
		
		
	}
	@Test(dataProvider="dataforpost")
	public  void postdata(String title, String author, int id )
	{
		
		RequestSpecification req=RestAssured.given();
		Map<String, Object>map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("title", title);
		map.put("author",author);
		req.contentType(ContentType.JSON).accept(ContentType.JSON).body(map.toString());
		Response resp=req.post("http://localhost:3000/posts");
		String body=resp.getBody().prettyPrint();
		System.out.print(body);
		int status=resp.getStatusCode();
		System.out.print(status);
		
		
		
		
		
	
	}
	
	
	
   

}
