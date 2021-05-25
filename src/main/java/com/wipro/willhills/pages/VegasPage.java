package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VegasPage {
    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;

    public VegasPage() {
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Accept & Close']")
    public WebElement acceptAndCloseButton;

    @FindBy(how = How.XPATH, using = "//a[text()='View All']")
    public WebElement viewAllButton;

    @FindBy(how = How.XPATH, using = "//div[@class='tiles-shift-group']//img")
    public List<WebElement> allGamesImages;
     //div[contains(@class,'fixed-tiles-row--desktop')]//img

    @FindBy(how = How.XPATH, using = "//button[@id='spinButton']/div")
    public WebElement playButtonForRainBowRiches;

    @FindBy(how = How.XPATH, using = "//span[text()='NO']")
    public WebElement noSoundForRainBowRiches;
    //span[text()='NO']



}
