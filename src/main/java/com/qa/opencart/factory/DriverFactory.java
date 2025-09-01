package com.qa.opencart.factory;

import com.qa.opencart.exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.*;
import java.sql.Driver;
import java.util.Properties;

import com.qa.opencart.exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * This class initializing the Driver
 */
public class DriverFactory {
    WebDriver driver;
    Properties prop;

    /**
     * Initializes the WebDriver based on the browser specified in the properties.
     *
     * @param prop
     * @return
     */
    public WebDriver initDriver(Properties prop) {
        String browserName = prop.getProperty("browser");
        System.out.println("Browser Name : " + browserName);
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Please enter the valid browser name.." + browserName);
                throw new BrowserException(("=====INVALID BROWSER====="));

        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    /**
     * Initializes and loads properties from the configuration file.
     *
     * @return the loaded Properties object
     */
    public Properties initProp() {
        prop = new Properties();
        try {

            InputStream ip = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}