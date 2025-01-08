package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageUtills {
    public void removeBan(){
        executeJavaScript("$('#fixedban').remove()");
    }
    public void removeFooter(){
        executeJavaScript("$('footer').remove()");
    }
}
