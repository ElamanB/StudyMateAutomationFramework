package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentsPage {

    public StudentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
