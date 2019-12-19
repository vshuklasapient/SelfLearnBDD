package TestSelf.Learning;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/TestSelf/Learning", plugin = {"pretty",
        "html:target", "json:target/cucumber.json"}, tags = {"@complete"})
public class RunCukes {
} 