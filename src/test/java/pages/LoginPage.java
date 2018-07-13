package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
        extends BasePage {

    public static By email_tb = By.cssSelector("input[type='email']");
    public static By email_tb_empty = By.cssSelector("div[class$='-input-email auth0-lock-error']");
    public static By password_tb = By.cssSelector("input[type='password']");
    public static By password_tb_empty = By.cssSelector("div[class$='-input-password auth0-lock-error']");
    public static By invalid_credential_msg = By.cssSelector("span[class='animated fadeInUp']");
    public static By login_btn = By.cssSelector("button[type='submit']");
    public static By recover_passwrd_link = By.cssSelector("a[class='auth0-lock-alternative-link']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        waitUntilElementVisible(login_btn);
    }

    /*
       login to account with email and password.
    */
    public BasePage loginToAccount(String email, String password) {
        enterText(email_tb, email);
        enterText(password_tb, password);
        click(login_btn);
        if (email.equals("")) {
            System.out.println("Email field has empty value.");
            Assert.assertTrue(driver.findElement(email_tb_empty).isEnabled());
            return new LoginPage(super.driver, super.wait);
        } else if (password.equals("")) {
            System.out.println("Password field has empty value.");
            Assert.assertTrue(driver.findElement(password_tb_empty).isEnabled());
            return new LoginPage(super.driver, super.wait);
        } else {
            if (isElementPresent(invalid_credential_msg)) {
                System.out.println("Login form has invalid Credential.");
                Assert.assertTrue(driver.findElement(invalid_credential_msg).isDisplayed());
                return new LoginPage(super.driver, super.wait);
            } else {
                System.out.println("Login form has valid credential.");
                return new MainPage(super.driver, super.wait);
            }
        }
    }

    /*
        click on password recovery link.
    */
    public PwdRecoveryPage clickRecoverPassword(){
        click(recover_passwrd_link);
        return new PwdRecoveryPage(super.driver,super.wait);
    }
}
