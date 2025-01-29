package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import static io.qameta.allure.Allure.step;

public class RegistrationPageObjectsTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Tag("simple")
    @DisplayName("Тест на полное заполнение формы")

    @Test
    void successfulRegistrationTest() {
                step("Открываем страницу", () -> registrationPage.openPage());
                step("Закрываем баннеры", () -> registrationPage.removeBlockingElements());
                step("Вводим имя", () -> registrationPage.setFirstName(testData.firstName));
                step("Вводим фамилию", () -> registrationPage.setLastName(testData.lastName));
                step("Вводим Email", () -> registrationPage.setUserEmail(testData.userEmail));
                step("Выбираем пол", () -> registrationPage.setGender(testData.genderWrapper));
                step("Вводим номер телефона", () -> registrationPage.setNumber(testData.setNumber));
                step("Указываем дату рождения", () ->
                        registrationPage.setDateOfBrith(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth));
                step("Выбираем предмет", () -> registrationPage.setSubjects(testData.subject));
                step("Выбираем хобби", () -> registrationPage.setHobbies(testData.hobby));
                step("Загружаем картинку", () -> registrationPage.setImagesPage(testData.picture));
                step("Вводим адрес", () -> registrationPage.setAddress(testData.address));
                step("Выбираем штат", () -> registrationPage.setState(testData.state));
                step("Выбираем город", () -> registrationPage.setCity(testData.city));
                step("Подтверждаем форму", () -> registrationPage.submit());

                step("Проверяем рузельтат", () -> {
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
                });
    }

    @Tag("simple")
    @DisplayName("Тест на минимальное заполнение формы")

    @Test
    void fillRequiredFieldsTest(){
        step("Открываем страницу", () -> registrationPage.openPage());
        step("Закрываем баннеры", () -> registrationPage.removeBlockingElements());
        step("Вводим имя", () -> registrationPage.setFirstName(testData.firstName));
        step("Вводим фамилию", () -> registrationPage.setLastName(testData.lastName));
        step("Выбираем пол", () -> registrationPage.setGender(testData.genderWrapper));
        step("Вводим номер телефона", () -> registrationPage.setNumber(testData.setNumber));
        step("Подтверждаем форму", () -> registrationPage.submit());

        step("Проверяем рузельтат", () -> {
            registrationPage
                    .submissionCheckSuccess()
                    .submissionModalMessage("Thanks for submitting the form");
            registrationPage
                    .checkResultTablePairs("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultTablePairs("Gender", testData.genderWrapper)
                    .checkResultTablePairs("Mobile", testData.setNumber);
        });
    }


    @Tag("simple")
    @DisplayName("Негативный тест на заполнение формы")

    @Test
    void shortPhoneNumberNegativeTest(){
        step("Открываем страницу", () -> registrationPage.openPage());
        step("Закрываем баннеры", () -> registrationPage.removeBlockingElements());
        step("Вводим имя", () -> registrationPage.setFirstName(testData.firstName));
        step("Вводим фамилию", () -> registrationPage.setLastName(testData.lastName));
        step("Выбираем пол", () -> registrationPage.setGender(testData.genderWrapper));
        step("Выбираем пол", () -> registrationPage.setNumber(testData.setNumberNegative));
        step("Подтверждаем форму", () -> registrationPage.submit());

        step("Ошибка заполнения формы", () -> registrationPage.submissionCheckFail());
    }
}




