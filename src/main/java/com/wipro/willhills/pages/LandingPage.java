package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public WaitUtils waitUtils;

    public LandingPage() {
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how= How.ID, using = "login-button")
    public WebElement loginButton;

    @FindBy(how= How.XPATH, using = "//span[text()='Login']")
    public WebElement closeLoginButton;

    @FindBy(how= How.ID, using = "join-button")
    public WebElement joinButton;

    @FindBy(how = How.XPATH, using= "//a[text()='Betting']")
    public WebElement bettingLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Casino']")
    public WebElement casinoLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Vegas']")
    public WebElement vegasLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Live Casino']")
    public WebElement liveCasinoLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Games']")
    public WebElement gamesLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Bingo']")
    public WebElement bingoLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Poker']")
    public WebElement pokerLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Promotions']")
    public WebElement promotionsLink;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'myaccount-dropdown')]")
    public WebElement accountDropDown;

    @FindBy(how = How.XPATH, using = "//span[text()='Logout']")
    public WebElement logOut;

    @FindBy(how = How.XPATH, using = "//button[text()='Accept & Close']")
    public WebElement acceptAndCloseButton;




    public JoinFormPage clickJoinButton(){
        this.waitUtils.waitForElementToBeClickable( this.joinButton);
        this.joinButton.click();
        return new JoinFormPage();
    }
    public BettingPage clickOnBettingLink() {
        this.waitUtils.waitForElementToBeClickable( this.bettingLink);
        this.bettingLink.click();
        return new BettingPage();

    }
}
