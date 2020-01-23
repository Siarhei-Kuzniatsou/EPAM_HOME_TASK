//package TestAutomation.seleniumGrid;
//
//import automationHomework.Pages.InboxPage;
//import automationHomework.Pages.MainPage;
//import automationHomework.Services.Colors;
//import automationHomework.Services.Highlight;
//import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.net.MalformedURLException;
//import java.net.URL;
//import static com.codeborne.selenide.Selenide.$;
//
//
//public class ActionTestGrid {
//    public static final String ERRORLOGIN = "general";
//    static WebDriver driver;
//
//    @Test
//    void actionsTest() throws MalformedURLException {
//
//
////        ChromeOptions options = new ChromeOptions()
//////        options.addExtensions(new File("/path/to/extension.crx"))
//////        options.setBinary(new File("/path/to/chrome"));
////
////        // For use with ChromeDriver:
////        ChromeDriver driver = new ChromeDriver(options);
//
//        // For use with RemoteWebDriver:
//        RemoteWebDriver driver = new RemoteWebDriver(
//                new URL("http://10.5.16.200:4444/wd/hub"),
//                new ChromeOptions());
//
//
//
////        -----------------------------------------------------
////        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
////        capabilities.setBrowserName("chrome");
////        capabilities.setPlatform(Platform.WIN10);
////
////        driver = new RemoteWebDriver(new URL( "http://10.5.16.200:4444/wd/hub"), capabilities);
//
////        -------------------------------------------------------
//
//
//        driver.get("http://www.mail.ru/");
//        driver.manage().window().maximize();
//
//        Actions builder = new Actions(driver);
//        SelenideElement input = $(By.id("mailbox:login"));
//        new Highlight(driver, Colors.RED).highlightElement(input);
//        input.click();
//        Action action = builder
//                .sendKeys(input, ERRORLOGIN)
//                .doubleClick()
//                .sendKeys(Keys.DELETE)
//                .build();
//        action.perform();
//        new MainPage(driver).logIn();
//        Assert.assertTrue(new InboxPage(driver).isLoaded());
//        action =builder
//                .moveToElement($(By.xpath("//*[@id='PH_logoutLink']")))
//                .contextClick()
//                .build();
//        action.perform();
//        Assert.assertTrue($(By.xpath("//*[@id='PH_authLink']")).isEnabled());
//        driver.quit();
//    }
//
//}
