package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public static By welcome_section = By.cssSelector("div[class='welcome'");
    public static By upcoming_section = By.cssSelector("div[class='upcoming']");

    public MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        waitUntilElementVisible(welcome_section);
    }

    /*
       check whether upcoming product section is visible.
    */
    public Boolean checkUpcomingProductSectionPresent(){
        waitUntilElementVisible(upcoming_section);
        return isElementPresent(upcoming_section);
    }
}
