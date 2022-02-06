package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    public Properties prop;
    public int STATUS_CODE_200 = 200;
    public int STATUS_CODE_201 = 201;
    public int STATUS_CODE_400 = 400;
    public int STATUS_CODE_500 = 500;


    public TestBase(){
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            prop = new Properties();
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
