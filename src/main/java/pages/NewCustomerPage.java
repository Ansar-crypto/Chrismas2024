package pages;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage extends BaseClass {
WebDriver driver;
CommonUtil commonUtil;
    @FindBy(xpath = "//div[@id='container_tasks']/following::div[1]")
    WebElement taskModule;
    @FindBy(xpath = "//div[@class='title ellipsis']")
    WebElement addNewButton;
    @FindBy(xpath ="//div[@class='item createNewCustomer']" )
    WebElement navigateToNewCustomer;
    @FindBy(xpath = "//div[@id='customerLightBox']/descendant::input[1]")
    WebElement enterCustName;
    @FindBy(xpath = "//div[text()='Create Customer']")
    WebElement createCustomer;

    public NewCustomerPage(WebDriver driver){
        this.driver=driver;
        launchBrowser("chrome");
        PageFactory.initElements(this.driver,this);
        CommonUtil commonUtil=new CommonUtil(driver);
        this.commonUtil=commonUtil;
    }
    public void createCust(String custName){
        taskModule.click();
        addNewButton.click();
        navigateToNewCustomer.click();
        commonUtil.waitForElementClickable(enterCustName);
        enterCustName.sendKeys(custName);
        createCustomer.click();
    }
}
