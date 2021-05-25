package com.wipro.willhills.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            FileInputStream fileInput = new FileInputStream(new File(FrameWorkConstants.MAIN_RESOURCES + "/config.properties"));
            properties.load(fileInput);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
