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
 * */

public class RestBasicScript_1 {

	@Test
	public void restBasicScript() {
		RestAssured.baseURI = "https://reqres.in/";
			given().
				param("header", "value").
			when().
				get("/api/users/2").
			then().
			  assertThat().statusCode(200).
				 and().contentType(ContentType.JSON).and().
				 body("data.first_name",equalTo("Janet")).and().// Body assertion using json path;
				 header("headerName", "expectedValue"); // Header assertion using json path;
	}
}
