package pages;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class IrctcPage1 extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;
    @FindBy(xpath = "(//input[@aria-activedescendant='p-highlighted-option'])[1]")
    WebElement from;
    @FindBy(xpath = "(//input[@aria-activedescendant='p-highlighted-option'])[2]")
    WebElement to;
    @FindBy(xpath = "(//button[@class='search_btn train_Search'])[1]")
    WebElement search;

    public IrctcPage1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
        CommonUtil commonUtil=new CommonUtil(this.driver);
    }
    public void startJourney(String startPoint) throws AWTException {
        //Robot robot=new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);

        from.sendKeys(startPoint);
    }
    public void stopJourney(String endPoint)  {

        to.sendKeys(endPoint);

    }
    public void click()throws InterruptedException, AWTException{
        Thread.sleep(5000);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        search.click();
    }
}
