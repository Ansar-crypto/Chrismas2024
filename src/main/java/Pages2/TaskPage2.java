package Pages2;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage2 extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @FindBy(xpath = "//div[text()=\"Tasks\"]")
    WebElement taskModule;
    @FindBy(xpath = "//div[text()=\"Add New\"]")
    WebElement addNew;
    @FindBy(xpath = "//div[text()='New Tasks']")
    WebElement newTask;
    @FindBy(xpath = "//div[text()='Select Customer and Project to Add Tasks for']/following::div[10]")
    WebElement custDropdown;
    @FindBy(xpath = "(//div[text()='Tata Industries'])[2]")
    WebElement selectCustomer;
    @FindBy(xpath = "(//input[@placeholder='Enter Project Name'])[2]")
    WebElement projectDropdown;
    //@FindBy(xpath = "(//div[text()='Tata Curve EV'])[3]")
    //WebElement selectProject;
    @FindBy(xpath = "(//input[@placeholder='Enter task name'])[4]")
    WebElement enterTask1;
    @FindBy(xpath = "(//thead[@class='createTasksTableHead']/following::input[1]")
    WebElement enterTask2;
    @FindBy(xpath = "(//thead[@class='createTasksTableHead'])/following::input[5]")
    WebElement enterTask3;
    @FindBy(xpath = "(//thead[@class='createTasksTableHead'])/following::input[9]")
    WebElement enterTask4;
    @FindBy(xpath = "(//thead[@class='createTasksTableHead'])/following::input[13]")
    WebElement enterTask5;
    @FindBy(xpath = "//div[text()='Create Tasks']")
    WebElement createTask;

    public TaskPage2(WebDriver driver) {
        this.driver = driver;
        launchBrowser("chrome");
        PageFactory.initElements(this.driver, this);
        commonUtil = new CommonUtil(driver);
    }
    public void createTasks(String task1,String task2,String task3,String task4,String task5) throws InterruptedException {
        taskModule.click();
        addNew.click();
        newTask.click();
        //commonUtil.waitForElementToVisible(custDropdown);
        //custDropdown.click();
        //selectCustomer.click();
        Thread.sleep(10000);
        //projectDropdown.sendKeys("Tata Curve Ev");
        //selectProject.click();
        enterTask1.sendKeys(task1);
        enterTask2.sendKeys(task2);
        enterTask3.sendKeys(task3);
        enterTask4.sendKeys(task4);
        enterTask5.sendKeys(task5);
        createTask.click();
    }
}
