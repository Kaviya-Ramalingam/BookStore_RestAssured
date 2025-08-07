package stepDefinitions;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import utilities.CommonUtils;
import utilities.TestContext;
import utilities.TestData;

public class PutRequest_steps {

	TestData data = new TestData();

	TestContext context = TestContext.getInstance();

	@Given("user creates put request to update book by isbn")
	public void user_creates_put_request_to_update_book_by_isbn() {
		context.req1 = context.req1.pathParam("firstISBN", context.firstISBN)
				.body(data.updatebook(context.userID, context.secondISBN));
	}

	@Then("user should see the updated book")
	public void user_should_see_the_updated_book() {
		context.response.then().assertThat().body("userId", Matchers.equalTo(context.userID));
		context.response.then().assertThat().body("books[0].isbn", Matchers.equalTo(context.secondISBN));
		context.response.then().assertThat().body(CommonUtils.validateAgainstSchema("updateBookByISBN.json"));
	}

}
