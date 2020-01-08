package automationHomework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class SentPage {
    public SentPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public boolean searchLetterByTime(String date) throws InterruptedException {
        String locateLetterByDate = new StringBuilder()
                .append("//div[text()='")
                .append(date)
                .append("']").toString();
        try {
            $(By.xpath(locateLetterByDate)).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
