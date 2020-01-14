package TestAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/otherMailTest/Cucumber.json",
                "html:target/otherMailTest/cucumber-html-report"
        },
        features = "./src/main/resourcesForTest/otherMailTest"
)
public class RunOtherEmailTest {

}
