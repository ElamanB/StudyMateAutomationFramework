package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;

    @FindBy(id = "mui-component-select-language")
    public WebElement languageDropdown;

    @FindBy(css = "li[data-value=en]")
    public WebElement englishLanguage;

    public void logIn(String email, String password) {
        languageDropdown.click();
        englishLanguage.click();

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        loginButton.click();
    }


}
