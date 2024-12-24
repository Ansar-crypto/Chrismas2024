package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import Common.TestListeners;
import Pages2.UserPage2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.awt.*;
import java.io.IOException;
@Listeners(TestListeners.class)
public class UserTest2 extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;

    PropertyHandling propertyHandling;

    UserPage2 userPage2;
    @BeforeClass
    public void setup() throws IOException {
        propertyHandling=new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        String actitimeUrl=propertyHandling.getProperty("actitimeUrl");
        driver=super.driver;
        driver.get(actitimeUrl);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        userPage2=new UserPage2(driver);
    }
    @Test
    public void createUser() throws AWTException {
    userPage2.user();
    }
    @Test
    public void verifyUser(){
        userPage2.verifyAcc();
    }
    @Test
    public void delitUser() throws AWTException, InterruptedException {
        userPage2.delitAcc();
    }
}
