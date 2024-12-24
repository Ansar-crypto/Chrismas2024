package Pages2;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage2 extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;
    @FindBy(xpath = "//div[text()=\"Tasks\"]")
    WebElement taskModule;
    @FindBy(xpath = "//div[text()=\"Add New\"]")
    WebElement addNew;
    @FindBy(xpath = "//div[@class=\"item createNewProject\"]")
    WebElement newProject;
    @FindBy(xpath = "(//input[@placeholder=\"Enter Project Name\"])[2]")
    WebElement newProjectName;
    @FindBy(xpath = "(//div[@class=\"dropdownButton\"])[15]")
    WebElement dropDown;
    @FindBy(xpath = "(//div[@class=\"itemRow cpItemRow \"])[4]")
    WebElement selectCompany;
    @FindBy(xpath = "//div[text()=\"Create Project\"]")
    WebElement createproject;
    @FindBy(xpath = "(//input[@placeholder=\"Start typing name ...\"])[1]")
    WebElement searchBox;
    @FindBy(xpath = "//div[@class='node projectNode editable selected']/descendant::div[5]")
    WebElement editButton;
    @FindBy(xpath = "(//div[text()='ACTIONS'])[2]")
    WebElement actionButton;
    @FindBy(xpath = "(//div[text()=\"Delete\"])[3]")
    WebElement delitButton;
    @FindBy(xpath = "//span[text()=\"Delete permanently\"]")
    WebElement delitPermanently;


    public ProjectPage2(WebDriver driver) {
        this.driver = driver;
        launchBrowser("chrome");
        PageFactory.initElements(this.driver, this);
        commonUtil=new CommonUtil(driver);
    }
    public void project(String projectName){
        taskModule.click();
        addNew.click();
        newProject.click();
        commonUtil.waitForElementClickable(newProjectName);
        newProjectName.sendKeys(projectName);
        dropDown.click();
        selectCompany.click();
        createproject.click();
    }
    public void verify(String project){
        searchBox.sendKeys(project);
    }
    public void delit() throws InterruptedException {
        Thread.sleep(10000);
        editButton.click();
        Thread.sleep(5000);
        actionButton.click();
        delitButton.click();
        delitPermanently.click();
    }
}
