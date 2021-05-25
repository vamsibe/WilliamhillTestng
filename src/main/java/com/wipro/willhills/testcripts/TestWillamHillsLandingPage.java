package com.wipro.willhills.testcripts;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.pages.LandingPage;
import com.wipro.willhills.utils.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TestWillamHillsLandingPage extends BaseTest {

    private LandingPage landingPage;

    @BeforeMethod
    public void initTestWillamHillsLandingPage() {
        this.landingPage = new LandingPage();
    }

    @Test
    public void testLoginAndLogoutFunctionalityFromLandingPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        this.landingPage.loginButton.click();
        this.landingPage.loginFormPage.login("bhas08", "Bh2021bh");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        this.landingPage.acceptAndCloseButton.click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.landingPage.accountDropDown.click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.landingPage.logOut.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertTrue(this.landingPage.closeLoginButton.isDisplayed(),"user has not logged out");
      //  Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @Test
    public void testBettingPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.bettingLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("betting"));
        Assert.assertTrue(title.toLowerCase().contains("betting"));
        //System.out.println(this.landingPage.liveCasinoLink.getAttribute("class"));
        Assert.assertTrue(this.landingPage.bettingLink.getAttribute("class").contains("active"));
    }
    @Test
    public void testVegasPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.vegasLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("vegas"));
        Assert.assertTrue(title.toLowerCase().contains("vegas"));
        //System.out.println(this.landingPage.liveCasinoLink.getAttribute("class"));
        Assert.assertTrue(this.landingPage.vegasLink.getAttribute("class").contains("active"));
    }
    @Test
    public void testLiveCasinoPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.liveCasinoLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("livecasino"));
        Assert.assertTrue(title.toLowerCase().contains("live casino"));
        //System.out.println(this.landingPage.liveCasinoLink.getAttribute("class"));
        Assert.assertTrue(this.landingPage.liveCasinoLink.getAttribute("class").contains("active"));
    }

    @Test
    public void testCasinoPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.casinoLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        //  System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        // System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("casino"));
        Assert.assertTrue(title.toLowerCase().contains("casino"));
        Assert.assertTrue(this.landingPage.casinoLink.getAttribute("class").contains("active"));

    }
    @Test
    public void testGamesPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.gamesLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        //  System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        // System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("gaming"));
        Assert.assertTrue(title.toLowerCase().contains("games"));
        Assert.assertTrue(this.landingPage.gamesLink.getAttribute("class").contains("active"));

    }
    @Test
    public void testBingoPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.bingoLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        //  System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        // System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("bingo"));
        Assert.assertTrue(title.toLowerCase().contains("bingo"));
        Assert.assertTrue(this.landingPage.bingoLink.getAttribute("class").contains("active"));

    }
    @Test
    public void testPokerPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.pokerLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        //  System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        // System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("poker"));
        Assert.assertTrue(title.toLowerCase().contains("poker"));
        Assert.assertTrue(this.landingPage.pokerLink.getAttribute("class").contains("active"));

    }
    @Test
    public void testPromotionsPage() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        this.landingPage.promotionsLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String title = DriverManager.getDriver().getTitle();
        //  System.out.println(title);
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        // System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.toLowerCase().contains("promotions"));
        Assert.assertTrue(title.toLowerCase().contains("promotions"));
        //Assert.assertTrue(this.landingPage.promotionsLink.getAttribute("class").contains("active"));

    }
    @Test
    public void testJoinFunctionalityFromLandingPage() throws Exception {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/join.xlsx");   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        // System.out.println(sheet.getLastRowNum());
        //System.out.println(row.getLastCellNum());
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                CellType type = cell.getCellTypeEnum();

                switch (type.toString().toLowerCase()) {
                    case "string":    //field that represents string cell type
                        System.out.print(cell.getStringCellValue() + "\t\t\t");
                        break;
                    case "numeric":    //field that represents number cell type
                        System.out.print(cell.getNumericCellValue() + "\t\t\t");
                        break;
                    default:
                }
            }

        }
    }

}

