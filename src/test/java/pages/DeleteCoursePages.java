package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeleteCoursePages {
    public DeleteCoursePages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Courses']")
    public WebElement courses1;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    public WebElement edit1;

    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    public WebElement delete1;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium sc-eKJbhj iZsItr css-fab8xs']")
    public WebElement confirmDelete1;

    @FindBy(xpath = "//*[text()='Trash']")
    public WebElement trash;


}
