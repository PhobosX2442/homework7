package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private SelenideElement namePayPage = $("div[class$='tracking-tight']");
    private SelenideElement cardNumber = $("input[data-qa-id*='number']");
    private SelenideElement cardMonth = $("button[data-qa-id='payment_card_month_select']");
    private SelenideElement cardYear = $("button[data-qa-id*='year']");
    private SelenideElement cardCVV = $("input[data-qa-id='payment_card_cvc_input']");
    private SelenideElement btnPayment = $("button[data-qa-id='payment_submit_button']");
    private SelenideElement cardName = $("input[data-qa-id='payment_card_holder_input']");
    private SelenideElement successPayText = $x("//p[@class='text-xl mt-5']");

    @Step("Берём текст с названием страницы оплаты")
    public String paymentPageTitle() {
        return namePayPage.getText();
    }

    @Step("Устанавливаем имя держателя карты")
    public void setCardName(String name) {
        cardName.setValue(name);
    }

    @Step("Устанавливаем номер карты")
    public void setCardNumber(String number) {
        cardNumber.setValue(number);
    }

    @Step("Выбираем месяц карты")
    public void selectMonth(String month) {
        cardMonth.click();
        $x("//*[text() = '" + month + "']/parent::*[@class]").click();
    }

    @Step("Выбираем год карты")
    public void selectYear(String year) {
        cardYear.click();
        $x("//*[text() = '" + year + "']/parent::*[@class]").click();
    }

    @Step("Устанавливаем CVV")
    public PaymentPage setCVV(String cvv) {
        cardCVV.setValue(cvv);
        return this;
    }

    @Step("Кликаем на кнопку оплаты")
    public void btnPaymentClick() {
        btnPayment.click();
    }

    @Step("Находим текст, символизирующий успешную оплату")
    public String checkSuccessPayText() {
        return successPayText.getText();
    }
}
