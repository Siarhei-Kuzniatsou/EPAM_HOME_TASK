package automationHomework.Pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class NewLetterPage {


    private SelenideElement to = $(By.xpath("//div[contains(@data-type,'to')]//input[contains(@type,'text')]"));
    private SelenideElement subject = $(By.name("Subject"));
    private SelenideElement body = $(By.xpath("//div[contains(@role,'textbox')]"));
    private SelenideElement saveButton = $(By.xpath("//span[contains(@title,'Save')]"));
    private SelenideElement closeButton = $(By.xpath("//button[contains(@title,'Close')]"));
    private SelenideElement closeButtonAfterSend = $(By.xpath("//span[contains(@title,'Close')]"));
    private SelenideElement sendButton = $(By.xpath("//span[contains(@title,'Send')]"));

    public NewLetterPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public void fillingMessage(Letter letter) {
        to.sendKeys(letter.getTo());
        subject.sendKeys(letter.getSubject());
        this.body.sendKeys(letter.getBody());
    }

    public void saveNewLetter(Letter letter) throws InterruptedException {
        saveButton.click();
        letter.setDate();
        closeButton.click();
    }

    public void sendNewLetter(Letter letter){
        sendButton.click();
        letter.setDate();
        closeButtonAfterSend.click();
    }

    public String getTo() { return $(By.xpath("//div[contains(@title,'general_ks@mail.ru')]//span[text()='general_ks@mail.ru']")).getText(); }

    public String getSubject() {
        return subject.getValue();
    }

    public String getBody() {
        int newLineIndex = body.getText().indexOf("\n");
        return body.getText().substring(0, newLineIndex);
    }
}
