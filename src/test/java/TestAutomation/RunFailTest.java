package TestAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
//        plugin = {
////                "pretty", "json:target/otherMailTest/Cucumber.json",
////                "html:target/otherMailTest/cucumber-html-report",
////                "com.epam.reportportal.cucumber.StepReporter"
//        },
        features = "./src/main/resourcesForTest/failTest"
)
public class RunFailTest {

        @BeforeClass
        public static void init(){
                BaseSelenium.setup();
        }

        @AfterClass
        public static void exit(){
                BaseSelenium.close();
        }

}
