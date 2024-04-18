package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EditCoursePage;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;

public class EditCourseTests {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    EditCoursePage editCoursePage = new EditCoursePage();

    @BeforeEach
    public void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }
    @Test
    public void testSuccessfulCreateGroup() {

        //Assertions.assertTrue(editCoursePage.isDisplayed());

        editCoursePage.courses.click();
        editCoursePage.edit.click();
        editCoursePage.edit1.click();
        editCoursePage.editCourseName.sendKeys(" Edited course name");
        editCoursePage.editDescription.sendKeys(" Edited course description");
        editCoursePage.editDate.sendKeys("12042024");
        editCoursePage.saveButton.click();

       // Assertions.assertTrue(editCoursePage..isDisplayed());

//        groupsPag.groupNameInput.sendKeys("Group one!");
//        groupsPage.creationDateInput.sendKeys("12042024");
//        groupsPage.descriptionInput.sendKeys("Testing group creation!");
//
//        int numOfGroupsBefore = groupsPage.listOfGroups.size();
//
//        groupsPage.createButton.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
//                ("//div[@class='css-1qf1rpk']/div"), numOfGroupsBefore + 1));
//
//        Assertions.assertTrue(groupsPage.newCreatedGroup.isDisplayed());
//
//        int numOfGroupsAfter = groupsPage.listOfGroups.size();
//
//        Assertions.assertTrue(groupsPage.listOfGroups.get(0).getText().contains("Group one!"));
//
//        Assertions.assertEquals(numOfGroupsBefore, numOfGroupsAfter - 1);

    }
}
