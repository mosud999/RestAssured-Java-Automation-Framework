package com.restassured.project.tutorial;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given; // For given ()
import static org.hamcrest.Matchers.equalTo; // For equalTo()
import org.testng.annotations.Test;

/*
 * In extract you can get the response for what you hit;
 * Then you have to tell what you extract. That's why we use response method because we need to extract the response (extract().response();)
 * and store into reference;
 * 
 * To print the response as string (Originially we receive the response as raw/json format) then if you want to print
 * you have to convert this as string (res.asString());
 * 
 * If you want to pull out the specifics place id or any specific information from the response then you first have to convert this into
 * json format;
 * 
 *  When you extract the response how does it look like?
		Initially we receive as raw format. Then we convert this to string format. Next we convert the string into json format and by using the get method we can pullout any specific information by providing the key;
		String responseString = res.asString(); // to convert into string; Grab the response is done here;
						
		JsonPath js = new JsonPath(responseString); // JsonPath converts string into json;
		js.get("place_id"); // By providing the path name you will get the value;

 * After we get the place id then we send a DELETE request.

 * */

public class GrabbingResponseBodyIntoString_3 {

	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		// Task-1: Hit and create place request and grab the response;
				String b = "{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958750" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"]," + "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\"" + "}";
				Response res = given().
				queryParam("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y")
				.body(b).
				when().post("/maps/api/place/add/json").
				then().assertThat().statusCode(200).
				and().contentType(ContentType.JSON).and().body("status", equalTo("OK")).
				extract().response();
				
				String responseString = res.asString();
				System.out.println(responseString); // ---->print the whole response in output; Grab the response is done here;
				
		// Task-2: From the response we get the particular Place-Id by converting row data to String and then String to Json;
				JsonPath js = new JsonPath(responseString);
				String value = js.get("place_id"); // we can keep the extracted value in a variable and then print;
				System.out.println(value);
				
		// Task-3: We hit a DELETE request and verify the response;
				given().
				post("maps/api/place/delete/json"). // ----->Send the post uri.
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and(). //Verify the contents; 
				body("status",equalTo("OK")); // ------->Verify body status is OK



	}
}
