package stepDefinitions;

import baseclass.LibraryClass;
import pages.AddToCartPage;
import pages.FlipkartFilters;
import pages.FlipkartResultPage;
import pages.FlipkartSearchPage;
import pages.PlaceOrderPage;
import utilities.ResuabilityClass;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSearchTestSteps extends LibraryClass{ 
		ResuabilityClass re;
	    FlipkartSearchPage search;
	    FlipkartResultPage frp;
	    FlipkartFilters ff;
	    AddToCartPage atc;
	    PlaceOrderPage pop;
	    
	    private static final Logger logger = LogManager.getLogger(LibraryClass.class);
	    


		@Given("To launch th browser and enter url")
		public void to_launch_th_browser_and_enter_url() {
//		        logger.info("Application Launched");
		        re = new ResuabilityClass(driver);
		        search = new FlipkartSearchPage(driver);
		        frp= new FlipkartResultPage(driver);
		        ff= new FlipkartFilters(driver);
		        atc= new AddToCartPage(driver);
		        pop= new PlaceOrderPage(driver);

		}

    	
		@When("Enter text in the Search field")
		public void enter_text_in_the_search_field() {
	    	System.out.println("*******************************************************************3");
			search.search("Mobiles");
	    	System.out.println("*******************************************************************4");
			logger.info("Searched Mobiles");

		}
		@When("Click the search button")
		public void click_the_search_button() {
			search.clickSearch();
			logger.info("Clicked Search");
		}
		@Then("Search result should get displayed")
		public void search_result_should_get_displayed() {
		    re.getTitleName();
		    logger.info("Naviagted to result page");
		}
		
		@Then("Take screenshot after the result")
		public void take_screenshot_after_the_result() throws IOException {
			re.takescreenshot("src/test/resources/screenshot/flipkartSearchResult.png");
			   logger.info("Took screenshot");
		}
	 
		@Then("Apply filters to the result")
		public void apply_filters_to_the_result() {
			ff.brandFilter();
			logger.info("Brand filter");
	    	ff.ratingFilter();
			logger.info("rating filter");
	
		}


		@Then("Take screenshot after the filter")
		public void take_screenshot_after_the_filter() throws IOException {
			re.takescreenshot("src/test/resources/screenshot/flipkartFilterResult.png");
			   logger.info("Took screenshot");
		}

		@Then("Click on the first result")
		public void click_on_the_first_result() {
	    	frp.firstResult();
			logger.info("Clicked on the first result");

		}

		@Then("Add to the cart")
		public void add_to_the_cart() {
	    	atc.addToCart();
			logger.info("Clicked add to cart");

		}

		@Then("Take screenshot after addding to cart")
		public void take_screenshot_after_addding_to_cart() throws IOException {
			re.takescreenshot("src/test/resources/screenshot/flipkartAddcart.png");
			   logger.info("Took screenshot");
		}

		@Then("Click place order")
		public void click_place_order() {
	    	pop.placeOrder();
			logger.info("Clicked Place order");

		}

		@Then("Take Screenshot after clicking on place order")
		public void take_screenshot_after_clicking_on_place_order() throws IOException {
			re.takescreenshot("src/test/resources/screenshot/flipkartPlaceorder.png");
			   logger.info("Took screenshot");
		}
}
