package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TicketPage {
    private SelenideElement linkMovie = $("div[class*='grid']");
    private SelenideElement namePayPage = $("div[class$='tracking-tight']");
    private SelenideElement cardNumber = $("input[data-qa-id*='number']");
    private SelenideElement cardMonth = $("button[data-qa-id='payment_card_month_select']");
    private SelenideElement cardYear = $("button[data-qa-id*='year']");
    private SelenideElement btnBuyTicket = $x("//p[contains(text(), \"Купить билет\")]\n");
    private SelenideElement cardCVV = $("input[data-qa-id='payment_card_cvc_input']");
    private SelenideElement btnPayment = $("button[data-qa-id='payment_submit_button']");
    private SelenideElement cardName = $("input[data-qa-id='payment_card_holder_input']");
    private SelenideElement sucText = $x("//p[@class='text-xl mt-5']");
    private SelenideElement btnFilter = $x("//a[@href='/movies?page=1']");

    public void clickMovie(String film) {
        linkMovie.$(byText(film)).click();
    }

    public String getPayPageNamefile() {
        return namePayPage.getText();
    }

    public SelenideElement setMonthPick(String month) {
        return $x("//*[text() = '" + month + "']/parent::*[@class]");
    }

    //завернуть локатор в переменную
    public SelenideElement setYearPick(String year) {
        return $x("//*[text() = '" + year + "']/parent::*[@class]");
    }

    public void addCardNumber(String name, String number, String month, String year, String CVV) {
        cardName.setValue(name);
        cardNumber.setValue(number);
        cardMonth.click();
        setMonthPick(month).click();
        cardYear.click();
        setYearPick(year).click();
        cardCVV.setValue(CVV);
    }

    public void clickBuyTicket() {
        btnBuyTicket.click();
    }

    public void btnPaymentClick() {
        btnPayment.click();
    }

    public String checkSucText() {
        return sucText.getText();
    }

    public void clickFilterPage() {
        btnFilter.click();
    }
}
