package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    private WebElement productName;

    @FindBy(xpath="//a[normalize-space()='Proceed to checkout']")
    private WebElement proceedToCheckoutLink;


    public boolean productNameIsDisplayed(String product){
       return elementUtil.doGetText(productName).contains(product);
    }

    public void hitProceedToCheckoutLink(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutLink));
        elementUtil.doClick(proceedToCheckoutLink);
    }
}
