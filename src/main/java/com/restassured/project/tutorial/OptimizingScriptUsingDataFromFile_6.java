package com.restassured.project.tutorial;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given; // For given ()
import static org.hamcrest.Matchers.equalTo; // For equalTo()

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.Resources;

/*
 * Step-1: Create a file and keep your host name and dynamic data in the file.
 * Step-2: Create object for Properties class and pull out the values.
 * Step-3: You have to use FileInputStream to provide the path of the file location.
 * Step-4: load method is connecting between properties and file.
 * 
 * ------------------Properties file description-------------------------
 * name = env.properties
 * (keep the below data:)
 * 		HOST = "https://maps.googleapis.com"
 * 		KEY  = "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y"
 * 
 * */

public class OptimizingScriptUsingDataFromFile_6 {

	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\rahul\\workspace\\DemoProject\\src\\files\\env.properties");
		prop.load(fis);
		
		//prop.get("HOST");
	}

	@Test
	public void AddandDeletePlace()
	{
		
		//Task 1- Grab the response
		RestAssured.baseURI= prop.getProperty("HOST");
		Response res=given().
		
		queryParam("key",prop.getProperty("KEY")).
		body(Resources.getPostData()). //------>getting data from configuration.Resources class;
		when().
		post(Resources.placePostData()). //------>getting data from configuration.Resources;
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		// Task 2- Grab the Place ID from response
		
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
		
		//Task 3 place this place id in the Delete request
		given().
		queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		
		body("{" + "\"place_id\": \"" + placeid + "\"" + "}").
		when().
		post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
		
		
	}
}
