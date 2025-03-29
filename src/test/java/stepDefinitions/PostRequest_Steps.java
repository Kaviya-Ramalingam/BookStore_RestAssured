package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.API_Resources;
import utilities.CommonUtils;
import utilities.TestContext;
import utilities.TestData;
import utilities.specBuilder;

public class PostRequest_Steps extends specBuilder {

	TestData data = new TestData();
	CommonUtils utils = new CommonUtils();

	TestContext context;

	public PostRequest_Steps(TestContext context) {
		this.context = context;

	}

	@Given("user creates Post request for the BookStore endpoints with {string} and {string}")
	public void user_creates_post_request_for_the_book_store_endpoints_with_and(String testcaseName, String sheetName)
			throws FileNotFoundException, IOException {
		context.req1 = given().spec(requestSpecification()).body(data.userDataPayload(testcaseName, sheetName));
	}

	@When("user call {string} endpoint with {string} http request")
	public void user_call_endpoint_with_http_request(String resource, String method) {
		API_Resources resources = API_Resources.valueOf(resource);
		if (method.equalsIgnoreCase("post")) {
			context.response = context.req1.when().post(resources.getResource()).then().log().all().extract()
					.response();
		} else if (method.equalsIgnoreCase("get")) {
			context.response = context.req1.when().get(resources.getResource()).then().log().all()
					.extract().response();
		} else if (method.equalsIgnoreCase("getBooks")) {
			context.response = context.req1.when().get(resources.getResource()).then().log().all().extract().response();
		} else if (method.equalsIgnoreCase("getBookByIsbn")) {
			context.response = context.req1.when().get(resources.getResource()).then().log().all()
					.extract().response();
		} else if (method.equalsIgnoreCase("delete")) {
			context.response = context.req1.when().delete(resources.getResource()).then().log().all().extract()
					.response();
		} else if (method.equalsIgnoreCase("put")) {
			context.response = context.req1.when().put(resources.getResource()).then().log().all().extract().response();
		}
	}

	@Then("user should get {int} status code,{string} status line and {string} content-type")
	public void user_should_get_status_code_status_line_and_content_type(Integer statusCode, String statusLine,
			String contentType) {
		context.response.then().log().all().assertThat()
				.spec(responseSpecification(statusCode, statusLine, contentType));

		if (statusCode == 200 && context.response.body().asString().contains("token")) {

			context.token = (CommonUtils.getJsonPath(context.response, "token"));
			System.out.println("Extracted Token in POST: " + context.token);
		} else if (statusCode == 201 && context.response.body().asString().contains("userID")) {
			context.userID = (CommonUtils.getJsonPath(context.response, "userID"));
			System.out.println(context.userID);
		}
	}

	@Given("user creates Post request for the BookStore endpoints with {string} and {string} and set authorisation")
	public void user_creates_post_request_for_the_book_store_endpoints_with_and_and_set_authorisation(
			String testcaseName, String sheetName) throws IOException {
		context.req1 = given().header("Authorization", "Bearer " + context.token).spec(requestSpecification())
				.body(data.userDataPayload(testcaseName, sheetName));
	}

}
