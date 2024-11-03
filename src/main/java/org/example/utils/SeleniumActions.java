package org.example.utils;

import org.example.BaseWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SeleniumActions extends BaseWebDriver {

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



}
