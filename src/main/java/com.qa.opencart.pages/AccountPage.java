package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.opencart.constants.AppConstants.*;

public class AccountPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    //Constructor of the page class
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }


    //Private By locators
    private final By logoutLink = By.linkText("Logout");
    private final By search = By.name("search");


    //Public page actions/methods
    public String getAccountPageTitle() {
        String title = eleUtil.waitFotTitleIs(HOME_PAGE_TITLE, DEFAULT_TIME_OUT);
        System.out.println("Account page title : " + title);
        return title;
    }

    public String getAccountPageURL() {
        String url = eleUtil.waitForURLContains(HOME_PAGE_URL_FRACTION, DEFAULT_TIME_OUT);
        System.out.println("Account page url : " + url);
        return url;
    }

    public boolean isLogoutLinkExist() {
        return eleUtil.isElementDisplayed(logoutLink);
    }

}
