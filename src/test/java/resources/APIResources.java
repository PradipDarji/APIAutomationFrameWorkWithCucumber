package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	AddStationAPI("/stations"),
	getStationAPI("/stations/"),
	deleteStationAPI("/stations/");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
