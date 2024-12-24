package com.actitimeautomation.TestClasses;

import Common.BaseClass;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewCustomerPage;

import java.io.IOException;

public class NewCustomerTest extends BaseClass {
    private static final Logger log = LoggerFactory.getLogger(NewCustomerTest.class);
    WebDriver driver;
    NewCustomerPage newCustomerPage;
    @BeforeClass
    public void setup() throws IOException {

        PropertyHandling propertyHandling=new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        String url=propertyHandling.getProperty("actitimeUrl");
        driver=super.driver;
        driver.get(url);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        NewCustomerPage newCustomerPage=new NewCustomerPage(driver);
        this.newCustomerPage=newCustomerPage;
    }
    @Test
    public void createNewCust(){
    newCustomerPage.createCust("Ansar");
    }
}