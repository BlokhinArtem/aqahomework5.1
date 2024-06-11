package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Самара", "Омск", "Казань", "Челябинск", "Ростов-на-Дону", "Уфа", "Волгоград", "Пермь", "Красноярск", "Воронеж", "Саратов", "Краснодар", "Тольятти", "Ижевск", "Ульяновск", "Барнаул", "Владивосток", "Ярославль", "Иркутск", "Тюмень", "Махачкала", "Хабаровск", "Новокузнецк", "Оренбург", "Кемерово", "Рязань", "Томск", "Астрахань", "Пенза", "Липецк", "Тула"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
}