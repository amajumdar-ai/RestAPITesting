package TestAPIs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;





import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class GETCall {
	
	
	/*

@BeforeSuite
public void setUp() {
	htmlReporter = new ExtentHtmlReporter("extentResult.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);	
}
*/
	
	

	@Test
	public void getcalltest() throws IOException
	{
		
		//ExtentTest test = extent.createTest("TEST RESULT", "Sample description");
		RequestSpecification request= RestAssured.given();
		Response resp=request.get("https://reqres.in/api/unknown/2");
		//ResponseSpecification response= RestAssured.responseSpecification;
	resp.getBody().prettyPrint();
	int statuscode=resp.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
	
		
	//test.log(Status.INFO, "This step shows usage of log(status, details)");
   // test.info("This step shows usage of info(details)");
   
		
	}
	/*
	@Test
	public void POSTTest() throws IOException
	{
		ExtentTest test = extent.createTest("SecondTest", "Sample description");
		
			
		
		RequestSpecification request=RestAssured.given();
		
		
		HashMap<String,String> obj=new HashMap<String,String>();
		obj.put("name"," arpita");
		obj.put("job", "Tester");
		
		Response resp=request.contentType(ContentType.JSON).accept(ContentType.JSON).header("content-type","application/json").body(obj).when()
		.post("https://reqres.in/api/users");
		int statuscode=resp.statusCode();
		System.out.print(statuscode);
		resp.getBody().prettyPrint();
		
		Assert.assertEquals(statuscode,201);
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    JsonPath path=resp.jsonPath();
	  String id=  path.get("id");
	  System.out.print("id is ;"+id);
	  // String name= path.get("name");
	  // Assert.assertTrue(name.equals("arpita"));
	  // String job= path.get("job");
	//   Assert.assertTrue(job.equals("tester"));
	 	*/
		
	}
/*
	    @AfterSuite
		public void tearDown() {
			 extent.flush();
		}
		*/
		
	
	


