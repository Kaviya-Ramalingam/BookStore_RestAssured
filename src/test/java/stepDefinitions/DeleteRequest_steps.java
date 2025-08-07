package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import utilities.TestContext;
import utilities.TestData;
import utilities.specBuilder;

public class DeleteRequest_steps extends specBuilder {

	TestData data = new TestData();

	TestContext context = TestContext.getInstance();

	@Given("user creates delete request to delete the book")
	public void user_creates_delete_request_to_delete_the_book() throws IOException {
		context.req1 = context.req1.body(data.deleteBook(context.secondISBN, context.userID));
		System.out.println("user craetes delete request to delete the book");
	}

	@Given("user creates delete request to delete user")
	public void user_creates_delete_request_to_delete_user() {
		context.req1 = context.req1.pathParam("userId", context.userID);
	}

}
