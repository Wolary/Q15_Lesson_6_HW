package quru.qa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    public ResultsTableComponent checkResult(String sample){
        $(".table-responsive").shouldHave(text(sample));
        return this;
    }


}
