package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
    features = {"src/test/resources/Features/Flipkart.feature"},
    glue = {"stepDefinitions", "Hooks"},
    tags = "@smoke",  // Only use this if the feature has this tag
    plugin = {
        "pretty",
        "html:target/cucumber-html-report.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt",
        "testRunner.CucumberExtentReportPlugin"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

