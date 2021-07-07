package com.wipro.willhills.utils;

import com.wipro.willhills.browserUtils.WaitUtils;
import com.wipro.willhills.driver.Driver;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.report.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;

public class BaseTest {
    int testRowIndexToUpdateStatus = 0;
    protected BaseTest(){

    }

    protected WaitUtils waitUtils;
    private static PropertiesFileReader propertiesFileReader = null;

    static {
        if(Objects.isNull(propertiesFileReader)) {
            propertiesFileReader = new PropertiesFileReader();
        }
    }

    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.initReports();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReport();
    }

    @BeforeMethod
    public void setup() {
        Driver.initDriver(propertiesFileReader.getProperty("browser"));
        this.waitUtils = new WaitUtils();
        DriverManager.getDriver().get(propertiesFileReader.getProperty("appUrl"));
        DriverManager.getDriver().manage().window().maximize();
    }

    /*@AfterMethod
    public void tearDown(ITestResult result) {
     Driver.quitDriver();
        if (result.getStatus() == ITestResult.FAILURE) {
            new ReadXlsFile(System.getProperty("user.dir") + "/src/main/resources/join.xlsx")
                    .setCellData("TestCases",DataUtils.statusColumnIndex , DataUtils.testRowIndex.get(testRowIndexToUpdateStatus), "Failed");
        } else {
            new ReadXlsFile(System.getProperty("user.dir") + "/src/main/resources/join.xlsx")
                    .setCellData("TestCases", DataUtils.statusColumnIndex, DataUtils.testRowIndex.get(testRowIndexToUpdateStatus), "Passed");
        }
        testRowIndexToUpdateStatus++;
    }*/

}
