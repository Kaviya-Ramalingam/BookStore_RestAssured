package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pojo.AddBookForUserPojo;
import pojo.CollectionOfIsbnPojo;
import pojo.CreateUserPojo;
import pojo.DeleteBookPojo;
import pojo.UpdateUserWithAnotherIsbn;

public class TestData {

	static ExcelUtility excel = new ExcelUtility(
			System.getProperty("user.dir") + "//src//test//java//resources//BookStore_API.xlsx");

	public CreateUserPojo getUserData(String testcaseName, String sheetName) throws IOException {
		List<String> excelData = excel.getData(testcaseName, sheetName);

		CreateUserPojo user = new CreateUserPojo();
		user.setUserName(excelData.get(1));
		user.setPassword(excelData.get(2));
		return user;

	}

	public AddBookForUserPojo getBookData(String userID, String firstISBN) {
		AddBookForUserPojo book = new AddBookForUserPojo();
		book.setUserId(userID);
		CollectionOfIsbnPojo isbn = new CollectionOfIsbnPojo();
		isbn.setIsbn(firstISBN);
		book.setCollectionOfIsbns(Collections.singletonList(isbn));
		return book;

	}

	public UpdateUserWithAnotherIsbn updatebook(String userId, String isbn) {
		UpdateUserWithAnotherIsbn updateBook = new UpdateUserWithAnotherIsbn();
		updateBook.setIsbn(isbn);
		updateBook.setUserId(userId);
		return updateBook;

	}

	public DeleteBookPojo deleteBook(String ISBN, String userId) {

		DeleteBookPojo deleteBook = new DeleteBookPojo();
		deleteBook.setUserId(userId);
		deleteBook.setIsbn(ISBN);
		return deleteBook;

	}

}
