package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TennisInPlayPage extends AllSportsInPlayPage {
    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;
    public BettingPage bettingPage;
   // public AllSportsInPlayPage allSportsInPlayPage;

    public TennisInPlayPage( ) {
        this.driver = driver;
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.bettingPage = new BettingPage();
        // this.allSportsInPlayPage = new AllSportsInPlayPage(this.driver);
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    String first_active_match_xpath= "(//div[@id='tennis']//div[@class='event'][.//div[contains(@class,'btmarket__actions') and not(contains(@class,'disabled-market'))]])[1]";
    By firstSportName_xpath = By.xpath(first_active_match_xpath+"//a[contains(@class,'btmarket__name--featured')]");
    By hometeam_xpath = By.xpath(first_active_match_xpath+"//div[contains(@class,'btmarket__actions')]/div[1]");
    By awayteam_xpath = By.xpath(first_active_match_xpath+"//div[contains(@class,'btmarket__actions')]/div[2]");
    By noOfTennisGamesInPlay_xpath  = By.xpath("//i[contains(@class,'tennis')]//ancestor::a[1]/span");
    By tennisGameInPlayPage_xpath = By.xpath("//section[@id='in-play-content']//h2[text()='tennis']");




    public boolean isSpecificGameInPlayPageLoaded() {
        return verifyElement(tennisGameInPlayPage_xpath);
    }
    public int noOfSpecificGamesInPlay() {
        String number = getText(noOfTennisGamesInPlay_xpath);
        int noOfTennisGamesPlaying = Integer.parseInt(number);
        return noOfTennisGamesPlaying;
    }
   /* public String findFirstActiveSport() {
        return getAttributeValue(firstSportName_xpath, "title");
    }
    public void betOnHomeTeam(String amount) throws InterruptedException {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on home team");
        //  Reporter.addStepLog("Placing a bet on home team");
        waitForElement(driver, hometeam_xpath, 10);
        clickOn(hometeam_xpath);
        enterText(betInput_xpath, amount);
        waitInSeconds(3);
        closeallchangesinprice();
        waitInSeconds(3);
        getDetailsAfterPlacingBet();
        placeBet();
    }
    public void betOnAwayTeam(String amount) throws InterruptedException {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on away team");
        //   Reporter.addStepLog("Placing a bet on away team");
        waitForElement(driver, awayteam_xpath, 10);
        clickOn(awayteam_xpath);
        enterText(betInput_xpath, amount);
        waitInSeconds(3);
        closeallchangesinprice();
        waitInSeconds(3);
        getDetailsAfterPlacingBet();
        placeBet();
    }*/
    public void betforDraw(String amount) {
        Assert.fail("Tennis don't have draw");
    }

    public void closeallchangesinprice(){
        By pricedown_xpath = By.xpath("//div[contains(@class,'price-down') or contains(@class,'price-up')]//a[@title='Remove Selection']/i");
        clickOn(pricedown_xpath);

    }


}
