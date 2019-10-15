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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.Resources;
import configuration.ReuseableMethods;

/*
 * Step-1: Create a json file and add all the payloads to that;
 * Step-2: Update the method GenerateStringFromResource;
 * Step-3: Read all the bytes as string format;
 * 
 * */

public class HandleStaticJsonPayloads_11 {

	@Test

	public void addBook() throws IOException
	{
	RestAssured.baseURI="http://216.10.245.166";
	Response resp=given().
	header("Content-Type","application/json").

	body(GenerateStringFromResource("C:\\Users\\rahul\\Documents\\Addbookdetails.json")).
	when().
	post("/Library/Addbook.php").
	then().assertThat().statusCode(200).
	extract().response();
	
	JsonPath js= ReuseableMethods.rawToJson(resp);
	   String id=js.get("ID");
	   System.out.println(id);

	   //deleteBOok
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
}
