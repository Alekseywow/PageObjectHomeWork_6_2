package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendareComponent;
import pages.components.ModalComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            stateDropdown = $("#stateCity-wrapper"),
            cityField = $("#city"),
            cityDropdown = $("#stateCity-wrapper"),
            submitBtn =  $("#submit");

    TableComponent tableComponent = new TableComponent();
    ModalComponent modalComponent = new ModalComponent();
    CalendareComponent calendareComponent = new CalendareComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }
    public RegistrationPage removeBlockingElements() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBrith(String day, String month, String year){
        dateOfBirthInput.click();
        calendareComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setImagesPage(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityField.click();
        cityDropdown.$(byText(value)).click();
        return this;
    }
    public void submit() {
        submitBtn.click();
    }
    public RegistrationPage submissionCheckSuccess() {
        modalComponent.isVisible();
        return this;
    }
    public void submissionCheckFail() {
        modalComponent.isHidden();
    }
    public void submissionModalMessage(String value) {
        modalComponent.getTitle(value);
    }
    public RegistrationPage checkResultTablePairs(String key, String value) {
        tableComponent.getCellValueByKey(key, value);
        return this;
    }

}
