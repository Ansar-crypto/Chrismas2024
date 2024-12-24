package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import Common.TestListeners;
import Pages2.CustomerPage2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
@Listeners(TestListeners.class)
public class CustomerTest2 extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    CommonUtil commonUtil;

    CustomerPage2 customerPage2;
    @BeforeClass
    public void setup() throws IOException {
        PropertyHandling propertyHandling = new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        String actitimeUrl=propertyHandling.getProperty("actitimeUrl");
        driver=super.driver;
        driver.get(actitimeUrl);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        CommonUtil commonUtil=new CommonUtil(driver);
        customerPage2=new CustomerPage2(driver);
    }
    @Test
    public void createCust(){
       customerPage2.createCustomer("Tata Industries");
       customerPage2.customerDescription("Automotive Industries");
    }
    //@Test
    //public void delitCustmer() {
        //customerPage2.delit("Tata Industries");
   // }
}
