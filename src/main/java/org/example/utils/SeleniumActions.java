package org.example.utils;

import org.example.BaseWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions extends BaseWebDriver {

    private final int default_timeout_second = 45;
    private final WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ZERO);

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].style.border='3px solid red';", element);

        // Optionally add a delay to visualize the highlight
        try {
            Thread.sleep(100); // Highlight for 500ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Restore original style
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    private int getTimeout(int... timeoutInSecoonds){
        return (timeoutInSecoonds.length > 0) ? timeoutInSecoonds[0] : default_timeout_second;
    }

    public WebElement waitForElementToBePresent(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement waitForElementToBeDisplayed(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(By element, int... timeoutInSeconds) {
        waitForElementToBePresent(element, timeoutInSeconds);
        waitForElementToBeDisplayed(element, timeoutInSeconds);
        waitForElementToBeClickable(element, timeoutInSeconds).click();
    }

    public void writeInELement(By element, String text, int... timeoutInSeconds){
        waitForElementToBeClickable(element, timeoutInSeconds).sendKeys(text);
    }

}
