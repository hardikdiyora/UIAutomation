package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public WebDriver _driver;
    public WebDriverWait _wait;

    @BeforeClass
    public void openBrowser () {

        //Create the driver object using ChromeDriver, All the TestClasses & PageClasses have to use this driver object.
        System.out.println("Opening the Chrome Browser...");
        _driver = new ChromeDriver();

        //Create a wait. All the TestClasses & PageClasses have to use this wait object.
        _wait = new WebDriverWait(_driver,15);

        //Maximize Browser Window
        _driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("Opening the Chrome Browser...");
        _driver.quit();
    }
}