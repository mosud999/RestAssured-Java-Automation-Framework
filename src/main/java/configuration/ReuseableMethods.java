package configuration;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
/*
 * Check the class ValidatingAdvancedXmlResponses_7 to see the use of re useable methods 1 and 2;
 * */
public class ReuseableMethods {

	// 1-For XML conversion;
	public static XmlPath rawToXML(Response r) {

		String respon = r.asString();
		XmlPath x = new XmlPath(respon);
		return x;

	}

	// 2-For JSON conversion;
	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
	}
}
