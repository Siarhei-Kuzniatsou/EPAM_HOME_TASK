package automationHomework.Pages;

import automationHomework.Services.Highlight;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class InboxPage {

    public InboxPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public boolean isLoaded() {
        try {
            $(By.xpath("//span[contains(text(),'Compose')]"))
                    .shouldHave(Condition.exist);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void createNewLetter() {
        try {
            new Highlight(getWebDriver()).highlightElement($(By.className("compose-button__wrapper")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.className("compose-button__wrapper")).click();
    }

    public void inDraftsGo(){
        try {
            new Highlight(getWebDriver()).highlightElement($(By.linkText("Drafts")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.linkText("Drafts")).click();
    }

    public void inSentPageGo(){
        try {
            new Highlight(getWebDriver()).highlightElement($(By.linkText("Sent")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.linkText("Sent")).click();
    }
}
