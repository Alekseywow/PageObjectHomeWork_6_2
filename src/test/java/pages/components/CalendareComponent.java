package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendareComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
