package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DealOrNoDealPage {

    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;

    public DealOrNoDealPage() {

        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Accept & Close']")
    public WebElement acceptAndCloseButton;

    @FindBy(how = How.XPATH, using = "//div[@class='sound-loader play-icon']")
    public WebElement playButton;

}
