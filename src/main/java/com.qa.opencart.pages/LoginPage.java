package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //1. Private By locators
    private final By email = By.id("input-email");
    private final By password =By.id("input-password");
    private final By loginBtn=By.xpath("//input[@value='Login']");
    private final By forgotPwdLink = By.linkText("Forgotten Password");


    //2. Public page Constructors
     public  LoginPage(WebDriver driver) {
         this.driver = driver;
     }

    //3. Public page actions/methods
    public String getLoginPageTitle(){
         String title = driver.getTitle();
         System.out.println("login page title : "+ title);
         return title;
        }

    public String getLoginPageUrl(){
            String URL = driver.getCurrentUrl();
            System.out.println("login page URL : "+ URL);
            return URL;
        }

        public boolean isForgotPwdLinkExist(){
            return  driver.findElement(forgotPwdLink).isDisplayed();
        }

        public void doLogin(String username, String pwd){
            System.out.println("user credentials: "+username + ":" + pwd);
            driver.findElement(email).sendKeys(username);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(loginBtn).click();
        }

}
