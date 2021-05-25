package com.wipro.willhills.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Hashtable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class JoinFormPage {
    private WebDriver driver;
    private WaitUtils waitUtils;

    public JoinFormPage() {
        this.driver = DriverManager.getDriver();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.NAME, using = "cp-registration-frame")
    public WebElement joinFormIframe;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'header-button-close')]")
    public WebElement closeButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Mr']")
    public WebElement mrTitle;

    @FindBy(how = How.XPATH, using = "//span[text()='Mrs']")
    public WebElement mrsTitle;

    @FindBy(how = How.XPATH, using = "//span[text()='Ms']")
    public WebElement msTitle;

    @FindBy(how = How.XPATH, using = "//span[text()='Miss']")
    public WebElement missTitle;

    @FindBy(how = How.ID, using = "reg-firstName")
    public WebElement firstName;

    @FindBy(how = How.ID, using = "reg-lastName")
    public WebElement lastName;

    @FindBy(how = How.ID, using = "reg-dobDay")
    public WebElement day;

    @FindBy(how = How.NAME, using = "dobMonth")
    public WebElement month;

    @FindBy(how = How.NAME, using = "dobYear")
    public WebElement year;

    @FindBy(how = How.ID, using = "reg-email")
    public WebElement email;

    @FindBy(how = How.ID, using = "reg-mobile")
    public WebElement mobile;

    @FindBy(how = How.ID, using = "reg-search")
    public WebElement inputSearchPostcode;

    @FindBy(how = How.LINK_TEXT, using = "Find address")
    public WebElement findAddress;

    @FindBy(how = How.ID, using = "reg-street1")
    public WebElement addressLine1;

    @FindBy(how = How.ID, using = "reg-street2")
    public WebElement addressLine2;

    @FindBy(how = How.ID, using = "reg-city")
    public WebElement townOrCity;

    @FindBy(how = How.ID, using = "reg-submit")
    public WebElement continueButton;

    public WebElement getTitle(String title) {
        switch (title.toLowerCase()) {
            case "mr":
                return this.mrTitle;
            case "mrs":
                return this.mrsTitle;
            case "ms":
                return this.msTitle;
            case "miss":
                return this.missTitle;
        }
        return null;
    }


    public void fillTheJoinForm(Hashtable<String, String> testData) {
        this.waitUtils.waitForElementToBeVisible(this.joinFormIframe);
        this.driver.switchTo().frame(this.joinFormIframe);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        this.waitUtils.waitForElementToBeVisible(this.firstName);
        if(Objects.nonNull(this.getTitle(testData.get("Title")))){
            this.getTitle(testData.get("Title")).click();
        }
        this.firstName.sendKeys(testData.get("First_name"));
        this.lastName.sendKeys(testData.get("Last_name"));
        this.day.sendKeys(testData.get("Dd"));
        this.month.sendKeys(testData.get("Mm"));
        this.year.sendKeys(testData.get("Yy"));
        this.email.sendKeys(testData.get("Email"));
        this.mobile.sendKeys(testData.get("Mobile"));
        this.inputSearchPostcode.sendKeys(testData.get("PostCode"));

    }

}
