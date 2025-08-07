@Get_Request

Feature: get request for user and book modules

Background: User sets Authorization
Given User sets authorization to bearer token

@getUser @test
Scenario: check if user exists
Given user creats get request with path parameter userid
When user call "getUser" endpoint with "get" http request
Then user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type
Then verify the response body

@getBooks @test
Scenario: check if user able to get all book details

When user call "getBooks" endpoint with "get" http request
Then user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type
Then verify the book details in response body

@getBookByisbn @test
Scenario: check if user able to get book by isbn
Given user creates get request with query parameter isbn
When user call "getBookByIsbn" endpoint with "get" http request
Then user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type
Then verify the book by isbn value


