package ru.netology;

import com.github.javafaker.Faker;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

    @Data
    @RequiredArgsConstructor

    public class RegistrationByCardInfo {

        private static Faker faker;
        @BeforeEach
        void setUpAll() {
           faker = new Faker(new Locale("ru"));
        }

        public static String city() {
            String[] cityNames = new String[] {"Москва", "Воронеж", "Липецк", "Рязань", "Тула", "Казань"};
            int city =  (int) (Math.random() * cityNames.length);
            return cityNames[city];
        }

        public static String name() {
//            String name = faker.name().lastName() + " " + faker.name().firstName();
            return faker.name().lastName() + " " + faker.name().firstName() ;
//            return name();
        }

        public static String phone() {
//            String phone = faker.phoneNumber().phoneNumber();
            return faker.phoneNumber().phoneNumber();
//            return phone();
        }

}
