package TestAPIs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.DataDriven;



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
	AssertJUnit.assertEquals(statuscode, 201);
	
	
		
		
		
		
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
		Map<String, Object>map=new HashMap<>();
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
		AssertJUnit.assertEquals(statuscode, 200);
		
		
		
		
	}
	@Test(dataProvider="dataforpost")
	public  void postdata(String title, String author, int id )
	{
		RequestSpecification req=RestAssured.given();
		Map<String, Object>map=new HashMap<>();
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
