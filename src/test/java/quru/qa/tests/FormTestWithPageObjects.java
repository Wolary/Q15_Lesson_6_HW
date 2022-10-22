package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quru.qa.pages.RegistrationFormPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestWithPageObjects {
    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    String firstName = "Ivan",
            lastName = "Ivanov",
            email = "ivan@ya.ru",
            gender = "Other",
            number = "1234567890";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    //  Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {
        registrationFormPages.openPage();
        registrationFormPages.setFirstName(firstName);
        registrationFormPages.setFirstName(firstName);
        registrationFormPages.setGender(gender);
        registrationFormPages.setNumber(number);
        $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("4");
            $(".react-datepicker__year-select").selectOptionByValue("1982");
            $(".react-datepicker__day.react-datepicker__day--016").click();
        $("#subjectsInput").setValue("arts").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("joka.jpg");
        $("#currentAddress").setValue("Russia, Krasnodar, Krasnaya 5.");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("gurgaon").pressEnter();
        $("#submit").click();

//проверяем ввод
        $(".table-responsive").shouldHave(text(firstName + lastName),
                text(email),
                text(gender),
                text(number),
                text("16 May,1982"),
                text("Arts"),
                text("Reading"),
                text("Joka.jpg"),
                text("Russia, Krasnodar, Krasnaya 5."),
                text("NCR Gurgaon"));
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
