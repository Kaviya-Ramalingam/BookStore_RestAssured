package utilities;

public enum API_Resources {

	createUser("/Account/v1/User"), 
	createToken("/Account/v1/GenerateToken"), 
	authorizeUser("/Account/v1/Authorized"),
	addBook("/BookStore/v1/Books"), 
	getUser("/Account/v1/User/{userId}"), 
	getBooks("/BookStore/v1/Books"),
	getBookByIsbn("/BookStore/v1/Book?ISBN="), 
	updateBookByIsbn("/BookStore/v1/Books/{firstISBN}"),
	deleteBook("/BookStore/v1/Book"), 
	deleteUser("/Account/v1/User/{userId}"),

	;

	private String resource;

	API_Resources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

	

}
