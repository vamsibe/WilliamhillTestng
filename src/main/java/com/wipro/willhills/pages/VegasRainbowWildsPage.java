package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VegasRainbowWildsPage {

    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;

    public VegasRainbowWildsPage() {

        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Accept & Close']")
    public WebElement acceptAndCloseButton;

    @FindBy(how = How.XPATH, using = "//button[@id='spinButton']/div")
    public WebElement playButtonForRainBowRiches;

    @FindBy(how = How.XPATH, using = "//span[text()='NO']")
    public WebElement noSound;

    @FindBy(how = How.XPATH, using = "//iframe[@id='game-launcher-iframe']")
    public WebElement gameLauncherIframe;

    @FindBy(how = How.XPATH, using = "//iframe[@id='gameIFrame']")
    public WebElement gamesIframe;

    @FindBy(how = How.XPATH, using = "//iframe[@id='game']")
    public WebElement iframe;

    @FindBy(how = How.XPATH, using = "//div[@id='gameContainer']/canvas")
    public WebElement canvasContinue;

}
