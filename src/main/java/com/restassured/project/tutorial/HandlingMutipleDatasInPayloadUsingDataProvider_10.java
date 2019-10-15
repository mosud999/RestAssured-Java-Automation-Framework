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
 * Step-1: How to add data provider for handling multiple datas in your rest api;
 * 
 * */

public class HandlingMutipleDatasInPayloadUsingDataProvider_10 {

	@Test(dataProvider = "BooksData")

	public void addBook(String isbn, String aisle)

	{

		RestAssured.baseURI = "http://216.10.245.166";

		Response resp = given().

				header("Content-Type", "application/json").

				body(Resources.addbook(isbn, aisle)).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response();

		JsonPath js = ReuseableMethods.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

		// deleteBOok

	}

/*@DataProvider(name="BooksData")
public Object[][]  getData()

{

//array=collection of elements

//multidimensional array= collection of arrays

	return new Object[][] {"ojfwty"}, {"cwetee","4253"}, {"okmfet","533"} ;//fix it using mulitdimensional array;

}*/
}
