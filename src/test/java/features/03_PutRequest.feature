@Put_Request

Feature: put request for book modules

Background: User sets Authorization
Given User sets authorization to bearer token


@updateBookByisbn @test
Scenario: check if user able to update book by isbn
Given user creates put request to update book by isbn
When user call "updateBookByIsbn" endpoint with "put" http request
Then user should get 200 status code,"HTTP/1.1 200 OK" status line and "application/json; charset=utf-8" content-type
Then user should see the updated book

