package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationFormPages;

public class FormTestWithPageObjectsWithFaker {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            address = faker.address().streetAddress(),
            email = faker.internet().emailAddress();

    String gender = "Other",
            subjects = "arts",
            phone = "1234567890",
            hobbies = "Reading",
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
                .setNumber(phone)
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
                .checkResult(phone)
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
                .setNumber(phone)
                .submitForm();

//проверяем ввод
        registrationFormPages.checkResult(firstName + " " + lastName)
                .checkResult(gender)
                .checkResult(phone);
    }
}
