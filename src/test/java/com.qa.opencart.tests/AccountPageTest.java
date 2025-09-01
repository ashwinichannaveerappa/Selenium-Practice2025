package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.qa.opencart.constants.AppConstants.*;

/*
 * This class is to test the Account Page functionalities.
 */
public class AccountPageTest extends BaseTest {
    //BT,BC(annotations)

    @BeforeClass
    public void accPageSetup() {
        accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void accPageTitleTest() {
        Assert.assertEquals(HOME_PAGE_TITLE, accountPage.getAccountPageTitle());
    }

    @Test
    public void accPageUrlTest() {
        Assert.assertTrue(accountPage.getAccountPageURL().contains(HOME_PAGE_URL_FRACTION));
    }

    @Test
    public void isLogoutLinkExistTest() {
        Assert.assertTrue(accountPage.isLogoutLinkExist());
    }
    
}
