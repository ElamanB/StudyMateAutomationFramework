package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.DeleteCoursePages;
import pages.EditCoursePage;
import pages.LoginPage;
import utilities.Driver;

public class DeleteCourseTests {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    DeleteCoursePages deleteCourseTests = new DeleteCoursePages();

    @BeforeEach
    public void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");

    }
    @Test
    public void testDelete(){
        deleteCourseTests.courses1.click();
        deleteCourseTests.edit1.click();
        deleteCourseTests.delete1.click();
        deleteCourseTests.confirmDelete1.click();
        deleteCourseTests.trash.click();
    }
}
