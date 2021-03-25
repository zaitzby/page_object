package pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentsRegistrationFormPage {
    Faker faker = new Faker();

    String name = faker.name().name();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String yearOfBirth = "1961";
    String monthOfBirth = "October";
    String dateOfBirth = "13";
    String subject = "Arts";
    String subject2 = "Biology";
    String hobby = "Reading";
    String fileName = "fox.PNG";
    String address = faker.address().fullAddress();
    String state = "Rajasthan";
    String city = "Jaipur";

    public void openRegistrationPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void fillInRegistrationForm(){
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        setBirthData(dateOfBirth, monthOfBirth, yearOfBirth);
        $("#subjectsInput").setValue("ar").pressEnter();
        $("#subjectsInput").setValue("bi").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
    }
    public void setBirthData(String date, String month, String year){
        String datePickerLocator = String.format("%s %sth, %s", month, date, year);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $("[aria-label$='" + datePickerLocator + "']").click();

    }
    public void submitFilledForm(){
        $("#submit").click();
    }
    public void verifyFilledData(){
        $(".table-responsive").shouldHave(
                text("Student Name " + name + " " + lastName),
                text("Student Email " + email),
                text("Gender " + gender),
                text("Mobile " + mobile),
                text("Date of Birth " + dateOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text("Subjects " + subject + ", " + subject2),
                text("Hobbies " + hobby),
                text("Picture " + fileName),
                text("Address " + address),
                text("State and City " + state + " " + city)
        );
    }
}
