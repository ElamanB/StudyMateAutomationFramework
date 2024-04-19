package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.GroupsPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupsPageTests {

    static WebDriver driver;
    GroupsPage groupsPage = new GroupsPage();
    CommonPage commonPage = new CommonPage();
    WebDriverWait wait;

    @BeforeAll
    public static void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }

    /**
     * This Java test method uses Selenium WebDriver to verify that a new group
     * can be successfully created in a web application, checking UI elements'
     * visibility, interacting with form fields, and confirming that the group count increases by one.
     */
    @Test
    @Order(1)
    public void testSuccessfulCreateGroup() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assertions.assertTrue(commonPage.groupsTab.isDisplayed());

        groupsPage.createGroupButton.click();

        Assertions.assertTrue(groupsPage.popUpGroupWindow.isDisplayed());

        groupsPage.groupNameInput.sendKeys("Group one!");
        groupsPage.creationDateInput.sendKeys("12042024");
        groupsPage.descriptionInput.sendKeys("Testing group creation!");

        int numOfGroupsBefore = groupsPage.listOfGroups.size();

        groupsPage.createButton.click();

        wait.until(ExpectedConditions.visibilityOf(groupsPage.groupSuccessfullySavedAlert));

        Assertions.assertTrue(groupsPage.groupSuccessfullySavedAlert.isDisplayed());
        Assertions.assertTrue(groupsPage.groupSuccessfullySavedAlert.getText().contains("Group successfully saved"));


        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                ("//div[@class='css-1qf1rpk']/div"), numOfGroupsBefore + 1));

        Assertions.assertTrue(groupsPage.newCreatedGroup.isDisplayed());

        int numOfGroupsAfter = groupsPage.listOfGroups.size();

        Assertions.assertTrue(groupsPage.listOfGroups.get(0).getText().contains("Group one!"));

        Assertions.assertEquals(numOfGroupsBefore, numOfGroupsAfter - 1);

        wait.until(ExpectedConditions.invisibilityOf(groupsPage.groupSuccessfullySavedAlert));
//        commonPage.administratorButton.click();
//        commonPage.logOutButton.click();
//        commonPage.logOutConfirmationButton.click();

    }

    /**
     * This Java test method, uses Selenium WebDriver to validate the functionality
     * of cancelling a group creation in a web application. It initiates the creation process,
     * inputs data into the group form, and then cancels it.
     */
    @Test
    @Order(2)
    public void testCancelInCreateGroup() {

        groupsPage.createGroupButton.click();

        Assertions.assertTrue(groupsPage.popUpGroupWindow.isDisplayed());

        groupsPage.groupNameInput.sendKeys("Group two!");
        groupsPage.creationDateInput.sendKeys("12042024");
        groupsPage.descriptionInput.sendKeys("Testing group creation!");

        int numOfGroupsBefore = groupsPage.listOfGroups.size();

        groupsPage.cancelButton.click();

        int numOfGroupsAfter = groupsPage.listOfGroups.size();

        Assertions.assertEquals(numOfGroupsBefore, numOfGroupsAfter);
        Assertions.assertFalse(groupsPage.listOfGroups.get(0).getText().contains("Group two!"));


//        commonPage.administratorButton.click();
//        commonPage.logOutButton.click();
//        commonPage.logOutConfirmationButton.click();

    }


    /**
     *
     This Java test method, uses Selenium WebDriver to ensure that an attempt
     to create a duplicate group ("Group one!") triggers an appropriate error alert
     about the existing title and then verifies that the process can be canceled cleanly.
     */
    @Test
    @Order(3)
    public void testNS1CreateGroup() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assertions.assertTrue(commonPage.groupsTab.isDisplayed());

        groupsPage.createGroupButton.click();

        Assertions.assertTrue(groupsPage.popUpGroupWindow.isDisplayed());

        groupsPage.groupNameInput.sendKeys("Group one!");
        groupsPage.creationDateInput.sendKeys("12042024");
        groupsPage.descriptionInput.sendKeys("Testing group creation!");

        groupsPage.createButton.click();

        wait.until(ExpectedConditions.visibilityOf(groupsPage.titleAlreadyExistsAlert));
        Assertions.assertTrue(groupsPage.titleAlreadyExistsAlert.isDisplayed());


        groupsPage.cancelButton.click();

        wait.until(ExpectedConditions.invisibilityOf(groupsPage.titleAlreadyExistsAlert));
//        commonPage.administratorButton.click();
//        commonPage.logOutButton.click();
//        commonPage.logOutConfirmationButton.click();


    }

    @Test
    @Order(4)
    public void editGroupTest(){
        List<WebElement> sideBar = driver.findElements(By.xpath("//div[@class='MuiListItemIcon-root css-1f8bwsm']"));
        Assertions.assertEquals(sideBar.size(),7);
        commonPage.groupsTab.click();
        List<WebElement> groups = driver.findElements(By.xpath("//div[@class='MuiPopover-root " +
                "MuiModal-root MuiModal-hidden css-jpt4u3']"));
        int size = groups.size();
        Assertions.assertTrue(size==4);
        groupsPage.threeDots.click();
        groupsPage.editButton1.click();
        Actions actions = new Actions(driver);
        actions.keyDown(groupsPage.groupNameInput, Keys.COMMAND).sendKeys("a");
        actions.keyUp(groupsPage.groupNameInput, Keys.COMMAND);
        actions.keyDown(groupsPage.groupNameInput, Keys.BACK_SPACE);
        actions.keyUp(groupsPage.groupNameInput, Keys.BACK_SPACE);
        actions.build().perform();
        Faker faker = new Faker();
        String text = faker.name().title();
        groupsPage.groupNameInput.sendKeys(text);
        groupsPage.saveButton.click();
        WebElement confirmation = driver.findElement(By.xpath("//div[text()='"+text+"']"));
        System.out.println(confirmation.getText());
        Assertions.assertEquals(confirmation.getText(),text);
    }
    @Test
    @Order(5)
    public void deleteGroupTest(){
        commonPage.groupsTab.click();
        List<WebElement> groups = driver.findElements(By.xpath("//div[@class='MuiPopover-root " +
                "MuiModal-root MuiModal-hidden css-jpt4u3']"));
        int size = groups.size();
        Assertions.assertTrue(size==4);
        groupsPage.threeDots.click();
        groupsPage.deleteGroupButton1.click();
        groupsPage.deleteButton.click();
        SeleniumUtils.waitForSeconds(1);
        Assertions.assertTrue(size==3);

    }






    @AfterEach
    public void endPoint() {
        driver.manage().deleteAllCookies();
    }
}
