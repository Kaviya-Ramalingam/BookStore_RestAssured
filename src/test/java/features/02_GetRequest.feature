@Get_Request

Feature: get request for user and book modules

Background: User sets Authorization
Given User sets authorization to bearer token

@getUser
Scenario: check if user exists
Given user creates get request for BookStore API endpoints
When user call "getUser" endpoint with "get" http request
Then user should get 200 status code and "OK" status line.

@getBooks
Scenario: check if user able to get all book details
Given user creates get request for BookStore API endpoints
When user call "getBook" endpoint with "get" http request
Then user should get 200 status code and "OK" status line.

@getBookByisbn
Scenario: check if user able to get book by isbn
Given user creates get request for BookStore API endpoints
When user call "getBookByIsbn" endpoint with "get" http request
Then user should get 200 status code and "OK" status line.


