package TestAPIs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	

@BeforeSuite
public void setUp() {
	htmlReporter = new ExtentHtmlReporter("extent.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);	
}

	@Test
	public void getcalltest() throws IOException
	{
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		RequestSpecification request= RestAssured.given();
		Response resp=request.get("https://reqres.in/api/unknown/2");
		//ResponseSpecification response= RestAssured.responseSpecification;
	resp.getBody().prettyPrint();
	int statuscode=resp.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
	
		
	test.log(Status.INFO, "This step shows usage of log(status, details)");
    test.info("This step shows usage of info(details)");
   
		
	}
	
	@Test
	public void POSTTest() throws IOException
	{
		ExtentTest test = extent.createTest("SecondTest", "Sample description");
		
			
		
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
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    
		
		
		
	}
		
	    @AfterSuite
		public void tearDown() {
			 extent.flush();
		}
		
		
		
		
	}
	


