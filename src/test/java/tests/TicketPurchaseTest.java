package tests;

import com.codeborne.selenide.Selenide;
import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TicketPage;
import io.qameta.allure.*;

@Feature("Покупка билета")
@Epic("Домашка 7")
@Tag("Билеты")
@Severity(SeverityLevel.BLOCKER)
@UITest
public class TicketPurchaseTest {

    public TicketPage ticketPage = new TicketPage();

    @Story("Покупка билета (тест)")
    @Test
    public void buyTicket() {
        ticketPage.clickMovie("Свинка");
        ticketPage.clickBuyTicket();
        Assertions.assertEquals("Покупка билета", ticketPage.getPayPageNamefile()); //проверка нахождения на странице оплаты
        ticketPage.addCardNumber("Auto Toster","4242424242424242", "Декабрь", "2025", "123");
        ticketPage.btnPaymentClick();
        Assertions.assertEquals("Спасибо за покупку", ticketPage.checkSucText());
        Selenide.closeWebDriver();
    }
}
