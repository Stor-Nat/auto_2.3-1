package ru.netology;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTest {

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");

        RegistrationByCardInfo info = new RegistrationByCardInfo();

        $("[data-test-id='city'] input").setValue(faker.address().cityName());

//        Очищаем поле ввода даты
        $("[data-test-id=date] input.input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
//        Генерируем строку с датой
        String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        Ввод сгенерированной даты
        $("[data-test-id=date] input.input__control").setValue(date);

        $("[data-test-id='name'] input").setValue(faker.name().fullName());

        $("[data-test-id='phone'] input").setValue(faker.phoneNumber().phoneNumber());

        $("[data-test-id=agreement]").click();

        $(byText("Запланировать")).click();

        $(withText("Успешно!")).waitUntil(visible, 15000);

//      Проверка даты в сплывающем сообщении
        $("[data-test-id='success-notification'] .notification__content").waitUntil(visible, 15000).shouldHave(text(date));

//        Очищаем поле ввода даты
        $("[data-test-id=date] input.input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
//        Генерируем строку с датой
        String date2 = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        Ввод сгенерированной даты
        $("[data-test-id=date] input.input__control").setValue(date);

        $(byText("Запланировать")).click();

        $(byText("Перепланировать")).click();

        $(withText("Успешно!")).waitUntil(visible, 15000);

//        Проверка даты в сплывающем сообщении
//        $("[data-test-id='success-notification'] .notification__content").waitUntil(visible, 15000).shouldHave(text(date2));
    }
}
