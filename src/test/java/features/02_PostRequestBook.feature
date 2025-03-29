
Feature: post request for book modules

Background: User sets Authorization
Given User sets authorization to bearer token

@addBook @test
Scenario: check if user is able to add book
Given user creates Post request for the BookStore endpoints and set authorisation
When user call "addBook" endpoint with "post" http request
Then  user should get 201 status code,"HTTP/1.1 201 Created" status line and "application/json; charset=utf-8" content-type
Then user should see the book added
