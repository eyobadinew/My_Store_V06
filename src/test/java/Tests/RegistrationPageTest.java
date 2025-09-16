package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.RegistrationPage;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class RegistrationPageTest extends BaseTest {
HomePage homePage;
RegistrationPage registrationPage;


    // 1. Registration Positive Test
    @Test (priority=5)
    public void doRegistrationTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        registrationPage = new RegistrationPage(driver, wait);
        registrationPage.enterRegistrationUserName();
        registrationPage.enterRegistrationEmail();
        registrationPage.enterRegistrationPassword();
        registrationPage.hitRegistrationButton();

        assertTrue(registrationPage.registrationSuccessMessage().contains("Nice to see you."));
    }


    // 2. Registration UserName Required Test

    @Test(priority =1)

    public void userNameRequiredTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        registrationPage = new RegistrationPage(driver, wait);
        registrationPage.enterRegistrationEmail();
        registrationPage.enterRegistrationPassword();
        registrationPage.hitRegistrationButton();
        assertEquals(registrationPage.registrationErrorMessage(),"Error: Please enter a valid account username.");
    }

    // Registration Email Required Test
    @Test(priority=2)
    public void emailRequiredTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        registrationPage = new RegistrationPage(driver, wait);
        registrationPage.enterRegistrationUserName();
        registrationPage.enterRegistrationPassword();
        registrationPage.hitRegistrationButton();
        assertEquals(registrationPage.registrationErrorMessage(),"Error: Please provide a valid email address.");
    }


    // Registration Password Required Test
    @Test(priority=3)
    public void passwordRequiredTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        registrationPage = new RegistrationPage(driver, wait);
        registrationPage.enterRegistrationUserName();
        registrationPage.enterRegistrationEmail();
        registrationPage.hitRegistrationButton();
        assertEquals(registrationPage.registrationErrorMessage(), "Error: Please enter an account password.");
    }

    // Privacy Policy validation
    @Test(priority=4)
    public void privacyPolicyPageValidation(){
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        registrationPage = new RegistrationPage(driver, wait);
        registrationPage.hitPrivacyPolicyLink();
        assertEquals(Constants.PRIVACY_POLICY_PAGE_TITLE,"Privacy Policy; e-commerce");
    }
}
