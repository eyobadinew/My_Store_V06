package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public AddProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='wcj_add_new_product_title']")
    private WebElement productTitle;

    @FindBy(xpath="//textarea[@id='wcj_add_new_product_desc']")
    private WebElement descriptionField;

    @FindBy(xpath="//input[@id='wcj_add_new_product_regular_price']")
    private WebElement regularPriceField;

    @FindBy(xpath="//select[@id='wcj_add_new_product_cats']")
    private WebElement selectCategories;

    @FindBy(xpath="//input[@name='wcj_add_new_product']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement productAddSuccessMessage;



   public void enterProductTitle(String title){
       elementUtil.doSendKeys(productTitle,title);
   }

    public void enterProductDescription(String description){
        elementUtil.doSendKeys(descriptionField,description);
    }
    public void setPrice(String price){
        elementUtil.doSendKeys(regularPriceField,price);
    }

    public void selectCategory(String category){
       elementUtil.doSelectDropDownByVisibleText(selectCategories,category);
    }

  public void hitAddButton(){
       elementUtil.doClick(addButton);
  }

   public String productSuccessfullyAddedMessage(){
      return elementUtil.doGetText(productAddSuccessMessage);
   }


}
