package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    //  Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivan@ya.ru";
        String number = "1234567890";



        open("/automation-practice-form");

            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Other")).click();
        $("#userNumber").setValue(number);
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
        $(".table-responsive").shouldHave(text("Ivan Ivanov"),
                text("ivan@ya.ru"),
                text("Other"),
                text("1234567890"),
                text("16 May,1982"),
                text("Arts"),
                text("Reading"),
                text("Joka.jpg"),
                text("Russia, Krasnodar, Krasnaya 5."),
                text("NCR Gurgaon"));
    }
}
