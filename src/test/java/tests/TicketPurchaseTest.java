package tests;

import io.qameta.allure.*;
import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;
import pages.PaymentPage;

@Feature("Покупка билета")
@Epic("Домашка 7")
@Tag("smoke")
@Severity(SeverityLevel.BLOCKER)
@UITest
public class TicketPurchaseTest {

    private PaymentPage paymentPage = new PaymentPage();
    private FilmCatalogPage filmCatalogPage = new FilmCatalogPage();
    private FilmPage filmPage = new FilmPage();

    @Story("Покупка билета (тест)")
    @DisplayName("Покупка билета")
    @Test
    public void buyTicket() {
        filmCatalogPage.selectFilm("Титаник");
        filmPage.clickBuyTicket();

        Allure.step("Проверяем нахождение на странице оплаты", () -> {
            Assertions.assertEquals("Покупка билета", paymentPage.paymentPageTitle());
        });

        paymentPage.setCardName("Auto Toster");
        paymentPage.setCardNumber("4242424242424242");
        paymentPage.selectMonth("Декабрь");
        paymentPage.selectYear("2025");
        paymentPage.setCVV("123");
        paymentPage.btnPaymentClick();

        Allure.step("Проверяем, прошла ли покупка успешно", () -> {
            Assertions.assertEquals("Спасибо за покупку", paymentPage.checkSuccessPayText());
        });

    }
}
