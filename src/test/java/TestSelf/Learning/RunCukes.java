package TestSelf.Learning;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/TestSelf/Learning", format = {"pretty",
        "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json"}, tags = {"@complete"})
public class RunCukes {
}