package com.wipro.willhills.testcripts;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.driver.Driver;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.pages.LandingPage;
import com.wipro.willhills.utils.BaseTest;
import com.wipro.willhills.utils.TestDataProvider;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public final class TestWillamHillsBettingPage extends BaseTest {

    private LandingPage landingPage;

    private TestWillamHillsBettingPage() {
    }

    @BeforeMethod
    public void initTestWillamHillsLandingPage() {
        this.landingPage = new LandingPage();
    }

    @Test
    public void loginTest() {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        this.landingPage.loginButton.click();
        this.landingPage.loginFormPage.login("bhas08", "Bh2021bh");
    }

    @Test(dataProvider = "getDataFromXL", dataProviderClass = TestDataProvider.class)
    public void loginTestUsingDataFromExcelSheet(Hashtable<String, String> testData) {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.loginButton);
        this.landingPage.loginButton.click();
        this.landingPage.loginFormPage.loginFormUsingExcel(testData);
    }


    public void joinTest() throws IOException {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.joinButton);
        this.landingPage.clickJoinButton();
    }

    @Test(dataProvider = "getDataFromXL", dataProviderClass = TestDataProvider.class)
    public void joinTestUsingDataFromExcelSheet(Hashtable<String, String> testData) throws IOException {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.joinButton);
        this.landingPage.clickJoinButton();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.landingPage.joinFormPage.fillTheJoinForm(testData);
       // System.out.println(testData);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
       // Assert.assertTrue(false);
    }

    @Test(dataProvider = "getDataFromJson", dataProviderClass = TestDataProvider.class)
    public void joinTestUsingDataFromJson(Hashtable<String, String> testData) throws IOException {
        this.waitUtils.waitForElementToBeClickable(this.landingPage.joinButton);
        this.landingPage.clickJoinButton();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.landingPage.joinFormPage.fillTheJoinForm(testData);
        // System.out.println(testData);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);


    }
}