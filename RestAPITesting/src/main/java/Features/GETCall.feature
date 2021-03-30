Feature: Get Resources
Scenario: As an authorized user, I should get all the users records

Given I am an authorized user
When I hit the GET api route
Then I should get the response body
And I should get 200 status code
And I should see the following resources in the response body
|id       | 1090878194951962624  |
|name     | arpita majumdar      |
|username | arpitam37952011      |


Scenario: I should get 401 unauthorized response, in case of invalid token
Given I have provided an invalid token
When I hit the api
Then I should receive a proper response body
And I should see status code as 401