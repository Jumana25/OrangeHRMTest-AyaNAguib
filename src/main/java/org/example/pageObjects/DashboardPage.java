package org.example.pageObjects;

import io.cucumber.java.bs.A;
import org.example.utils.JsUtil;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class DashboardPage {

    SeleniumActions seleniumActions = new SeleniumActions();
    JsUtil jsUtil = new JsUtil();

    private final String TAB = "//*[contains(@class, 'main-menu-item') and text()='@Txt']";
    private final By EXISTINGUSERSNUMBER_TXT = By.xpath("//span[contains(normalize-space(.), 'Records Found')]");
    private final By ADD_BTN = By.xpath("//button[normalize-space()='Add']");

    public void openTab(String tabName){
        seleniumActions.clickOnElement(By.xpath(TAB.replace("@Txt", tabName)));
        jsUtil.waitForDocumentReady(seleniumActions.getTimeout(30));
    }

    public String getNumberOfExistingUsers(){
        return seleniumActions.getPatternFromElementText(EXISTINGUSERSNUMBER_TXT, "\\d+", 15);
    }

    public void clickAddButton(){
        seleniumActions.clickOnElement(ADD_BTN, 20);
    }


}
