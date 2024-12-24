package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.PropertyHandling;
import Common.TestListeners;
import Pages2.DepartmentPage2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

@Listeners(TestListeners.class)
public class DepartmentTest2 extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    DepartmentPage2 departmentPage2;
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
        departmentPage2=new DepartmentPage2(driver);
    }
    @Test
    public void createDepartment(){
    departmentPage2.createDept();
    }
}
