package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenShooter {

    private final WebDriver driver;

    public ScreenShooter(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] takeScreenshot() {
        // Capture screenshot and return it as a byte array
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
