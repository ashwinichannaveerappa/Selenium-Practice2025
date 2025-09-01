package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;

import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.opencart.constants.AppConstants.*;

public class LoginPageTest extends BaseTest {


    @Test
    public void loginPageTitleTest() {
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, LOGIN_PAGE_TITLE);
    }

    @Test
    public void loginPageUrlTest() {
        String actualUrl = loginPage.getLoginPageUrl();
        Assert.assertTrue(actualUrl.contains(LOGIN_PAGE_URL_FRACTION));
    }

    @Test
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = Short.MAX_VALUE)
    public void loginTest() {
      accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
      Assert.assertEquals(accountPage.getAccountPageTitle(), HOME_PAGE_TITLE);
    }
}
