package automationHomework.Pages;

import automationHomework.Services.Highlight;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new Highlight(getWebDriver()).highlightElement($(byName("password")));
        $(byName("password")).sendKeys(PASSWORD, Keys.ENTER);
    }

    private MainPage checkDomain() {
        new Highlight(getWebDriver()).highlightElement($(byName("domain")));
        $(byName("domain")).selectOptionContainingText(DOMAIN);
        return this;
    }

    private MainPage enterLogin() {
        new Highlight(getWebDriver()).highlightElement($(byName("login")));
        $(byName("login")).sendKeys(LOGIN, Keys.ENTER);
        return this;
    }

}
