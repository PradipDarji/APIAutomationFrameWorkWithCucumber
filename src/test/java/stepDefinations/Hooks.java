package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		StepDefination m =new StepDefination();
		if(StepDefination.id==null)
		{
		
		m.add_Place_Station_with("Shetty", "French");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		
		}
		
		

	}
}
