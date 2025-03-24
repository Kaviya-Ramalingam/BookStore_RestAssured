

@DeleteRequest
Feature: Delete request for user and book modules

Background: User sets Authorization
Given User sets authorization to bearer token
 
@deleteBook
Scenario: check if user is able to delete a book
Given user creates delete request for the bookstore endpoints 
When user call "deleteBook" endpoint with "delete" http request
Then user should get 204 status code and "No content" status line.
    
@deleteUserbyuserID
Scenario: check if user is able to delete a user by userId 
Given user creates delete request for the BookStore endpoints 
When user call "deleteUser" endpoint with "delete" http request
Then user should get 204 status code and "No content" status line.