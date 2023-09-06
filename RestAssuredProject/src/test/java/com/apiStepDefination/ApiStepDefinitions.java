package com.apiStepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static org.hamcrest.Matchers.*;

public class ApiStepDefinitions {
	private RequestSpecification request;
	private Response response;

	@Given("the base URL is {string}")
	public void setBaseURI(String url) {
		RestAssured.baseURI = url;
	}

	@When("I pass a GET request to {string}")
	public void passGetRequest(String endpoint) {
		response = 
				RestAssured.get(endpoint);
		System.out.println(response.contentType());
	}

	@When("I send a POST request to {string} with the following request body")
	public void i_send_a_post_request_to_with_the_following_request_body(String endpoint, String requestBody) {

		JSONObject jsonBody = new JSONObject(requestBody);
		response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jsonBody.toString())
				.when()
				.post(endpoint);
	}

	

	@Then("the response status code should be {int}")
	public void verifyStatusCode(int statusCode) {
		response
		.then()
		.statusCode(statusCode);
		System.out.println(response.getStatusCode());
	}

	@Then("the response body should contain {string}")
	public void verifyResponseBodyContains(String expectedText) {
		response
		.then()
		.body("data.first_name", equalTo(expectedText));
		System.out.println(response.getStatusLine());
	}


	}

