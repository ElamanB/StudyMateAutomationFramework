package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Driver;

import java.time.Duration;

public class CoursesTests {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    CoursesPage coursesPage = new CoursesPage();
    WebDriverWait wait;


    @BeforeEach

    public void loginIn() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }
    @Test
    public void positive(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        coursesPage.courses.click();
        coursesPage.createCourse.click();
        coursesPage.courseName.sendKeys("JIRA PRACTICING 3 ");
        coursesPage.date.sendKeys("04.12.2024");
        coursesPage.description.sendKeys("This is Jira practicing of Group-1");
        coursesPage.create.click();

        wait.until(ExpectedConditions.visibilityOf(coursesPage.courseSuccessfullySavedAlert));

        Assertions.assertTrue(coursesPage.courseSuccessfullySavedAlert.getText().contains("The course successfully created"));

    }
    @Test
    public void negative(){
        coursesPage.courses.click();
        coursesPage.createCourse.click();
        coursesPage.courseName.sendKeys("JIRA PRACTICING 3 ");
        coursesPage.date.sendKeys("05.12.2024");
        coursesPage.description.sendKeys("This is Jira practicing of Group-1");
        coursesPage.create.click();
        wait.until(ExpectedConditions.visibilityOf(coursesPage.courseAlreadyExistsAlert));

        Assertions.assertTrue(coursesPage.courseAlreadyExistsAlert.getText().contains("Course with the same title already exists"));

    }
}
