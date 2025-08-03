package com.prep.tests;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import javax.security.auth.login.FailedLoginException;

/**
 * WebDriver Basics *
 */
public class WebDriverBasics
{
    public static void main( String[] args )   {
        //Open the Browser
        ChromeDriver driver = new ChromeDriver();

        //FirefoxDriver feDriver = new FirefoxDriver();
        //SafariDriver safariDriver = new SafariDriver(); //check  Allow Remote automation in develop
        //EdgeDriver edgeDriver = new EdgeDriver();

        //Open the Website
        driver.get("https://naveenautomationlabs.com/");

        //print the Website Title
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Welcome to Naveen AutomationLabs - naveen automationlabs";

        //assertions/ validations
        if(actualTitle.equalsIgnoreCase(expectedTitle))
        {
            System.out.println("Title is correct : PASS");
        }else{
            System.out.println("Title is not Correct : FAIL");
        }
        driver.quit();
        
    }
}
