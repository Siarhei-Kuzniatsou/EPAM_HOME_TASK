package TestAutomation;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.runner.RunWith;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
//        plugin = {
//                "pretty", "json:target/Cucumber.json",
//                "html:target/cucumber-html-report"
//        },
        features = "C:/Users/Siarhei_Kuzniatsou1/Desktop/repos/EPAM_HOME_TASK/src/main/resourcesForTest/mailTest"
)
public class RunTestEmail {

        @After
        public void closeBrowser(){
                getWebDriver().quit();
        }
}
