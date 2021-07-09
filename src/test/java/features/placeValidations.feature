Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if Station is being Succesfully added using AddPlaceAPI
	Given Add Station Payload with "<name>"  "<ExternalId>"
	When user calls "AddStationAPI" with "POST" http request
	And verify ID created maps to "<name>" using "getStationAPI"
	Then the API call got created with status code 200
	
	Examples:
	|name 	 | ExternalId |
	|vinav | SF_TEST001 |
#	|BBhouse | Spanish  |


@DeletePlace @Regression
Scenario: Verify if Delete Station functionality is working

	Given DeleteStation API
	When user calls "deleteStationAPI" with "DELETE" http request
	Then the API call got deleted with status code 204
	
@NotFoundResource @Regression
 
Scenario: Verify if resource does not exist API Response
Given DeleteStation API
When user calls "deleteStationAPI" with "DELETE" http request
Then the API call for deletedAPI with status code 404
	



	

	
	
	
	
	
	

	
	
	