package com.restassured.project.tutorial;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given; // For given ()
import static org.hamcrest.Matchers.equalTo; // For equalTo()
import org.testng.annotations.Test;

/*
 * Read the instruction below:
 * # baseURI always takes string parameter where you have to pass the base URI;
 * 
 * # given() has a method name param() where you have to pass the 
 * 		1. Request headers 
 * 		2. Parameters 
 * 		3. Request Cookies
 * 
 * # when() method where you have to use the actual methods like GET, POST, PUT, DELETE.
 * 		Remember for GET method, we use resource as parameter which is the rest part after 
 * 		question mark "?" in the URI;
 * 
 * # then() method is used to perform various assertion to verify the data;
 * 		You can use and() method to perform several assertions together;
 * 
 * # Please add all the jar files.
 * 
 * NOTE: Post method you always have to send the body. Use backslash to avoid double quotataion inside quotataion;
 * */

public class DeleteRequest_4 {

	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		given().

				queryParam("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y")
				.body("{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958750" + "},"
						+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
						+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
						+ "\"types\": [\"shoe_store\"]," + "\"website\": \"http://www.google.com.au/\","
						+ "\"language\": \"en-AU\"" + "}").
				when().post("/maps/api/place/add/json").
				then().assertThat().statusCode(200).
				and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));

		// Create a place =response (place id)

		// delete Place = (Request - Place id)

	}
}
