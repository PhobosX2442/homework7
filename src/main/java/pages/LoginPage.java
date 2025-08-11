package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement inputEmail = $("#email");
    private SelenideElement inputPassword = $("#password");
    private SelenideElement buttonSubmit = $("button[data-qa-id='login_submit_button']");

    public LoginPage openLoginPage() {
         open("/login");
         return this;
    }

    public LoginPage setEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public LoginPage clickLogin() {
        buttonSubmit.click();
        return this;
    }
}
