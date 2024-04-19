package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.TeachersPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class TeacherPageTest {

    WebDriver driver;
    TeachersPage teachersPage = new TeachersPage();
    LoginPage loginPage = new LoginPage();



    @BeforeEach
    public void startPoint() {
        driver = Driver.getDriver();
        driver.get("https://codewise.studymate.us/login");
        loginPage.logIn("Admin@codewise.com", "codewise123");
    }
    @Test
    public void editTeacherTest(){
        SeleniumUtils.waitForSeconds(5);
        List<WebElement> sideBar = driver.findElements(By.xpath("//div[@class='MuiListItemIcon-root css-1f8bwsm']"));
        Assertions.assertEquals(sideBar.size(),7);
        teachersPage.teachersTab.click();
        SeleniumUtils.waitForSeconds(5);
        List<WebElement> teachers = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root css-1ipg9de']"));
        Assertions.assertEquals(teachers.size(),6);
        teachersPage.threeDots.click();
        teachersPage.editButton.click();
        Actions actions = new Actions(driver);
        actions.keyDown(teachersPage.editTeacherPhoneNumber, Keys.COMMAND).sendKeys("a");
        actions.keyUp(teachersPage.editTeacherPhoneNumber, Keys.COMMAND);
        actions.keyDown(teachersPage.editTeacherPhoneNumber, Keys.BACK_SPACE);
        actions.keyUp(teachersPage.editTeacherPhoneNumber, Keys.BACK_SPACE);
        actions.build().perform();
        Faker faker = new Faker();
        String a1 = faker.number().digits(3);
        String a2 = faker.number().digits(3);
        String a3 = faker.number().digits(4);
        String phoneNumber = a1+" "+a2+" "+a3;
        //    String phoneNumber = "+1 231 456 7841";
        teachersPage.editTeacherPhoneNumber.sendKeys(phoneNumber);
        teachersPage.saveButton.click();
        WebElement confirmation = driver.findElement(By.xpath("//td[text()='+1 "+phoneNumber+"']"));
        phoneNumber = "+1"+" "+phoneNumber;
        Assertions.assertEquals(confirmation.getText(),phoneNumber);
    }
    @Test
    public void deleteTeacher(){
        SeleniumUtils.waitForSeconds(5);
        List<WebElement> sideBar = driver.findElements(By.xpath("//div[@class='MuiListItemIcon-root css-1f8bwsm']"));
        Assertions.assertEquals(sideBar.size(),7);
        teachersPage.teachersTab.click();
        SeleniumUtils.waitForSeconds(5);
        List<WebElement> teachers = driver.findElements(By.xpath("//tr[@class='MuiTableRow-root css-1ipg9de']"));
        Assertions.assertEquals(teachers.size(),6);
        teachersPage.threeDots.click();
        teachersPage.threeDotsDeleteButton.click();
        teachersPage.deleteButton.click();


    }
}
