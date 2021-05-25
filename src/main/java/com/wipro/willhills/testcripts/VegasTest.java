package com.wipro.willhills.testcripts;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.pages.LandingPage;
import com.wipro.willhills.pages.VegasPage;
import com.wipro.willhills.pages.VegasRainbowWildsPage;
import com.wipro.willhills.utils.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VegasTest extends BaseTest {
    private LandingPage landingPage;
    private VegasPage vegasPage;
    private VegasRainbowWildsPage vegasRainbowWildsPage;

    @BeforeMethod
    public void initTestWillamHillsVegasPage() {
        this.landingPage = new LandingPage();
        this.vegasPage = new VegasPage();
        this.vegasRainbowWildsPage = new VegasRainbowWildsPage();
    }

    @Test
    public void testAllTheGamesAreHavingNames() {
        waitUtils.waitForElementToBeVisible(this.landingPage.loginButton);
        this.landingPage.vegasLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.viewAllButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        System.out.println(this.vegasPage.allGamesImages.size());
        for (int i = 0; i < this.vegasPage.allGamesImages.size(); i++) {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            String text = this.vegasPage.allGamesImages.get(i).getAttribute("alt");
            System.out.println(text + " :  " + (i + 1));

        }
    }

    @Test
    public void testingRainBowRichesGame() {
        waitUtils.waitForElementToBeVisible(this.landingPage.loginButton);
        this.landingPage.vegasLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.viewAllButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        int i = 2;
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String text = this.vegasPage.allGamesImages.get(i).getAttribute("alt");
        System.out.println(text + " :  " + (i + 1));
        this.vegasPage.allGamesImages.get(i).click();
        this.landingPage.loginFormPage.login("bhas08", "Bh2021bh");
        Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
        //  Assert.assertTrue(DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.gamesIframe);
        DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.gameLauncherIframe);
        DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.gamesIframe);
        DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.iframe);
        this.vegasRainbowWildsPage.noSound.click();
        Actions actions = new Actions(DriverManager.getDriver());

        actions.moveByOffset(770, 870).doubleClick().build().perform();
        // this.vegasRainbowWildsPage.canvasContinue.click();
        Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);

    }

    @Test
    public void clickOnRainBowWildMegaWays() {
        waitUtils.waitForElementToBeVisible(this.landingPage.loginButton);
        this.landingPage.vegasLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.viewAllButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        for(int i = 0;i<this.vegasPage.allGamesImages.size();i++){
       // Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String text = this.vegasPage.allGamesImages.get(i).getAttribute("alt");
           // System.out.println("  : "+text);
       // System.out.println(text + " :  " + (i + 1));
        if(text.equals( "Rainbow Wild Megaways")) {
            this.vegasPage.allGamesImages.get(i).click();
            this.landingPage.loginFormPage.login("bhas08", "Bh2021bh");
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
            DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.gameLauncherIframe);
               DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.gamesIframe);
              DriverManager.getDriver().switchTo().frame(this.vegasRainbowWildsPage.iframe);
            Actions actions = new Actions(DriverManager.getDriver());
            //  this.vegasRainbowWildsPage.noSound.click();
           // String javascript = "window.scrollBy(842,625)";
         //   JavascriptExecutor j = (JavascriptExecutor)DriverManager.getDriver();
           // j.executeScript("window.scrollBy(" + 842 + ", " + 625 + ");");
          //  j.executeScript("arguments[0].click();");
          //  j.executeScript(javascript);
            actions.moveByOffset(858, 605).click().build().perform();
           // Actions actions = new Actions(DriverManager.getDriver());
             // actions.moveByOffset(1438, 315).doubleClick().build().perform();
            Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
            actions.moveByOffset(738, 865).click().build().perform();
             this.vegasRainbowWildsPage.canvasContinue.click();
                Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);

        }
   }
    }

    @Test
    public void clickOnFirstGame() {
        waitUtils.waitForElementToBeVisible(this.landingPage.loginButton);
        this.landingPage.vegasLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.vegasPage.viewAllButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveByOffset(460, 540).click().build().perform();
        this.landingPage.loginFormPage.login("bhas08", "Bh2021bh");
        Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
        actions.moveByOffset(512, 829).click().build().perform();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        actions.moveByOffset(512, 829).click().build().perform();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        actions.moveByOffset(512, 829).click().build().perform();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        actions.moveByOffset(941, 379).click().build().perform();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        actions.moveByOffset(1072, 832).click().build().perform();

    }


}
