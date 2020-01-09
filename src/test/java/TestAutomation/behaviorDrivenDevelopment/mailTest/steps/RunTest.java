package TestAutomation.behaviorDrivenDevelopment.mailTest.steps;

import automationHomework.Pages.InboxPage;
import automationHomework.Pages.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RunTest {

    @Given("^I login as general_ks@mail\\.ru$")
    public void iLoginAsGeneral_ksMailRu() {
        open("http://www.mail.ru/");
        getWebDriver().manage().window().maximize();
    }

    @When("^I do login$")
    public void iDoLogin() {
        new MainPage(getWebDriver()).logIn();
    }

    @Then("^the button \"([^\"]*)\" should be visible$")
    public void theButtonShouldBeVisible(String arg0) throws Throwable {
        Assertions.assertTrue(new InboxPage(getWebDriver()).isLoaded());
    }
}
