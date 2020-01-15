package TestAutomation.behaviorDrivenDevelopment.mailTest.steps;

import TestAutomation.BaseSelenium;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class RunFailTestSteps extends BaseSelenium {

    @Given("^I go to Mail\\.ru$")
    public void iGoToMailRu() {
        driver.get("http://www.mail.ru");
        setWebDriver(driver);
    }

    @When("^I login as general_ks@mail\\.ru with \"([^\"]*)\"$")
    public void iLoginAsGeneral_ksMailRuWith(String password)  {
        $(byName("domain")).selectOptionContainingText("@mail.ru");
        Actions builder = new Actions(getWebDriver());
        Action action = builder
                .moveToElement($(byName("login")))
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .build();
        action.perform();
        $(byName("login")).sendKeys("general_ks", Keys.ENTER);
        $(byName("password")).sendKeys(password, Keys.ENTER);
    }

    @Then("^I \"([^\"]*)\" get button logout$")
    public void iGetButtonLogout (String result) throws InterruptedException {
        Assertions.assertEquals(result, isButtonVisible());
    }

    public String isButtonVisible() throws InterruptedException {

        boolean result = false;
        Thread.sleep(3000);
        try{
            result = $(byXpath("//*[contains(@title, 'sign out')]")).isDisplayed();
        }
        catch (NoSuchElementException e){
//            result = false;
        }
        if (result) {
            $(byXpath("//*[contains(@title, 'sign out')]")).click();
            return "yes";
        }
        else return "no";

    }
}
