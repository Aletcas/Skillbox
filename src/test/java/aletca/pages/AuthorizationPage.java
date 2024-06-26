package aletca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends Page {

    @FindBy(xpath = "//*[@id='username']")
    public static WebElement loginAut;

    @FindBy(xpath = "//*[@id='password']")
    public static WebElement passwordAut;

    @FindBy(xpath = "//*[@name='login']")
    public static WebElement authorize;

    @FindBy(xpath = "//*[@class='welcome-user']")
    public static WebElement hello;

    @FindBy(xpath = "//*[@class='woocommerce-error']")
    public static WebElement error;


    public AuthorizationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "my-account/");
        PageFactory.initElements(driver, this);
    }

    public static MainPage authorize(String login, String password) {
        AuthorizationPage.loginAut.sendKeys(login);
        AuthorizationPage.passwordAut.sendKeys(password);
        authorize.click();
        return new MainPage(driver, wait);
    }

    public String getTextHello() {
        return hello.getText();
    }

    public String getTextError() {
        return error.getText();
    }
}
