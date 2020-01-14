package automationHomework.Services;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Highlight {
    private JavascriptExecutor jsExec;
    private String color = "yellow";

    public Highlight(WebDriver driver) {
        jsExec = (JavascriptExecutor) driver;
    }

    public void highlightElement(SelenideElement element) {
        String bg = element.getCssValue("background");
        jsExec.executeScript("arguments[0].style.background = '" + color + "'", element);
        sleep(1000);
        File screenFile = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("HH_mm_ss");
        String date = format.format(new Date());
        try {
            FileUtils.copyFile(screenFile, new File("./target/screenshots/" + date + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsExec.executeScript("arguments[0].style.background = '" + bg + "'", element);
    }

    public Highlight(WebDriver driver, Colors color) {
        jsExec = (JavascriptExecutor) driver;
        this.color = color.toString();
    }
}
