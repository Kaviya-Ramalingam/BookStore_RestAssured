package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.CommonUtils;
import utilities.TestContext;
import utilities.TestData;
import utilities.specBuilder;

public class PostRequest_Steps extends specBuilder {

	TestData data = new TestData();
	CommonUtils utils = new CommonUtils();

	TestContext context = TestContext.getInstance();

	@Given("user creates Post request for the BookStore endpoints with {string} and {string}")
	public void user_creates_post_request_for_the_book_store_endpoints_with_and(String testcaseName, String sheetName)
			throws FileNotFoundException, IOException {
		context.req1 = given().spec(requestSpecification()).body(data.getUserData(testcaseName, sheetName));
	}

	@Given("user creates Post request for the BookStore endpoints with {string} and {string} and set authorisation")
	public void user_creates_post_request_for_the_book_store_endpoints_with_and_and_set_authorisation(
			String testcaseName, String sheetName) throws IOException {
		context.req1 = given().header("Authorization", "Bearer " + context.token).spec(requestSpecification())
				.body(data.getUserData(testcaseName, sheetName));
	}

	@Then("verify the userId in json response body")
	public void verify_the_user_id_in_json_response_body() {
		context.userID = (CommonUtils.getJsonPath(context.response, "userID"));
		System.out.println(context.userID);
		context.response.then().assertThat().body(CommonUtils.validateAgainstSchema("userSchema.json"));
	}

	@Then("token is generated and stored")
	public void token_is_generated_and_stored() {
		context.token = (CommonUtils.getJsonPath(context.response, "token"));
		System.out.println("Extracted Token in POST: " + context.token);
	}

}
