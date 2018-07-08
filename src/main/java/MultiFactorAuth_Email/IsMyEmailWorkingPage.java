package MultiFactorAuth_Email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IsMyEmailWorkingPage {

    private final WebDriver driver;

    @FindBy(id="verify_email")
    private WebElement email;

    @FindBy(id="content_cob_check")
    private WebElement checkBtn;

    public IsMyEmailWorkingPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("http://ismyemailworking.com");
    }

    public void checkEmail(final String emailAddress){
        this.email.sendKeys(emailAddress);
        this.checkBtn.click();
    }

}