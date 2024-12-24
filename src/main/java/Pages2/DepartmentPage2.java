package Pages2;

import Common.BaseClass;
import Common.CommonUtil;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentPage2 extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;

    @FindBy(xpath = "//div[text()='Users']")
    WebElement userModule;
    @FindBy(xpath = "(//div[text()='  Departments'])[1]")
    WebElement departmentButton;
    @FindBy(xpath = "//td[@class='newGroupInputCell']/input")
    WebElement deptTextBox;
    @FindBy(xpath = "//button[@id='groupManagementLightBox_addGroupButton']")
    WebElement addDept;
    public DepartmentPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
         commonUtil=new CommonUtil(driver);
    }
    public void createDept(){
        commonUtil.waitForElementClickable(userModule);
        userModule.click();
        departmentButton.click();
        deptTextBox.sendKeys("Softeware Testing");
        commonUtil.waitForElementClickable(addDept);
        addDept.click();
    }
}
