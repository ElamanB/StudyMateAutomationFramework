package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.GroupsPage;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupsPageTests {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    GroupsPage groupsPage = new GroupsPage();
    CommonPage commonPage = new CommonPage();
    WebDriverWait wait;

    @BeforeEach
    public void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }

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
        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();

    }

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

        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();

    }

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


    }






    @AfterEach
    public void endPoint() {
        driver.manage().deleteAllCookies();
    }
}
