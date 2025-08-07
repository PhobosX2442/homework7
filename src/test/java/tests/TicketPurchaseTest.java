package tests;

import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.TicketPage;

@UITest
public class TicketPurchaseTest {

    public TicketPage ticketPage = new TicketPage();

    @Test
    public void buyTicket() {
        ticketPage.clickMovie("Свинка");
        ticketPage.clickBuyTicket();
        Assertions.assertEquals("Покупка билета", ticketPage.getPayPageNamefile()); //проверка нахождения на странице оплаты
        ticketPage.addCardNumber("Auto Toster","4242424242424242", "Декабрь", "2025", "123");
        ticketPage.btnPaymentClick();
        Assertions.assertEquals("Спасибо за покупку", ticketPage.checkSucText());
    }
}
