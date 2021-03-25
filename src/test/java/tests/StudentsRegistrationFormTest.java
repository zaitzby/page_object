package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentsRegistrationFormPage;

public class StudentsRegistrationFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fullFillForm() {
        StudentsRegistrationFormPage registrationPage = new StudentsRegistrationFormPage();

        registrationPage.openRegistrationPage();
        registrationPage.fillInRegistrationForm();
        registrationPage.submitFilledForm();
        registrationPage.verifyFilledData();

    }
}
