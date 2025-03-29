
@DeleteRequest

Feature: Delete request for user and book modules

Background: User sets Authorization
Given User sets authorization to bearer token
 
@deleteBook @test
Scenario: check if user is able to delete a book
Given user creates delete request to delete the book 
When user call "deleteBook" endpoint with "delete" http request
Then user should get 204 status code,"HTTP/1.1 204 No Content" status line and "" content-type
    
@deleteUserbyuserID @test
Scenario: check if user is able to delete a user by userId 
Given user creates delete request to delete user
When user call "deleteUser" endpoint with "delete" http request
Then user should get 204 status code,"HTTP/1.1 204 No Content" status line and "" content-type