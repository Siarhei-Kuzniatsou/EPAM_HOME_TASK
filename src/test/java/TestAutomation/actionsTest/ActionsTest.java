package TestAutomation.actionsTest;

import automationHomework.Pages.InboxPage;
import automationHomework.Pages.MainPage;
import automationHomework.Services.Colors;
import automationHomework.Services.Highlight;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ActionsTest {
    public static final String ERRORLOGIN = "general";

    @Test
    void actionsTest(){
        open("http://www.mail.ru/");
        getWebDriver().manage().window().maximize();
        Actions builder = new Actions(getWebDriver());
        SelenideElement input = $(By.id("mailbox:login"));
        try {
            new Highlight(getWebDriver(), Colors.RED).highlightElement(input);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        input.click();
        Action action = builder
                .sendKeys(input, ERRORLOGIN)
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .build();
        action.perform();
        new MainPage(getWebDriver()).logIn();
        Assert.assertTrue(new InboxPage(getWebDriver()).isLoaded());
        action =builder
                .moveToElement($(By.xpath("//*[@id='PH_logoutLink']")))
                .contextClick()
                .build();
        action.perform();
        Assert.assertTrue($(By.xpath("//*[@id='PH_authLink']")).isEnabled());
            getWebDriver().quit();
    }

}
