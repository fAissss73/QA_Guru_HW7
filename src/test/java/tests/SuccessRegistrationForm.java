package tests;

import org.junit.jupiter.api.Test;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
public class SuccessRegistrationForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setEmail("alex@petrov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Economics")
                .setHobbies("Sports")
                .setHobbies("Music")
                .setAddress("Street 1")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .uploadPictures()
                .submitRegistration()
                .checkResult("Student Name", "Alex Petrov")
                .checkResult("Student Email", "alex@petrov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Economics")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "images.jpg")
                .checkResult("Address", "Street 1")
                .checkResult("State and City", "Rajasthan Jaipur");

    }
    @Test
    void failedRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setEmail("alex@petrov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .submitRegistration()
                .checkLastNameTyping("border-color", "rgb(220, 53, 69)");
    }

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setEmail("alex@petrov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setAddress("Street 1")
                .submitRegistration()
                .checkResult("Student Name", "Alex Petrov")
                .checkResult("Student Email", "alex@petrov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Address", "Street 1");

    }
}
