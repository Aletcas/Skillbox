package aletca;

import aletca.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MainPageTests extends TestBase {

    private String messagesTextOrder = "Текст заказ получен отсутствует";

    @Description("Оформление заказа с валидными данными")
    @Test
    public void addingItemToCart() throws InterruptedException {

        var page = new MainPage(driver, wait);
        page.open();
        MainPage.goToCatalog();
        WebElement element = driver.findElement(By.xpath("//*[@id='title_bread_wrap']"));
        Assertions.assertTrue(element.isDisplayed());
        MainPage.add();
        MainPage.goToOrder();
        MainPage.avtoriz();
        MainPage.tablePlacingAnOrderWithName("Alecsa", "Ivanova");
        MainPage.setDeliveryCountru();
        MainPage.tablePlacingAnOrderWithAll("Цветочная",
                "Смоленск", "Смоленская",
                "15138974", "89206846987");

        Assertions.assertEquals(page.getTextOrderReceived(), "Заказ получен", messagesTextOrder);
    }
}
