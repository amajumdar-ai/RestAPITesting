package TestAPIs;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.AssertJUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;

import org.testng.annotations.Test;

import TestData.testData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TestNG_DataProvider extends testData{
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

@BeforeSuite
public void setUp() {
	htmlReporter = new ExtentHtmlReporter("extent.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);	
}

	
	
	@Test(dataProvider="POSTExample1")
	public void POSTExample1(String name, String job)
	{
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
		RequestSpecification request=RestAssured.given();
		JSONObject body=new JSONObject();
		body.put("name", name);
		body.put("job", job);
		
		request.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type","application/json").body(body.toString());
		
		Response resp=request.post("https://reqres.in/api/users");
		
		int statuscode=resp.statusCode();
		System.out.print(statuscode);
		resp.getBody().prettyPrint();
		
		Assert.assertEquals(statuscode,201);
		
		
		
	}
	
	
	
	


	@Test(dataProvider="POSTExample2")
	public void POSTExample2(String name, String job)
	{
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		JSONObject obj=new JSONObject();
		obj.put("name", name);
		obj.put("job", job);
		RestAssured.given()
		
		
		
		.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type", "application/json").body(obj.toString())
		
		.when().post("https://reqres.in/api/users")
		.then().log().body().toString();
		
		
	}
	
    @AfterSuite
	public void tearDown() {
		 extent.flush();
	}
}