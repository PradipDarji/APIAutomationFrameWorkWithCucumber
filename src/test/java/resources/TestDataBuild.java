package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	
	public AddPlace addPlacePayLoad(String name, String ExternalId)
	{
		AddPlace p =new AddPlace();
		p.setAltitude(150);
		p.setExternal_id(ExternalId);
		p.setName(name);
		p.setLongitude(-35.67);
		p.setLongitude(32.67);
		
		
		
		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}



}
