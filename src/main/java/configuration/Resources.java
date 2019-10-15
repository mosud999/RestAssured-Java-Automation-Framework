package configuration;

public class Resources {
	
	public static String placePostData() {
		String res = "maps/api/place/delete/json";
		return res;
	}
	
	public static String getPostData() {
		String body = "{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958750" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"]," + "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\"" + "}";
		return body;
	}
	
	public static String addbook(String aisle, String isbn) {
		String payload = "{" + "\"location\": {" + "\"lat\": -33.8669710," + aisle+ "\"lng\": 151.1958750" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"]," +isbn+ "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\"" + "}";
		return payload;
	}
	
	

}
