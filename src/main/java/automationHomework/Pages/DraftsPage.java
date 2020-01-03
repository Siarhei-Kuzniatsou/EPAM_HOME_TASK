package automationHomework.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class DraftsPage {

    private String locateLetterByDate;

    private String getLocateLetterByDate() {
        return locateLetterByDate;
    }

    private void setLocateLetterByDate(String date) {
        locateLetterByDate = new StringBuilder()
                .append("//div[text()='")
                .append(date)
                .append("']").toString();
    }

    public boolean searchLetterByTime(String date){
            setLocateLetterByDate(date);
            try{
                $(By.xpath(getLocateLetterByDate())).isEnabled();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
    }

    public void enterInLetter(String date){
        setLocateLetterByDate(date);
        $(By.xpath(getLocateLetterByDate())).click();
    }

    public DraftsPage(WebDriver driver){
        setWebDriver(driver);
    }
}
