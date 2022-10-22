package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationFormPages;
import quru.qa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestWithPageObjects {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    String firstName = "Ivan",
            lastName = "Ivanov",
            email = "ivan@ya.ru",
            gender = "Other",
            number = "1234567890",
            subjects = "arts",
            hobbies = "Reading",
            address = "Russia, Krasnodar, Krasnaya 5.",
            picture = "joka.jpg",
            state = "NCR",
            city = "Noida",
            day = "16", month = "April", year = "1982";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {
        registrationFormPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .checkState(state)
                .checkCity(city)
                .submitForm();

//проверяем ввод
        registrationFormPages.checkResult(firstName + " " + lastName)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(number)
                .checkResult(day + " " + month + "," + year)
                .checkResult(subjects)
                .checkResult(hobbies)
                .checkResult(picture)
                .checkResult(address)
                .checkResult(state + " " + city);
    }

    @Test
    void fillFormMinimumTest() {

        registrationFormPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(number)
                .submitForm();

//проверяем ввод
        registrationFormPages.checkResult(firstName + " " + lastName)
                .checkResult(gender)
                .checkResult(number);
    }
}
