package automationHomework.Services;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HighlightElement {
    private JavascriptExecutor jsExec;

    public HighlightElement(WebDriver driver) {
        jsExec = (JavascriptExecutor) driver;
    }

    public void highlightElementYellow(SelenideElement element) throws InterruptedException {
        String bg = element.getCssValue("background");
        jsExec.executeScript("arguments[0].style.background = 'yellow'", element);
        jsExec.executeScript("arguments[0].style.background = '" + bg + "'", element);
    }

}
