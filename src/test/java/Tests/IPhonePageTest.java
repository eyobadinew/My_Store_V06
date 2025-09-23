package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.WatchPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IPhonePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    WatchPage watchPage;
    CartPage cartPage;
    @Test
    public void doIPhoneAddToCartTest(){
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.hitProductLink("iPhone");
        watchPage = new WatchPage(driver,wait);
        String product = "IPhone XR";
        watchPage.addProductToCart(product);
        watchPage.hitViewCartLink();
        cartPage = new CartPage(driver,wait);
       assertTrue(cartPage.productNameIsDisplayed(product));

    }

}
