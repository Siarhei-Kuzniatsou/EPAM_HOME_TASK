package automationHomework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Compose')]")
    private WebElement composeMessageButton;

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'/drafts/')]")
    private WebElement draftsButton;


    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public boolean isLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(composeMessageButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void createNewLetter() {
        composeMessageButton.click();
    }

    public void inDraftsGo(){
        draftsButton.click();
    }
}
