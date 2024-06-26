package aletca;

import aletca.pages.AuthorizationPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorizationTests extends TestBase {

    private String messagesText = "Неверное сообщение после авторизации";
    private String messagesError = "Отсутствует сообщение об ошибке";

    @Description("Авторизация пользователя с валидными данными")
    @Test
    public void user_Authorization_With_Valid_Data() {
        var page = new AuthorizationPage(driver, wait);
        page.open();
        AuthorizationPage.authorize("alecsa", "123456as");

        Assertions.assertEquals(page.getTextHello(), "| Привет alecsa !", messagesText);
    }

    @Description("Авторизация пользователя без заполнения обязательного поля имя")
    @Test
    public void click_On_AButton_With_Empty_Fields() {
        var page = new AuthorizationPage(driver, wait);
        page.open();
        AuthorizationPage.authorize("", "");

        Assertions.assertEquals(page.getTextError(), "Error: Имя пользователя обязательно.", messagesError);
    }
}
