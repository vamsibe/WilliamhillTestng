package com.wipro.willhills.driver;

import com.wipro.willhills.utils.FrameWorkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {
    private Driver() {

    }

    // public static WebDriver driver;

    public static void initDriver(String browserName) {

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                if (Objects.isNull(DriverManager.getDriver())) {
                    System.setProperty("webdriver.chrome.driver", FrameWorkConstants.CHROME_DRIVER_PATH);
                    DriverManager.setDriver(new ChromeDriver());
                } else {
                    throw new RuntimeException("Failed to open chrome browser");
                }
                break;
            case "firefox":
                if (Objects.isNull(DriverManager.getDriver())) {
                    System.setProperty("webdriver.gecko.driver", FrameWorkConstants.FIREFOX_DRIVER_PATH);
                    DriverManager.setDriver(new FirefoxDriver());
                } else {
                    throw new RuntimeException("Failed to open firefox browser");
                }
                break;
            default:
                throw new RuntimeException("Failed to initialize driver, please check your driver path or browser name");
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
             DriverManager.unload();
        }
    }
}
