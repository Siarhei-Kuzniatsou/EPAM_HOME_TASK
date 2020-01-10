package TestAutomation.behaviorDrivenDevelopment.mailTest.steps;

import automationHomework.Pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RunTestSteps {

    private Letter letter;
    private NewLetterPage newLetterPage;
    private InboxPage inboxPage;
    private DraftsPage draftsPage;
    private SentPage sentPage;


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
    public void theButtonShouldBeVisible(String arg0) {

        inboxPage = new InboxPage(getWebDriver());
        Assertions.assertTrue(inboxPage.isLoaded());
    }

    @Given("^I click button Compose and fill fields To, Subject and Body$")
    public void iClickButtonComposeAndFillFieldsToSubjectAndBody() {
        inboxPage.createNewLetter();
        letter = new Letter("general_ks@mail.ru", "Test", "Test");
        newLetterPage = new NewLetterPage(getWebDriver());
        newLetterPage.fillingMessage(letter);
    }

    @When("^I save letter as draft$")
    public void iSaveLetterAsDraft() throws InterruptedException {
        newLetterPage.saveNewLetter(letter);
    }

    @Then("^new letter can be into drafts and has all fields filling$")
    public void newLetterCanBeIntoDraftsAndHasAllFieldsFilling() throws InterruptedException {
        inboxPage.inDraftsGo();
        draftsPage = new DraftsPage(getWebDriver());
        Assert.assertTrue(draftsPage.searchLetterByTime(letter.getDate())); //Only by time;
        draftsPage.enterInLetter(letter.getDate());
        Assert.assertEquals("general_ks@mail.ru", newLetterPage.getTo());
        Assert.assertEquals("Test", newLetterPage.getSubject());
        Assert.assertEquals("Test", newLetterPage.getBody());
    }

    @Given("^Sent letter of Drafts$")
    public void sentLetterOfDrafts() {
    }

    @When("^Go to Drafts, check letter and send$")
    public void goToDraftsCheckLetterAndSend() {
        newLetterPage.sendNewLetter(letter);
    }

    @Then("^letter can be into Sent folder$")
    public void letterCanBeIntoSentFolder() throws InterruptedException {
        inboxPage.inSentPageGo();
        sentPage = new SentPage(getWebDriver());
        Assert.assertTrue(sentPage.searchLetterByTime(letter.getDate()));
    }

    @Given("^LogOut$")
    public void logout() {
    }

    @When("^Click button logOut$")
    public void clickButtonLogOut() {
        $(By.xpath("//*[@id='PH_logoutLink']")).click();
    }

    @Then("^Button Login can be visible$")
    public void buttonLoginCanBeVisible() {
        Assert.assertTrue($(By.xpath("//*[@id='PH_authLink']")).isEnabled());
    }


}
