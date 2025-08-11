package pages;

import com.codeborne.selenide.SelenideElement;

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

    public String PaymentPageTitle() {
        return namePayPage.getText();
    }

    public void addCardNumber(String name, String number, String month, String year, String CVV) {
        cardName.setValue(name);
        cardNumber.setValue(number);
        cardMonth.click();
        $x("//*[text() = '" + month + "']/parent::*[@class]").click();
        cardYear.click();
        $x("//*[text() = '" + year + "']/parent::*[@class]").click();
        cardCVV.setValue(CVV);
    }

    public void btnPaymentClick() {
        btnPayment.click();
    }

    public String checkSuccessPayText() {
        return successPayText.getText();
    }
}
