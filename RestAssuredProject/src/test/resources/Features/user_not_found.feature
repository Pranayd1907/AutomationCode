Feature: ReqRes.in API Testing

  Scenario: Get a Single User Not Found
    Given the ReqRes.in base URL is "https://reqres.in"
    When I send a GET request to "/api/users/23"  
    Then the response status code should be notfound 404
    And the response body should contain blank "{}"
