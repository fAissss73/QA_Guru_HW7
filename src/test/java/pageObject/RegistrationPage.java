package pageObject;

import com.codeborne.selenide.SelenideElement;
import pageObject.components.CalendarComponent;
import pageObject.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsContainer #subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            adreesInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            uploadImage = $("#uploadPicture"),
            submitClick = $("#submit");



    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent resultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setAddress(String value) {
        adreesInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPictures() {
        uploadImage.uploadFromClasspath("images.jpg");

        return this;
    }

    public RegistrationPage submitRegistration() {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkLastNameTyping(String key, String value) {
        lastNameInput.shouldHave(cssValue(key, value));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultComponent.checkRegistrationResults(key, value);

        return this;
    }
}
