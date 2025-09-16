package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
private WebDriver driver;
private WebDriverWait wait;
private ElementUtil elementUtil;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
        elementUtil = new ElementUtil(driver);
    }


     @FindBy(how = How.CSS, using ="li[id='menu-item-77'] a")
     private WebElement myAccountLink;

    @FindBy(xpath="//ul[@id='menu-main']//a")
    private List<WebElement> productCategories;

  /*  @FindBy(xpath="//div[@class='col-full']//div[1]//form[1]//select[1]")
    private WebElement sortingDropDowns;
*/
    public void hitMyAccountLink(){
        elementUtil.doClick(myAccountLink);
    }

    public void hitProductLink(String product){
        elementUtil.doClickByLinkText(product);
    }











}
