package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void StudentRegistrationForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9102196184");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("image/1.png");
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-content").should(appear);
        $(".modal-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"), text("ivanov@gmail.com")
        , text("Male"), text("1.png"), text("9102196184"), text("26 July,1993"), text("Maths"), text("Sports"),
                text("Russia"), text("NCR Delhi"));
    }
}
