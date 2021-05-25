package com.wipro.willhills.report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private static final ThreadLocal<ExtentTest> et = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return et.get();
    }

    public static void setExtentTest(ExtentTest test){
        et.set(test);
    }
}
