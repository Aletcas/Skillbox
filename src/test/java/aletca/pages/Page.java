package aletca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public Page(WebDriver driver, WebDriverWait wait, String subUrl) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = wait;
        this.subUrl = subUrl;
    }

    public Page(WebDriver driver, WebDriverWait wait) {
        this(driver, wait, "");
    }

    public void open() {
        driver.navigate().to(getPageUrl());
    }

    private String getPageUrl() {
        return url + subUrl;
    }

    public String url = "https://intershop5.skillbox.ru/";
    private String subUrl;
}
