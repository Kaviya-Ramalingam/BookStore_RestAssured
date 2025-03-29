package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.TestContext;
import utilities.TestData;
import utilities.specBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;

public class DeleteRequest_steps extends specBuilder{
	
	private TestContext context;
	TestData data;
	
	public DeleteRequest_steps(TestContext context) {
		this.context = context;
		this.data = new TestData();
	}
	
	
	
	@Given("user creates delete request to delete the book")
	public void user_creates_delete_request_to_delete_the_book() throws IOException {
		context.req1=context.req1.body(data.deleteBook(context.secondISBN, context.userID));
		System.out.println("user craetes delete request to delete the book");
	}

	

	@Given("user creates delete request to delete user")
	public void user_creates_delete_request_to_delete_user() {
	    context.req1=context.req1.pathParam("userId", context.userID);
	}




	

}
