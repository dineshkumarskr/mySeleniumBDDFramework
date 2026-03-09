package com.WJ.stepDefinition;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIMethods {
	RequestSpecification request;
	Response response;
	ResponseBody rb;
	
	@Given("User is on the Store API endpoint")
	public void user_is_on_the_store_api_endpoint() {
	    RestAssured.baseURI = "https://fakestoreapi.com";
	    request = RestAssured.given();
	}

	@When("User sends a GET request to retrieve all products")
	public void user_sends_a_get_request_to_retrieve_all_products() {
		response  = request.get("/products");		
	}

	@Then("User receives a response with status code {int}")
	public void user_receives_a_response_with_status_code(int int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), int1);
	}

	@Then("The response contains a product with rate of {}")
	public void the_response_contains_a_product_with_rate_of(String S) {
	    // Write code here that turns the phrase above into concrete actions
		rb = response.getBody();
		JsonPath jsnPath = response.jsonPath();
		String x = jsnPath.getString("rating.rate[0]");
		System.out.println("Rate of first product is :"+x);
		assertEquals(S, x);
	}
	
	@When("User sends a POST request to insert a new products")
	public void user_sends_a_post_request_to_insert_a_new_products() {
		request.header("Content-Type","application/json");
		String requestBody = "{\r\n"
				+ "    \"title\": \"API Test Documnet\",\r\n"
				+ "    \"price\": 19.99,\r\n"
				+ "    \"description\": \"This is a test product\",\r\n"
				+ "    \"image\": \"https://example.com/product-image.jpg\",\r\n"
				+ "    \"category\": \"electronics\"\r\n"
				+ "}";
		response = request.body(requestBody).post("/products");
	}
	
	@Then("User receives a response with product id")
	public void user_receives_a_response_with_product_id() {
		rb = response.getBody();
		JsonPath jsnPath = response.jsonPath();
		int id = jsnPath.getInt("id");
		System.out.println("ID of created product is :"+id);
		assertEquals(21, id);
	}


}
