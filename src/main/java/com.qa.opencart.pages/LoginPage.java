package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.opencart.constants.AppConstants.*;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    //1. Private By locators
    private final By email = By.id("input-email");
    private final By password = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@value='Login']");
    private final By forgotPwdLink = By.linkText("Forgotten Password");


    //2. Public page Constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    //3. Public page actions/methods
    public String getLoginPageTitle() {
        String title = eleUtil.waitFotTitleIs(LOGIN_PAGE_TITLE, AppConstants.DEFAULT_TIME_OUT);
        System.out.println("login page title : " + title);
        return title;
    }

    public String getLoginPageUrl() {
        String URL = eleUtil.waitForURLContains(LOGIN_PAGE_URL_FRACTION, AppConstants.DEFAULT_TIME_OUT);
        System.out.println("login page URL : " + URL);
        return URL;
    }

    public boolean isForgotPwdLinkExist() {
        return eleUtil.isElementDisplayed(forgotPwdLink);
    }

    public AccountPage doLogin(String username, String pwd) {
        System.out.println("user credentials: " + username + ":" + pwd);
        eleUtil.waitForElementVisible(email, DEFAULT_TIME_OUT).sendKeys(username);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(loginBtn);
        return new AccountPage(driver);
    }


}
