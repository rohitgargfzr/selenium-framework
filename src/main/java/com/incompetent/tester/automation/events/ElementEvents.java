package com.incompetent.tester.automation.events;

import com.incompetent.tester.automation.events.Identifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class ElementEvents {

    /**
     * Function returns By object based upon identifiers;
     * @param elementLocator
     * @param identifier
     * @return
     */
    public static By getBy(Identifier identifier, String elementLocator) {
        switch (identifier) {
            case XPATH:
                return By.xpath(elementLocator);
            case ID:
                return By.id(elementLocator);
            case CSS:
                return By.cssSelector(elementLocator);
            case LINK_TEST:
                return By.linkText(elementLocator);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(elementLocator);
            default:
                throw new RuntimeException("Please choose a valid identifier");
        }
    }

    /**
     * Function is used to wait for an element, return a WebElement once it is returned.
     * @param driver
     * @param by
     * @return
     */
    public static WebElement fluentWait(WebDriver driver, By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(WaitTime.MAX_SECONDS.getWaitTime()))
                .pollingEvery(Duration.ofSeconds(WaitTime.POLLING_IN_EVERY.getWaitTime()))
                .ignoring(Exception.class);

        Function<WebDriver, WebElement> element = webDriver -> {
            return webDriver.findElement(by);
        };

        return (WebElement) wait.until(element);
    }


    /**
     * Function is used to identify if an element is clickable.
     * @param driver
     * @param by
     * @return boolean
     */
    public static boolean isElementClickable(WebDriver driver, By by){
        WebElement element = fluentWait(driver, by);
        return element.isDisplayed() && element.isEnabled();
    }


    /**
     * Function is used to identify if an element is selected
     * @param driver
     * @param by
     * @return boolean
     */
    public static boolean isElementSelected(WebDriver driver, By by){
        return fluentWait(driver, by).isSelected();
    }

    /**
     * Function is used to validate if an element is displayed
     * @param driver
     * @param by
     * @return boolean
     */
    public static boolean isElementDisplayed(WebDriver driver, By by){
        return fluentWait(driver, by).isDisplayed();
    }


    /**
     * This function is used to click on an element based upon identifiers.
     * @param driver
     * @param identifier
     * @param locatorString
     */
    public static void click(WebDriver driver, Identifier identifier, String locatorString){
        fluentWait(driver, getBy(identifier, locatorString)).click();
    }


    /**
     * This function is used to set element.
     * @param driver
     * @param identifier
     * @param locatorString
     * @param textToSet
     */
    public static void sendKeys(WebDriver driver, Identifier identifier, String locatorString, String textToSet){
        fluentWait(driver, getBy(identifier, locatorString)).sendKeys(textToSet);
    }
}
