package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

public class RegistrationPageObjectsTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBlockingElements()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .setNumber(testData.setNumber)
                .setDateOfBrith(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .setImagesPage(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();
        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");
        registrationPage
                .checkResultTablePairs("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTablePairs("Student Email", testData.userEmail)
                .checkResultTablePairs("Gender", testData.genderWrapper)
                .checkResultTablePairs("Mobile", testData.setNumber)
                .checkResultTablePairs("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResultTablePairs("Subjects", testData.subject)
                .checkResultTablePairs("Hobbies", testData.hobby)
                .checkResultTablePairs("Picture", testData.picture)
                .checkResultTablePairs("Address", testData.address)
                .checkResultTablePairs("State and City", testData.state + " " + testData.city);
    }
    @Test
    void fillRequiredFieldsTest(){
        registrationPage.openPage()
                .removeBlockingElements()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.genderWrapper)
                .setNumber(testData.setNumber)
                .submit();
        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");
        registrationPage
                .checkResultTablePairs("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTablePairs("Gender", testData.genderWrapper)
                .checkResultTablePairs("Mobile", testData.setNumber);
    }
    @Test
    void shortPhoneNumberNegativeTest(){
        registrationPage
                .openPage()
                .removeBlockingElements()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.genderWrapper)
                .setNumber(testData.setNumberNegative)
                .submit();

        registrationPage
                .submissionCheckFail();
    }
}




