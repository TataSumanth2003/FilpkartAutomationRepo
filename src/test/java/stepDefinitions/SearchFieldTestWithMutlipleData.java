package stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseclass.LibraryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartSearchPage;
import utilities.ResuabilityClass;

public class SearchFieldTestWithMutlipleData extends LibraryClass{

	ResuabilityClass re;
    FlipkartSearchPage search;
    public String picText;
    private static final Logger logger = LogManager.getLogger(LibraryClass.class);
    @Given("Launch the browser and enter the URL")
    public void launch_the_browser_and_enter_the_url() {
//    	initializeBrowser();
//        openApplication();
//        logger.info("Application Launched");
        re = new ResuabilityClass(driver);
        search = new FlipkartSearchPage(driver);
    }

    @When("Enter {string} in the search field")
    public void enter_in_the_search_field(String text) {
    	picText=text;
		search.search(text);
		logger.info("Searched "+text);

		search.clickSearch();
		logger.info("Clicked Search");

    }

    @Then("Search results should be displayed")
    public void search_results_should_be_displayed() {
    	re.getTitleName();
		logger.info("Results displayed");

    }

    @Then("Verify the results")
    public void verify_the_results() {
		logger.info("Verified results");

    }

    @Then("Take a screenshot and close the browser")
    public void take_a_screenshot_and_close_the_browser() throws IOException {
    	re.takescreenshot("src/test/resources/screenshot/flipkartsearch"+picText+".png");
		   logger.info("Took screenshot");

//		   closeBrowser();
//
//		   logger.info("Closed Browser");
    }
}
