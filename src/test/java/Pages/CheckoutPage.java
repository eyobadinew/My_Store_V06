package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {


    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        elementUtil = new ElementUtil(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='billing_first_name']")
    private WebElement firstNameField;
    @FindBy(xpath="//input[@id='billing_last_name']")
    private WebElement lastNameField;
    @FindBy(xpath="//input[@id='billing_address_1']")
    private WebElement streetAddressField;
    @FindBy(xpath="//input[@id='billing_postcode']")
    private WebElement zipCodeField;
    @FindBy(xpath="//input[@id='billing_email']")
    private WebElement emailField;
    @FindBy(xpath="//button[@id='place_order']")
    private WebElement placeOrderButton;
   @FindBy(xpath ="//h1[normalize-space()='Order received']")
   private WebElement orderReceivedMessage;

    public void enterFirstName(String fName){
        firstNameField.clear();
       // elementUtil.doSendKeys(firstNameField,fName);
        elementUtil.javaScriptExecutorDoSendKeys(firstNameField,fName);
    }

    public void enterLastName(String lName){
        lastNameField.clear();
        elementUtil.doSendKeys(lastNameField,lName);
    }
    public void enterStreetAddress(String address){
        streetAddressField.clear();
        elementUtil.doSendKeys(streetAddressField,address);
    }
    public void enterZipcode(String zip){
        zipCodeField.clear();
        elementUtil.doSendKeys(zipCodeField,zip);
    }
    public void enterEmail(String email){
        emailField.clear();
        elementUtil.doSendKeys(emailField,email);
    }
    public void hitPlaceOrderButton(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        elementUtil.javaScriptExecutorDoClick(placeOrderButton);
    }
    public String orderSuccessfullyReceivedMessage(){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(orderReceivedMessage)));
        return elementUtil.doGetText(orderReceivedMessage);
    }

}
