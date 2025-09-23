package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public WatchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@title='View cart']")
    private WebElement viewCartLink;

    public void addProductToCart(String product) {
        String xpath = "//h2[normalize-space()='" + product + "']/../..//a[2]";
        WebElement productLink = driver.findElement(By.xpath(xpath));
        productLink.click();

    }

   public void hitViewCartLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(viewCartLink));
        elementUtil.doClick(viewCartLink);
   }




}
