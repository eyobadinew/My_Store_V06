package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    HomePage homePage;
    LoginPage loginPage;


    @Test(priority = 6)
    public void LoginTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        assertEquals(Constants.LOGIN_PAGE_TITLE, "My account; e-commerce");
        assertTrue(loginPage.loginSuccessMessage().contains("Nice to see you."));
    }

    // Login with wrong username and password
    @Test(priority = 1)
    public void loginWithWrongUseNameAndPasswordTest() {


        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        String un = "test2test.com";
        loginPage.doLogin(un, "0998765");
        System.out.println(loginPage.loginWithWrongUserNameAndPasswordErrorMessage());
        assertTrue(loginPage.loginWithWrongUserNameAndPasswordErrorMessage().contains("The username " + un + " is not registered on this site"));

    }

    // Login with wrong password

    @Test(priority = 2)
    public void loginWithWrongPasswordTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        String un = "jobjoba";
        loginPage.doLogin(un, "0998765");
        System.out.println(driver.findElement(By.xpath("//div[@id='content']//li[1]")).getText());
        assertTrue(loginPage.loginWithWrongPasswordErrorMessage().contains("Error: The password you entered for the username " + un + " is incorrect"));

    }

    // Login in test for required UserName
    @Test(priority = 3)

    public void loginUserNameRequiredTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin("", "099876511");
        assertTrue(loginPage.loginWithOutUserNameErrorMessage().contains("Error: Username is required."));

    }


    // Login Test for Required Password
    @Test(priority = 4)
    public void loginPasswordRequiredTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin("eyobbizuneh", "");
        assertTrue(loginPage.loginWithOutUserNameErrorMessage().contains("Error: The password field is empty."));

    }


    // Forgot/Lost Password Test   ... Soft Assert Test
    @Test(priority = 5)
    public void forgotPasswordTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.hitLostYourPasswordLink();
        loginPage.enterForgotPasswordEmail("jobjoba");
        loginPage.hitResetPasswordButton();
        assertEquals(loginPage.passwordResetAlertMessage(), "Password reset email has been sent.");

    }


}
