package Pages;

import Base.BasePage;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationPage  extends BasePage {
     private WebDriver driver;
     private WebDriverWait wait;
    private ElementUtil elementUtil;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@id='reg_username']")
    private WebElement registrationUserNameField;
    @FindBy(xpath="//input[@id='reg_email']")
    private WebElement registrationEmailField;
    @FindBy(xpath="//input[@id='reg_password']")
    private WebElement registrationPasswordField;
    @FindBy(xpath="//button[normalize-space()='Register']")
    private WebElement registrationRegisterButton;
    @FindBy(xpath="//h2[text()='. Nice to see you.']")
    private WebElement registrationSuccessMessage;
    @FindBy(xpath="//div[@id='content']//li[1]")
    private WebElement registrationError;
    @FindBy(xpath ="//a[normalize-space()='privacy policy']")
    private WebElement privacyPolicyLink;



    public void enterRegistrationUserName(){
        elementUtil.doSendKeys(registrationUserNameField,randomString().toUpperCase());
    }

    public void enterRegistrationEmail(){
        elementUtil.doSendKeys(registrationEmailField,randomAlphaNumeric()+"@gmail.com");
    }

  public void enterRegistrationPassword(){
        elementUtil.doSendKeys(registrationPasswordField,randomAlphaNumeric());
  }
   public void hitRegistrationButton(){
      elementUtil.doClick(registrationRegisterButton);
   }

   public String registrationSuccessMessage(){
       wait.until(ExpectedConditions.visibilityOfAllElements(registrationSuccessMessage));
       return elementUtil.doGetText(registrationSuccessMessage);
   }

    public String registrationErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfAllElements(registrationError));
        return elementUtil.doGetText(registrationError);
    }

    public void hitPrivacyPolicyLink(){
        elementUtil.doClick(privacyPolicyLink);
    }












}
