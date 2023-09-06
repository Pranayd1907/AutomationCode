Feature: API Feature ReqRes.in API Testing

  Scenario: Send GET Request to Users Endpoint
    Given the base URL is "https://reqres.in"
    When I pass a GET request to "/api/users"
    Then the response status code should be 200

Scenario:  Send POST Request to Users Endpoint
    When I send a POST request to "/api/users/" with the following request body
      """
      {
      data: {
        "email":"george.bluth@reqres.in",
        "first_name":"Amruta",
        "last_name":"Bluth",
        "avatar":"https://reqres.in/img/faces/1-image.jpg"
        }
      }
      """
    Then the response status code should be 201
    And the response body should contain "Amruta"
    
   

 


