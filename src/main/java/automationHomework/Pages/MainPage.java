package automationHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    public static final String PASSWORD = "g1020958G";
    public static final String LOGIN = "general_ks";
    public static final String DOMAIN = "@mail.ru";
    private WebDriver driver;
    @FindBy(id = "mailbox:login")
    private WebElement login;
    @FindBy(id = "mailbox:password")
    private WebElement password;
    private Select domain;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        checkDomain()
                .enterLogin()
                .enterPassword();
    }

    private void enterPassword() {
        password.sendKeys(PASSWORD, Keys.ENTER);
    }

    private MainPage checkDomain() {
        domain = new Select(driver.findElement(By.id("mailbox:domain")));
        domain.selectByVisibleText(DOMAIN);
        return this;
    }

    private MainPage enterLogin() {
        login.sendKeys(LOGIN, Keys.ENTER);
        return this;
    }

}
