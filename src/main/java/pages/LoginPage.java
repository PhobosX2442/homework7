package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement inputEmail = $("#email");
    private SelenideElement inputPassword = $("#password");
    private SelenideElement buttonSubmit = $("button[data-qa-id='login_submit_button']");

    public void openBrowser(String url) {
        open(url);
    }

    public void setEmail(String email) {
        inputEmail.setValue(email);
    }

    public void setPassword(String password) {
        inputPassword.setValue(password);
    }

    public void clickLogin() {
        buttonSubmit.click();
    }

}
