Feature: To validate Flipkart functionality


Background:
  Given Launch the browser and enter the URL

@smoke
Scenario: To validate the search functionality
	Given To launch th browser and enter url
  When Enter text in the Search field
  And Click the search button
  Then Search result should get displayed
  And Take screenshot after the result
  And Apply filters to the result
  Then Take screenshot after the filter
  And Click on the first result
  Then Add to the cart 
  And Take screenshot after addding to cart
  Then Click place order 
  And Take Screenshot after clicking on place order

@smoke
Scenario Outline: To test the search functionality with different values
  When Enter "<text>" in the search field
  Then Search results should be displayed
  And Verify the results
  And Take a screenshot and close the browser

Examples:
  | text    |
  | Mobiles |
  | Tshirt  |
  | Tv      |
  | Bottles |
