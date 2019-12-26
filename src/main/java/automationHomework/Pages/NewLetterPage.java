package automationHomework.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewLetterPage {

    @FindBy(xpath = ("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input"))
    private WebElement to;

    @FindBy(xpath = ("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input"))
    private WebElement subject;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")
    private WebElement body;

    @FindBy(xpath = "[title*='Send']")
    private WebElement sendButton;


    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span")
    private WebElement saveButton;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[2]/div/div/button[2]")
    private WebElement closeButton;



    private WebDriver driver;
    public NewLetterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void fillingMessage(Letter letter) {
        to.sendKeys(letter.getTo());
        subject.sendKeys(letter.getSubject());
        this.body.sendKeys(letter.getBody());
    }

    public void saveNewLetter(Letter letter) throws InterruptedException {
        saveButton.click();
        Thread.sleep(5000);
        letter.setDate();
        closeButton.click();
        Thread.sleep(5000);
    }

    public void sendNewLetter(){
        sendButton.click();
        closeButton.click();
    }

    public String getTo() {
        return to.getText();
    }

    public String getSubject() {
        return subject.getText();
    }

    public String getBody() {
        return body.getText();
    }


}
