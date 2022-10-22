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
            hobbies = "arts",
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
                .setHobbies(hobbies);
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("joka.jpg");
        $("#currentAddress").setValue("Russia, Krasnodar, Krasnaya 5.");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("gurgaon").pressEnter();

        $("#submit").click();

//проверяем ввод
        registrationFormPages.checkResult(firstName + " " + lastName)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(number)
                .checkResult(day + " " + month + "," + year)
                .checkResult("Arts")
                .checkResult("Reading")
                .checkResult("Joka.jpg")
                .checkResult("Russia, Krasnodar, Krasnaya 5.")
                .checkResult("NCR Gurgaon");
    }
    @Test
    void fillFormMinimumTest() {

        registrationFormPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(number);
        $("#submit").click();

//проверяем ввод
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(gender),
                text(number));
    }
}
