package ru.netology;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

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


        $(byText("Запланировать")).click();

        $(withText("Успешно!")).waitUntil(visible, 15000);

        $(byText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
//      Проверка даты в сплывающем сообщении
//        $("[data-test-id=notification] .notification__content").waitUntil(visible, 15000).shouldHave(text(date));


    }
    }
