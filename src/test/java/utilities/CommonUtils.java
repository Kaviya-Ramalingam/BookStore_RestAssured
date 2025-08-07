package utilities;

import java.io.File;
import java.util.List;

import org.hamcrest.Matcher;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtils {
	
	public static String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

	public static List<String> getListOfJson(Response response, String key) {
		String resp = response.asString(); // Convert the response to a string
		JsonPath js = new JsonPath(resp); // Initialize JsonPath to parse the response
		return js.getList(key); // The getList method is used to extract a list from the JSON
	}

	public static Matcher<?> validateAgainstSchema(String schemaFileName) {
		File schemaFile = new File("src/test/java/resources/" + schemaFileName);
		return JsonSchemaValidator.matchesJsonSchema(schemaFile);
	}

}
