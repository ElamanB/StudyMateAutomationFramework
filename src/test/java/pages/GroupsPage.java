package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GroupsPage {

    public GroupsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//h2/following-sibling::button")
    public WebElement createGroupButton;

    @FindBy(name = "name")
    public WebElement groupNameInput;

    @FindBy(name = "dateOfFinish")
    public WebElement creationDateInput;

    @FindBy(css = "textarea[name='description']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='css-1qf1rpk']/div")
    public List<WebElement> listOfGroups;


    @FindBy(id = "modal")
    public WebElement popUpGroupWindow;

    @FindBy(xpath = "//div[text()='Group one!']")
    public WebElement newCreatedGroup;


    @FindBy(xpath = "//p[text()='Group successfully saved']")
    public WebElement groupSuccessfullySavedAlert;

    @FindBy(xpath = "//p[text()='A group with the same title already exists']")
    public WebElement titleAlreadyExistsAlert;





}
