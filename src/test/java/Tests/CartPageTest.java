package Tests;

import Base.BaseTest;
import Pages.*;
import Utils.Constants;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    WatchPage watchPage;
    CartPage cartPage;
    @Test(priority=1)
    public void validateCartPage(){
        homePage = new HomePage(driver,wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.hitProductLink("Watch");
        watchPage = new WatchPage(driver,wait);
        watchPage.addProductToCart("Apple Watch Series 6");
        watchPage.hitViewCartLink();
        assertEquals(Constants.CART_PAGE_TITLE,"Cart; e-commerce");
        homePage.hitMyAccountLink();
        loginPage.doLogout();
    }


    @Test(priority=2)
    public void selectedProductIsDisplayedInCartTest(){
        homePage = new HomePage(driver,wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.hitProductLink("Watch");
        watchPage = new WatchPage(driver,wait);
        String product = "Apple Watch Series 6";
        watchPage.addProductToCart(product);
        watchPage.hitViewCartLink();
        assertEquals(Constants.CART_PAGE_TITLE,"Cart; e-commerce");
        cartPage = new CartPage(driver,wait);
        assertTrue(cartPage.productNameIsDisplayed(product));
    }
}
