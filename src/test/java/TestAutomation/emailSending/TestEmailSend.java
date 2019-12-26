package TestAutomation.emailSending;

import automationHomework.Pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class TestEmailSend {
    private MainPage mainPage;
    private InboxPage inboxPage;
    private NewLetterPage newLetterPage;
    private DraftsPage draftsPage;
    private Letter letter;

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
        draftsPage = new DraftsPage(driver);
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
        letter = new Letter("general_ks@mail.ru", "Test", "Test");
        newLetterPage.fillingMessage(letter);
        newLetterPage.saveNewLetter(letter);
        inboxPage.inDraftsGo();
        Assertions.assertTrue(draftsPage.searchLetterByTime(letter.getDate())); //Only by time;
        draftsPage.enterInLetter(letter.getDate());
        Assertions.assertEquals("general_ks@mail.ru", newLetterPage.getTo());
        Assertions.assertEquals("Test", newLetterPage.getSubject());
        Assertions.assertEquals("Test", newLetterPage.getBody());
        Thread.sleep(2000);
    }

    @DisplayName("Send the mail")
    @Order(3)
    @Test
    void sendMail() throws InterruptedException {
        newLetterPage.sendNewLetter();
        inboxPage.inDraftsGo();
        Assertions.assertFalse(draftsPage.searchLetterByTime(letter.getDate()));
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
