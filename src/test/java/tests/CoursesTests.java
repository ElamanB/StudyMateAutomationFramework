package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Driver;

public class CoursesTests {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    CoursesPage coursesPage = new CoursesPage();

    @BeforeEach

    public void loginIn() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }
    @Test
    public void create(){
        coursesPage.courses.click();
        coursesPage.createCourse.click();
        coursesPage.courseName.sendKeys("JIRA PRACTICING 1 ");
        coursesPage.date.sendKeys("04.12.2024");
        coursesPage.description.sendKeys("This is Jira practicing of Group-1");
        coursesPage.create.click();
        Assertions.assertTrue(coursesPage.courseSuccessfullySavedAlert.isDisplayed());
        Assertions.assertTrue(coursesPage.courseSuccessfullySavedAlert.getText().contains("The course successfully created"));

    }
}
