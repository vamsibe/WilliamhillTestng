package com.wipro.willhills.driver;

import com.wipro.willhills.utils.FrameWorkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverManager {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driver){
         dr.set(driver);
    }

    public static void unload(){
        dr.remove();
    }
}
