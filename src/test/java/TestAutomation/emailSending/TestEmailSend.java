package TestAutomation.emailSending;

import com.sun.org.apache.xpath.internal.XPath;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
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

    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Написать письмо')]")
    WebElement sendMessage;
    public static WebDriver driver;

    @BeforeAll
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Siarhei_Kuzniatsou1/Desktop/repos/EPAM_HOME_TASK/src/test/java/TestAutomation/emailSending/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);

    }


    @DisplayName("Login to the mail box")
    @Order(1)
    @Test
    void login() throws InterruptedException {
        driver.get("http://www.mail.ru/");
        WebElement login = driver.findElement(By.id("mailbox:login"));
        login.sendKeys("general_ks");
        Select select = new Select(driver.findElement(By.id("mailbox:domain")));
        select.selectByVisibleText("@mail.ru");
        WebElement password = driver.findElement(By.id("mailbox:submit"));
        password.submit();
        WebElement sentpassword = driver.findElement(By.id("mailbox:password"));
        sentpassword.sendKeys("g1020958G");
        password.submit();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(sendMessage));
    }

    @DisplayName("Create a new mail (fill addressee, subject and body fields)")
    @Order(2)
    @Test
    void createNewEmail() throws InterruptedException {

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("a.b-toolbar__btn.js-shortcut[data-title*='Написать письмо']"))));
//        driver.findElement(By.xpath("///div/a/span[contains(text(),'Написать письмо')]")).submit();
        System.out.println(sendMessage.isEnabled());
        sendMessage.click();
        Thread.sleep(2000);

//        driver.findElement(By.id("compose_to")).sendKeys("general_ks@mail.ru");
//        driver.findElement(By.name("Subject")).sendKeys("Test");
//        driver.findElement(By.id("tinymce")).sendKeys("Test!");
//        driver.findElement(By.cssSelector("ata-title='Сохранить'")).submit();
//        driver.findElement(By.cssSelector("data-text='Сохранить черновик'")).submit();
//        driver.findElement(By.id("500001")).submit();
//        Assertions.assertDoesNotThrow((Executable) driver.findElement(By.cssSelector("b-datalist__body.b-datalist__item js-datalist-item.b-datalist__item__body.Test")));
//        driver.findElement(By.cssSelector("b-datalist__body.b-datalist__item js-datalist-item.b-datalist__item__body.Test")).submit();


    }

//            6) Verify the draft content (addressee, subject and body – should be the same as in 3).
//            7) Send the mail.
//8) Verify, that the mail disappeared from Drafts.
//            9) Verify, that the mail is in Sent.
//            10) Log off.

    @AfterAll
    static void closeAll() {
        driver.quit();
    }

}
