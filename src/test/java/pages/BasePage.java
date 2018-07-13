package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public static By open_menu = By.cssSelector("i[class='fa fa-angle-down']");
    public static By log_out = By.cssSelector("i[class='fa fa-sign-out']");

    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    /*
        wait until element to be visible.
    */
    public void waitUntilElementVisible(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    /*
       click on the element.
    */
    public void click(By element) {
        driver.findElement(element).click();
    }

    /*
       Enter the text into text box.
    */
    public void enterText(By element, String text) {
        waitUntilElementVisible(element);
        driver.findElement(element).sendKeys(text);
    }

    /*
        logout from the account
    */
    public LoginPage logOut(){
        click(open_menu);
        click(log_out);
        return new LoginPage(driver, wait);
    }

    /*
        check whether element is present or not.
    */
    public boolean isElementPresent(By by) {
        try {
            waitUntilElementVisible(by);
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
