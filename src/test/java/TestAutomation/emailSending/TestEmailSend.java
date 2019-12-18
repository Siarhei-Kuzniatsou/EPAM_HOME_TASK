package TestAutomation.emailSending;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmailSend {
    public static  WebDriver driver;

    @BeforeAll
    static void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Siarhei_Kuzniatsou1/Desktop/repos/EPAM_HOME_TASK/src/test/java/TestAutomation/emailSending/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Login to the mail box")
    @Order(1)
//    @Disabled
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
        WebElement result = driver.findElement(By.id("PH_user-email"));
        System.out.println(result.getText());
        System.out.println(result.getAttribute("value"));
        Assertions.assertEquals("general_ks@mail.ru", result.getText());
        Assertions.assertEquals("general_ks@mail.ru", result.getAttribute("text"));

    }

//    @Test
//    @DisplayName("Assert, that the login is successful")
//    @Order(2)
//    @Disabled
//    void loginIsSuccessful(){
//
//    }
//
//    @Test
//    @DisplayName("Create a new mail (fill addressee, subject and body fields)")
//    @Order(3)
//    @Disabled
//    void createNewEmail(){
//
//    }

//
//            4) Save the mail as a draft.
//            5) Verify, that the mail presents in Drafts.
//            6) Verify the draft content (addressee, subject and body – should be the same as in 3).
//            7) Send the mail.
//8) Verify, that the mail disappeared from Drafts.
//            9) Verify, that the mail is in Sent.
//            10) Log off.
    @AfterAll
    static void closeAll(){
        driver.quit();
    }

}
