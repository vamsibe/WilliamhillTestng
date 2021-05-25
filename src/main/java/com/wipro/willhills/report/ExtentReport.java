package com.wipro.willhills.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {

    }

    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("WilliamHills  Report");
            spark.config().setReportName("WilliamHills Regression Test");
        }
    }

    public static void flushReport() {
        try {
            if (Objects.nonNull(extent)) {
                extent.flush();
            }
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "/index.html").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
        ExtentManager.setExtentTest(test);
    }
}
