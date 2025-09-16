package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Test(priority = 1)
    public void homePageValidation() {
        homePage = new HomePage(driver, wait);
        assertEquals(Constants.HOME_PAGE_TITLE, "e-commerce; Automation Practice Website");

    }

    @Test(priority = 2)
    public void navigateToLoginAndRegistrationPageTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        assertEquals(Constants.LOGIN_PAGE_TITLE, "My account; e-commerce");

    }

    @Test(priority = 3)
    public void navigateToMacPageTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitProductLink("Mac");
        assertEquals(Constants.MAC_PAGE_TITLE, "Mac; e-commerce");

    }

    @Test(priority = 4)
    public void navigateToIPhonePageTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitProductLink("iPhone");
        assertEquals(Constants.IPHONE_PAGE_TITLE, "iPhone; e-commerce");

    }

    @Test(priority = 5)
    public void navigateToWatchPageTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitProductLink("Watch");
        assertEquals(Constants.WATCH_PAGE_TITLE, "Watch; e-commerce");

    }

    @Test(priority = 6)
    public void navigateToAccessoriesPageTest() {

        homePage = new HomePage(driver, wait);
        homePage.hitProductLink("Accessories");
        assertEquals(Constants.ACCESSORIES_PAGE_TITLE, "Accessories; e-commerce");

    }


}
