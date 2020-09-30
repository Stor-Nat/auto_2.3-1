package ru.netology;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
//            Очищаем поле ввода даты
        $("[data-test-id=date] input.input__control").doubleClick().sendKeys(Keys.BACK_SPACE);

        @Data
        @RequiredArgsConstructor
        class RegistrationByCardInfo {
            private final String address = faker.address().cityName();
            private final String name = faker.name().fullName();

            private final String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            private final PhoneNumber phone = faker.phoneNumber();
        }
//        public class DataGenerator {
//            private DataGenerator() {
//            }
//
//            public static class Registration {
//                private Registration() {
//                }
//
//                public static RegistrationByCardInfo generateByCard(String locale) {
//                    Faker faker = new Faker(new Locale("ru"));
//                    return new RegistrationByCardInfo(
//                            faker.address().cityName(),
//                            LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
//                            faker.date(),
//                            faker.name().fullName(),
//                            faker.phoneNumber(),
//                    );
        $("[data-test-id=agreement]").click();
        $(byText("Запланировать")).click();

        $(withText("Успешно!")).waitUntil(visible, 15000);


        $(byText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
//      Проверка даты в сплывающем сообщении
//        $("[data-test-id=notification] .notification__content").waitUntil(visible, 15000).shouldHave(text(date));

//                }
//            }
//        }

    }
    }
