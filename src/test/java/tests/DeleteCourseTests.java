package tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DeleteCoursePages;
import pages.EditCoursePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

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
    public void testDelete() {
        deleteCourseTests.courses1.click();
        deleteCourseTests.edit1.click();
        deleteCourseTests.delete1.click();
        deleteCourseTests.confirmDelete1.click();
        Assertions.assertTrue(deleteCourseTests.popUpWindow.isDisplayed());
        deleteCourseTests.trash.click();
        SeleniumUtils.waitForSeconds(5);
        boolean isElementFound = false;
        for (WebElement element : deleteCourseTests.listOfElements) {
            if (element.getText().contains("Edited course description")){
                isElementFound = true;
                System.out.println(isElementFound);
                break;
            }
        }
        Assertions.assertTrue(isElementFound);
     }
}

