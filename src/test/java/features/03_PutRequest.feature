@Put_Request

Feature: put request for book modules

Background: User sets Authorization
Given User sets authorization to bearer token


@updateBookByisbn
Scenario: check if user able to update book by isbn
Given user creates put request for BookStore API endpoints
When user call "updateBookByIsbn" endpoint with "get" http request
Then user should get 200 status code and "OK" status line.


