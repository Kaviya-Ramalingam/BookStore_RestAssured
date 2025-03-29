package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestContext {

	public Response response;
	public RequestSpecification req1;
	public ResponseSpecification res1;
	public static String token = null;
	public static String userID = null;
	public static String firstISBN = null;
	public static String secondISBN = null;
	public static String thirdISBN = null;


}
