package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import Common.TestListeners;
import Pages2.TaskPage2;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
@Listeners(TestListeners.class)
public class TaskTest2 extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    TaskPage2 taskPage2;

    CommonUtil commonUtil;

    @BeforeClass
    public void setup() throws IOException {
        PropertyHandling propertyHandling=new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver=super.driver;
        String actitimeUrl=propertyHandling.getProperty("actitimeUrl");
        driver.get(actitimeUrl);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        commonUtil=new CommonUtil(driver);
        taskPage2=new TaskPage2(driver);
    }
    @DataProvider
    public Object[][] getTestData(){
        Object [][] obj=new Object[][]{
                {"Making Ev Wheels","Making Ev Battery","Making Ev BLDC Motor","Making Ev Wire Harness","Making Ev Dashboard"}
        };
        return obj;
    }
    @Test(priority = 1, dataProvider = "getTestData")
    public void createTask(Object task1,Object task2,Object task3,Object task4,Object task5) throws InterruptedException {
        taskPage2.createTasks(task1.toString(),task2.toString(),task3.toString(),task4.toString(),task5.toString());
    }
}
