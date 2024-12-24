package com.actitimeautomation.TestClasses2;

import Common.BaseClass;
import Common.PropertyHandling;
import Pages2.FlipkartPage2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class FlipkartTest2 extends BaseClass {
    WebDriver driver;

    FlipkartPage2 flipkartPage2;
    @BeforeClass
    public void setup() throws IOException {
        PropertyHandling propertyHandling=new PropertyHandling();
        String browser=propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver=super.driver;
        driver.get("https://www.flipkart.com/");
        flipkartPage2=new FlipkartPage2(driver);
    }
    @Test
    public void addProductToCart() throws InterruptedException, AWTException {
    flipkartPage2.flipkart();
    }
}
