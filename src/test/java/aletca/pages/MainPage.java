package aletca.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

    @FindBy(xpath = "//*[text()='В корзину']")
    public static WebElement card;

    @FindBy(xpath = "//*[text()='Каталог']")
    public static WebElement catalogMenu;

    @FindBy(xpath = "//*[text()='Электроника']")
    public static WebElement tablet;

    @FindBy(xpath = "//*[text()='Планшеты']")
    public static WebElement tablets;

    @FindBy(xpath = "//a[text()='Оформление заказа']")
    public static WebElement order;

    @FindBy(xpath = "//a[@class ='showlogin']")
    public static WebElement orderAut;

    @FindBy(xpath = "//*[@id ='username']")
    public static WebElement nameAut;

    @FindBy(xpath = "//*[@id ='password']")
    public static WebElement passwordAut;

    @FindBy(xpath = "//*[@id='select2-billing_country-container']")
    public static WebElement spanCounry;

    @FindBy(xpath = "//button[@name ='login']")
    public static WebElement buttonAut;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public static WebElement name;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public static WebElement surname;

    @FindBy(xpath = "//*[@class='select2-search__field']")
    public static WebElement countryField;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public static WebElement address; //улица и номер дома

    @FindBy(xpath = "//*[@id='billing_city']")
    public static WebElement city;

    @FindBy(xpath = "//*[@id='billing_state']")
    public static WebElement region;

    @FindBy(xpath = "//*[@id='billing_postcode']")
    public static WebElement index;

    @FindBy(xpath = "//*[@id='billing_phone']")
    public static WebElement telephone;

    @FindBy(xpath = "//button[text()='Оформить заказ']")
    public static WebElement submit;

    @FindBy(xpath = "//*[text()='Заказ получен']")
    public static WebElement orderReceived;


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "");
        PageFactory.initElements(driver, this);
    }

    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    public void open() {
        driver.navigate()
              .to(url);
    }

    public static void goToCatalog() {
        new Actions(driver)
                .moveToElement(catalogMenu)
                .moveToElement(tablet)
                .moveToElement(tablets)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(tablets));
        tablets.click();
    }

    public static void add() {
        card.click();
    }

    public static void goToOrder() {
        new Actions(driver)
                .moveToElement(order)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(order));
        order.click();
    }

    public static void avtoriz() {
        orderAut.click();
        nameAut.sendKeys("alecsa");
        passwordAut.sendKeys("123456as");
        buttonAut.click();
    }
    public static void tablePlacingAnOrderWithName(String name, String surname) {
        MainPage.name.sendKeys(name);
        MainPage.surname.sendKeys(surname);
    }

    public static void setDeliveryCountru() {
        spanCounry.click();
        countryField.sendKeys("Russia");
        countryField.sendKeys(Keys.ENTER);
    }

    public static void tablePlacingAnOrderWithAll(String address, String city, String region,
                                                      String index, String telephone) {
        MainPage.address.sendKeys(address);
        MainPage.city.sendKeys(city);
        MainPage.region.sendKeys(region);
        MainPage.index.sendKeys(index);
        MainPage.telephone.sendKeys(telephone);
        submit.click();
    }

    public String getTextOrderReceived() {
        return orderReceived.getText();
    }
}




