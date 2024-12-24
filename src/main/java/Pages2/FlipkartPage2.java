package Pages2;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FlipkartPage2 extends BaseClass {
    WebDriver driver;

    @FindBy(xpath = "//div[@data-id='SHOG6KYZMKRCQDB8']")
    WebElement selectProduct;

    public FlipkartPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);

    }
    public void flipkart() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        boolean searchBox=driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).isDisplayed();
        if (searchBox){
            driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("red chief shoes");
        }
        else {
            System.out.println("unable to search given product");
        }
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        selectProduct.click();
    }
}
