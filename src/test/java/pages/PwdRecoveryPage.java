package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PwdRecoveryPage
        extends BasePage
{
    public static By email_tb = By.cssSelector("input[type='email']");
    public static By send_email_btn = By.cssSelector("button[type='submit']");

    public PwdRecoveryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /*
       submit password recovery form by filling email.
    */
    public LoginPage submitPwdRecoveryForm(String email){
        enterText(email_tb, email);
        click(send_email_btn);
        return new LoginPage(super.driver, super.wait);
    }
}
