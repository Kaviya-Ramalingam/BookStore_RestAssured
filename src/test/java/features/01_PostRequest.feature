
@postRequest

Feature: post request for user and book modules
 
@createUser
Scenario: check if user is able to create a account 
Given user creates Post request for the BookStore endpoints with valid username and password
When user call "createUser" endpoint with "post" http request
Then user should get 201 status code and "created" status line.
    
@createToken
Scenario: check if user is able to generate token 
Given user creates Post request for the BookStore endpoints with valid username and password
When  user call "createToken" endpoint with "post" http request
Then user should get 200 status code and "OK" status line.
 
@authoriseToken
Scenario: check if user is able to authorize token 
Given user creates Post request for the BookStore endpoints with valid username and password
When  user call "authorizeToken" endpoint with "post" http request
Then user should get 200 status code and "OK" status line.
  
@addBook
Scenario: check if user is able to add book
Given user creates post request for the bookstore endpoints and set authorisation "bearer token"
When user call "addBook" endpoint with "post" http request
Then user should get 201 status code and "created" status line.  
     

