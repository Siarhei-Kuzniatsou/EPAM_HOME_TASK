package TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSelenium {

    public static WebDriver driver;

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/TestAutomation/emailSending/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void close(){
        driver.quit();
    }
}
