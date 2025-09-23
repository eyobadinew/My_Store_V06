package Tests;

import Base.BaseTest;
import Pages.AddProductPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.Constants;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddProductPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AddProductPage addProductPage;

    @Test
    public void addProductTest(){
        homePage = new HomePage(driver, wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.hitAddProductButton();
        assertEquals(Constants.ADD_PRODUCT_PAGE_TITLE, "Add product; e-commerce");
        addProductPage = new AddProductPage(driver, wait);
        addProductPage.enterProductTitle(basePage.randomAlphaNumeric());
        addProductPage.enterProductDescription("My New Product");
        addProductPage.setPrice("$760");
        addProductPage.selectCategory("iPhone");
        addProductPage.hitAddButton();
        assertTrue(addProductPage.productSuccessfullyAddedMessage().contains("successfully added"));
    }
}
