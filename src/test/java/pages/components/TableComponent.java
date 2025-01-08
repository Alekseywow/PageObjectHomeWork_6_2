package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    public void getCellValueByKey(String key, String value){
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }
}
