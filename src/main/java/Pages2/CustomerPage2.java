package Pages2;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage2 extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;
    @FindBy(xpath = "//div[text()=\"Tasks\"]")
    WebElement taskModule;
    @FindBy(xpath = "//div[text()=\"Add New\"]")
    WebElement addNew;
    @FindBy(xpath = "//div[text()=\"New Customer\"]")
    WebElement newCustomer;
    @FindBy(xpath = "(//input[@placeholder=\"Enter Customer Name\"])[2]")
    WebElement customerName;
    @FindBy(xpath = "//textarea[@placeholder=\"Enter Customer Description\"]")
    WebElement custdescription;
    @FindBy(xpath = "//div[text()=\"Create Customer\"]")
    WebElement createCustomer;
    @FindBy(xpath = "(//input[@placeholder=\"Start typing name ...\"])[1]")
    WebElement searchCustomer;
    @FindBy(xpath = "(//div[@class=\"editButton\"])[16]")
    WebElement editButton;
    @FindBy(xpath = "(//div[@class=\"actions\"])[1]/descendant::div[4]")
    WebElement actionButton;
    @FindBy(xpath = "(//div[text()=\"Delete\"])[2]")
    WebElement delitButton;
    @FindBy(xpath = "//span[text()=\"Delete permanently\"]")
    WebElement delitPermanently;

    public CustomerPage2(WebDriver driver){
        this.driver=driver;
        launchBrowser("chrome");
        PageFactory.initElements(this.driver,this);
        commonUtil=new CommonUtil(driver);
    }
    public void createCustomer(String custumer) {
        taskModule.click();
        addNew.click();
        newCustomer.click();
        commonUtil.waitForAllElementToVisible(customerName);
        customerName.sendKeys(custumer);
    }
    public void customerDescription(String custDescription){
        custdescription.sendKeys(custDescription);
        createCustomer.click();
    }
    public void delit(String search) {
        searchCustomer.sendKeys(search);
        commonUtil.waitForAllElementToVisible(editButton);
        editButton.click();
        commonUtil.waitForElementClickable(actionButton);
        actionButton.click();
        delitButton.click();
        delitPermanently.click();
    }
}
