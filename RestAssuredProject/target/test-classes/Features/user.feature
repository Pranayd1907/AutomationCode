Feature: ReqRes.in User API Testing

  Scenario: Retrieve a user by ID
    Given the ReqRes.in base URL for get is "https://reqres.in/api"
    When I send a GET request as  "/users/2"
    Then the response status code should be success 200
    And the response body should contain name "Janet"
