package com.actitimeautomation.TestClasses;

import Common.BaseClass;
//import Common.CommonUtil;
import Common.ExcelHandling;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

//import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

public class GetAndInsertAllCustomerInexcel extends BaseClass {
    static WebDriver driver;

    public GetAndInsertAllCustomerInexcel(){
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws InterruptedException, IOException {
        new GetAndInsertAllCustomerInexcel();
        driver.get("https://online.actitime.com/consultant/tasks/tasklist.do");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("ansar3@yopmail.com","India1");
       // CommonUtil commonUtil=new CommonUtil(driver);
       // commonUtil.waitForElementToPresent("");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        Thread.sleep(5000);
        //List<WebElement> allCustomers =driver.findElements(By.xpath("//div[contains(@class,'customerNode')]//div[@class='text']"));
        //List<WebElement> allCustomers =driver.findElements(By.xpath("//div[contains(@class,'taskRowCellWrapper')]"));
        //List<WebElement> allCustomers =driver.findElements(By.xpath("//tr[@class='taskRow']"));
        List<WebElement> allCustomers =driver.findElements(By.xpath("//div[@class='projectTitle']"));
        System.out.println(allCustomers.size());

        //create two dimensional array
        Object [][] data=new Object[allCustomers.size()][1];

        for (int i=0;i<=allCustomers.size()-1;i++){

        String customerName=allCustomers.get(i).getText();
        data[i][0]=customerName;
        }
        ExcelHandling excelHandling=new ExcelHandling();
        String filepath="E:/XL selenium/Test.xlsx";
                excelHandling.writeExcelData(filepath,"Sheet1",data);
        driver.quit();
    }
}
