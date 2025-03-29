package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specBuilder {
	
	
RequestSpecification req ;
ResponseSpecification res;


public RequestSpecification requestSpecification() throws IOException {
	
	ConfigReader.ReadDataFromConfig();
	try {
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt",true)); //add true ,so that logs will get appended
		 req=new RequestSpecBuilder().setBaseUri(ConfigReader.getUrl("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
	}
	catch (Exception e) {
		e.printStackTrace(); // Print stack trace for debugging
		throw new RuntimeException(e);
	}
	
}

public ResponseSpecification responseSpecification(int statusCode,String statusLine,String statusMesg) {
	
	res = new ResponseSpecBuilder().expectStatusCode(statusCode).expectStatusLine(statusLine).expectContentType(statusMesg).build();
	return res;
	
}

}

