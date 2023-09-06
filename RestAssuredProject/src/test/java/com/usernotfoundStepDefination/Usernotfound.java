package com.usernotfoundStepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;

public class Usernotfound {
	private Response response;

	@Given("the ReqRes.in base URL is {string}")
	public void setBaseURI(String url) {
		RestAssured.baseURI = url;
	}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to_assuming_user_id_does_not_exist(String endpoint) {
		response = RestAssured.get(endpoint);
	}

	@Then("the response status code should be notfound {int}")
	public void verifyStatusCodeNotfound(int statusCode) {
		response.then().statusCode(statusCode);
		System.out.println(response.contentType());
		System.out.println(response.getStatusCode());
	}

	@Then("the response body should contain blank {string}")
	public void verifyResponseBodyContainBlank(String expectedText) {
		 String bodyValue=response.getBody().asString();
Assertions.assertEquals(bodyValue, expectedText);
		System.out.println(response.getStatusCode());
		System.out.println(bodyValue);
	}
}
