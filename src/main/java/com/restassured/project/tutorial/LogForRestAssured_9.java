package com.restassured.project.tutorial;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given; // For given ()
import static org.hamcrest.Matchers.equalTo; // For equalTo()

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.Resources;
import configuration.ReuseableMethods;

/*
 * Rest Assured Log Instruction : https://github.com/rest-assured/rest-assured/wiki/usage#logging 
 * */

public class LogForRestAssured_9 {

	@Test
	public void createPlaceAPI() throws IOException {
		String postdata = GenerateStringFromResource("C:\\Users\\rahul\\workspace\\DemoProject\\src\\files\\postdata.xml");
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response res = given().
				queryParam("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
				log().all(). // Log all request specification details including parameters, headers and body
				body(postdata).
				when().post("/maps/api/place/add/xml").
				then().assertThat().statusCode(200).
				and().contentType(ContentType.XML).and().
				extract().response();
		
				// You can use reuseable method instead of line 51,52,53;
				//XmlPath x = ReuseableMethods.rawToXML(res); 
				//String value = x.get("PlaceAddResponse.place_id"); // ---> We can keep the extracted value in a variable and then print; This format will come from the printed response;
				//System.out.println(value);
		
				String responseString = res.asString();
				System.out.println(responseString); // ----> Print the whole response in output; Grab the response is done here;
				XmlPath x = new XmlPath(responseString); // -------> Converting String data to XML data using this class XmlPath;
				String value = x.get("PlaceAddResponse.place_id"); // ---> We can keep the extracted value in a variable and then print; This format will come from the printed response;
				System.out.println(value);

	}
	// This method will read characters as bytes and return as String;
	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
