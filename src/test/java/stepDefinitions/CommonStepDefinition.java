package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.API_Resources;
import utilities.TestContext;
import utilities.specBuilder;

public class CommonStepDefinition extends specBuilder {

	TestContext context = TestContext.getInstance();

	@When("user call {string} endpoint with {string} http request")
	public void user_call_endpoint_with_http_request(String resource, String method) {
		API_Resources resources = API_Resources.valueOf(resource);

		switch (method.toLowerCase()) {
		case "post":
			context.response = context.req1.when().post(resources.getResource()).then().log().all().extract()
					.response();
			break;
		case "get":

			context.response = context.req1.when().get(resources.getResource()).then().log().all().extract().response();
			break;

		case "delete":
			context.response = context.req1.when().delete(resources.getResource()).then().log().all().extract()
					.response();
			break;
		case "put":
			context.response = context.req1.when().put(resources.getResource()).then().log().all().extract().response();
			break;
		default:
			throw new IllegalArgumentException("Unknown method: " + method);
		}
	}

	@Then("user should get {int} status code,{string} status line and {string} content-type")
	public void user_should_get_status_code_status_line_and_content_type(Integer statusCode, String statusLine,
			String contentType) {
		context.response.then().log().all().assertThat()
				.spec(responseSpecification(statusCode, statusLine, contentType));
		System.out.println("POST step - Context object hashcode: " + context.hashCode());

	}
}
