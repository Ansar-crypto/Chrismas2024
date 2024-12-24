package com.actitimeautomation.TestClasses;

import Common.BaseClass;
import Common.ExcelHandling;
import com.actitimeautomation.sampleTestNG.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class DataProviderTest extends BaseClass {
    private static final Logger log = LoggerFactory.getLogger(DataProviderTest.class);
    WebDriver driver;

    @BeforeClass
    public void setup(){
        launchBrowser("chrome");
        driver=super.driver;
        driver.get("https://online.actitime.com/consultant/tasks/tasklist.do");
    }
    @DataProvider
    public Object[][] getTestData(){
        Object [][] obj=new Object[][]{
                {"username","password"},
                {"username1","password1"}
        };
            return obj;
    }
    @Test(dataProvider = "getTestData")
    public void verifyLogin(Object username,Object password) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username.toString(),password.toString());
        Thread.sleep(5000);
    }
    @DataProvider
    public Object [][] getTestDataFromExcel() throws IOException {
        ExcelHandling excelHandling=new ExcelHandling();
        String filepath="E:/XL selenium/Test.xlsx";
        Object[][] excelData=excelHandling.getExcelData(filepath,"Sheet1");
        return excelData;
    }
    @Test(dataProvider = "getSampleData", dataProviderClass = TestDataProvider.class)
    public void test(Object param1,Object param2,Object param3){

        System.out.println(param1 + "  "+param2 + "  " + param3);
    }

}
