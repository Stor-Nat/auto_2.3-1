package ru.netology;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    @Data
    @RequiredArgsConstructor

    public class RegistrationByCardInfo {
        Faker faker = new Faker();

        private final String address = faker.address().cityName();
        private final String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        private final String name = faker.name().fullName();
        private final PhoneNumber phone = faker.phoneNumber();
}
