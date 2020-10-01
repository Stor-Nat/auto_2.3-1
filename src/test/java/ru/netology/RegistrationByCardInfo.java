package ru.netology;

import com.github.javafaker.Faker;

import lombok.Data;
import lombok.RequiredArgsConstructor;

    @Data
    @RequiredArgsConstructor

    public class RegistrationByCardInfo {
        Faker faker = new Faker();

        private final String address = faker.address().cityName();
//        private final String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        private final String name = faker.name().fullName();
        private final String phone = faker.phoneNumber().phoneNumber();
}
