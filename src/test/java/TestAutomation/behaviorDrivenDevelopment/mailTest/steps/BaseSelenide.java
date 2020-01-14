package TestAutomation.behaviorDrivenDevelopment.mailTest.steps;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseSelenide {

    public static void openDriver(){
        open("http://www.mail.ru/");
        getWebDriver().manage().window().maximize();
    }

    public static void closeDriver(){
        getWebDriver().quit();
    }

}
