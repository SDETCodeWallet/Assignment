package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "src/test/resources/features/SampleScenarios.feature", 
	    glue = "stepdefinitions",
	    tags = "@TestUI",
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = false
	)
public class TestRunner extends AbstractTestNGCucumberTests {
}
