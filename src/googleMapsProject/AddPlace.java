package googleMapsProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddPlace {
	
	//Validate if Add Place API is working as expected
	
	public static void main(String[] args) {
		
		// Rest Assured Principles: 
		// given - all input details
		// when - submit the API - Resource, HTTP Method
		// then - Validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().statusCode(200).body("scope", equalTo ("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		//Add Place -> Update Place with New Address -> Git Place to validate if New Address is present in response or not
		
		//JSON class -> takes String as Input and convert in to JSON
		
		JsonPath js = new JsonPath(response); //for parsing json
		String placeId = js.get("place_id");// getting placeId and stored for reuse
		
		System.out.println(placeId);
		
		System.out.println("============================Add Place API Done===========================================");
		
		//Update Place
		String newAddress ="70 winter walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		System.out.println("============================Update Place API Done===========================================");

		//Get Place
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		
		
		
	}


}
