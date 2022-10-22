package quru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPages {

    //Elements
    private SelenideElement firstNameInput = $("#firstName"),
                    lastName = $("#lastName"),
                    gender = $("#genterWrapper"),
                    number = $("#userNumber");

    // Actions
    public RegistrationFormPages openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPages setFirstName(String value){
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationFormPages setLastName(String value){
        lastName.setValue(value);
        return this;

    }

    public RegistrationFormPages setGender(String value){
        gender.$(byText(value)).click();
        return this;


    }

    public RegistrationFormPages setNumber(String value){
        number.setValue(value);
        return this;

    }


}
