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

import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class BettingPage {

    private WebDriver driver;
    public LoginFormPage loginFormPage;
    public JoinFormPage joinFormPage;
    public LandingPage landingPage;
    public WaitUtils waitUtils;

    public BettingPage() {
        this.driver = DriverManager.getDriver();
        this.loginFormPage = new LoginFormPage();
        this.joinFormPage = new JoinFormPage();
        this.landingPage = new LandingPage();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Accept & Close']")
    public WebElement acceptAndCloseButton;

    @FindBy(how = How.CSS, using = "button[data-test-id='@sitebase/login-button_loginButtonId']")
    public WebElement bettingLoginButton;

    @FindBy(how = How.CSS, using = "input[name='username']")
    public WebElement userName;

    @FindBy(how = How.CSS, using = "input[name='password']")
    public WebElement password;

    @FindBy(how = How.CSS, using = "button[name='login-submit-button']")
    public WebElement loginSubmitButton;

    @FindBy(how = How.CSS, using = "div[data-test-id='error-box-message'] strong")
    public WebElement errorMessage;

    @FindBy(how = How.CSS, using = "span[class='cp-ma-myaccount-dropdown-button__balance']")
    public WebElement accountDropDown;

    @FindBy(how = How.XPATH, using = "//span[text()='Logout']")
    public WebElement logOut;

    @FindBy(how = How.CSS, using = "button[data-test-id='@sitebase/login-button_loginButtonId']")
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = "a[href='#all-sports']")
    public WebElement aToZSports;

    @FindBy(how = How.XPATH, using = "//ul[@id='desktop-sidebar-az']//li[2]//a")
    public List<WebElement> allSports;

    @FindBy(how = How.XPATH, using = "//span[@aria-current='page']//span")
    public WebElement pageTitleBreadcrumb;

    @FindBy(how = How.XPATH, using = "//ul[@class='c-list c-list--icon c-list--featured']//a[1]")
    public WebElement pageTitle;   //"//div[@id='title-bar']//div[contains(@class,'app-text-box')]")

    @FindBy(how = How.CSS, using = "a[title='In-Play']")
    public WebElement inPlay;

    @FindBy(how = How.CSS, using = "a[title='In-Play']")
    public WebElement betOnHomeTeam;

///////adding new oprning sites functionality

    By sitesNames = By.xpath("//li[@class='css-xnumgp']//a");
    By bettingSite = By.xpath("//li[@class='group-sites visible']//a[text()='Sports Betting']");
    String menuLink = "//a[text()='<LINK_NAME>']";
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'btmarket__link-name--ellipsis')]")
    public List<WebElement> allGamesToBet;

    @FindBy(how = How.XPATH, using= "//div[contains(@class,'topbets__footer')]")
    public WebElement topBets;

    @FindBy(how = How.XPATH, using= "//div[@id='topBetsContainer']//a[text()='View All Top Bets']")
    public WebElement viewAllTopBets;

    @FindBy(how = How.XPATH, using= "//a[@class='topbets__list-item--link']")
    public List<WebElement> getAllTopBetGames;

    Map<String, String> hmap = new HashMap<>();

    public void clickSitesNames() {
        hmap.put("Betting", "Online Sports Betting & Odds ⇒ Bet Online at William Hill™");
        hmap.put("Vegas", "Play Vegas Games online today | William Hill");
        hmap.put("Live Casino", "Live Casino | Play Live Casino Games | William Hill™");
        hmap.put("Casino", "Play Online Casino Games | Casino Online UK | William Hill™");
        hmap.put("Games", "Play Online Slots & Games ⇒ William Hill Games");
        hmap.put("Bingo", "Play Online Bingo Games | Spend £5 Get a £25 Bonus | William Hill");
        hmap.put("Poker", "Online Poker, Texas Hold'em & Casino Side Games - William Hill");
        hmap.put("Promotions", "William Hill Promotions");

    }

   /* public void openMenuLink(String linkName) {
        clickOn(By.xpath(menuLink.replace("<LINK_NAME>", linkName)));

    }*/

    public List<String> getAllExpectedSiteNames() {
        Set<String> ActualSiteNames = hmap.keySet();
        List<String> ll = new ArrayList<>(ActualSiteNames);
        Collections.sort(ll);
        return ll;
    }

    /* public List<String> getAllLinkedSites() {
         List<String> ll = getMultipleText(sitesNames);
         Set<String> ss = new TreeSet<String>(ll);
         ll = new ArrayList<String>(ss);
         Collections.sort(ll);
         return ll;
     }*/
  /* public String getPageHeaderAsString() {
       String text;
       if (this.pageTitleBreadcrumb.isEnabled()) {
            text = this.pageTitleBreadcrumb.getText();
       *//* if(text=="Baseball Highlights"){
            text= text.split(" ")[0];
            System.out.println(text);
        }*//*
       } else {
            text = this.pageTitle.getText();
       }
       return text;
   }*/
   /* public String getPageHeaderAsString() {
        String text;

        if (this.pageTitleBreadcrumb.isDisplayed()) {
            text = this.pageTitleBreadcrumb.getText();
        } else {
            text = this.pageTitle.getText();
        }
        return text;
    }*/
    public String getPageHeaderAsString() {
        String text;
        text = this.pageTitle.getText();
        return text;
    }


}
