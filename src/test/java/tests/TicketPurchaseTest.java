package tests;

import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;
import pages.PaymentPage;
import io.qameta.allure.*;

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
        filmCatalogPage.selectFilm("Свинка");
        filmPage.clickBuyTicket();
        Assertions.assertEquals("Покупка билета", paymentPage.PaymentPageTitle()); //проверка нахождения на странице оплаты
        paymentPage.addCardNumber("Auto Toster","4242424242424242", "Декабрь", "2025", "123");
        paymentPage.btnPaymentClick();
        Assertions.assertEquals("Спасибо за покупку", paymentPage.checkSuccessPayText());
    }
}
