package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.CommonUtils;
import utilities.TestContext;
import utilities.specBuilder;

public class GetRequest_steps extends specBuilder {

	CommonUtils utils = new CommonUtils();

	TestContext context;

	public GetRequest_steps(TestContext context) {
		this.context = context;
	}

	@Given("User sets authorization to bearer token")
	public void user_sets_authorization_to_bearer_token() throws IOException {

		context.req1 = given().header("Authorization", "Bearer " + context.token).spec(requestSpecification());
		System.out.println("****setting suthorisation: " + context.token);
	}

	@Given("user creats get request with path parameter userid")
	public void user_creats_get_request_with_path_parameter_userid() throws IOException {
		context.req1 = context.req1.pathParam("userId", context.userID) // Add ISBN as query parameter
				.spec(requestSpecification());
	}

	/*
	 * @When("user call get request for {string} endpoint with {string} http request"
	 * ) public void user_call_get_request_for_endpoint_with_http_request(String
	 * resource, String method) { API_Resources resources =
	 * API_Resources.valueOf(resource);
	 * 
	 * if (method.equalsIgnoreCase("get")) { context.response =
	 * context.req1.when().get(resources.getResource()).then().log().all()
	 * .extract().response(); } else if (method.equalsIgnoreCase("getBooks")) {
	 * context.response =
	 * context.req1.when().get(resources.getResource()).then().log().all().extract()
	 * .response(); } else if (method.equalsIgnoreCase("getBookByIsbn")) {
	 * context.response =
	 * context.req1.when().get(resources.getResource()).then().log().all()
	 * .extract().response(); } }
	 */

	@Then("verify the response body")
	public void verify_the_response_body() {

		String userId = CommonUtils.getJsonPath(context.response, "userId");
		System.out.println(userId);
		assertThat("User ID should match the expected value", userId, equalTo(context.userID));// hamcrest assertion
		context.response.then().assertThat().body("userId", Matchers.equalTo(context.userID));// restassuredassertion
	}

	@Then("verify the book details in response body")
	public void verify_the_book_details_in_response_body() {
		List<String> isbnList = CommonUtils.getListOfJson(context.response, "books.isbn");

		context.firstISBN = (CommonUtils.getJsonPath(context.response, "books[0].isbn"));
		System.out.println("first isbn: " + context.firstISBN);
		context.secondISBN = CommonUtils.getJsonPath(context.response, "books[1].isbn");
		System.out.println("second isbn: " + context.secondISBN);
		context.thirdISBN = CommonUtils.getJsonPath(context.response, "books[2].isbn");
		System.out.println("thirsd isbn: " + context.thirdISBN);
		// Print the extracted ISBNs
		System.out.println("List of ISBNs: " + isbnList);
	}

	@Given("user creates get request with query parameter isbn")
	public void user_creates_get_request_with_query_parameter_isbn() throws IOException {

		context.req1 = context.req1 // Add Authorization header with Bearer token
				.queryParam("ISBN", context.firstISBN) // Add ISBN as query parameter
				.spec(requestSpecification());
	}

	@Then("verify the book by isbn value")
	public void verify_the_book_by_isbn_value() {
		context.response.then().assertThat().body("isbn", Matchers.equalTo(context.firstISBN));
	}

}


