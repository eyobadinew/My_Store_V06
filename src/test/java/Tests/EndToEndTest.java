package Tests;

import Base.BaseTest;
import Pages.*;
import Utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class EndToEndTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    WatchPage watchPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    @Test
    public void doEndToEndTest() {
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.hitProductLink("iPhone");
        watchPage = new WatchPage(driver, wait);
        String product ="IPhone XR";
        watchPage.addProductToCart(product);
        watchPage.hitViewCartLink();
        assertEquals(Constants.CART_PAGE_TITLE, "Cart; e-commerce");
        cartPage = new CartPage(driver, wait);
        assertTrue(cartPage.productNameIsDisplayed(product));
        cartPage.hitProceedToCheckoutLink();
        checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.enterFirstName("King");
        checkoutPage.enterLastName("Ethiopia");
        checkoutPage.enterStreetAddress("8976 Webster Street");
        checkoutPage.enterZipcode("94117");
        checkoutPage.enterEmail("terstersofthetesters@test.com");
        checkoutPage.hitPlaceOrderButton();
        assertEquals(checkoutPage.orderSuccessfullyReceivedMessage(), "Order received");
    }
}