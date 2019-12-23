package automationHomework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;

public class NewLetterPage {
    @FindBy(xpath = "[class*='inputContainer']")
    List<WebElement> inputFields;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Compose')]")
    private WebElement to;

    @FindBy(xpath = "[role*='textbox']")
    private WebElement body;

    @FindBy(xpath = "[title*='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "[title*='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "[title*='Close']")
    private WebElement closeButton;



    private WebDriver driver;
    public NewLetterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void fillingMessage(Letter letter) {
        inputFields.get(0).sendKeys(letter.getTo());
        inputFields.get(1).sendKeys(letter.getSubject());
        this.body.sendKeys(letter.getBody());
    }

    public void saveNewLetter(Letter letter){
        saveButton.click();
        letter.setDate();
        closeButton.click();
    }

    public void sendNewLetter(){
        sendButton.click();
        closeButton.click();
    }


//    driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")).sendKeys("general_ks@mail.ru");
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")).sendKeys("Test");
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")).sendKeys("Test!");
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span")).click();
////        Нажимаем кнопку черновики
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[2]/div/div/button[2]")).click();
//        driver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div/div[2]/div/div[1]/nav/a[5]")).click();


}
