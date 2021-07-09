package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	static Response response;
	TestDataBuild data =new TestDataBuild();
	static String id;
	

@Given("Add Station Payload with {string}  {string}")
public void add_Place_Station_with(String name, String ExternalId) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	
		 
		 res=given().spec(requestSpecification())
		.body(data.addPlacePayLoad(name,ExternalId));
	}

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
//constructor will be called with value of resource which you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource()+id);
		
		else if(method.equalsIgnoreCase("DELETE"))
			response = res.when().delete(resourceAPI.getResource()+id);
		
}

	@Then("the API call got created with status code {int}")
	public void the_API_call_got_created_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		
	
	}

	
	@Then("verify ID created maps to {string} using {string}")
	public void verify_ID_created_maps_to_using(String expectedName, String resource) throws IOException {
	
	   // requestSpec
		  System.out.println(response);
		 id=getJsonPath(response,"ID");
		 res=given().spec(requestSpecification());
		 user_calls_with_http_request(resource,"GET");
		  String actualName=getJsonPath(response,"name");
		  assertEquals(actualName,expectedName);
		 
	    
	}
	
	@Given("DeleteStation API")
	public void deleteStation_API() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   
		res =given().spec(requestSpecification());
	}

	
	@Then("the API call got deleted with status code {int}")
	public void the_API_call_got_deleted_with_status_code(Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),204);

}
	
	@Then("the API call for deletedAPI with status code {int}")
	public void the_API_call_for_deletedAPI_with_status_code(Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),404);
}	    
}
	



