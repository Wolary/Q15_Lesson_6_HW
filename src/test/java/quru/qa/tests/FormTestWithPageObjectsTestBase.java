package quru.qa.tests;

import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationFormPages;

public class FormTestWithPageObjectsTestBase extends TestBase{
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();

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
