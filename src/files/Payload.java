package files;

public class Payload {

	//body is stored here and calling in main class by ->  ClassName.methodName();
	public static String AddPlace() 
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Deshmukh House\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, Pune\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://Deshmukh House.com\",\r\n"
				+ "  \"language\": \"English-IN\"\r\n"
				+ "}\r\n"
				+ "";

}
}