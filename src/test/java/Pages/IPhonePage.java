package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPhonePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public IPhonePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }


}
