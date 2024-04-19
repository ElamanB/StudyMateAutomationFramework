package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CoursesPage {

    public CoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement courses;
    @FindBy(xpath = "//button[text()='Create course']")
    public WebElement createCourse;

    @FindBy(name = "courseName")
    public WebElement courseName;

    @FindBy(xpath = "//*[@name='dateOfFinish']")
    public WebElement date;

    @FindBy(css = "textarea[name='description']")
    public WebElement description;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement create;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']/div")
    public List<WebElement> listOfCourses;

    @FindBy(xpath = "//p[text()='The course successfully created']")
    public WebElement courseSuccessfullySavedAlert;



}
