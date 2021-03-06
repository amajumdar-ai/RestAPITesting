package TestAPIs;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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





public class POST_Tests extends DataDriven {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

@BeforeSuite
public void setUp() {
	htmlReporter = new ExtentHtmlReporter("extent.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);	
}
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
	
	
		
		
		
		
	}
	@Test(priority=2)
	public void getRecords()
	{
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
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
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
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
	
	@AfterTest()
	public void generateLog()

	{
		final Logger logger = LogManager.getLogger(POST_Tests.class);  
		

	}
	
    @AfterSuite
	public void tearDown() {
		 extent.flush();
	}

}
