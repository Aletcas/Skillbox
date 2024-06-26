package aletca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends Page {

    @FindBy(xpath = "//*[@id='reg_username']")
    public static WebElement login;

    @FindBy(xpath = "//*[@id='reg_email']")
    public static WebElement email;

    @FindBy(xpath = "//*[@name='password']")
    public static WebElement password;

    @FindBy(xpath = "//button[@name='register']")
    public static WebElement registration;

    @FindBy(xpath = "//div[@class='content-page']")
    public static WebElement message;

    @FindBy(xpath = "//a[@class='showlogin']")
    public static WebElement pleaseLogIn;


    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "register/");
        PageFactory.initElements(driver, this);
    }

    public static MainPage registration(String login, String email, String password) {
        RegistrationPage.login.sendKeys(login);
        RegistrationPage.email.sendKeys(email);
        RegistrationPage.password.sendKeys(password);
        registration.click();
        return new MainPage(driver, wait);
    }

    public String getMessage() {
        return message.getText();
    }

    public String getTextExisting() {
        return pleaseLogIn.getText();
    }
}
