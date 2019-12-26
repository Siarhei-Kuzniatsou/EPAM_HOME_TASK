package automationHomework.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage {

    private WebDriver driver;
    private String locateLetterByDate;
    private NewLetterPage newLetterPage;


        private String getLocateLetterByDate() {
        return locateLetterByDate;
    }
    private void setLocateLetterByDate(String date) {
        locateLetterByDate = new StringBuilder()
                .append(".//*[text()='")
                .append(date)
                .append("']").toString();
    }

    public boolean searchLetterByTime(String date){
            setLocateLetterByDate(date);
        return driver.findElement(By.xpath(getLocateLetterByDate())).isEnabled();
    }

    public void enterInLetter(String date){
        setLocateLetterByDate(date);
        driver.findElement(By.xpath(getLocateLetterByDate())).click();
        this.newLetterPage = new NewLetterPage(driver);
    }

    public DraftsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
