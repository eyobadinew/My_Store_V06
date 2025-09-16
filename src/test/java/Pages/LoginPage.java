package Pages;

import Utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ElementUtil elementUtil;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = " //button[normalize-space()='Log in']")
    private WebElement loginButton;
    @FindBy(how = How.CSS, using = "li[id='menu-item-77'] a")
    WebElement myAccountLink;

    @FindBy(xpath = "//h1[normalize-space()='My account']")
    private WebElement loginPageHeader;
    @FindBy(xpath = "//h2[1]")
    private WebElement loginMessage;


    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutButton;
    @FindBy(id = "reg_username")
    private WebElement registrationUserName;
    @FindBy(id = "reg_email")
    private WebElement registrationEmail;
    @FindBy(id = "reg_password")
    private WebElement registrationPassword;
    @FindBy(xpath = "//button[normalize-space()='Register']")
    private WebElement registrationButton;
    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    private WebElement lostPassword;

    @FindBy(id = "user_login")
    private WebElement lostPasswordUserName;

    @FindBy(xpath = "//button[normalize-space()='Reset password']")
    private WebElement resetPassword;
    @FindBy(xpath = "//a[normalize-space()='privacy policy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement loginError;

    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    private WebElement lostYourPasswordLink;

    @FindBy(xpath = "//button[normalize-space()='Reset password']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement passwordResetAlertMessage;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement forgotPasswordEmailField;


    public void doLogin(String un, String pw) {

        elementUtil.doSendKeys(userName, un);
        elementUtil.doSendKeys(password, pw);
        elementUtil.doClick(loginButton);

    }

    public void enterUserName(String un) {
        elementUtil.doSendKeys(userName, un);
    }

    public void enterPassword(String pw) {
        elementUtil.doSendKeys(password, pw);
    }


    public String loginSuccessMessage() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(loginMessage)));
        ;
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(loginPageHeader)));
        ;
        return elementUtil.doGetText(loginMessage);

    }

    public String loginWithWrongUserNameAndPasswordErrorMessage() {
        return elementUtil.doGetText(loginError);
    }

    public String loginWithWrongPasswordErrorMessage() {
        return elementUtil.doGetText(loginError);
    }

    public String loginWithOutUserNameErrorMessage() {
        return elementUtil.doGetText(loginError);
    }

    public String loginWithOutPasswordErrorMessage() {
        return elementUtil.doGetText(loginError);
    }

    public void hitLostYourPasswordLink() {
        elementUtil.doClick(lostYourPasswordLink);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordEmailField));
    }

    public void hitResetPasswordButton() {
        elementUtil.doClick(resetPasswordButton);
    }

    public String passwordResetAlertMessage() {
        return elementUtil.doGetText(passwordResetAlertMessage);
    }

    public void enterForgotPasswordEmail(String un) {
        elementUtil.doSendKeys(forgotPasswordEmailField, un);
    }
}
