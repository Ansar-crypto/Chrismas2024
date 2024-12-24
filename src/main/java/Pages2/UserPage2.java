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

public class UserPage2 extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;

    @FindBy(xpath = "//div[text()='Users']")
    WebElement userModule;
    @FindBy(xpath = "//div[text()='New User']")
    WebElement newUser;
    @FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='createUserPanel_emailField']")
    WebElement emailID;
    @FindBy(xpath = "//div[@id='createUserPanel_accessToOtherProductSelectorPlaceholder']/following::div[9]")
    WebElement dropDown;
    @FindBy(xpath = "(//div[text()='Quality Control'])[3]")
    WebElement selectDept;
    @FindBy(xpath = "//div[@class='components_switcher small off animated']")
    WebElement switchButton;
    @FindBy(xpath = "//div[text()='Save & Send Invitation']")
    WebElement createUser;
    @FindBy(xpath = "(//span[text()='Close'])[1]")
    WebElement close;
    @FindBy(xpath = "//table[@class='userNameSelectorsTable']/descendant::div[14]")
    WebElement search;
    @FindBy(xpath = "//table[@class='userNameSelectorsTable']/descendant::input")
    WebElement textBox;
    @FindBy(xpath = "//thead[@id='userListTableHeader']/following::div[9]")
    WebElement editIcon;
    @FindBy(xpath = "//div[text()='DELETE']")
    WebElement delit;

    public UserPage2(WebDriver driver){
        this.driver=driver;
        launchBrowser("chrome");
        PageFactory.initElements(this.driver,this);
         commonUtil=new CommonUtil(driver);
    }
    public void user() throws AWTException {
        commonUtil.waitForElementToVisible(userModule);
        userModule.click();
        newUser.click();
        commonUtil.waitForElementClickable(firstName);
        firstName.sendKeys("Ansar");
        commonUtil.waitForElementClickable(lastName);
        lastName.sendKeys("shaikh");
        commonUtil.waitForElementClickable(emailID);
        emailID.sendKeys("ansar3@yopmail.com");
        dropDown.click();
        commonUtil.waitForElementClickable(selectDept);
        selectDept.click();
        //commonUtil.waitForElementClickable(switchButton);
        //Actions actions=new Actions(driver);
        //actions.click(driver.findElement(By.xpath("//div[@class='components_switcher small off animated']"))).build().perform();
        switchButton.click();
        createUser.click();
    }
    public void verifyAcc() {
        commonUtil.waitForElementToVisible(close);
        close.click();
        search.click();
        textBox.sendKeys("Ansar");
    }
    public void delitAcc() throws AWTException, InterruptedException {
        //Thread.sleep(5000);
        //Actions actions=new Actions(driver);
        //actions.click(driver.findElement(By.xpath("//th[@id='sortBySickControl']/following::div[8]"))).build().perform();
        //commonUtil.fluentWait((By) driver.findElement(By.xpath("//thead[@id='userListTableHeader']/following::div[9]")));
        editIcon.click();
        //actions.click(driver.findElement(By.xpath("//div[text()='DELETE']"))).build().perform();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
