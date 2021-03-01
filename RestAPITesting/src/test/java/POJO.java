import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;






public class POJO {
	
	
	objectRepository or=new objectRepository("Appy","Software");
	
	@Test
	public void POST()
	{
		RequestSpecification request=RestAssured.given();
		request.contentType(ContentType.JSON).accept(ContentType.JSON).body(or);
		Response resp= request.post("https://reqres.in/api/users");
		String body=resp.getBody().prettyPrint();
		//System.out.print(body);
		int status=resp.getStatusCode();
		System.out.print(status);
		AssertJUnit.assertEquals(status, 201);
		
	
	}

}
