package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.TestContext;
import utilities.TestData;

public class PutRequest_steps {
	
	TestContext context;
	TestData data;
	
	public PutRequest_steps(TestContext context) {
		this.context=context;
		this.data = new TestData();
		
	}
	
	@Given("user creates put request to update book by isbn")
	public void user_creates_put_request_to_update_book_by_isbn() {
	  context.req1=context.req1.pathParam("firstISBN", context.firstISBN).body(data.updateBookbyIsbn(context.userID, context.secondISBN));
	}


}
