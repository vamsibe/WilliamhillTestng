package com.wipro.willhills.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.utils.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginFormPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    public LoginFormPage() {
        this.driver = DriverManager.getDriver();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "input[name='username']")
    public WebElement userName;

    @FindBy(how = How.CSS, using = "input[name='password']")
    public WebElement password;

    @FindBy(how = How.CSS, using = "button[name='login-submit-button']")
    public WebElement loginSubmitButton;

    public void login(String userName, String password){
        this.waitUtils.waitForElementToBeVisible(this.userName);
        this.userName.sendKeys(userName);
        this.waitUtils.waitForElementToBeVisible(this.password);
        this.password.sendKeys(password);
        this.waitUtils.waitForElementToBeClickable(this.loginSubmitButton);
        this.loginSubmitButton.click();
    }
    public void loginFormUsingExcel(Hashtable<String, String> testData){
        this.waitUtils.waitForElementToBeVisible(this.userName);
        this.userName.sendKeys(testData.get("UserName"));
        this.waitUtils.waitForElementToBeVisible(this.password);
        this.password.sendKeys(testData.get("Password"));
        this.waitUtils.waitForElementToBeClickable(this.loginSubmitButton);
        this.loginSubmitButton.click();
    }

   }
