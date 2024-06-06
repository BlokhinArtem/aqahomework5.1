package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class pattern {
    private Faker faker;

    private String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void shouldBeSuccessfullyCompleted() {
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        String planningDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(name);
        $("[data-test-id='phone'] input").setValue(phone);
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Самара");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] input").setValue(name);
        $("[data-test-id='phone'] input").setValue(phone);
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(byText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(Condition.visible, Duration.ofSeconds(1));
//        $(".notification__content").shouldBe(Condition.visible, Duration.ofSeconds(1));
//        $(".notification__content").shouldHave(Condition.exactText("У вас уже запланирована встреча на другую дату. Перепланировать?"));
    }

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }
}