package Tests;

import Base.BaseTest;
import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(DashboardPageTest.class);
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

   @Test(priority=1)
    public void validateDashboardPage(){
        homePage = new HomePage(driver,wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage = new DashboardPage(driver,wait);
        assertTrue(dashboardPage.dashboardIsDisplayed());
       assertTrue(loginPage.loginSuccessMessage().contains("Nice to see you."));
       loginPage.doLogout();
    }

    @Test(priority =2)
    public void navigateToAccountDetailsPage(){
        homePage = new HomePage(driver,wait);
        homePage.hitMyAccountLink();
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        dashboardPage = new DashboardPage(driver,wait);
        dashboardPage.hitAccountDetailsLink();
        assertEquals(dashboardPage.getAccountsPageHeader(),"Account details");
    }
}
