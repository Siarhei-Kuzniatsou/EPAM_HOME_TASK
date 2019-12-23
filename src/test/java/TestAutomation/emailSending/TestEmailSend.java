package TestAutomation.emailSending;

import automationHomework.Pages.InboxPage;
import automationHomework.Pages.Letter;
import automationHomework.Pages.MainPage;
import automationHomework.Pages.NewLetterPage;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class TestEmailSend {
    private MainPage mainPage;
    private InboxPage inboxPage;
    private NewLetterPage newLetterPage;

    public static WebDriver driver;

    @BeforeAll
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Siarhei_Kuzniatsou1/Desktop/repos/EPAM_HOME_TASK/src/test/java/TestAutomation/emailSending/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        mainPage = new MainPage(driver);
        inboxPage = new InboxPage(driver);
        newLetterPage = new NewLetterPage(driver);
    }


    @DisplayName("Login to the mail box")
    @Order(1)
    @Test
    void login() throws InterruptedException {
        driver.get("http://www.mail.ru/");
        mainPage.logIn();
        Assert.assertTrue(inboxPage.isLoaded());
    }

    @DisplayName("Create a new mail (fill addressee, subject and body fields)")
    @Order(2)
    @Test
    void createNewEmail() throws InterruptedException {
        inboxPage.createNewLetter();
        Letter letter = new Letter("general_ks@mail.ru", "Test", "Test");
        newLetterPage.fillingMessage(letter);
        newLetterPage.saveNewLetter(letter);
        Assertions.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Test')]")).isEnabled());
//        driver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[4]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[1]/div[1]/div[6]/div/div[1]/a/span/a")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Test')]")).click();
        Assertions.assertEquals("general_ks", driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/div/span")).getText());
        Assertions.assertEquals("Test", driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")).getCssValue("value"));
        Assertions.assertEquals("Test!", driver.findElement(By.xpath("//*[@id='style_15770891121113291285_BODY']/div/div/div[1]")).getText());
        Thread.sleep(2000);
    }

    @DisplayName("Send the mail")
    @Order(3)
    @Test
    void sendMail() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]")).click();
        Assertions.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'Test')]")).isEnabled());
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div[2]/div/div[2]/div[4]/div[2]/div[2]/div[3]/div/div/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[4]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/div/div/div/div[2]/div/div[1]/nav/a[4]")).click();
        Assertions.assertEquals("Test", driver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[4]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div/div[1]/div[3]/div[3]/div[1]/div[1]/div[6]/div/div[2]/a/span/a/div[4]/div/div[3]/span[1]/span")).getText());
        Thread.sleep(2000);
    }

    @DisplayName("Log off")
    @Order(4)
    @Test
    void logOff() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='PH_logoutLink']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='PH_authLink']")).isEnabled());
        Thread.sleep(2000);
    }

    @AfterAll
    static void closeAll() {
        driver.quit();
    }

}
