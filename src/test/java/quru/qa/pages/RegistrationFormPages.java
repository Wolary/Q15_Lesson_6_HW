package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import quru.qa.pages.components.CalendarComponent;
import quru.qa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPages {

    //Elements

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $("#genterWrapper"),
            number = $("#userNumber"),
            hobbies = $("#subjectsInput");

    // Actions
    public RegistrationFormPages openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPages setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPages setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public RegistrationFormPages setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationFormPages setGender(String value) {
        gender.$(byText(value)).click();
        return this;


    }

    public RegistrationFormPages setNumber(String value) {
        number.setValue(value);
        return this;
    }

    public RegistrationFormPages setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPages setHobbies(String value) {
        hobbies.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPages checkResult(String sample){
        resultsTableComponent.checkResult(sample);
        return this;
    }


}
