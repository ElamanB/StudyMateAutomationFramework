package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditCoursePage {
    public EditCoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement  courses;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    public WebElement edit;

    @FindBy(xpath = "(//*[text()='Edit'])[2]")
    public WebElement edit1;

    @FindBy(name = "courseName")
    public WebElement editCourseName;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement editDescription;

    @FindBy(name = "dateOfFinish")
    public WebElement editDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;





}
