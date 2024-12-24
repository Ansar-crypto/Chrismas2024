package com.actitimeautomation.TestClasses;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.IrctcPage1;

import java.awt.*;
import java.io.IOException;

public class IrctcTest1 extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

  IrctcPage1 irctcPage;

    CommonUtil commonUtil;
    @BeforeClass
    public void setup() throws IOException {
        propertyHandling=new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver=super.driver;
        driver.get("https://www.irctc.co.in/nget/train-search");
        irctcPage=new IrctcPage1(driver);
        driver.manage().window().maximize();
        commonUtil =new CommonUtil(driver);
    }
    @DataProvider
    public Object[][] getTestData()
    {   Object[][] obj=new Object[][]
            {
                    {"PUNE","MUMBAI"}
            };
        return obj;
    }
    @Test(priority = 1,dataProvider = "getTestData")
    public void fromTo(Object start,Object stop) throws AWTException, InterruptedException {
        irctcPage.startJourney(start.toString());
        irctcPage.stopJourney(stop.toString());
    }
    @Test
    public void searchRoute() throws InterruptedException, AWTException {
        irctcPage.click();
    }
}
