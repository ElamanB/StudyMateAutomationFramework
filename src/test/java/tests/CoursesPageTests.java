package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.CoursesPage;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CoursesPageTests {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    CoursesPage deleteCourseTests = new CoursesPage();
    CoursesPage editCoursePage = new CoursesPage();
    CommonPage commonPage = new CommonPage();

    @BeforeEach
    public void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");
    }
    //Syimyk's delete course
    @Test
    @Order(2)
    public void testDelete() {
        deleteCourseTests.courses1.click();
        deleteCourseTests.editMenuButton.click();
        deleteCourseTests.delete1.click();
        deleteCourseTests.confirmDelete1.click();
        Assertions.assertTrue(deleteCourseTests.popUpWindow.isDisplayed());
        deleteCourseTests.trash.click();
        SeleniumUtils.waitForSeconds(5);
        boolean isElementFound = false;
        for (WebElement element : deleteCourseTests.listOfElements) {
            if (element.getText().contains("dited course name")){
                isElementFound = true;
                System.out.println(isElementFound);
                break;
            }
        }
        Assertions.assertTrue(isElementFound);
    }
    //Syimyk's edit course
    @Test
    @Order(1)
    public void testEdit() {
        commonPage.coursesTab.click();
        editCoursePage.editMenuButton.click();
        editCoursePage.editButton.click();

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
        Assertions.assertTrue(editCoursePage.popUp.isDisplayed());

        SeleniumUtils.waitForSeconds(5);
        commonPage.administratorButton.click();
        commonPage.logOutButton.click();
        commonPage.logOutConfirmationButton.click();
    }
    @AfterEach
    public void after(){
        driver.manage().deleteAllCookies();
    }
}
