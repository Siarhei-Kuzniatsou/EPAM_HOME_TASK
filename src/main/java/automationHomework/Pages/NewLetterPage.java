package automationHomework.Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewLetterPage {


//    private ElementsCollection elements;
//    private WebElement to = getWebDriver().findElement(By.xpath("[data-name='to']"));
    private SelenideElement to = $(By.xpath("//div[contains(@data-type,'to')]//input[contains(@type,'text')]"));
    private SelenideElement subject = $(By.name("Subject"));
    private SelenideElement body = $(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div/div[1]"));
    private SelenideElement saveButton = $(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span"));
    private SelenideElement closeButton = $(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[2]/div/div/button[2]"));
    private SelenideElement sendButton = $(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span"));

    public NewLetterPage(WebDriver driver) {
        setWebDriver(driver);
//        elements = $(By.xpath("[data-name='to']")).shouldBe(CollectionCondition.size(2));
//        elements = $$(By.xpath("[class='container--H9L5q size_s_compressed--2c-eV']")).shouldBe(CollectionCondition.size(2));
//        to = elements.get(0);
    }

    public void fillingMessage(Letter letter) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement to = getWebDriver().findElement(By.xpath("//div[contains(@data-type,'to')]//input[contains(@type,'text')]"));

        to.sendKeys(letter.getTo());
        subject.sendKeys(letter.getSubject());
        this.body.sendKeys(letter.getBody());
    }

    public void saveNewLetter(Letter letter) throws InterruptedException {
        saveButton.click();
        letter.setDate();
        closeButton.click();
    }

    public void sendNewLetter(){
        sendButton.click();
        Configuration.clickViaJs = true;
        closeButton.click();
    }

    public String getTo() {
//         WebElement to = getWebDriver().findElement(By.xpath("//div[contains(@data-type,'to')]//input[contains(@type,'text')]"));

        return to.getText();
    }

    public String getSubject() {
        return subject.getText();
    }

    public String getBody() {
        return body.getText();
    }
}
