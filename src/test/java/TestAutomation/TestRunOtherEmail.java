package TestAutomation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
//                "pretty", "json:target/otherMailTest/Cucumber.json",
//                "html:target/otherMailTest/cucumber-html-report",
                "com.epam.reportportal.cucumber.StepReporter"
        },
        features = "./src/main/resourcesForTest/otherMailTest"
)
public class TestRunOtherEmail {
        @BeforeClass
        public static void loggerMyTest(){
        Logger logger = LogManager.getRootLogger();
                logger.debug("Debug message");
                logger.info("Info message");
                logger.fatal("Fatal message");
                logger.error("Error message");
                logger.warn("Warn message");
        }

}
