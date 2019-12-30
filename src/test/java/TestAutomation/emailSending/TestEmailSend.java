package TestAutomation.emailSending;

import automationHomework.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestEmailSend {
    private MainPage mainPage;
    private InboxPage inboxPage;
    private NewLetterPage newLetterPage;
    private DraftsPage draftsPage;
    private Letter letter;

    public static WebDriver driver;

    @Test(description = "Login to the mail box")
    void login() throws InterruptedException {
        open("http://www.mail.ru/");
        getWebDriver().manage().window().maximize();
        mainPage = new MainPage(getWebDriver());
        mainPage.logIn();
        inboxPage = new InboxPage(getWebDriver());
        Assert.assertTrue(inboxPage.isLoaded());
    }

    @Test(dependsOnMethods = "login", description = "create New Email")
    void createNewEmail() throws InterruptedException {
        inboxPage.createNewLetter();
        letter = new Letter("general_ks@mail.ru", "Test", "Test");
        newLetterPage = new NewLetterPage(getWebDriver());
        newLetterPage.fillingMessage(letter);
        newLetterPage.saveNewLetter(letter);
        inboxPage.inDraftsGo();
        draftsPage = new DraftsPage(getWebDriver());
        Assert.assertTrue(draftsPage.searchLetterByTime(letter.getDate())); //Only by time;
        draftsPage.enterInLetter(letter.getDate());
//        Assert.assertEquals(letter, );
        Assert.assertEquals("general_ks@mail.ru", newLetterPage.getTo());
        Assert.assertEquals("Test", newLetterPage.getSubject());
        Assert.assertEquals("Test", newLetterPage.getBody());
    }


    @Test(dependsOnMethods = "createNewEmail", description = "Send the mail")
    void sendMail() throws InterruptedException {
        newLetterPage.sendNewLetter();
        inboxPage.inDraftsGo();
        Assert.assertFalse(draftsPage.searchLetterByTime(letter.getDate()));
    }


    @Test(dependsOnMethods = "sendMail", description = "Log off")
    void logOff() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='PH_logoutLink']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='PH_authLink']")).isEnabled());
        Thread.sleep(2000);
    }

    @AfterTest
    static void closeAll() {
        driver.quit();
    }

}
