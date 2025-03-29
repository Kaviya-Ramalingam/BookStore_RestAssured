
@postRequest

Feature: post request for user and book modules
 
@createUser @test
Scenario Outline: check if user is able to create a account 
Given user creates Post request for the BookStore endpoints with "<testcaseName>" and "<sheetName>"
When user call "createUser" endpoint with "post" http request
Then user should get 201 status code,"HTTP/1.1 201 Created" status line and "application/json; charset=utf-8" content-type

Examples:
|testcaseName|sheetName|
|valid       |User     |

    
@createToken @test
Scenario Outline: check if user is able to generate token 
Given user creates Post request for the BookStore endpoints with "<testcaseName>" and "<sheetName>"
When  user call "createToken" endpoint with "post" http request
Then user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type


Examples:
|testcaseName|sheetName|
|valid       |User     |

 
@authoriseUser @test
Scenario Outline: check if user is able to authorize token 
Given user creates Post request for the BookStore endpoints with "<testcaseName>" and "<sheetName>" and set authorisation
When  user call "authorizeUser" endpoint with "post" http request
Then  user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type

Examples:
|testcaseName|sheetName|
|valid       |User     |


