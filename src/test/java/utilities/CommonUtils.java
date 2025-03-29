package utilities;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtils {
	
	
	public static String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	 // Method to extract values from JSON response using a key
    public static List<String> getListOfJson(Response response, String key) {
        String resp = response.asString();  // Convert the response to a string
        JsonPath js = new JsonPath(resp);   // Initialize JsonPath to parse the response
        
        // Extract and return the list of ISBNs
        return js.getList(key);  // The getList method is used to extract a list from the JSON
    }

}
