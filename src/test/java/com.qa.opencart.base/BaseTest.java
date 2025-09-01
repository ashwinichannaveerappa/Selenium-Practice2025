package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    DriverFactory driverFactory;
    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    
    protected Properties prop;

    /**
     *
     */
    @BeforeTest
    public void setup() {
        driverFactory = new DriverFactory();
        prop = driverFactory.initProp();
        driver = driverFactory.initDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
