package com.wipro.willhills.browserUtils;


import com.wipro.willhills.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private WebDriverWait wait;
    public WaitUtils(){
        this.wait = new WebDriverWait(DriverManager.getDriver(), 15);
    }

    public void waitForElementToBeClickable(WebElement element){
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

}
