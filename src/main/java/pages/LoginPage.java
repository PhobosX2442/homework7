package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement inputEmail = $("#email");
    private SelenideElement inputPassword = $("#password");
    private SelenideElement buttonSubmit = $("button[data-qa-id='login_submit_button']");
    private SelenideElement btnLogin = $("[data-qa-id='login_page_button']");

    @Step("Открываем браузер и заходим на страницу авторизации")
    public LoginPage open() {
         Selenide.open("/");
         btnLogin.click();
         return this;
    }

    @Step("Заполняем Email")
    public LoginPage setEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("Заполняем пароль")
    public LoginPage setPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    @Step("Кликаем по кнопке отправки данных")
    public LoginPage clickLogin() {
        buttonSubmit.click();
        return this;
    }
}
