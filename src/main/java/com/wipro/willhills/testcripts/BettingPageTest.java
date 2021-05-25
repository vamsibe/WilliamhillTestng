package com.wipro.willhills.testcripts;

import com.google.common.collect.Table;
import com.google.common.util.concurrent.Uninterruptibles;

import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.pages.AllSportsInPlayPage;
import com.wipro.willhills.pages.BettingPage;
import com.wipro.willhills.pages.LandingPage;
import com.wipro.willhills.report.ExtentManager;
import com.wipro.willhills.report.ExtentReport;
import com.wipro.willhills.utils.BaseTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BettingPageTest extends BaseTest {
    private LandingPage landingPage;
    private BettingPage bettingPage;
    private AllSportsInPlayPage allSportsInPlayPage;
    private String sportsName;

    @BeforeMethod
    public void inItBettingPageTest() {
        System.out.println(DriverManager.getDriver());
        this.landingPage = new LandingPage();
        this.bettingPage = new BettingPage();
        this.allSportsInPlayPage = new AllSportsInPlayPage(DriverManager.getDriver());

    }

    @Test
    public void testLoginFunctionalityForBettingPage() throws AssertionError, InterruptedException {
        try {
            ExtentReport.createTest("Login Functionality For Betting Page");
            ExtentManager.getExtentTest().info("Waiting for betting link to clickable");
            waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
            //  this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
            Uninterruptibles.sleepUninterruptibly(5000, TimeUnit.MILLISECONDS);
            this.landingPage.bettingLink.click();
            ExtentManager.getExtentTest().info("clicked for betting link to clickable");
            this.bettingPage.loginButton.click();
            this.bettingPage.loginFormPage.login("bhas08", "Bh2021bh");
            Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
            //  this.landingPage.clickOnBettingLink();
            // Assert.assertTrue(this.landingPage.loginButton.isDisplayed());
            //  this.bettingPage.bettingLoginButton.click();
            // Thread.sleep(20000);
            //   this.bettingPage.userName.isDisplayed();
            //   this.bettingPage.userName.sendKeys("bhas08");
            //   this.bettingPage.password.sendKeys("Bh2021bh");
            //  this.bettingPage.loginSubmitButton.click();
            //  Thread.sleep(2000);
            Assert.assertTrue(this.bettingPage.accountDropDown.isDisplayed());
            ExtentManager.getExtentTest().pass("Account drop down is present");
            // Thread.sleep(2000);
            this.bettingPage.accountDropDown.click();
            Thread.sleep(1000);
            this.bettingPage.logOut.click();
            Thread.sleep(1000);
            Assert.assertTrue(this.bettingPage.loginButton.isDisplayed());
        } catch (Exception | AssertionError e) {
            ExtentManager.getExtentTest().fail(e);
            throw e;
        }
    }

    @Test
    public void numberOfLiveGamesPresentIsEqualToHeaderPresent() throws AssertionError, Exception {
        try {
            ExtentReport.createTest("Number Of Live Games Present Is Equal To Header Present");
            waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
            //  this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
            this.landingPage.bettingLink.click();
            Uninterruptibles.sleepUninterruptibly(5000, TimeUnit.MILLISECONDS);
            Assert.assertTrue(this.bettingPage.aToZSports.isDisplayed());
            String text = this.bettingPage.aToZSports.getText();
            String str = text.replaceAll("\\D+", "");
            int number = this.bettingPage.allSports.size();
        /*System.out.println(number);
        System.out.println(Integer.parseInt(str) + "%%%%%$&^£$&&%77");*/
            Assert.assertEquals(Integer.parseInt(str), number);
            ExtentManager.getExtentTest().pass("Matching with number");
        } catch (Exception | AssertionError e) {
            ExtentManager.getExtentTest().fail(e);
            throw e;
        }
    }

  /*  @Test
    public void whenIClickOnASportThatCorrespondingPageShouldOpen() {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        this.landingPage.bettingLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.bettingPage.acceptAndCloseButton.click();
        this.bettingPage.allSports.forEach((sport) -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            sport.click();
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            //System.out.println(this.bettingPage.getPageHeaderAsString().toLowerCase());
            //System.out.println(this.bettingPage.getPageHeaderAsString().toLowerCase().replace(" ", "-")+" : "+DriverManager.getDriver().getCurrentUrl());
            //System.out.println( DriverManager.getDriver().getCurrentUrl().substring(DriverManager.getDriver().getCurrentUrl().lastIndexOf("/")+1));
            //System.out.println( DriverManager.getDriver().getCurrentUrl().split("/")[DriverManager.getDriver().getCurrentUrl().split("/").length-3]);
            if (DriverManager.getDriver().getCurrentUrl().contains("meetings")) {
                Assert.assertEquals(this.bettingPage.getPageHeaderAsString().toLowerCase().replace(" ", "-"),
                        DriverManager.getDriver().getCurrentUrl().split("/")[DriverManager.getDriver().getCurrentUrl().split("/").length - 2]);
            } else if (DriverManager.getDriver().getCurrentUrl().contains("tv-specials")) {
                Assert.assertEquals(this.bettingPage.getPageHeaderAsString().toLowerCase().replace("/", "-"),
                        DriverManager.getDriver().getCurrentUrl().substring(DriverManager.getDriver().getCurrentUrl().lastIndexOf("/") + 1));
            } else if (DriverManager.getDriver().getCurrentUrl().contains("virtual-world")) {
                Assert.assertEquals(this.bettingPage.getPageHeaderAsString().toLowerCase().replace(" ", "-"),
                        DriverManager.getDriver().getCurrentUrl().split("/")[DriverManager.getDriver().getCurrentUrl().split("/").length - 3]);
            } else {
                Assert.assertEquals(this.bettingPage.getPageHeaderAsString().toLowerCase().replace(" ", "-"),
                        DriverManager.getDriver().getCurrentUrl().substring(DriverManager.getDriver().getCurrentUrl().lastIndexOf("/") + 1));
            }

        });

    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"football"},
                        {"tennis"},
                        {"cricket"},
                        {"darts"}
                };
    }

    @Test(dataProvider = "SearchProvider")
    public void selectSportInPlayAndGetTheRespectiveActiveSportPage(String sport) throws InterruptedException {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        this.landingPage.bettingLink.click();
        this.bettingPage.inPlay.click();
        this.allSportsInPlayPage.clickOnSport(sport);
        Thread.sleep(2000);
        this.allSportsInPlayPage.checkSportIsActive(sport);
        // this.allSportsInPlayPage.openSport(sportsName);
        //   Assert.assertTrue(this.allSportsInPlayPage.isSpecificGameInPlayPageLoaded());
        System.out.println(sportsName + " in-play page is loaded : " + this.allSportsInPlayPage.isSpecificGameInPlayPageLoaded());
        // Reporter.addStepLog(sportsName + " in-play page is loaded : " + sports.isSpecificGameInPlayPageLoaded());
        this.sportsName = sportsName;
        Assert.assertTrue(this.allSportsInPlayPage.isSpecificGameInPlayPageLoaded());
        //System.out.println("******No of games in play for " + sportsName + " is " + this.allSportsInPlayPage.noOfSpecificGamesInPlay());
        //  Reporter.addStepLog("No of games in play for " + sportsName + " is " + sports.noOfSpecificGamesInPlay());
    }

    @Test
    public void printAllGamesToBet() throws IOException {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        this.landingPage.bettingLink.click();
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("JavaBooks");
        int rowCount = 0;
        int columnCount = 0;
        for (int i = 0; i < this.bettingPage.allGamesToBet.size(); i++) {
            if (!this.bettingPage.allGamesToBet.get(i).getText().equals("")) {
                XSSFRow row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                System.out.println(this.bettingPage.allGamesToBet.get(i).getText());
                cell.setCellValue(this.bettingPage.allGamesToBet.get(i).getText());
            }
        }
        FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx"));
        workbook.write(out);
        out.close();
    }

    @Test
    public void printAllTopBets() throws IOException {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        this.landingPage.bettingLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.bettingPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.bettingPage.topBets.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.bettingPage.viewAllTopBets.click();
        while (this.bettingPage.viewAllTopBets.isDisplayed()) {
            this.bettingPage.viewAllTopBets.click();
        }
        //  else if (!this.bettingPage.viewAllTopBets.isDisplayed()) {

        File f = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\allTopBets.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("AllTopBets");
        int rowCount = 0;
        int columnCount = 0;
        for (int i = 0; i < this.bettingPage.getAllTopBetGames.size(); i++) {
            if (!this.bettingPage.getAllTopBetGames.get(i).getText().equals("")) {
                XSSFRow row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                System.out.println(this.bettingPage.getAllTopBetGames.get(i).getText());
                cell.setCellValue(this.bettingPage.getAllTopBetGames.get(i).getText());
            }
        }
        FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\allTopBets.xlsx"));
        workbook.write(out);
        out.close();
    }*/
}
