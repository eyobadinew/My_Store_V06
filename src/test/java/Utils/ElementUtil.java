package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public By getLocator(String value) {
        return By.id(value);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }


    public void doSendKeysWithLocator(By locator, String value) {
      getElement(locator).sendKeys(value);
   }

    public void doSendKeys(WebElement element, String value) {
             element.sendKeys(value);
          }

     public void doClick(WebElement element){
         element.click();
     }

    public String doGetText(WebElement element) {
        return element.getText();

    }
    public boolean doIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    public boolean doIsSelected(WebElement element) {
        return element.isSelected();
    }
    public boolean doIsEnabled(WebElement element) {
        return element.isEnabled();
    }


    public void doClickByLinkText(String linkTextName){
         driver.findElement(By.linkText(linkTextName)).click();

     }


     // *** Java Script Executor utils

   public void javaScriptExecutorDoSendKeys(WebElement element, String text){
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value= '" + text + "';", element);
    }


    public void javaScriptExecutorDoClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);}










    // ***************************Drop Down Utils
    // ***********************************

    public void doSelectDropDownByVisibleText(WebElement element,String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void doSelectDropDownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void doSelectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);

    }

    public void selectDropDownValueWithoutSelectClass(By locator, String value) {
        List<WebElement> optionsList = getElements(locator);

        for (WebElement e : optionsList) {

            String text = e.getText();

            if (text.equals(value)) {
                e.click();
                break;
            }

        }
    }





    public void doActionsSendKeys(WebElement element, String value) {
        Actions action = new Actions(driver);
        action.sendKeys(element, value).perform();
    }

    public void doActionsClick(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void doSendKeysWithMoveToElement(WebElement element, String value) {
        Actions action = new Actions(driver);
        action.moveToElement(element).sendKeys(value).build().perform();
    }

    public void doClickWithMoveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }




    public int getElementsCount(String tagName) {
        return driver.findElements(By.tagName(tagName)).size();
    }



 /*   public List<String> getAttributesList(String tagName, String attributeName) {

        List<String> attrList = new ArrayList<String>();

        List<WebElement> elementList = driver.findElements(By.tagName(tagName));
        for (WebElement e : elementList) {
            String text = e.getAttribute(attributeName);
            attrList.add(text);
        }

        return attrList;
    }

    public void doClickFromList(By locator, String linkText) {
        List<WebElement> footerList = getElements(locator);

        for (int i = 0; i < footerList.size(); i++) {
            String text = footerList.get(i).getText();
            if (text.equals(linkText)) {
                footerList.get(i).click();
                break;
            }
        }
    }



    // ***************************** wait utils ************************

    public List<WebElement> visibilityOfAllElements(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void getPageLinksText(By locator, int timeOut) {
        visibilityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
    }

    public int getPageLinksCount(By locator, int timeOut) {
        return visibilityOfAllElements(locator, timeOut).size();
    }

    public String waitForTitlePresent(String titleValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.titleIs(titleValue));
        return driver.getTitle();
    }

    public String waitForTitlePresent(String titleValue, int timeOut, int intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
        wait.until(ExpectedConditions.titleIs(titleValue));
        return driver.getTitle();
    }

    public Alert waitForAlertToBePresent(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean waitForUrl(String urlValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.urlContains(urlValue));
    }

    public WebElement waitForElementToBeLocated(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }

    public void clickWhenReady(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    *//**
     * This is custom dynamic wait to find the webelement
     *
     * @param locator
     * @return
     *//*
    public WebElement retryingElement(By locator) {

        WebElement element = null;
        int attempts = 0;

        while (attempts < 30) {

            try {
                element = driver.findElement(locator);
                break;
            }

            catch (StaleElementReferenceException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {

                }
            }

            catch (NoSuchElementException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {

                }

                System.out.println("element is not found in attempt : " + (attempts + 1));
            }

            attempts++;
        }

        return element;

    }*/
}
