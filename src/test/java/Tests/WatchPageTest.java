package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.WatchPage;
import Utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WatchPageTest extends BaseTest {
HomePage homePage;
LoginPage loginPage;
WatchPage watchPage;
    @Test
    public void doWatchAddToCartTest(){
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.hitProductLink("Watch");
        watchPage = new WatchPage(driver,wait);
        watchPage.addProductToCart("Apple Watch Series 6");

    }



}
