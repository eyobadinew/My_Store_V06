package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[normalize-space()='Dashboard']")
    private WebElement dashBoardLink;
    @FindBy(xpath ="//a[normalize-space()='Account details']")
    private WebElement accountDetailsLink;
    @FindBy(xpath ="//h1[normalize-space()='Account details']")
    private WebElement accountDetailsPageHeader;

    public boolean dashboardIsDisplayed(){
      return  elementUtil.doIsDisplayed(dashBoardLink);

    }
  public void hitAccountDetailsLink(){
        elementUtil.doClick(accountDetailsLink);
  }

  public String getAccountsPageHeader(){
       return elementUtil.doGetText(accountDetailsPageHeader);
  }

}
