package com.wipro.willhills.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ElementActions {

    protected WebDriver driver;
    protected Actions act;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        act = new Actions(this.driver);
        wait = new WebDriverWait(this.driver, 20);
        js = (JavascriptExecutor) this.driver;
    }

    public ElementActions() {

    }

    protected void clickOn(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void enterText(By by, String txt) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by).sendKeys(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void actionsEnterText(By by, String txt) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            act.moveToElement(driver.findElement(by)).click().sendKeys(txt).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void waitInSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected void waitForElement(WebDriver driver,By by,int seconds) {
        WebDriverWait waitElement = new WebDriverWait(driver,seconds);
        waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    protected String getAttributeValue(By by, String attributeName){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by).getAttribute(attributeName);
    }

    protected boolean verifyElement(By by){
        System.out.println("--->"+wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by).size()>0;
    }
    protected List<String> getMultipleText(By by){
        List<String> list = new ArrayList<>();
        List<WebElement> ele = driver.findElements(by);
        for(int i=0;i<ele.size();i++){

            list.add(ele.get(i).getText());
        }
        return list;
    }
    protected void switchToNewPage(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for(String s: windowHandles){
            if(!s.equals(currentWindow)){
                driver.switchTo().window(s);
            }
        }
    }

}
