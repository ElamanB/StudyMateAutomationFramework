package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CoursesPage {

    public CoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "Courses")
    public WebElement courses;
}
