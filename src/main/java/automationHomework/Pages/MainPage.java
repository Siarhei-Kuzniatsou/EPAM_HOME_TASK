package automationHomework.Pages;

import automationHomework.Services.Highlight;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class MainPage {
    public static final String PASSWORD = "g1020958G";
    public static final String LOGIN = "general_ks";
    public static final String DOMAIN = "@mail.ru";

    public MainPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public void logIn() {
        checkDomain()
                .enterLogin()
                .enterPassword();
    }

    private void enterPassword() {
        try {
            new Highlight(getWebDriver()).highlightElement($(byName("password")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(byName("password")).sendKeys(PASSWORD, Keys.ENTER);
    }

    private MainPage checkDomain() {
        try {
            new Highlight(getWebDriver()).highlightElement($(byName("domain")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(byName("domain")).selectOptionContainingText(DOMAIN);
        return this;
    }

    private MainPage enterLogin() {
        try {
            new Highlight(getWebDriver()).highlightElement($(byName("login")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(byName("login")).sendKeys(LOGIN, Keys.ENTER);
        return this;
    }

}
