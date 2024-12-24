package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import Common.TestListeners;
import Pages2.ProjectPage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;

import java.io.IOException;

@Listeners(TestListeners.class)
public class ProjectTest2 extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;

    ProjectPage2 projectPage2;
    @BeforeClass
    public void setup() throws IOException {
        PropertyHandling propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver = super.driver;
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        LoginPage loginPage = new LoginPage(driver);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username, password);
        commonUtil = new CommonUtil(driver);
        projectPage2=new ProjectPage2(driver);
    }
    @Test
    public void createProject(){
        projectPage2.project("Tata Curve EV");
    }
    @Test
    public void verifyProject(){
        projectPage2.verify("Tata Curve EV");
    }
    @Test
    public void delitProject() throws InterruptedException {
        projectPage2.delit();
    }
}
