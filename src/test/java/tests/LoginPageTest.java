package tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PwdRecoveryPage;

public class LoginPageTest
        extends TestBase
{
    private LoginPage _loginPage;

    @BeforeMethod
    void setUp(){
        _driver.get("<-PLEASE ENTER REQUIRED WEBSITE LINK->");
    }

    @Test
    void verifyLoginSuccessFully(){
        System.out.println("Verify a user is able to login successfully.");
        _loginPage = new LoginPage(_driver, _wait);
        System.out.println("Logging into account with valid credentials.");
        MainPage _mainPage = (MainPage)_loginPage.loginToAccount("QWERT@gmail.com", "Password@12");
        Assert.assertTrue(_mainPage.checkUpcomingProductSectionPresent());
        System.out.println("Log out from Account.");
        _mainPage.logOut();
    }

    @Test
    void verifyEmptyEmail_InLoginFormError(){
        System.out.println("Verify a user is able to see red box on submitting empty value email login form.");
        _loginPage = new LoginPage(_driver, _wait);
        _loginPage.loginToAccount("", "QWERTY");
    }

    @Test
    void verifyEmptyPassword_InLoginFormError(){
        System.out.println("Verify a user is able to see red box on submitting empty value password login form.");
        _loginPage = new LoginPage(_driver, _wait);
        _loginPage.loginToAccount("QWERTY@gmail.com", "");
    }

    @Test
    void verifyWrongCredentialsError(){
        System.out.println("Verify a user is able to see error message on wrong credentials.");
        _loginPage = new LoginPage(_driver, _wait);
        System.out.println("Logging into account with invalid credentials.");
        _loginPage.loginToAccount("QWERT@gmail.com", "Password@");
    }

    @Test
    void verifyNavigateForgotPwdLink(){
        System.out.println("Verify a user is able to navigate on recover password page.");
        _loginPage = new LoginPage(_driver, _wait);
        System.out.println("Navigating to recover password page.");
        PwdRecoveryPage _recoverPage = _loginPage.clickRecoverPassword();
        _recoverPage.submitPwdRecoveryForm("QWERT@gmail.com");
    }
}
