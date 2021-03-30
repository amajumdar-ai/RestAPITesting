import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.fasterxml.jackson.core.type.TypeReference;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class Validate_Complex_Response_Body {
	
	static RequestSpecification request;
	static Response resp;
	static String Baseurl="https://reqres.in/api/users";;
	
	
	
		
	
	
	
	@Test()
	public void SingleResponseBody()
	{
		
		 request=RestAssured.given().pathParam("id", "2");
		resp=request.get(Baseurl+"/{id}");
		String body=resp.body().prettyPrint();
		int statuscode=resp.getStatusCode();
		
		
		Assert.assertEquals(statuscode, 200);
		//resp.body("data.first_name", hasItems("Michael","Lindsay"));
		//Assert.assertEquals("data.first_name", hasItems("Michael","Lindsay"));
		JsonPath path=resp.jsonPath();
		//String firstname=path.get("firstname");
		
		System.out.print(path.get("data.first_name").equals("JANET"));
		System.out.print(path.get("support.text").equals("To keep ReqRes free, contributions towards server costs are appreciated!"));
		
		
	}
	@Test()
	public void MultipleResponse()
	{
	
		 request=RestAssured.given().queryParams("page", "2");
			resp=request.get(Baseurl);
			String body=resp.body().prettyPrint();
			int statuscode=resp.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(body.contains("id"),true);
		
		JsonPath path=resp.jsonPath();
		
		
		
		
		
		
		
		
		
	}

}
