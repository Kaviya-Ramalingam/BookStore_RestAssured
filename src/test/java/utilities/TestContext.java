package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestContext {

	private final static TestContext INSTANCE = new TestContext();
	// This line declares a static final instance of the TestContext class.
	// The INSTANCE variable holds the only instance of the TestContext class.
	// The keyword final ensures that the reference to this instance cannot be
	// changed (i.e., it's constant),
	// and the keyword static means that it belongs to the class itself, rather than
	// to any instance.

	public static TestContext getInstance() { // This is the public method that provides access to the single instance
		return INSTANCE;										// of the TestContext class.
												// It allows other classes to get the one and only instance of
												// TestContext
		
	}

	// Constructor with debug message
	public TestContext() {
		System.out.println("TestContext constructor called. Instance: " + this);
	}

	public Response response;
	public RequestSpecification req1;
	public ResponseSpecification res1;
	public String token = null;
	public String userID = null;
	public String firstISBN = null;
	public String secondISBN = null;
	public String thirdISBN = null;
}
