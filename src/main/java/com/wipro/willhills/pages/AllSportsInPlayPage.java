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
import org.testng.Assert;

import java.text.DecimalFormat;

public class AllSportsInPlayPage extends ElementActions {

    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;
    public BettingPage bettingPage;

    public AllSportsInPlayPage(WebDriver driver) {
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.bettingPage = new BettingPage();
      //  this.footballInPlayPage = new FootballInPlayPage(this.driver);
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "h1[id='a11y-header-panel__title']")
    public WebElement sportsInPlay_header;

    String sportToActive = "//i[@class='contextual-nav__icon icon-%s']";
     //  "//a[@data-link-panel='panel-inplay-%s']";
    String activatedSport = "//li[a[contains(@href,'in-play/" + "{sportName}" + "')]]";
    protected String generic_sports_xpath = "//i[contains(@class,'icon-%s')]";
    //ul[@id='contextual-navigation-menu']//i[contains(@class,'icon-%s')]";

    By betInput_xpath = By.xpath("//span[@class='bs-bet-stake__value']");
    By total_price_xpath = By.xpath("//dt[text()='Total Stake:']/following-sibling::dd");
    //span[@id='total-stake-price']");
    By return_price_xpath = By.xpath(" //dt[text()='Total Returns:']/following-sibling::dd");
    //span[contains(@class,'return__amount')]");
    //span[@id='total-to-return-price']");  //dt[text()='Total Returns:']/following-sibling::dd
    By place_bet_xpath = By.xpath("//span[text()='Place Bet']");
    //li[contains(@class,'betslip-bet-actions')]/input[@value='Place Bet']");
    // ("//input[@value='Place Bet' and contains(@class,'place-bet-button')]");
    By bet_placed_xpath = By.xpath("//p[text()='Bet Placed']//following-sibling::button[text()='Done']");
    //p[text()='Bet Placed']");
    //*[contains(@class,'betslip-receipt') and text()='Bets placed']");
    By sport_count_xpath = By.xpath("//div[@class='sport-events-container']");
    By in_play_section_xpath = By.xpath("//h1[text()='All Sports In-Play']");
    By noOfGamesInPlay_xpath = By.xpath("//i[contains(@class,'all-sports')]//ancestor::a[1]/span");
    double beforeAmount;
    double afterAmount;

    ///tennis_xpath
    String first_active_match_xpath = "(//div[@id='tennis']//div[@class='event'][.//div[contains(@class,'btmarket__actions') and not(contains(@class,'disabled-market'))]])[1]";
    By firstSportName_xpath = By.xpath("(//div[@class='event']//a)[1]");
    // By.xpath(first_active_match_xpath + "//a[contains(@class,'btmarket__name--featured')]");
    By hometeam_xpath = By.xpath("(//div[@class='btmarket__selection'][1]//button)[1]");
    //By.xpath(first_active_match_xpath + "//div[contains(@class,'btmarket__actions')]/div[1]");
    By awayteam_xpath;
    //   By.xpath(first_active_match_xpath + "//div[contains(@class,'btmarket__actions')]/div[2]");
    By drawteam_xpath = By.xpath("(//div[@class='btmarket__selection'][2]//button)[1]");
    By noOfTennisGamesInPlay_xpath = By.xpath("//i[contains(@class,'tennis')]//ancestor::a[1]/span");
    By tennisGameInPlayPage_xpath = By.xpath("//section[@id='in-play-content']//h2[text()='tennis']");

    By account_balance_xpath = By.xpath("//span[contains(@class,'__balance')]");

    public By getAwayTeamXpath(String gameName) {
        if (gameName.equals("football")) {
            awayteam_xpath = By.xpath("(//div[@class='btmarket__selection'][3]//button)[1]");
        } else {
            awayteam_xpath = By.xpath("(//div[@class='btmarket__selection'][2]//button)[1]");
        }
        return awayteam_xpath;
    }

    public AllSportsInPlayPage() {
        super();
    }

    public void clickOnSport(String sportName) throws InterruptedException {
        String sport_xpath = String.format(sportToActive, sportName);
        Thread.sleep(2000);
        driver.findElement(By.xpath(sport_xpath)).click();
    }

    public void checkSportIsActive(String sportName) throws InterruptedException {
        WebElement activeSport = driver.findElement(By.xpath(activatedSport.replace("{sportName}",
                sportName.toLowerCase())));
        Assert.assertTrue(activeSport.getAttribute("class").contains("active"));
    }

    @FindBy(how = How.CSS, using = " (//div[@class='btmarket__selection']/button/span)[1]")
    public WebElement bet_on_first_homeTeam;

    public boolean isSportsPageLoaded() {
        boolean hasMoreSports = driver.findElements(sport_count_xpath).size() > 1;
        boolean isInPlayLoaded = verifyElement(in_play_section_xpath);
        return hasMoreSports && isInPlayLoaded;
    }

    public boolean isSpecificGameInPlayPageLoaded() {
        return true;
    }

    public int noOfSpecificGamesInPlay() {
        String number = getText(noOfGamesInPlay_xpath);
        int totalNoOflGamesPlaying = Integer.parseInt(number);
        return totalNoOflGamesPlaying;

    }

    /*  public String findFirstActiveSport() {
          return null;
      }*/
    public String findFirstActiveSport() {
        return getAttributeValue(firstSportName_xpath, "title");
    }

    public void betOnHomeTeam(String amount) throws InterruptedException {
        //  Thread.sleep(2000);
        beforePlacingABetDetails();
        System.out.println("Placing a bet on home team");
        //  Reporter.addStepLog("Placing a bet on home team");
        waitForElement(driver, hometeam_xpath, 10);
        clickOn(hometeam_xpath);
        // clickOn(cookies_text);
        actionsEnterText(betInput_xpath, amount);
        //  waitInSeconds(3);
        //  closeallchangesinprice();
        waitInSeconds(3);
        placeBet();
        getDetailsAfterPlacingBet();

    }

    public void betOnAwayTeam(String amount, String sportsName) throws InterruptedException {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on away team");
        //   Reporter.addStepLog("Placing a bet on away team");
        waitForElement(driver, getAwayTeamXpath(sportsName), 10);
        clickOn(awayteam_xpath);
        //  clickOn(cookies_text);
        clickOn(betInput_xpath);
        actionsEnterText(betInput_xpath, amount);
        //  enterText(betInput_xpath, amount);
        // waitInSeconds(3);
        //  closeallchangesinprice();
        //   waitInSeconds(3);
        placeBet();
        getDetailsAfterPlacingBet();
        //  placeBet();

    }

    public void betforDraw(String amount) throws InterruptedException {
        beforePlacingABetDetails();
        System.out.println("Placing a bet on draw");
        // Reporter.addStepLog("Placing a bet on draw");
        waitForElement(driver, drawteam_xpath, 10);
        clickOn(drawteam_xpath);
        actionsEnterText(betInput_xpath, amount);
        waitInSeconds(2);
        placeBet();
        //  closeallchangesinprice();
        getDetailsAfterPlacingBet();
        //  waitInSeconds(4);

    }

    public void closeallchangesinprice() {
        //  By pricedown_xpath = By.xpath("//div[contains(@class,'price-down') or contains(@class,'price-up')]//a[@title='Remove Selection']/i");
        By pricedown_xpath = By.xpath("//span[text()='Accept Price Changes']");
        clickOn(pricedown_xpath);

    }

    public void getDetailsAfterPlacingBet() throws InterruptedException {
        Thread.sleep(2000);
        String returnPrice = getText(return_price_xpath);
        String totalPrice = getText(total_price_xpath);
        System.out.println("Amount placed on the bet is : " + totalPrice);
        System.out.println("Return stakes for placing bet " + returnPrice);
        //  Reporter.addStepLog("Amount placed on the bet is : "+totalPrice);
        ///  Reporter.addStepLog("Return stakes for placing bet is "+returnPrice);
    }

    public void placeBet() {
        waitForElement(driver, place_bet_xpath, 20);
        clickOn(place_bet_xpath);
        waitInSeconds(4);
    }
    public double getAccountBalance(){
        waitForElement(driver, account_balance_xpath, 10);
        String amountRaw = getText(account_balance_xpath);
        return Double.parseDouble(amountRaw.substring(1));
    }

    public void beforePlacingABetDetails() {
        //waitInSeconds(4);
        System.out.println("***The first selected in-play game is " + findFirstActiveSport());
        //Reporter.addStepLog("The first selected in-play game is "+findFirstActiveSport());
        beforeAmount = getAccountBalance();
        System.out.println("Amount in the account before placing bid is " + beforeAmount);
        //  Reporter.addStepLog("Amount in the account before placing bid is "+ beforeAmount);
    }

    public void amountDeductedAfterPlacingBet(String betAmount) {
        waitInSeconds(1);
        afterAmount = getAccountBalance();
        System.out.println("Amount in the account after placing bid is " + afterAmount);
        //  Reporter.addStepLog("Amount in the account after placing bid is "+ afterAmount);
        double decreasedAmount = Double.valueOf(new DecimalFormat("#.##").format(beforeAmount - afterAmount));
        try {
            Assert.assertTrue(decreasedAmount == Double.parseDouble(betAmount), "Amount deducted from Account is not equals to " + betAmount);
        } catch (NumberFormatException e) {
            System.out.println("betting suspended");
        }
    }

    public boolean isBetsPlaced() {
        return verifyElement(bet_placed_xpath);
    }

    public AllSportsInPlayPage openSport(String sportsName) {
        AllSportsInPlayPage sports = null;
        String specific_sports_xpath = null;
        switch (sportsName.toLowerCase()) {
            case "football":
                specific_sports_xpath = String.format(generic_sports_xpath, "football");
                Assert.assertTrue(verifyElement(By.xpath(specific_sports_xpath)), "No football sport In Play");
                waitInSeconds(3);
                clickOn(By.xpath(specific_sports_xpath));
                sports = new FootballInPlayPage();
                break;
            case "tennis":
                specific_sports_xpath = String.format(generic_sports_xpath, "tennis");
                System.out.println(specific_sports_xpath);
                Assert.assertTrue(verifyElement(By.xpath(specific_sports_xpath)), "No Tennis sport In Play");
                waitInSeconds(1);
                clickOn(By.xpath(specific_sports_xpath));
                sports = new TennisInPlayPage();
                break;
            default:
                Assert.fail("Not a valid sports " + sportsName);
        }
        return sports;
    }


}
