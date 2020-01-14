package automationHomework.Pages;

import automationHomework.Services.Highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class DraftsPage {

    private String locateLetterByDate;

    private String getLocateLetterByDate() {
        return locateLetterByDate;
    }

    private void setLocateLetterByDate(String date) {
        if (date.charAt(0) == '0') date = date.substring(1);
        locateLetterByDate = new StringBuilder()
                .append("//div[text()='")
                .append(date)
                .append("']").toString();
    }

    public boolean searchLetterByTime(String date) {
        setLocateLetterByDate(date);
        return $(By.xpath(getLocateLetterByDate())).isEnabled();
    }

//    public boolean checkLetterSent(String date) throws InterruptedException {
//
//        setLocateLetterByDate(date);
//        Boolean elementCondition = false;
//        try{
//            elementCondition = $(By.xpath(getLocateLetterByDate())).isDisplayed();
//        }
//        catch (NoSuchElementException e){
//            return  elementCondition;
//        }
//        return elementCondition;
//    }


    public void enterInLetter(String date) {
        setLocateLetterByDate(date);
        new Highlight(getWebDriver()).highlightElement($(By.xpath(getLocateLetterByDate())));
        $(By.xpath(getLocateLetterByDate())).click();
    }

    public DraftsPage(WebDriver driver) {
        setWebDriver(driver);
    }
}
