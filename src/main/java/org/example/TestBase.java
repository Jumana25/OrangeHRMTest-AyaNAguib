package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.ScreenShooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    protected static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Open browser in maximized mode
            options.addArguments("--disable-notifications"); // Disable notifications
            options.addArguments("--disable-extensions"); // Disable extensions for stability
            options.addArguments("--incognito"); // Run in incognito mode
            options.addArguments("--remote-allow-origins=*"); // Avoid CORS issues
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

