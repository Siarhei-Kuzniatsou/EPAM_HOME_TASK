package automationHomework.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class DraftsPage {

    private WebDriver driver;
    private String locateLetterByDate;
    private NewLetterPage newLetterPage;


    private String getLocateLetterByDate() {
        return locateLetterByDate;
    }

    private void setLocateLetterByDate(String date) {
        locateLetterByDate = new StringBuilder()
                .append(".//*[text()='")
                .append(date)
                .append("']").toString();
    }

    public boolean searchLetterByTime(String date){
            setLocateLetterByDate(date);
        return $(By.xpath(getLocateLetterByDate())).isEnabled();
    }

    public void enterInLetter(String date){
        setLocateLetterByDate(date);
        $(By.xpath(getLocateLetterByDate())).click();
        this.newLetterPage = new NewLetterPage(getWebDriver());
    }

    public DraftsPage(WebDriver driver){
        setWebDriver(driver);
    }
}
