package aletca;

import aletca.pages.RegistrationPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {

    private String messageText = "Неверное сообщение после регистрации";
    private String negative = "Не появилось сообщение об уже существующей учетной записи";

    @Description("Регистрация пользователя со всеми валдиными данными")
    @Test
    public void user_Registration_With_Valid_Data() {
        var page = new RegistrationPage(driver, wait);
        page.open();
        RegistrationPage.registration("alecsa8", "Alecsas8@mail.ru", "123456as");

        Assertions.assertEquals(page.getMessage(), "Регистрация завершена", messageText);
    }

    @Description("Регистрация пользователя с уже зарегистрированными данными.")
    @Test
    public void user_Registration_With_ExistingEntry() {
        var page = new RegistrationPage(driver, wait);
        page.open();
        RegistrationPage.registration("alecsa", "Alecsa@mail.ru", "123456as");

        Assertions.assertEquals(page.getTextExisting(), "Пожалуйста авторизуйтесь.", negative);
    }
}
