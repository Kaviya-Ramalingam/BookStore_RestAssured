package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.TestContext;
import utilities.TestData;
import utilities.specBuilder;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.hamcrest.Matchers;
public class PostRequestBook_steps extends specBuilder {
	
	TestContext context;
	TestData data;
	
	public PostRequestBook_steps(TestContext context) {
		this.context=context;
		this.data = new TestData();
	}
	
	@Given("user creates Post request for the BookStore endpoints and set authorisation")
	public void user_creates_post_request_for_the_book_store_endpoints_and_set_authorisation() throws IOException {
	   context.req1= context.req1.body(data.createBook(context.userID, context.firstISBN));
	}

	@Then("user should see the book added")
	public void user_should_see_the_book_added() {
		context.response.then().assertThat().body("books[0].isbn", Matchers.equalTo(context.firstISBN));
		
	}
}
