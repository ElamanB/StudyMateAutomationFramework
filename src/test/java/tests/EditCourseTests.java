package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EditCoursePage;
import pages.LoginPage;
import utilities.Driver;

import javax.swing.*;
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
        editCoursePage.courses.click();
        editCoursePage.edit.click();
        editCoursePage.edit1.click();

        Actions action = new Actions(driver);
        action.keyDown(editCoursePage.editCourseName, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editCourseName,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editCourseName.sendKeys("Edited course name");

        action.keyDown(editCoursePage.editDescription, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editDescription,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editDescription.sendKeys("Edited course description");

        action.keyDown(editCoursePage.editDate, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(editCoursePage.editDate,Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        editCoursePage.editDate.sendKeys("12042024");
        editCoursePage.saveButton.click();



    }
}
