import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ObjectMapper {
	@Test
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
		
		request.contentType(ContentType.JSON).accept(ContentType.JSON).body(map.toString());
		Response resp=request.post("http://localhost:3000/posts");
	
	   String responsebody=resp.getBody().prettyPrint();
	   System.out.print(responsebody);
	   int statuscode=resp.getStatusCode();
	   System.out.print(statuscode);
	   Assert.assertEquals(statuscode, 201);
	
		
	}

}
