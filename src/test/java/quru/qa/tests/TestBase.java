package quru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    static  String firstName = "Ivan",
            lastName = "Ivanov",
            email = "ivan@ya.ru",
            gender = "Other",
            phone = "1234567890",
            subjects = "arts",
            hobbies = "Reading",
            address = "Russia, Krasnodar, Krasnaya 5",
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
}
