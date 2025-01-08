package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationPageObjectsTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBlockingElements()
                .setFirstName("Aleksey")
                .setLastName("Danilov")
                .setUserEmail("mail@mail.ru")
                .setGender("Male")
                .setNumber("8900909090")
                .setDateOfBrith("26","September","1994")
                .setSubjects("English")
                .setHobbies("Sports")
                .setImagesPage("image.png")
                .setAddress("INDIA")
                .setState("NCR")
                .setCity("Delhi")
                .submit();
        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");
        registrationPage
                .checkResultTablePairs("Student Name", "Aleksey Danilov")
                .checkResultTablePairs("Student Email", "mail@mail.ru")
                .checkResultTablePairs("Gender", "Male")
                .checkResultTablePairs("Mobile", "8900909090")
                .checkResultTablePairs("Date of Birth", "26" + " " + "September" +","+"1994")
                .checkResultTablePairs("Subjects", "English")
                .checkResultTablePairs("Hobbies", "Sports")
                .checkResultTablePairs("Picture", "image.png")
                .checkResultTablePairs("Address", "INDIA")
                .checkResultTablePairs("State and City", "NCR" +" "+ "Delhi");
    }
    @Test
    void fillRequiredFieldsTest(){
        registrationPage.openPage()
                .removeBlockingElements()
                .setFirstName("Aleksey")
                .setLastName("Danilov")
                .setGender("Male")
                .setNumber("8900909090")
                .submit();
        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");
        registrationPage
                .checkResultTablePairs("Student Name", "Aleksey Danilov")
                .checkResultTablePairs("Gender", "Male")
                .checkResultTablePairs("Mobile", "8900909090");
    }
    @Test
    void shortPhoneNumberNegativeTest(){
        registrationPage
                .openPage()
                .removeBlockingElements()
                .setFirstName("Aleksey")
                .setLastName("Danilov")
                .setGender("Male")
                .setNumber("890090909")
                .submit();

        registrationPage
                .submissionCheckFail();
    }
}




