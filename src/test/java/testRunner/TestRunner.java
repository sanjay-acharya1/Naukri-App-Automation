package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/profile.feature",
				glue= {"stepDefinitions","hooks"},
				tags = "@upre",
				plugin={"pretty","html:target/cucumber-reports/Cucumber.html",
						"pretty","junit:target/cucumber-reports/Cucumber.xml",
						"pretty","json:target/cucumber-reports/Cucumber.json"})

public class TestRunner {

}
