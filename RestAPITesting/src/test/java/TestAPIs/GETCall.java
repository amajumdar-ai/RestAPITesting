package TestAPIs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.AssertJUnit;
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
	static ExtentHtmlReporter reporter;
	static ExtentReports reports;
	static ExtentTest logger;
	static ExtentTest logger2;
@BeforeTest()
public void generateReport()
{
 reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/report.html");
 reports=new ExtentReports();
reports.attachReporter(reporter);
logger=reports.createTest("getcalltest");
logger.getStatus();
 logger2=reports.createTest("POSTTest");
logger2.getStatus();
}
	@Test
	public void getcalltest()
	{
		
		RequestSpecification request= RestAssured.given();
		Response resp=request.get("https://reqres.in/api/unknown/2");
		//ResponseSpecification response= RestAssured.responseSpecification;
	resp.getBody().prettyPrint();
	int statuscode=resp.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
	ExtentTest test=reports.createTest("getcall");
		
		
		
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
		
		AssertJUnit.assertEquals(statuscode,200);
		ExtentTest test=reports.createTest("POSTTest");
		
		
		
		
		
		
		
		
		
		
	}
	

}
