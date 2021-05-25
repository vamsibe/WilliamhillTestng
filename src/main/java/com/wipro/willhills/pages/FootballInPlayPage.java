package com.wipro.willhills.pages;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FootballInPlayPage extends AllSportsInPlayPage {
    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;
    public BettingPage bettingPage;
    public AllSportsInPlayPage allSportsInPlayPage;

    public FootballInPlayPage() {
        this.driver = driver;
       // super(driver);
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.bettingPage = new BettingPage();
        this.allSportsInPlayPage = new AllSportsInPlayPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    @FindBy(how = How.XPATH, using = " (//div[@class='btmarket__selection']/button/span)[1]")
    public WebElement click_on_first_homeTeam;

    @FindBy(how = How.CSS, using = ".bs-bet-stake__value")
    public WebElement bet_on_first_homeTeam;

    String clickOnAllHomeTeamBets = "//div[@id='" + "{sportName}" + "']//div[@class='btmarket__selection'][1]//span[1]";
    String clickOnAllAwayTeamBets = "//div[@id='" + "{sportName}" + "']//div[@class='btmarket__selection'][2]//span[1]";
    String clickOnDrawBets = "//div[@id='" + "{sportName}" + "']//div[@class='btmarket__selection'][3]//span[1]";
    String clickOnASpecificTeam = "//h2[text()='" + "{teamName}" + "']//ancestor::section[@class='bs-quick-bet']//span[@class='bs-bet-stake__value']";
    String placeABetOnTheSelectedTeam = "//button[@data-name='" + "{teamName}" + "']/span[1]";

    @FindBy(how = How.XPATH, using = "//a[@class='btmarket__name btmarket__name--featured']/div[2]")
    public List<WebElement> noOfTeamsInPlayOfAGivenSport;

    String noOfItemsDisplayedOnAInPlaySportHeader= "//a[@data-sport-slug='"+"{sportN}"+"']/span";

    String first_active_match_xpath = "(//div[@id='football']//div[@class='event'][.//div[contains(@class,'btmarket__actions') and not(contains(@class,'disabled-market'))]])[1]";
    By firstSportName_xpath = By.xpath(first_active_match_xpath + "//a[contains(@class,'btmarket__name--featured')]");
    By hometeam_xpath = By.xpath(first_active_match_xpath + "//div[contains(@class,'btmarket__actions')]/div[1]");
    By drawteam_xpath = By.xpath(first_active_match_xpath + "//div[contains(@class,'btmarket__actions')]/div[2]");
    By awayteam_xpath = By.xpath(first_active_match_xpath + "//div[contains(@class,'btmarket__actions')]/div[3]");
    By noOfFootballGamesInPlay_xpath = By.xpath("//i[contains(@class,'football')]//ancestor::a[1]/span");
    By footballInPlayPage_xpath = By.xpath("//section[@id='in-play-content']//h2[text()='football']");

    public int getNoOfItemsDisplayedOnAInPlay(String sportName) {
        WebElement item = driver.findElement(By.xpath(noOfItemsDisplayedOnAInPlaySportHeader.replace("{sportN}",
                sportName.toLowerCase())));
        return Integer.parseInt(item.getText());
    }


    public boolean isSpecificGameInPlayPageLoaded() {
        return verifyElement(footballInPlayPage_xpath);
    }
    public int noOfSpecificGamesInPlay() {
        String number = getText(noOfFootballGamesInPlay_xpath);
        int noOfFootballGamesPlaying = Integer.parseInt(number);
        return noOfFootballGamesPlaying;
    }
    public String findFirstActiveSport() {
        return getAttributeValue(firstSportName_xpath, "title");
    }
    /*public void betOnHomeTeam(String amount) {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on home team");
       // Reporter.addStepLog("Placing a bet on home team");
        waitForElement(driver, hometeam_xpath, 10);
        clickOn(hometeam_xpath);
        enterText(betInput_xpath, amount);
        waitInSeconds(3);
        closeallchangesinprice();
        getDetailsAfterPlacingBet();
        waitInSeconds(4);
        placeBet();
    }*/
 /*   public void betOnAwayTeam(String amount) {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on away team");
      //  Reporter.addStepLog("Placing a bet on away team");
        waitForElement(driver, awayteam_xpath, 10);
        clickOn(awayteam_xpath);
        enterText(betInput_xpath, amount);
        waitInSeconds(3);
        closeallchangesinprice();
        getDetailsAfterPlacingBet();
        waitInSeconds(4);
        placeBet();
    }*/
/*
    public void betforDraw(String amount) {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on draw");
       // Reporter.addStepLog("Placing a bet on draw");
        waitForElement(driver, drawteam_xpath, 10);
        clickOn(drawteam_xpath);
        enterText(betInput_xpath, amount);
        waitInSeconds(3);
        closeallchangesinprice();
        getDetailsAfterPlacingBet();
        waitInSeconds(4);
        placeBet();
    }*/
    public void closeallchangesinprice(){
        By pricedown_xpath = By.xpath("//div[contains(@class,'price-down') or contains(@class,'price-up')]//a[@title='Remove Selection']/i");
        clickOn(pricedown_xpath);

    }


}
