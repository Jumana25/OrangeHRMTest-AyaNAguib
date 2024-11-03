package org.example;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.utils.ScreenShooter;

public class CucumberHooks {

    ScreenShooter screenShooter = new ScreenShooter(TestBase.getDriver());

    @Before("@UI")
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before UI Scenario: " + scenario.getName());
        TestBase.initializeDriver();
    }

    @After("@UI")
    public void afterScenario(Scenario scenario) {
        System.out.println("After UI Scenario: " + scenario.getName());
        if (TestBase.getDriver() != null) {
            TestBase.quitDriver();
        }
    }

    @AfterStep("@UI")
    public void afterStep(Scenario scenario) {
        byte[] screenshot = screenShooter.takeScreenshot();
        if (screenshot != null) {
            scenario.attach(screenshot, "image/png", scenario.getName() + " Screenshot");
        }
    }
}
