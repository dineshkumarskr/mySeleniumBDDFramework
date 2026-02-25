Feature: Get All products from Store
	@APIGETTest
	Scenario Outline: Get a product from Store using GET method
        Given User is on the Store API endpoint
        When User sends a GET request to retrieve all products
        Then User receives a response with status code 200
        Then The response contains a product with rate of <rate of the product>
        
        Examples:
            | rate of the product |
            | 3.9                 |
	
	@APIPOSTTest
	Scenario Outline: Post a product to Store using POST method
        Given User is on the Store API endpoint
        When User sends a POST request to insert a new products
        Then User receives a response with product id
       
        
 