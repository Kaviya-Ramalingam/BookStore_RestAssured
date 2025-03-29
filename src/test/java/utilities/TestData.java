package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestData {
	
	static ExcelUtility excel = new ExcelUtility(System.getProperty("user.dir")+"//src//test//java//resources//BookStore_API.xlsx") ;
	
	public Map<String, String> userDataPayload(String testcaseName,String sheetName) throws IOException {
		//Random randomNum = new Random();
	
	Map<String ,String >userData = new HashMap<>();
	List<String> excelData = excel.getData(testcaseName, sheetName);
	userData.put("userName", excelData.get(1));
	userData.put("password", excelData.get(2));
	return userData;
	}

	
	public Map<String, Object> createBook(String userID,String firstISBN){
		Map<String,Object >postBook = new HashMap<>();//create map for request body
		postBook.put("userId",userID);//add userid to it
		Map<String,String>isbnMap = new HashMap<>();//create a map for isbn
		isbnMap.put("isbn", firstISBN);
		
		postBook.put("collectionOfIsbns",new Map[]{isbnMap});//add the single isbn map to collectionOfIsbns list
		return postBook;
		
	}
	
	public Map<String,String>deleteBook(String firstISBN,String userId){
		Map<String, String>deleteBookData = new HashMap<>();
		deleteBookData.put("isbn", firstISBN);
		deleteBookData.put("userId", userId);
		
		return deleteBookData;
		
	}
	
	public Map<String ,String>updateBookbyIsbn(String userId,String isbn){
		Map<String,String>updateBookData=new HashMap<>();
		updateBookData.put("userId", userId);
		updateBookData.put("isbn", isbn);
		
		return updateBookData;
		
	}
	
	
}
