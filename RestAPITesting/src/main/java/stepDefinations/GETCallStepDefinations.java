package stepDefinations;




import java.util.Map;
import org.testng.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GETCallStepDefinations{
	static RequestSpecification request;
	static Response resp;
	static AuthenticationScheme token;

@Given("^I am an authorized user$")
public void i_am_an_authorized_user() {
	 request= RestAssured.given();
	request.auth().oauth2("AAAAAAAAAAAAAAAAAAAAAGjzNAEAAAAACZCrbbR2eMwVfZCktYcFwIOPNpk%3D9ks8s7s8UDkufjksOjdL0xKbYs7vsoy3mH8seI0Mi6pUSQmZN3");
	
	
}



@When("^I hit the GET api route$")
public void i_hit_the_GET_api_route() {
	 resp=request.get("https://api.twitter.com/2/users/by/username/arpitam37952011");
}

@Then("^I should get the response body$")
public void i_should_get_the_response_body()  {
	resp.getBody().prettyPrint();
}

@Then("^I should get (\\d+) status code$")
public void i_should_get_status_code(int arg1)  {
	int statuscode=resp.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
}

@Then("^I should see the following resources in the response body$")
public void i_should_see_the_following_resources_in_the_response_body(Map<String, String> myMap)  {
  System.out.println(myMap.get("id")); 
  System.out.println(myMap.get("name"));
  System.out.println(myMap.get("username")); 
 
 
}
@Given("^I have provided an invalid token$")
public void i_have_provided_an_invalid_token() throws Throwable {
	request= RestAssured.given(); 
}


    


@When("^I hit the api$")
public void i_hit_the_api() throws Throwable {
   resp=request.get("https://api.twitter.com/2/users/by/username/arpitam37952011");
}

@Then("^I should receive a proper response body$")
public void i_should_receive_a_proper_response_body() throws Throwable {
	resp.getBody().prettyPrint();
	
	
   
}

@Then("^I should see status code as (\\d+)$")
public void i_should_see_status_code_as(int arg1) throws Throwable {
  int statuscode= resp.getStatusCode();
  Assert.assertEquals(statuscode, 401);
}


}