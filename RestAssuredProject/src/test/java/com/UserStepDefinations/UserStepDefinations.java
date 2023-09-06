package com.UserStepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserStepDefinations {
	private Response response;
	@Given("the ReqRes.in base URL for get is {string}")
	public void the_req_res_in_base_url_for_get_is(String url) {
		 RestAssured.baseURI = url;
	}
	@When("I send a GET request as {string}")
	public void i_send_a_get_request_as(String endpoint) {
		response = RestAssured.get(endpoint);
	}
	@Then("the response status code should be success {int}")
	public void the_response_status_code_should_be_success(int statusCode) {
		
		response.then().assertThat().statusCode(statusCode);
		System.out.println("Response Content:\n" + response.asString());
	}
	@Then("the response body should contain name {string}")
	public void the_response_body_should_contain_name(String expectedText) {
		
		System.out.println("Response Status Code is : "+ response.getStatusCode());
		response.then().assertThat().body("data.first_name",org.hamcrest.Matchers.equalTo(expectedText));
	}

}
